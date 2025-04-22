<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>タスク管理システム - 削除失敗</title>
</head>
<body>
	<%@ include file="header.jsp"%>
	<h1>削除に失敗しました</h1>
	
	<br>

	<form action="task-list-servlet" method="GET">
		<input type="submit" value="一覧に戻る">
	</form>
	<br>
	<br>
	<%@ include file="footer.jsp"%>

</body>
</html>