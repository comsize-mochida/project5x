<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="java.util.List, model.entity.TaskBean, model.entity.CategoryBean, model.entity.StatusBean, model.entity.UserBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>タスク管理システム - 編集</title>
<link href="css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
	<!-- ヘッダー -->
	<%@ include file="header.jsp"%>

	<!-- メイン画面 -->
	<main>
		<div class="inner">
			<h2>変更する項目を編集してください</h2>

			<%
			request.setCharacterEncoding("UTF-8");
			TaskBean taskBean = (TaskBean) request.getAttribute("taskBean");
			List<CategoryBean> categoryList = (List<CategoryBean>) request.getAttribute("categoryList");
			List<StatusBean> statusList = (List<StatusBean>) request.getAttribute("statusList");
			List<UserBean> userList = (List<UserBean>) request.getAttribute("userList");
			%>

			<form action="update-confirm-servlet" method="POST">
				<div class="form-wrap">
					<table class="form-table">
						<tr>
							<th>タスク名</th>
							<td><input type="text" value="<%=taskBean.getTaskName()%>"
								name="taskName" size="50" required></td>
						</tr>
						<tr>
							<th>カテゴリ情報</th>
							<td><select name="category" required>
									<%
									for (CategoryBean bean : categoryList) {
									%>
									<%
									if (bean.getCategoryID() == taskBean.getCategoryID()) {
									%>
									<option
										value="<%=bean.getCategoryID()%>/<%=bean.getCategoryName()%>"
										selected><%=bean.getCategoryName()%></option>
									<%
									} else {
									%>
									<option
										value="<%=bean.getCategoryID()%>/<%=bean.getCategoryName()%>"><%=bean.getCategoryName()%></option>
									<%
									}
									%>
									<%
									}
									%>
							</select></td>
						</tr>
						<tr>
							<th>期限</th>
							<td><input type="date" value="<%=taskBean.getLimitDate()%>"
								name="limitDate" id="limitDate"></td>
						</tr>
						<tr>
							<th>担当者情報</th>
							<td><select name="user" required>
									<%
									for (UserBean bean : userList) {
									%>
									<%
									if (bean.getUserID().equals(taskBean.getUserID())) {
									%>
									<option value="<%=bean.getUserID()%>/<%=bean.getUserName()%>"
										selected><%=bean.getUserName()%></option>
									<%
									} else {
									%>
									<option value="<%=bean.getUserID()%>/<%=bean.getUserName()%>"><%=bean.getUserName()%></option>
									<%
									}
									%>
									<%
									}
									%>
							</select></td>
						</tr>
						<tr>
							<th>ステータス情報</th>
							<td><select name="status" required>
									<%
									for (StatusBean bean : statusList) {
									%>
									<%
									if (bean.getStatusCode().equals(taskBean.getStatusCode())) {
									%>
									<option
										value="<%=bean.getStatusCode()%>/<%=bean.getStatusName()%>"
										selected><%=bean.getStatusName()%></option>
									<%
									} else {
									%>
									<option
										value="<%=bean.getStatusCode()%>/<%=bean.getStatusName()%>"><%=bean.getStatusName()%></option>
									<%
									}
									%>
									<%
									}
									%>
							</select></td>
						</tr>
						<tr>
							<th>メモ</th>
							<td><textarea name="memo" cols="50" rows="10"><%=taskBean.getMemo()%></textarea>
							</td>
						</tr>
					</table>
				</div>
				<input type="button" class="btn"
					onclick="location.href='task-list-servlet';" value="一覧に戻る">
				<input type="submit" class="btn" value="編集内容の確認に進む">
			</form>

			<script>
				const day = new Date();

				const today = day.toISOString().split("T")[0];

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