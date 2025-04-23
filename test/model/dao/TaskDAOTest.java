package model.dao;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import model.entity.CategoryBean;
import model.entity.TaskBean;

class TaskDAOTest {

	@Test
	void selectCategory_成功() {
		//準備Arrange
		TaskDAO dao = new TaskDAO();
		List<CategoryBean> list = new ArrayList<>();
		
		//実行Act
		try{
			list = dao.selectCategory();
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		//検証Assert
		assertNotNull(list);
	}
	
	@Test
	void selectTask_成功() {
		//準備Arrange
		TaskDAO dao = new TaskDAO();
		TaskBean bean = new TaskBean();
		int taskID = 1;
		
		//実行Act
		try {
			bean = dao.selectTask(taskID);
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
