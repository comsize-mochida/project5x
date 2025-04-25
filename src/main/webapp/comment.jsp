<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.List, model.entity.CommentBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>タスク管理システム - コメント</title>
<link href="css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
	<!-- ヘッダー -->
	<%@ include file="header.jsp"%>

	<!-- メイン画面 -->
	<main>
		<div class="inner">
			<%
			request.setCharacterEncoding("UTF-8");
			List<CommentBean> commentList = (List<CommentBean>) request.getAttribute("commentList");
			int taskID = (int) session.getAttribute("taskID");
			String taskName = (String) session.getAttribute("taskName");
			String userID = (String) session.getAttribute("userID");
			%>

			<h2>コメント一覧</h2>
			<h3 class="comment-h3">
				タスク名：<%=taskName%></h3>
			<form action="comment-delete-servlet" method="POST">
				<table class="form-table">
					<tr>
						<th>投稿者</th>
						<th>コメント内容</th>
						<th>投稿日時</th>
						<th>削除</th>
					</tr>
					<%
					for (CommentBean bean : commentList) {
					%>
					<tr>
						<td><%=bean.getUserName()%></td>
						<td><%=bean.getComment()%></td>
						<td><%=bean.getUpdateDatetime()%></td>
						<td>
							<%
							if (bean.getUserName().equals(userName)) {
							%> <input type="hidden" name="commentID"
							value="<%=bean.getCommentID()%>"> <input type="submit"
							class="btn" value="削除"> <%
 }
 %>
						</td>
					</tr>
					<%
					}
					%>
				</table>
			</form>
			<h3 class="comment-h3">コメント追加</h3>
			<form action="comment-servlet" method="POST">
				<input type="hidden" name="taskID" value="<%=taskID%>"> <input
					type="hidden" name="userID" value="<%=userID%>">
				<textarea name="comment" cols="50" rows="10" required></textarea>
				<br> <input type="submit" class="btn" value="投稿">
			</form>
			<form>
				<input type="button" class="btn"
					onclick="location.href='task-list-servlet';" value="一覧に戻る">
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