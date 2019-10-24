<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ユーザ認証</title>
</head>
<body>
  <h2>ログイン画面</h2>
  <form action="j_security_check" method="post">
     ユーザＩＤ <input type="text" name="j_username">
     <br>
      パスワード <input type="password" name="j_password">
      <br>
      <input type="submit" value="ログイン">
      <input type="reset" value="取消">
	</form>
</body>
</html>