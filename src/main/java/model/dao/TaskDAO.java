package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.entity.StatusBean;

public class TaskDAO {

	public List<StatusBean> selectStatus() throws ClassNotFoundException, SQLException {

		String sql = "SELECT status_code,status_name FROM m_status";
		List<StatusBean> list = new ArrayList<>();

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {

			ResultSet res = pstmt.executeQuery();

			while (res.next()) {

				StatusBean bean = new StatusBean();

				bean.setStatusCode(res.getString("status_code"));
				bean.setStatusName(res.getString("status_name"));

				list.add(bean);

			}

		}

		return list;

	}

}
