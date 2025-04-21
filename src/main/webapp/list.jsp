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
	int currentPage = (Integer) request.getAttribute("currentPage");
	int totalPages = (Integer) request.getAttribute("totalPages");
	%>
	<form action="delete-comfirm-servlet" method="POST">
		<table border="double">
			<tr>
				<th>削除</th>
				<th>タスク名</th>
				<th>カテゴリ情報</th>
				<th>期限</th>
				<th>担当者情報</th>
				<th>ステータス情報</th>
				<th>メモ</th>

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
			</tr>
			<%
			}
			%>
			<!-- ページネーション -->
			<div class="pagination">
				<%
				if (currentPage > 1) {
				%>
				<a href="?page=<%=currentPage - 1%>">前へ</a>
				<%
				}
				%>

				<%
				for (int i = 1; i <= totalPages; i++) {
				%>
				<%
				if (i == currentPage) {
				%>
				<strong><%=i%></strong>
				<%
				} else {
				%>
				<a href="?page=<%=i%>"><%=i%></a>
				<%
				}
				%>
				<%
				}
				%>

				<%
				if (currentPage < totalPages) {
				%>
				<a href="?page=<%=currentPage + 1%>">次へ</a>
				<%
				}
				%>
			</div>
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