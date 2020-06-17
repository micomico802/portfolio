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
	 検索条件を入力してください。
	<br>（何も入力しないと全件抽出します）
	<br>
	<br>

	<form action="/my_portfolio/ItemsSearcherServlet" method="POST">

		ID: <input type="text" name="item_id"> 商品名: <input type="text"
			name="item_name">
		メーカー名：<SELECT NAME="maker_name">
			<OPTION VALUE="" selected></OPTION>
			<OPTION VALUE="apple">apple</OPTION>
			<OPTION VALUE="sony">sony</OPTION>
			<OPTION VALUE="nec">nec</OPTION>
			<OPTION VALUE="microsoft">microsoft</OPTION>
		</SELECT> <br>
		<br> <input type="submit" value="検索">
	</form>

	<br><br>
	<a href="/my_portfolio/TopView.jsp">トップ画面に戻る</a>
</body>
</html>