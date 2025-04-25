<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>タスク管理システム - ログイン失敗</title>
<link href="css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
	<!-- ヘッダー -->
	<header>
		<div class="inner">
			<!--サイト名-->
			<h1>タスク管理システム</h1>
		</div>
	</header>
	<!-- メイン画面 -->
	<main>
		<div class="inner">
			<form action="login.jsp" method="POST">
				<h2>ログインに失敗画面</h2>
				<hr>
				<h3>ログインに失敗しました</h3>
				<input type="submit" class="btn" value="ログイン画面へ">
			</form>
		</div>
	</main>
</body>
</html>