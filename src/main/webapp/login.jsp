<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>タスク管理システム - ログイン</title>
<link href="css/style.css" rel="stylesheet" type="text/css">

</head>
<body>
	<header>
		<div class="inner">
			<!--サイト名-->
			<h1>タスク管理システム</h1>
		</div>
	</header>
	<main>
		<div class="inner">
			<h2>ユーザIDとパスワードを入力してください</h2>
			<form action="login-servlet" method="POST">
				<div class="login-text">
					 ユーザID<input type="text" name="userID" maxlength="24"><br>
					パスワード<input type="password" name="password" maxlength="32">
				</div>
				<div class="button-group">
					<input type="submit" class="btn btn-login" name="login" value="ログイン">
					<input type="reset" class="btn btn-cancel" value="取消">
				</div>
			</form>
		</div>
	</main>
	<footer>
		<div class="inner"></div>
	</footer>
</body>
</html>