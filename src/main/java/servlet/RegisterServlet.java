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

import model.dao.TaskDAO;
import model.entity.TaskBean;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/register-servlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		try {

			request.setCharacterEncoding("UTF-8");

			HttpSession session = request.getSession();
			TaskBean bean = (TaskBean)(session.getAttribute("bean"));
			TaskDAO dao = new TaskDAO();
			int count = 0;
			String url = "";

			count = dao.register(bean);
					
			session.setAttribute("count", count);
			
			if(count != 0) {
				
				url = "register-success.jsp";
				
			}else {
				
				url = "register-failure.jsp";
				
			}

			RequestDispatcher rd = request.getRequestDispatcher(url);
			rd.forward(request, response);

		} catch (SQLException e) {

			RequestDispatcher rd = request.getRequestDispatcher("register-failure.jsp");
			rd.forward(request, response);

		} catch (ClassNotFoundException e) {

			RequestDispatcher rd = request.getRequestDispatcher("register-failure.jsp");
			rd.forward(request, response);

		}
		
	}

}
