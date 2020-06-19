<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.portfolio.miz.model.Items"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>検索画面</title>
</head>
<body>
	<%
	    Items beans = (Items) request.getAttribute("beans");
	%>
	<br>
	 更新したい項目を修正してください。
	<br>
	<br>
	<br>

	<form action="/my_portfolio/EditServlet" method="POST">
		<input type="hidden" name = "mode" value = "doUpdate">
		ID:<%= beans.getItemId() %> (変更不可)）
		<input type="hidden" name="item_id" value = "<%= beans.getItemId() %>"><br><br>
		商品名: <input type="text" name= "item_name" value = "<%= beans.getItemName() %>"><br><br>
		入荷日: <input type="text" name= "arrival_date"  value ="<%= beans.getArrivalDate() %>"><br><br>
		メーカー名：<SELECT NAME="maker_name">
			<OPTION VALUE="<%= beans.getMakerName() %>"selected>
			<%= beans.getMakerName() %></OPTION>
			<OPTION VALUE="apple">apple</OPTION>
			<OPTION VALUE="sony">sony</OPTION>
			<OPTION VALUE="nec">nec</OPTION>
			<OPTION VALUE="microsoft">microsoft</OPTION>
		</SELECT> <br><br>
		<br> <input type="submit" value="更新">
	</form>

	<a href="/SearchInput.jsp">検索画面に戻る</a>

</body>
</html>