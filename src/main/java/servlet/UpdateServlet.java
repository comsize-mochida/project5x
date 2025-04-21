package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.TaskDAO;
import model.dao.UserDAO;
import model.entity.CategoryBean;
import model.entity.StatusBean;
import model.entity.TaskBean;
import model.entity.UserBean;

/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/update-servlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		int taskID = Integer.parseInt(request.getParameter("taskID"));
		HttpSession session = request.getSession();
		session.setAttribute("taskID", taskID);
		
		TaskDAO tdao = new TaskDAO();
		UserDAO udao = new UserDAO();
		
		try {
			TaskBean bean = tdao.selectTask(taskID);
			List<CategoryBean> categoryList = tdao.selectCategory();
			List<StatusBean> statusList = tdao.selectStatus();
			List<UserBean> userList = udao.selectUser();
			request.setAttribute("taskBean", bean);
			request.setAttribute("categoryList", categoryList);
			request.setAttribute("statusList", statusList);
			request.setAttribute("userList", userList);
			RequestDispatcher rd = request.getRequestDispatcher("update-form.jsp");
			rd.forward(request, response);
			
		}catch(SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		TaskBean bean = (TaskBean)session.getAttribute("task");
		
		TaskDAO dao = new TaskDAO();
		
		String url;
		try {
			int count = dao.update(bean);
			request.setAttribute("count", count);
			url = "update-success.jsp";
			
		}catch(SQLException | ClassNotFoundException e) {
			url = "update-failure.jsp";
		}
		
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}

}
