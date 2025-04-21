<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.entity.TaskBean" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>タスク管理システム - 編集完了</title>
</head>
<body>
	<%@ include file="header.jsp" %>
		
	<h1>以下の内容で編集が完了しました</h1>
	
	<%
	request.setCharacterEncoding("UTF-8");
	TaskBean bean = (TaskBean)session.getAttribute("task");
	%>
	
	<table>
		<tr>
			<th>タスク名：</th>
			<td><%= bean.getTaskName() %></td>
		</tr>
		<tr>
			<th>カテゴリ情報：</th>
			<td><%= bean.getCategoryName() %></td>
		</tr>
		<tr>
			<th>期限：</th>
			<td>
			<% if(bean.getLimitDate()!=null){ %>
				<%= bean.getLimitDate() %>
			<% }%>
			</td>
		</tr>
		<tr>
			<th>担当者情報：</th>
			<td><%= bean.getUserName() %></td>
		</tr>
		<tr>
			<th>ステータス情報：</th>
			<td><%= bean.getStatusName() %></td>
		</tr>
		<tr>
			<th>メモ：</th>
			<td>
			<% if(bean.getMemo()!=null){ %>
				<%= bean.getMemo() %>
			<% }%>
			</td>
		</tr>
	</table>
	<form action="menu.jsp" method="GET">
		<input type="submit" value="メニューに戻る">
	</form>
	<%@ include file="footer.jsp" %>
</body>
</html>