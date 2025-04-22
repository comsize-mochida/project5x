<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="model.entity.TaskBean" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="model.dao.TaskDAO" %>

<html>
<head>
<meta charset="UTF-8">
<title>タスク管理システム - 削除確認</title>
</head>
<body>
	<%@ include file="header.jsp"%>
	<h1>このタスクを削除してよろしいですか？</h1>
	
	<!-- セッションから削除対象のタスクIDの配列を取得 -->
	<%

    // TaskDAOを使用して、各タスクIDに対応するTaskBeanを取得
	List<TaskBean> deleteTasks = (List<TaskBean>) session.getAttribute("deleteTasks");
	
	List<Integer> taskIdList = (List<Integer>) session.getAttribute("taskIdList");


    if (deleteTasks != null ) {
        for (TaskBean task : deleteTasks) {
	%>

	<table>
		<tr>
			<th>タスク名:</th>
			<td><%= task.getTaskName() %></td>
		</tr>
		<tr>
			<th>カテゴリ情報:</th>
			<td><%= task.getCategoryName() %></td>
		</tr>
		<tr>
			<th>期限:</th>
			<td><%= task.getLimitDate() %></td>
		</tr>
		<tr>
			<th>担当者情報:</th>
			<td><%= task.getUserName() %></td>
		</tr>
		<tr>
			<th>ステータス情報:</th>
			<td><%= task.getStatusName() %></td>
		</tr>
		<tr>
			<th>メモ:</th>
			<td><%= task.getMemo() %></td>
		</tr>
	</table>
	<hr>
	<%
		}
    }
	%>
	
	<br>
	<form action="list.jsp" method="POST">
		<input type="submit" value="一覧に戻る">
	</form>

	<!-- 一括削除フォーム -->
	<form action="delete-servlet" method="POST">
		<%
		// 削除対象のタスクIDをhiddenフィールドとしてフォームに追加
		for(Integer task : taskIdList){
		%>
			<input type="hidden" name="deleteIds" value="<%= task%>">		
		<%
		}
		//session.setAttribute("deleteIds", task);
		%>
		<input type="submit" value="削除">	
	</form>
	<br>
	<%@ include file="footer.jsp"%>
	
	 
</body>
</html>