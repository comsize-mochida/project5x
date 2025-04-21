package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
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
 * Servlet implementation class RegisterConfirmServlet
 */
@WebServlet("/register-confirm-servlet")
public class RegisterConfirmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterConfirmServlet() {
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
			TaskDAO taskDao = new TaskDAO();
			UserDAO userDao = new UserDAO();

			List<CategoryBean> categoryList = taskDao.selectCategory();
			List<StatusBean> statusList = taskDao.selectStatus();
			List<UserBean> userList = userDao.selectUser();

			session.setAttribute("categoryList", categoryList);
			session.setAttribute("statusList", statusList);
			session.setAttribute("userList", userList);
			
			RequestDispatcher rd = request.getRequestDispatcher("register-form.jsp");
			rd.forward(request, response);

		} catch (SQLException e) {

			RequestDispatcher rd = request.getRequestDispatcher("register-failure.jsp");
			rd.forward(request, response);

		} catch (ClassNotFoundException e) {

			RequestDispatcher rd = request.getRequestDispatcher("register-failure.jsp");
			rd.forward(request, response);

		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		try {
		
			request.setCharacterEncoding("UTF-8");
			HttpSession session = request.getSession();
			TaskBean bean = new TaskBean();
			
			String taskName = request.getParameter("taskName");
			String category = request.getParameter("category");
			String[] array1 = category.split(",");
			String limitDate = request.getParameter("limitDate");
			String user = request.getParameter("user");
			String[] array2 = user.split(",");
			String status = request.getParameter("status");
			String[] array3 = status.split(",");
			String memo = request.getParameter("memo");
			
			bean.setTaskName(taskName);
			bean.setCategoryID(Integer.parseInt(array1[0]));
			bean.setCategoryName(array1[1]);
			
			if(!limitDate.isEmpty()) {
			
				bean.setLimitDate(LocalDate.parse(limitDate));
				
			}else {
				
				bean.setLimitDate(null);
				
			}
			
			bean.setUserID(array2[0]);
			bean.setUserName(array2[1]);
			bean.setStatusCode(array3[0]);
			bean.setStatusName(array3[1]);
			bean.setMemo(memo);

			session.setAttribute("bean",bean);

			RequestDispatcher rd = request.getRequestDispatcher("register-confirm.jsp");
			rd.forward(request, response);
			
		}catch (DateTimeParseException e) {
			
			e.printStackTrace();
			
		}
		
	}

}
