<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<body>

	<%
	
	String userName = (String)(session.getAttribute("userName"));
	
	%>
	
	ログインユーザ：<%= userName %>
	
</body>
</html>