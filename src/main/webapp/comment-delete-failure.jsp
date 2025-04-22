<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>タスク管理システム - コメント削除失敗</title>
</head>
<body>
	
	<%@ include file="header.jsp"%>
	
	<h1>コメントの削除に失敗しました</h1>
	
	<br>

	<form action="comment.jsp" method="POST">
		<input type="submit" value="コメントに戻る">
	</form>
	<br>
	<br>
	<%@ include file="footer.jsp"%>
	

</body>
</html>