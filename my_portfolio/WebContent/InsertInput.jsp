<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>検索画面</title>
</head>
<body>

	<br>
	 新規登録する情報を入力してください。
	<br>
	<br>
	<br>

	<form action="/my_portfolio/EditServlet" method="POST">
		<input type ="hidden" name = "mode" value = "insert">
		ID: <input type="text" name="item_id"> 商品名: <input type="text"
			name="item_name">
		入荷日: <input type="text" name="arrival_date">
		メーカー名：<SELECT NAME="maker_name">
			<OPTION VALUE="" selected></OPTION>
			<OPTION VALUE="apple">apple</OPTION>
			<OPTION VALUE="sony">sony</OPTION>
			<OPTION VALUE="nec">nec</OPTION>
			<OPTION VALUE="microsoft">microsoft</OPTION>
		</SELECT> <br>
		<br> <input type="submit" value="追加">
	</form>

	<br><br>

	<a href="/my_portfolio/InsertInput.jsp">追加画面に戻る</a><br>
	<a href="/my_portfolio/TopView.jsp">トップ画面に戻る</a>
</body>
</html>