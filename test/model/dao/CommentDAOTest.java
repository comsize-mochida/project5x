package model.dao;


import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import model.entity.CommentBean;

class CommentDAOTest {

	
	@Test
	void register_成功() {
		//準備Arrange
		CommentDAO dao = new CommentDAO();
		int count = 0;
		CommentBean bean = new CommentBean();
		bean.setTaskID(1);
		bean.setUserID("a-takahashi");
		bean.setComment("サンプル");
		
		//実行Act
		try {
			count = dao.register(bean);
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		//検証Assert
		assertEquals(1, count);
	}
	
	@Test
	void register_失敗() {
		//準備Arrange
		CommentDAO dao = new CommentDAO();
		int count = 0;
		CommentBean bean = new CommentBean();
		bean.setTaskID(100);
		bean.setUserID("a-takahashi");
		bean.setComment("サンプル");
		
		//実行Act
		try {
			count = dao.register(bean);
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		//検証Assert
		assertEquals(0, count);
	}
	
	@Test
	void delete_成功() {
		//準備Arrange
		CommentDAO dao = new CommentDAO();
		int commentID = 2;
		int count = 0;
		CommentBean bean = null;
		
		//実行Act
		try {
			count = dao.delete(commentID);
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		//検証Assert
		assertEquals(1, count);
		
	}

	
	@Test
	void delete_失敗() {
		//準備Arrange
		CommentDAO dao = new CommentDAO();
		int commentID = 100;
		int count = 0;
		CommentBean bean = null;
		
		//実行Act
		try {
			count = dao.delete(commentID);
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		//検証Assert
		assertEquals(0, count);
		
	}
  
	@Test
	void selectAll_成功() {
		
		CommentDAO dao = new CommentDAO();
		List<CommentBean> list = new ArrayList<>();
		int taskID = 1;
		
		try {
			
			list = dao.selectAll(taskID);
		
		} catch (SQLException e) {

			e.printStackTrace();

		} catch (ClassNotFoundException e) {

			e.printStackTrace();

		}
		
		
	}

}
