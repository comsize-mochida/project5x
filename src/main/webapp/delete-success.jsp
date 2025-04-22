<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="model.entity.TaskBean" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>タスク管理システム - 削除成功</title>
</head>
<body>
	<%@ include file="header.jsp"%>
	<h1>以下の内容を削除しました</h1>


	<%
	List<TaskBean> deleteTasks = (List<TaskBean>) session.getAttribute("deleteTasks");

	for (TaskBean task : deleteTasks) {
	%>

	<table>
		<tr>
			<th>タスク名:</th>
			<td><%= task.getTaskName() %></td>
		</tr>
		<tr>
			<th>カテゴリ情報:</th>
			<td><%= task.getCategoryName() %></td>
		</tr>
		<tr>
			<th>期限:</th>
			<td><%= task.getLimitDate() %></td>
		</tr>
		<tr>
			<th>担当者情報:</th>
			<td><%= task.getUserName() %></td>
		</tr>
		<tr>
			<th>ステータス情報:</th>
			<td><%= task.getStatusName() %></td>
		</tr>
		<tr>
			<th>メモ:</th>
			<td><%= task.getMemo() %></td>
		</tr>
	</table>
	<hr>
	
	<%
	} 
	%>
	
	<br>

	<form action="menu.jsp" method="POST">
		<input type="submit" value="メニューに戻る">
	</form>
	<br>
	<br>

	<%@ include file="footer.jsp"%>

</body>
</html>