<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="java.util.List,model.entity.CategoryBean,model.entity.StatusBean,model.entity.UserBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>タスク管理システム - 新規登録</title>
</head>
<body>

	<%@ include file="header.jsp"%>

	<h1>登録情報を入力してください</h1>

	<form action="register-confirm-servlet" method="post">

		<table border="1">

			<tr>

				<th>タスク名：</th>

				<td><input type="text" name="taskName" size="50" maxlength="50" required></td>

			</tr>

			<tr>

				<th>カテゴリ情報：</th>

				<td>
				
				<select name="category" required>

						<%
					
						List<CategoryBean> categoryList = (List)(session.getAttribute("categoryList"));
						for(CategoryBean cb : categoryList){
					
					%>

						<option
							value="<%= cb.getCategoryID()%>,<%= cb.getCategoryName() %>"><%= cb.getCategoryName() %></option>

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
					
						List<UserBean> userList = (List)(session.getAttribute("userList"));
						for(UserBean ub : userList){
					
					%>

						<option
							value="<%= ub.getUserID()%>,<%= ub.getUserName()%>"><%= ub.getUserName() %></option>

						<%
					
						}
					
					%>

				</select></td>

			</tr>

			<tr>

				<th>ステータス情報：</th>
				<td><select name="status" required>

						<%
					
						List<StatusBean> statusList = (List)(session.getAttribute("statusList"));
						for(StatusBean sb : statusList){
					
					%>

						<option value="<%= sb.getStatusCode()%>,<%= sb.getStatusName() %>"><%= sb.getStatusName() %></option>

						<%
					
						}
					
					%>

				</select></td>

			</tr>

			<tr>

				<th>メモ：</th>
				<td><textarea name="memo" rows="10" maxlength="100" cols="50"></textarea>
			</tr>

		</table>

		<input type="button" onclick="location.href='menu.jsp'" value="メニューに戻る"> 
		<input type="submit" value="登録内容の確認に進む">

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

	<br>

	<%@ include file="footer.jsp"%>

</body>
</html>