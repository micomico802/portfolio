<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン画面</title>
</head>
<body>
	<% String firstComment = "IDとパスワードを入力して下さい"; %>
	<br><br>
	<%= firstComment %><br><br>
	<form action = "/my_portfolio/LoginServlet" method = "POST">
	ID:  <input type = "text" name = "user_id"><br><br>
	パスワード:<input type = "password" name = "password"><br><br>
	<button type = "submit">送信</button>
	</form>

	<button onclick="location.href= '/my_portfolio/RegisterForm.jsp' ">新規登録</button><br><br>
</body>
</html>