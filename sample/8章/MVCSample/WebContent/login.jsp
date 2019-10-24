<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>学生情報システム ログイン</title>
</head>
<body>
<h1>学生情報システム</h1>
<h2>ログイン</h2>
<form action="j_security_check" method="post">
  ログインID：<input type="text" name="j_username"><br>
  パスワード：<input type="password" name="j_password"><br>
  <input type="submit" value="ログイン">
  <input type="reset" value="リセット">
</form>
</body>
</html>
