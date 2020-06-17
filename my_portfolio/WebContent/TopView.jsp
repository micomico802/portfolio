<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% String message = (String)request.getAttribute("login"); %>
	<% String name = (String)session.getAttribute("name"); %>
	<br><br>
	こんにちは！<%= name %>さん<br><br>

	<button onclick="location.href= '/my_portfolio/SearchInput.jsp' ">一覧検索</button><br><br>
	<button onclick="location.href= '/my_portfolio/InsertInput.jsp' ">新規追加</button><br><br>

</body>
</html>