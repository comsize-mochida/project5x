<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>タスク管理システム - メニュー</title>
<link href="css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
	<!-- メニューとログインユーザ情報を表示するメニュー画面 -->

	<!-- ヘッダー -->
	<p><%@ include file="header.jsp"%></p>

	<!-- メイン画面 -->
	<main>
		<div class="inner">
			<h2>メニュー画面</h2>
			<div class="menu-btn">
				<form action="register-confirm-servlet" method="GET">
					<input type="submit" class="btn insert-page-btn" value="登録画面へ">
				</form>

				<form action="task-list-servlet" method="GET">
					<input type="submit" class="btn task-page-btn" value="タスク一覧画面へ">
				</form>
			</div>
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