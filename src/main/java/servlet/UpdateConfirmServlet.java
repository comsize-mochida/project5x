package servlet;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.entity.TaskBean;

/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/update-confirm-servlet")
public class UpdateConfirmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateConfirmServlet() {
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
		int taskID = (int)session.getAttribute("taskID");
		
		String taskName = request.getParameter("taskName");
		
		String category = request.getParameter("category");
		String[] cArray = category.split("/");
		int categoryCode = Integer.parseInt(cArray[0]);
		String categoryName = cArray[1];
		
		LocalDate limitDate = null;
		if(!request.getParameter("limitDate").isEmpty()) {
			limitDate = LocalDate.parse(request.getParameter("limitDate"), DateTimeFormatter.ofPattern("yyyy-MM-dd")) ;
		}
		
		String user = request.getParameter("user");
		String[] uArray = user.split("/");
		String userID = uArray[0];
		String userName = uArray[1];
		
		String status = request.getParameter("status");
		String[] sArray = status.split("/");
		String statusCode = sArray[0];
		String statusName = sArray[1];
		
		String memo = request.getParameter("memo");
		
		TaskBean bean = new TaskBean();
		bean.setTaskID(taskID);
		bean.setTaskName(taskName);
		bean.setCategoryID(categoryCode);
		bean.setCategoryName(categoryName);
		bean.setLimitDate(limitDate);
		bean.setUserID(userID);
		bean.setUserName(userName);
		bean.setStatusCode(statusCode);
		bean.setStatusName(statusName);
		bean.setMemo(memo);
		
		session.setAttribute("task", bean);
		
		RequestDispatcher rd = request.getRequestDispatcher("update-confirm.jsp");
		rd.forward(request, response);
		
	}

}
