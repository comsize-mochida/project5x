package model.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import model.entity.CommentBean;

class CommentDAOTest {

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
