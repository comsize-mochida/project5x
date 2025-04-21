<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>タスク管理システム - メニュー</title>
</head>
<body>
	<!-- メニューとログインユーザ情報を表示するメニュー画面 -->
	<p><%@ include file="header.jsp"%></p>
	<h1>メニュー画面</h1>


	<form action="register-confirm-servlet" method="GET">
		<input type="submit" value="登録画面へ">
	</form>

	<form action="task-list-servlet" method="GET">
		<input type="submit" value="タスク一覧画面へ">
	</form>

	
<%@ include file="footer.jsp"%>
</body>
</html>