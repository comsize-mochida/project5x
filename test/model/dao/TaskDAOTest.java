package model.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.time.LocalDate;
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
		TaskBean bean = null;
		int taskID = 1;
		
		//実行Act
		try {
			bean = dao.selectTask(taskID);
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		//検証Assert
		assertNotNull(bean);
	}

	
	@Test
	void update_成功() {
		//準備Arrange
		TaskDAO dao = new TaskDAO();
		int count = 0;
		TaskBean bean = new TaskBean();
		bean.setTaskName("サンプル");
		bean.setCategoryID(1);
		bean.setLimitDate(LocalDate.parse("2025-04-30"));
		bean.setUserID("a-takahashi");
		bean.setStatusCode("00");
		bean.setMemo("サンプル");
		bean.setTaskID(1);
		
		//実行Act
		try {
			count = dao.update(bean);
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		//検証Assert
		assertEquals(1,count);
	}
	
	@Test
	void update_失敗() {
		//準備Arrange
		TaskDAO dao = new TaskDAO();
		int count = 0;
		TaskBean bean = new TaskBean();
		bean.setTaskName(null);
		bean.setCategoryID(1);
		bean.setLimitDate(LocalDate.parse("2025-04-30"));
		bean.setUserID("a-takahashi");
		bean.setStatusCode("00");
		bean.setMemo("サンプル");
		bean.setTaskID(1);
		
		//実行Act
		try {
			count = dao.update(bean);
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		//検証Assert
		assertEquals(0,count);
	}
}
