package model.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import model.entity.UserBean;

class UserDAOTest {

	@Test
	void selectUser_成功() {
		
		UserDAO dao = new UserDAO();
		List<UserBean> list = new ArrayList<>();
		
		try {
			
			list = dao.selectUser();
			
		} catch (SQLException e) {

			e.printStackTrace();

		} catch (ClassNotFoundException e) {

			e.printStackTrace();

		}
		
	}

}
