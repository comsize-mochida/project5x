<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="java.util.List,model.entity.CategoryBean,model.entity.StatusBean,model.entity.UserBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>タスク管理システム - 新規登録</title>
<link href="css/style.css" rel="stylesheet" type="text/css">
</head>
<body>

	<!-- ヘッダー -->
	<%@ include file="header.jsp"%>

	<!-- メイン画面 -->
	<main>
		<div class="inner">
			<h2>登録情報を入力してください</h2>

			<form action="register-confirm-servlet" method="post">
				<div class="inner">
					<div class="form-wrap">
						<table class="form-table">
							<tr>
								<th>タスク名：</th>
								<td><input type="text" name="taskName" size="50"
									maxlength="50" required></td>
							</tr>

							<tr>
								<th>カテゴリ情報：</th>
								<td><select name="category" required>
										<%
										List<CategoryBean> categoryList = (List) (session.getAttribute("categoryList"));
										for (CategoryBean cb : categoryList) {
										%>
										<option
											value="<%=cb.getCategoryID()%>,<%=cb.getCategoryName()%>"><%=cb.getCategoryName()%></option>
										<%
										}
										%>
								</select></td>
							</tr>

							<tr>
								<th>期限：</th>
								<td><input type="date" name="limitDate" id="limitDate"></td>
							</tr>

							<tr>
								<th>担当者情報：</th>
								<td><select name="user" required>
										<%
										List<UserBean> userList = (List) (session.getAttribute("userList"));
										for (UserBean ub : userList) {
										%>
										<option value="<%=ub.getUserID()%>,<%=ub.getUserName()%>"><%=ub.getUserName()%></option>
										<%
										}
										%>
								</select></td>
							</tr>

							<tr>
								<th>ステータス情報：</th>
								<td><select name="status" required>
										<%
										List<StatusBean> statusList = (List) (session.getAttribute("statusList"));
										for (StatusBean sb : statusList) {
										%>
										<option
											value="<%=sb.getStatusCode()%>,<%=sb.getStatusName()%>"><%=sb.getStatusName()%></option>
										<%
										}
										%>
								</select></td>
							</tr>

							<tr>
								<th>メモ：</th>
								<td><textarea name="memo" rows="10" maxlength="100"
										cols="50"></textarea>
							</tr>
						</table>
					</div>
				</div>

				<input type="button" class="btn" onclick="location.href='menu.jsp'"
					value="メニューに戻る"> <input type="submit" class="btn"
					value="登録内容の確認に進む">
			</form>

			<script>
				//Dateクラスのインスタンス
				//生成時に今日の年月日時間を持つ
				const day = new Date();

				//today.toISOString()→"2025-04-17T08:24:50.123Z"
				//split("T")Tを区切りにして、[0]日付部分だけを取り出す
				const today = day.toISOString().split("T")[0];

				//document.getElementById("date")でid属性がdateのものを取得
				//.minで↑のmin属性を設定する
				document.getElementById("limitDate").min = today;
			</script>
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