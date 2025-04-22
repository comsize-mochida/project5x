package servlet;

import java.io.IOException;
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

import model.dao.TaskDAO;
import model.entity.TaskBean;

/**
 * Servlet implementation class DeleteConfirmServlet
 */
@WebServlet("/delete-confirm-servlet")
public class DeleteConfirmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteConfirmServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		
		//		タスク一覧から削除確認画面へ遷移するために使用するサーブレット
		try {
			// チェックされた taskID を取得（複数選択対応）
			String[] deleteIdCount = request.getParameterValues("taskID");
			
			// 選択された taskID に対応する TaskBean のリストを作成
			List<TaskBean> deleteTasks = new ArrayList<>();
            TaskDAO dao = new TaskDAO();
            
            if (deleteIdCount != null) {
            	List<Integer> taskIdList = new ArrayList<>();
                for (String idStr : deleteIdCount) {
                    int taskId = Integer.parseInt(idStr);
                    taskIdList.add(taskId);
        			session.setAttribute("taskIdList", taskIdList);

                    TaskBean task = dao.selectTask(taskId);
                    if (task != null) {
                        deleteTasks.add(task);
                    }
                }
            }
            
            // JSP に渡すため、リクエストスコープにセット
			session.setAttribute("deleteTasks", deleteTasks);
			// 削除確認画面へフォワード
			RequestDispatcher rd = request.getRequestDispatcher("delete-confirm.jsp");
			rd.forward(request, response);

		} catch (ClassNotFoundException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}
}

