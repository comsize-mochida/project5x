package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.entity.UserBean;

public class UserDAO {

	public List<UserBean> selectUser() throws SQLException, ClassNotFoundException {
		
		String sql = "SELECT user_id,user_name FROM m_user ORDER BY user_name";
		List<UserBean> list = new ArrayList<UserBean>();
		
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet res = pstmt.executeQuery()) {
			
			while (res.next()) {

				UserBean bean = new UserBean();

				bean.setUserID(res.getString("user_id"));
				bean.setUserName(res.getString("user_name"));

				list.add(bean);
			}
		}
		return list;
		
	}
	
}
