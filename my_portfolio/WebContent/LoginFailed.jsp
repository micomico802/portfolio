<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="com.portfolio.miz.model.users.entity.Users"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>結果</title>
</head>
<body>
<br><br>
	<c:forEach var = "message" items = "${messages}">
	<p><c:out value ="${message}" />
	<br></p>
	</c:forEach>
	<br><br>
	<a href = "/my_portfolio/index.jsp">パスワード入力画面に戻る</a>
</body>
</html>