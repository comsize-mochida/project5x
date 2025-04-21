package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.entity.UserBean;

public class UserDAO {

	public UserBean login(String id, String pass) throws SQLException, ClassNotFoundException {

		// データベースへの接続の取得、Statementの取得、SQLステートメントの実行

		UserBean user = new UserBean();

		String sql = "SELECT * FROM m_user WHERE user_id = ?";
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {

			// 結果の操作

			pstmt.setString(1, id);
			ResultSet res = pstmt.executeQuery();

			if (res.next()) {
				if (pass.equals(res.getString("password"))) {
					String userID = res.getString("user_id");
					String password = res.getString("password");
					String userName = res.getString("user_name");

					// UserBean user = new UserBean();
					user.setUserID(userID);
					user.setPassword(password);
					user.setUserName(userName);
					return user;
				} else {

					return user;
				}

			} else {

				return user;
			}

		}
	}

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
