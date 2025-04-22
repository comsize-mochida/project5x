package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.entity.CommentBean;

public class CommentDAO {

	public List<CommentBean> selectAll(int taskID) throws SQLException, ClassNotFoundException {
		
		List<CommentBean> list = new ArrayList<>();
		String sql = "SELECT t1.comment_id,t2.user_name,t1.comment,t1.update_datetime"
				+ " FROM t_comment t1 INNER JOIN m_user t2 ON t1.user_id = t2.user_id"
				+ " WHERE task_id = ?";

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				) {
			
			pstmt.setInt(1, taskID);
			
			try(ResultSet res = pstmt.executeQuery()){
				while (res.next()) {
					
					CommentBean bean = new CommentBean();
					
					bean.setCommentID(res.getInt("comment_id"));
					bean.setUserName(res.getString("user_name"));
					bean.setComment(res.getString("comment"));
					bean.setUpdateDatetime(res.getTimestamp("update_datetime").toLocalDateTime());
	
					list.add(bean);
				}
			}
			return list;

		}
	}
	
	public int register(CommentBean bean) throws SQLException, ClassNotFoundException {
		
		String sql = "INSERT INTO t_comment (task_id, user_id, comment) VALUES (?, ?, ?)";
		
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)){
			
			pstmt.setInt(1, bean.getTaskID());
			pstmt.setString(2, bean.getUserID());
			pstmt.setString(3, bean.getComment());
			
			int count = pstmt.executeUpdate();
			
			return count;
		}
		
	}
	
	public int delete(int commentID) throws SQLException, ClassNotFoundException {
		
		String sql = "DELETE FROM t_comment WHERE comment_id = ?";
		
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)){
			
			pstmt.setInt(1, commentID);
			
			int count = pstmt.executeUpdate();
			
			return count;
		}
		
	}
	
}
