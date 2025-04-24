package model.dao;


import static org.junit.jupiter.api.Assertions.*;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import model.entity.StatusBean;
import model.entity.TaskBean;

class TaskDAOTest {

	@Test
	void register_成功() {

		TaskDAO dao = new TaskDAO();
		TaskBean bean = new TaskBean();
		int count = 0;

		bean.setTaskName("タスク1");
		bean.setCategoryID(1);
		bean.setLimitDate(LocalDate.parse("2025-05-10"));
		bean.setUserID("a-takahashi");
		bean.setStatusCode("00");
		bean.setMemo("担当者は仮です");

		try {

			count = dao.register(bean);

		} catch (SQLException e) {

			e.printStackTrace();

		} catch (ClassNotFoundException e) {

			e.printStackTrace();

		}

	}

	@Test
	void register_失敗() {

		TaskDAO dao = new TaskDAO();

		TaskBean bean = null;
		int taskID = 1;
		TaskBean bean = new TaskBean();
		int count = 0;

		bean.setTaskName(null);
		bean.setCategoryID(1);
		bean.setLimitDate(LocalDate.parse("2025-05-10"));
		bean.setUserID("a-takahashi");
		bean.setStatusCode("00");
		bean.setMemo("担当者は仮です");

		try {

			count = dao.register(bean);

		} catch (SQLException e) {

			e.printStackTrace();

		} catch (ClassNotFoundException e) {

			e.printStackTrace();

		}

	}

	@Test
	void selectStatus_成功() {
		
		TaskDAO dao = new TaskDAO();
		List<StatusBean> list = new ArrayList<>();

		try {
			
			list = dao.selectStatus();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		} catch (ClassNotFoundException e) {
			
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
