<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.List, model.entity.CommentBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>タスク管理システム - コメント</title>
</head>
<body>
	<%@ include file="header.jsp" %>
	<%
	request.setCharacterEncoding("UTF-8");
	List<CommentBean> commentList = (List<CommentBean>)request.getAttribute("commentList");
	int taskID = (int)session.getAttribute("taskID");
	String taskName = (String)session.getAttribute("taskName");
	String userID = (String)session.getAttribute("userID");
	%>	
	<h1>コメント一覧</h1>
	<h2>タスク名：<%= taskName %></h2>
	
	<table border="double">
		<tr>
			<th>No</th><th>投稿者</th><th>コメント内容</th><th>投稿日時</th>
		</tr>
	<% for(CommentBean bean : commentList){ %>
		<tr>
			<td><%= bean.getCommentID() %></td>
			<td><%= bean.getUserName() %></td>
			<td><%= bean.getComment() %></td>
			<td><%= bean.getUpdateDatetime() %></td>
		</tr>
	<% } %>
	</table>
	<br>
	<h2>コメント追加</h2>
	<form action="comment-servlet" method="POST">
		<input type="hidden" name="taskID" value="<%= taskID %>">
		<input type="hidden" name="userID" value="<%= userID %>">
		<textarea name="comment" cols="50" rows="10"></textarea>
		<br><input type="submit" value="投稿">
	</form>
	<br>
	<form>
	<input type="button" onclick="location.href='task-list-servlet';" value="一覧に戻る">
	</form>
	<br>
	<%@ include file="footer.jsp" %>
</body>
</html>