<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="model.entity.TaskBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>タスク管理システム - 編集情報確認</title>
<link href="css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
	<!-- ヘッダー -->
	<%@ include file="header.jsp"%>
	<!-- メイン画面 -->
	<main>
		<div class="inner">
			<h2>この内容で編集してよろしいですか？</h2>

			<%
			request.setCharacterEncoding("UTF-8");
			TaskBean bean = (TaskBean) session.getAttribute("task");
			%>
			<form action="update-servlet" method="post">
				<div class="form-wrap">
					<table class="form-table">
						<tr>
							<th>タスク名：</th>
							<td><%=bean.getTaskName()%></td>
						</tr>
						<tr>
							<th>カテゴリ情報：</th>
							<td><%=bean.getCategoryName()%></td>
						</tr>
						<tr>
							<th>期限：</th>
							<td>
								<%
								if (bean.getLimitDate() != null) {
								%> <%=bean.getLimitDate()%> <%
 }
 %>
							</td>
						</tr>
						<tr>
							<th>担当者情報：</th>
							<td><%=bean.getUserName()%></td>
						</tr>
						<tr>
							<th>ステータス情報：</th>
							<td><%=bean.getStatusName()%></td>
						</tr>
						<tr>
							<th>メモ：</th>
							<td>
								<%
								if (bean.getMemo() != null) {
								%> <%=bean.getMemo()%> <%
 }
 %>
							</td>
						</tr>
					</table>
				</div>
				<input type="button" class="btn" onclick="history.back()"
					value="編集情報入力に戻る"> <input type="submit" class="btn"
					value="編集">
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