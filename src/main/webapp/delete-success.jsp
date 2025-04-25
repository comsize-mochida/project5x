<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="model.entity.TaskBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>タスク管理システム - 削除成功</title>
<link href="css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
	<!-- ヘッダー -->
	<%@ include file="header.jsp"%>

	<!-- メイン画面 -->
	<main>
		<div class="inner">
			<h2>以下の内容を削除しました</h2>

			<%
			List<TaskBean> deleteTasks = (List<TaskBean>) session.getAttribute("deleteTasks");

			for (TaskBean task : deleteTasks) {
			%>

			<table class="form-table">
				<tr>
					<th>タスク名:</th>
					<td><%=task.getTaskName()%></td>
				</tr>
				<tr>
					<th>カテゴリ情報:</th>
					<td><%=task.getCategoryName()%></td>
				</tr>
				<tr>
					<th>期限:</th>
					<td>
						<%
						if (task.getLimitDate() != null) {
						%> <%=task.getLimitDate()%> <%
 }
 %>
					</td>
				</tr>
				<tr>
					<th>担当者情報:</th>
					<td><%=task.getUserName()%></td>
				</tr>
				<tr>
					<th>ステータス情報:</th>
					<td><%=task.getStatusName()%></td>
				</tr>
				<tr>
					<th>メモ:</th>
					<td><%=task.getMemo()%></td>
				</tr>
			</table>
			<hr>

			<%
			}
			%>

			<br>

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