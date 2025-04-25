<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="model.entity.TaskBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>タスク管理システム - 登録完了</title>
<link href="css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
	<!-- ヘッダー -->
	<%@ include file="header.jsp"%>

	<%
	TaskBean bean = (TaskBean) (session.getAttribute("bean"));
	%>

	<!-- メイン画面 -->
	<main>
		<div class="inner">
			<h2>以下の内容で登録が完了しました</h2>
			<div class="inner">
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
 } else {
 %> <%
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
							<td><%=bean.getMemo()%></td>
						</tr>
					</table>
				</div>
			</div>

			<form action="menu.jsp" method="get">
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