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
		
		String sql = "SELECT category_id, category_name FROM m_category";
		
		try(Connection con = ConnectionManager.getConnection();
				PreparedStatement stmt = con.prepareStatement(sql);
				ResultSet res = stmt.executeQuery()){
			
			List<CategoryBean> list = new ArrayList<>();
			while(res.next()) {
				CategoryBean bean = new CategoryBean();
				bean.setCategoryID(res.getInt("category_id"));
				bean.setCategoryName(res.getString("category_name"));
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
			pstmt.setDate(3,java.sql.Date.valueOf(bean.getLimitDate()));
			pstmt.setString(4, bean.getUserID());
			pstmt.setString(5, bean.getStatusCode());
			pstmt.setString(6, bean.getMemo());

			count = pstmt.executeUpdate();
		}

		return count;

	}
	
}
