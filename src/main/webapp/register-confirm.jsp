<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.entity.TaskBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>タスク管理システム - 登録情報確認</title>
</head>
<body>

	<%@ include file="header.jsp"%>
	
	<% TaskBean bean = (TaskBean)(session.getAttribute("bean")); %>

	<h1>この内容で登録してよろしいですか？</h1>
	
	<form action="register-servlet" method="POST">
		
		<table>
			
			<tr>
				
				<th>タスク名：</th>
				<td><%= bean.getTaskName() %></td>
				
			</tr>
			
			<tr>
				
				<th>カテゴリ情報：</th>
				<td><%= bean.getCategoryName() %></td>
				
			</tr>
			
			<tr>
				
				<th>期限：</th>
				<td><% if(bean.getLimitDate() != null){%>
					
					<%= bean.getLimitDate() %>
					
					<%}else{%>
							
					
							
					<%}%></td>
				
			</tr>
			
			<tr>
				
				<th>担当者情報：</th>
				<td><%= bean.getUserName() %></td>
				
			</tr>
			
			<tr>
				
				<th>ステータス情報：</th>
				<td><%= bean.getStatusName() %></td>
				
			</tr>
			
			<tr>
				
				<th>メモ：</th>
				<td><%= bean.getMemo() %></td>
				
			</tr>
			
		</table>
		
		<input type="button" onclick="javascript:history.back()" value="登録情報入力に戻る">
		<input type="submit" value="登録">
		
	</form>
	
	<br>

	<%@ include file="footer.jsp"%>

</body>
</html>