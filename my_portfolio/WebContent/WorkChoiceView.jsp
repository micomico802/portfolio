<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.portfolio.miz.model.users.entity.Users"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>トップ画面</title>
</head>
<body>
	<%
    	Users userSession = (Users) session.getAttribute("login_info");
		if(userSession == null){

		}
	%>

	<br>
	<br> こんにちは！
	<br><%=userSession.getUserName()%>さん
	<br>
	<br>

	<div>
		<h2>メニュー</h2>
		<br>
		<br>
		<button onclick="location.href= '/my_portfolio/SearchInput.jsp' ">一覧検索</button>
		<br>
		<br>
		<button onclick="location.href= '/my_portfolio/InsertInput.jsp' ">新規追加</button>
		<br>
		<br>
	</div>
	<br>
	<br>
	<div>
		<a href="/test_jsp/logout.jsp">ログアウト</a>
	</div>

</body>
</html>