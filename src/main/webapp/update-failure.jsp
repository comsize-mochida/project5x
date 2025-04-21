<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>タスク管理システム - 編集失敗</title>
</head>
<body>
	<%@ include file="header.jsp" %>
	<h1>編集に失敗しました</h1>
	<%
	request.setCharacterEncoding("UTF-8");
	int taskID = (int)session.getAttribute("taskID");
	%>
	<form action="update-servlet" method="get">
		<input type="hidden" name="taskID" value="<%= taskID %>">
		<input type="submit" value="編集内容入力に戻る">
	</form>
	<%@ include file="footer.jsp" %>
</body>
</html>