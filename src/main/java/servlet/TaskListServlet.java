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

import model.dao.TaskDAO;
import model.entity.TaskBean;

/**
 * Servlet implementation class TaskListServlet
 */
@WebServlet("/task-list-servlet")
public class TaskListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TaskListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		TaskDAO dao = new TaskDAO();
		int currentPage = 1;
		int pageSize = 10;
		String pageParam = request.getParameter("page");
		if (pageParam != null) {
		    currentPage = Integer.parseInt(pageParam);
		}
		
		try {
			int totalCount = dao.countAll();
			int totalPages = (int) Math.ceil((double) totalCount / pageSize);
			int offset = (currentPage - 1) * pageSize;
			List<TaskBean> list = dao.selectAll(offset, pageSize);
			request.setAttribute("currentPage", currentPage);
			request.setAttribute("totalPages", totalPages);
			request.setAttribute("list",list);
			RequestDispatcher rd = request.getRequestDispatcher("list.jsp");
			rd.forward(request, response);
		} catch (ClassNotFoundException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
