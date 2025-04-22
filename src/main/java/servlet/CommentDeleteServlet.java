package servlet;

import java.io.IOException;
import java.net.URLEncoder;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.CommentDAO;

/**
 * Servlet implementation class CommentDeleteServlet
 */
@WebServlet("/comment-delete-servlet")
public class CommentDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommentDeleteServlet() {
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

		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		String taskName = (String)session.getAttribute("taskName");
		int taskID = (int)session.getAttribute("taskID");
		
		int commentID = Integer.parseInt(request.getParameter("commentID"));
		
		CommentDAO dao = new CommentDAO();
		try {
			int count = dao.delete(commentID);
			if(count == 0) {
				RequestDispatcher rd = request.getRequestDispatcher("comment-delete-failure.jsp");
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
