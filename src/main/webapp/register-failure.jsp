<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>タスク管理システム - 登録失敗</title>
</head>
<body>

	<%@ include file="header.jsp"%>
	
	<h1>登録に失敗しました</h1>
	
	<form action="menu.jsp" method="get">
		
		<input type="submit" value="登録内容入力に戻る">
		
	</form>
	
	<%@ include file="footer.jsp"%>
	
</body>
</html>