<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="model.entity.TaskBean"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="model.dao.TaskDAO"%>

<html>
<head>
<meta charset="UTF-8">
<title>タスク管理システム - 削除確認</title>
<link href="style.css" rel="stylesheet" type="text/css">
</head>
<body>
	<!-- ヘッダー -->
	<%@ include file="header.jsp"%>

	<!-- メイン画面 -->
	<main>
		<div class="inner">
			<h2>このタスクを削除してよろしいですか？</h2>

			<!-- セッションから削除対象のタスクIDの配列を取得 -->
			<%
			// TaskDAOを使用して、各タスクIDに対応するTaskBeanを取得
			List<TaskBean> deleteTasks = (List<TaskBean>) session.getAttribute("deleteTasks");

			List<Integer> taskIdList = (List<Integer>) session.getAttribute("taskIdList");

			if (deleteTasks != null) {
				for (TaskBean task : deleteTasks) {
			%>
			<div class="form-wrap">
				<table class="form-table" id="delete-table">
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
			</div>
			<hr>
			<%
			}
			}
			%>


			<!-- 一括削除フォーム -->
			<form action="delete-servlet" method="POST">
				<%
				// 削除対象のタスクIDをhiddenフィールドとしてフォームに追加
				for (Integer task : taskIdList) {
				%>
				<input type="hidden" name="deleteIds" value="<%=task%>">
				<%
				}
				//session.setAttribute("deleteIds", task);
				%>
				<input type="submit" class="btn" value="削除">
			</form>
			<br>
			<form action="list.jsp" method="POST">
				<input type="button" class="btn" onclick="history.back()"
					value="一覧に戻る">
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