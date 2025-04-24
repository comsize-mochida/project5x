package model.dao;

import static org.junit.jupiter.api.Assertions.*;

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

		//検証
		assertNotNull(list);

	}
	@Test
	void login_成功() {
		UserDAO dao = new UserDAO();
		UserBean userBean = null;
		String userID = "a-takahashi";
		String password = "ai";
		try {
			userBean = dao.login(userID, password);
		}catch(ClassNotFoundException | SQLException e){
			e.printStackTrace();
		}
		assertEquals("高橋愛", userBean.getUserName());
	}
	@Test
	void login_失敗() {
		//		準備
		UserDAO dao = new UserDAO();
		UserBean userBean = null;
		String 	userID = "tarou";
		String password = "test";

		//		実行
		try {
			userBean = dao.login(userID, password);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		//	検証
		assertNull(userBean.getUserName());
	}



}
