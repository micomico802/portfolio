<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="com.portfolio.miz.model.Items"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>検索結果</title>
</head>
<body>
	<br>

	<table border="1">
		<tr bgcolor="#cccccc">
			<td><b>ID</b></td>
			<td><b>商品名</b></td>
			<td><b>入荷日</b></td>
			<td><b>メーカー名</b></td>
			<td><b>削除</b></td>
			<td><b>更新</b></td>
		</tr>

		<c:forEach var = "item" items = "${result}" >
		<tr>
			<td><c:out value = "${item.itemId}" /></td>
			<td><c:out value = "${item.itemName}" /></td>
			<td><c:out value = "${item.arrivalDate}" /></td>
			<td><c:out value = "${item.makerName}" /></td>
			<td><a href="/my_portfolio/EditServlet?&mode=delete&item_id=<c:out value = "${item.itemId}" />">削除</a></td>
			<td><form action = "/my_portfolio/EditServlet" method = "POST">
				<input type = "hidden" name = "mode" value = "setUpdate">
				<input type ="hidden" name = "item_id" value = "${item.itemId}">
				<input type ="hidden" name = "item_name" value = "${item.itemName}">
				<input type ="hidden" name = "arrival_date" value = "${item.arrivalDate}">
				<input type ="hidden" name = "maker_name" value = "${item.makerName}">
				<input type = "submit" value = "変更">
			</form>
			</td>
		</tr>
		</c:forEach>
	</table>

	<br><br>

	<a href="/SearchInput.jsp">検索画面に戻る</a>

</body>
</html>