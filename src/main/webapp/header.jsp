<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link href="css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
	<header>
		<div class="inner">
			<!--サイト名-->
			<h1>タスク管理システム</h1>
		</div>
			<%
			String userName = (String) (session.getAttribute("userName"));
			%>
			<p class="login-user"><strong>ログインユーザ：</strong><%=userName%></p>
	</header>
</body>
</html>