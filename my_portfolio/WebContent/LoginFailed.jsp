<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>結果</title>
</head>
<body>
	<% String message = (String)request.getAttribute("login"); %>
	<% String name = (String)session.getAttribute("name"); %>

	<br><br>
	<%= message %><br>
	<br><br>
	<a href = "/my_portfolio/index.jsp">パスワード入力画面に戻る</a>
</body>
</html>