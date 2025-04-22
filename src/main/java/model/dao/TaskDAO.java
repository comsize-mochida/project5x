package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.entity.CategoryBean;
import model.entity.StatusBean;
import model.entity.TaskBean;

public class TaskDAO {

public int delete(int taskID) throws SQLException, ClassNotFoundException {
		
		String sql = "DELETE FROM t_task WHERE task_id = ?";
		int result = 0;
		//必ずPreparedStatement型で書くよ！
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {
			//ここではプレースホルダに値をセットする！
			//DeleteServlet.javaで記述した、
			//int delete = taskDAO.delete(taskBean);で受け取った引数を
			//pstmtにセットする！
			pstmt.setInt(1, taskID);
			result = pstmt.executeUpdate();
		}
		return result;
	}

	//ステータスマスタのステータスコードとステータス名をリストで取ってくるメソッド
	public List<StatusBean> selectStatus() throws ClassNotFoundException, SQLException {

		String sql = "SELECT status_code,status_name FROM m_status ORDER BY status_code";
		List<StatusBean> list = new ArrayList<>();

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {

			ResultSet res = pstmt.executeQuery();

			while (res.next()) {

				StatusBean bean = new StatusBean();

				bean.setStatusCode(res.getString("status_code"));
				bean.setStatusName(res.getString("status_name"));

				list.add(bean);

			}

		}

		return list;

	}

	//カテゴリマスタのカテゴリIDとカテゴリ名をリストで取ってくるメソッド
	public List<CategoryBean> selectCategory() throws SQLException, ClassNotFoundException {
		
		String sql = "SELECT category_id, category_name FROM m_category ORDER BY category_id";
		
		try(Connection con = ConnectionManager.getConnection();

				PreparedStatement stmt = con.prepareStatement(sql);
				ResultSet res = stmt.executeQuery()) {

			List<CategoryBean> list = new ArrayList<>();
			while (res.next()) {
				CategoryBean bean = new CategoryBean();
				bean.setCategoryID(res.getInt("category_id"));
				bean.setCategoryName(res.getString("category_name"));
				list.add(bean);
			}
			return list;
		}
	}

	public List<TaskBean> selectAll() throws SQLException, ClassNotFoundException {
		List<TaskBean> list = new ArrayList<>();
		String sql = "SELECT t1.task_id,t1.task_name,t2.category_name,t1.limit_date,t3.user_name,t4.status_name,t1.memo "
				+ "FROM t_task t1 inner join m_category t2 on t1.category_id = t2.category_id "
				+ "inner join m_user t3 on t1.user_id = t3.user_id inner join m_status t4 on t1.status_code = t4.status_code";

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement stmt = con.prepareStatement(sql);
				ResultSet res = stmt.executeQuery()) {
			
			
				while (res.next()) {
					TaskBean bean = new TaskBean();
					bean.setTaskID(res.getInt("task_id"));
					bean.setTaskName(res.getString("task_name"));
					bean.setCategoryName(res.getString("category_name"));
					if(res.getDate("limit_date") != null) {
						bean.setLimitDate(res.getDate("limit_date").toLocalDate());
					}else {
						bean.setLimitDate(null);
					}
					bean.setUserName(res.getString("user_name"));
					bean.setStatusName(res.getString("status_name"));
					bean.setMemo(res.getString("memo"));
	
					list.add(bean);
				}
			
			return list;

		}
	}
	


	public int register(TaskBean bean) throws ClassNotFoundException, SQLException {

		String sql = "INSERT INTO t_task (task_name,category_id,limit_date,user_id,status_code,memo) VALUES (?,?,?,?,?,?)";
		int count = 0;

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {

			pstmt.setString(1, bean.getTaskName());
			pstmt.setInt(2, bean.getCategoryID());
			if(bean.getLimitDate() != null) {
				pstmt.setDate(3, java.sql.Date.valueOf(bean.getLimitDate()));
			}else {
				pstmt.setString(3, null);
			}
			pstmt.setString(4, bean.getUserID());
			pstmt.setString(5, bean.getStatusCode());
			pstmt.setString(6, bean.getMemo());

			count = pstmt.executeUpdate();
		}

		return count;

	}
	
	//タスクテーブルを編集するメソッド
	public int update(TaskBean bean) throws SQLException, ClassNotFoundException {
		
		String sql = "UPDATE t_task SET task_name = ?, category_id = ?, limit_date = ?, user_id = ?, status_code = ?, memo = ? WHERE task_id = ?";
		
		try(Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)){
			
			pstmt.setString(1, bean.getTaskName());
			pstmt.setInt(2, bean.getCategoryID());
			if(bean.getLimitDate()!=null) {
				pstmt.setDate(3, java.sql.Date.valueOf(bean.getLimitDate()));
			}else {
				pstmt.setDate(3, null);
			}
			pstmt.setString(4, bean.getUserID());
			pstmt.setString(5, bean.getStatusCode());
			pstmt.setString(6, bean.getMemo());
			pstmt.setInt(7, bean.getTaskID());
			
			int count = pstmt.executeUpdate();
			
			return count;
		}
	}
	
	//タスクIDに対応するタスク情報を取ってくるメソッド
	public TaskBean selectTask(int taskID) throws SQLException, ClassNotFoundException{
		
		String sql = "SELECT t1.task_id, t1.task_name, t1.category_id, t2.category_name, t1.limit_date, t1.user_id, t3.user_name, t1.status_code, t4.status_name, t1.memo "
				+ "FROM t_task t1 inner join m_category t2 on t1.category_id = t2.category_id "
				+ "inner join m_user t3 on t1.user_id = t3.user_id "
				+ "inner join m_status t4 on t1.status_code = t4.status_code "
				+ "WHERE task_id = ?";
		
		try(Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)){
			
			pstmt.setInt(1, taskID);
			ResultSet res = pstmt.executeQuery();
			
			TaskBean bean = new TaskBean();
			if(res.next()) {
				bean.setTaskID(res.getInt("task_id"));
				bean.setTaskName(res.getString("task_name"));
				bean.setCategoryID(res.getInt("category_id"));
				bean.setCategoryName(res.getString("category_name"));
				if(res.getDate("limit_date") != null) {
					bean.setLimitDate(res.getDate("limit_date").toLocalDate());
				}else {
					bean.setLimitDate(null);
				}
				bean.setUserID(res.getString("user_id"));
				bean.setUserName(res.getString("user_name"));
				bean.setStatusCode(res.getString("status_code"));
				bean.setStatusName(res.getString("status_name"));
				bean.setMemo(res.getString("memo"));
			}
			
			return bean;
		}
		
	}

}
