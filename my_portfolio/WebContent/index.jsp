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
	ID:  <input type = "text" name = "id"><br><br>
	パスワード:<input type = "text" name = "pass"><br><br>
	<button type = "submit">送信</button>
	</form>
</body>
</html>