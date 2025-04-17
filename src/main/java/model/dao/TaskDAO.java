package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.entity.TaskBean;

public class TaskDAO {

	public int delete(TaskBean taskBean) throws SQLException, ClassNotFoundException {
		
		String sql = "DELETE FROM m_user WHERE task_id = ?";

		int result = 0;
		//必ずPreparedStatement型で書くよ！
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {

			//ここではプレースホルダに値をセットする！
			//DeleteConfirmServlet.javaで記述した、
			//int delete = taskDAO.delete(taskBean);で受け取った引数を
			//pstmtにセットする！
			pstmt.setInt(1, taskBean.getTaskID());
			result = pstmt.executeUpdate();

		}

		return result;
	}

}
