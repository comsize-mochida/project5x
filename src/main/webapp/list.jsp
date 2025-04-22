<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.List,model.entity.TaskBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>タスク管理システム - タスク一覧</title>
</head>
<body>
	<%@ include file="header.jsp"%>
	<h1>タスク一覧画面</h1>

	<%
	List<TaskBean> TaskBeanList = (List) request.getAttribute("list");
	%>
	<form action="delete-confirm-servlet" method="POST">
		<table border="double">
			<tr>
				<th>削除</th>
				<th>タスク名</th>
				<th>カテゴリ情報</th>
				<th>期限</th>
				<th>担当者情報</th>
				<th>ステータス情報</th>
				<th>メモ</th>
				<th>コメント</th>

			</tr>
			<%
			for (TaskBean Category : TaskBeanList) {
			%>
			<tr>
				<td>
					<%
					if (session.getAttribute("userName").equals(Category.getUserName())) {
					%><input type="checkbox" name="taskID" value="<%=Category.getTaskID()%>">
					<%
					}
					%>
				</td>
				<td>
					<%
					if (session.getAttribute("userName").equals(Category.getUserName())) {
					%> <a href="update-servlet?taskID=<%=Category.getTaskID()%>"><%=Category.getTaskName()%></a>
					<%
					} else {
					%> <%=Category.getTaskName()%> <%
 }
 %>
				</td>
				<td><%=Category.getCategoryName()%></td>
				<td>
					<%
					if (Category.getLimitDate() == null) {
					%>
					<%

					%> <%
 } else {
 %> <%=Category.getLimitDate()%> <%
 }
 %>
				</td>
				<td><%=Category.getUserName()%></td>
				<td><%=Category.getStatusName()%></td>
				<td>
					<%
					if (Category.getMemo() == null) {
					%>
					<%

					%> <%
 } else {
 %> <%=Category.getMemo()%> <%
 }
 %>
				</td>
				
				<td>
				
				<input type="button" value="コメント" onclick="location.href='comment-servlet?taskID=<%=Category.getTaskID()%>&taskName=<%=Category.getTaskName()%>'">
				
				</td>
			</tr>
			<%
			}
			%>
			
		</table>
		<br> <input type="submit" value="削除">
	</form>
	<br>
	<form action="menu.jsp" method="POST">
		<input type="submit" value="メニューに戻る">
	</form>
	<br>


	<%@ include file="footer.jsp"%>

</body>
</html>