package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.entity.StatusBean;

public class TaskDAO {

	public List<StatusBean> selectStatus() throws ClassNotFoundException, SQLException {

		String sql = "SELECT status_code,status_name FROM m_status";
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
  
	public List<CategoryBean> selectCategory() throws SQLException, ClassNotFoundException {
		
		String sql = "SELECT category_id, category_name FROM m_category";
		
		try(Connection con = ConnectionManager.getConnection();
				Statement stmt = con.createStatement();
				ResultSet res = stmt.executeQuery(sql)){
			
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
