<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>タスク管理システム - ログイン</title>
</head>
<body>

<form action="login-servlet" method="POST">

<h1>ユーザIDとパスワードを入力してください</h1>
<br>
ユーザID<input type="text"name="userID"maxlength="24" ><br>
パスワード<input type="password"name="password"maxlength="32"><br>
<input type="submit" name="login" value="ログイン">
<input type="reset" value="取消">

</form>
</body>
</html>