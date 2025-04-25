<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.List,model.entity.TaskBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>タスク管理システム - タスク一覧</title>
<link href="css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
	<!-- ヘッダー -->
	<%@ include file="header.jsp"%>

	<!-- メイン画面 -->
	<main>
		<div class="inner">
			<h2>タスク一覧画面</h2>

			<%
			List<TaskBean> TaskBeanList = (List) request.getAttribute("list");
			%>
			<div class="form-wrap">
				<form action="delete-confirm-servlet" method="POST">
					<table class="form-table">
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
								%><input type="checkbox" name="taskID"
								value="<%=Category.getTaskID()%>"> <%
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
								%> <%

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
								%> <%

 %> <%
 } else {
 %> <%=Category.getMemo()%> <%
 }
 %>
							</td>

							<td><input type="button" value="コメント"
								onclick="location.href='comment-servlet?taskID=<%=Category.getTaskID()%>&taskName=<%=Category.getTaskName()%>'">
							</td>
						</tr>
						<%
						}
						%>
					</table>
					<%
					for (TaskBean Category : TaskBeanList) {
					%>
					<%
					if (session.getAttribute("userName").equals(Category.getUserName())) {
					%><input type="submit" class="btn" value="削除">
					<%
					break;
					}
					%>
					<%
					}
					%>

				</form>
			</div>
			<form action="menu.jsp" method="POST">
				<input type="submit" class="btn" value="メニューに戻る">
			</form>
		</div>
		<!--PAGETOP-->
		<div class="pagetop">
			<p>
				<a href="#top">PageTop</a>
			</p>
		</div>
	</main>

	<!-- フッター -->
	<%@ include file="footer.jsp"%>
	<script type="text/javascript" src="js/jquery-3.7.1.min.js"></script>
	<script type="text/javascript" src="js/jquery.smoothscroll.js"></script>
	<script type="text/javascript" src="js/jquery.inview.min.js"></script>
	<script type="text/javascript" src="js/slick.min.js"></script>
	<script>
		//ふわっと表示
		$(function() {
			$(".inview").on("inview", function() {
				$(this).addClass("fade-in");
			});
		});

		//Pagetop	
		$(window).on("scroll", function() {
			if ($(this).scrollTop() > 100) {
				$(".pagetop").fadeIn();
			} else {
				$(".pagetop").fadeOut();
			}
		});
	</script>
</body>
</html>