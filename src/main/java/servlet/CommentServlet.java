package servlet;

import java.io.IOException;
import java.net.URLEncoder;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.CommentDAO;
import model.entity.CommentBean;

/**
 * Servlet implementation class CommentServlet
 */
@WebServlet("/comment-servlet")
public class CommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		try {
			
			request.setCharacterEncoding("UTF-8");
			HttpSession session = request.getSession();
			List<CommentBean> list = new ArrayList<>();
			CommentDAO dao = new CommentDAO();
			int taskID = Integer.parseInt(request.getParameter("taskID"));
			String taskName = request.getParameter("taskName");
			
			list = dao.selectAll(taskID);
			
			session.setAttribute("taskID",taskID );
			session.setAttribute("taskName", taskName);
			request.setAttribute("commentList", list);
			
			RequestDispatcher rd = request.getRequestDispatcher("comment.jsp");
			rd.forward(request, response);
		
		}catch (SQLException e) {
			
			e.printStackTrace();
			
		}catch (ClassNotFoundException e) {

			e.printStackTrace();
			
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		String taskName = (String)session.getAttribute("taskName");
		int taskID = Integer.parseInt(request.getParameter("taskID"));
		String userID = request.getParameter("userID");
		String comment = request.getParameter("comment");
		
		CommentBean bean = new CommentBean();
		bean.setTaskID(taskID);
		bean.setUserID(userID);
		bean.setComment(comment);
		
		CommentDAO dao = new CommentDAO();
		try {
			int count = dao.register(bean);
			if(count == 0) {
				RequestDispatcher rd = request.getRequestDispatcher("comment-failure.jsp");
				rd.forward(request, response);
			}else {
				String encodedName = URLEncoder.encode(taskName, "UTF-8");
				response.sendRedirect("comment-servlet?taskID=" + taskID + "&taskName=" + encodedName);
			}
			
		}catch(SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}

}
