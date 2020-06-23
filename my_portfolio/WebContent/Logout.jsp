<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログアウト画面</title>
</head>
	<% session.invalidate(); %>
	<br><br>
	<p>ログアウトしました</p><br><br>

	<a href = "/my_portfolio/index.jsp">ログイン画面へ</a>
</body>
</html>