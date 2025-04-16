package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.entity.CategoryBean;

public class TaskDAO {

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
	
	
}
