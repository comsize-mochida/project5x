package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.UserDAO;

/**
 * Servlet implementation class Loginservlet
 */
@WebServlet("/login-servlet")
public class Loginservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Loginservlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// リクエストオブジェクトのエンコーディング方式の指定
		request.setCharacterEncoding("UTF-8");

		// リクエストパラメータの取得(ログイン画面で入力した値)
		String userID = request.getParameter("userID");
		String password = request.getParameter("password");

		String url = null; // 転送先

		//			"yuki"と"hasegawa"をDAOとBEANを用いる
		UserDAO userdao = new UserDAO();
		try {
			userdao.login(userID, password);

			//				System.out.println(userdao.selectAll(id,password).getUser_name());
			//				userに入ってるidと入力したidが一緒なら～したい
			if (userdao.login(userID, password).getUserID() != null) {

				// 転送先の設定
				url = "menu.jsp";
				// セッションオブジェクトの取得
				HttpSession session = request.getSession();

				// セッションスコープへの属性の設定
				session.setAttribute("userName", userdao.login(userID, password).getUserName());
			} else {
				// 転送先の設定
				url = "login-failure.jsp";
				
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
			 url = "error.jsp"; // 例外時に備えておく（存在しなければ作る）
		}

		// リクエストの転送

		 RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}

}
