<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ユーザー登録画面</title>
</head>
<body>
<div>
	<h2>お客様情報登録</h2>
	<p>必要項目をご入力下さい</p>
</div>
<div class = "inputBlock">
	<form action="/my_portfolio/RegisterUserServlet" method="post">
        ログインID(メールアドレス):<input type="text" name="login_address"><br>
        パスワード:<input type="password" name="pass"><br>
        名前:<input type="text" name="name"><br>
   <input type="submit" value="確認">
    </form>
    <br>
    <p>* は必須項目です<p>
    </div>
</body>
</html>