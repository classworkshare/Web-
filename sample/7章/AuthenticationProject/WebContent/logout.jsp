<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ユーザ認証</title>
</head>
<body style="text-align: center;">
	<h2>ログアウトしました</h2>
	<br>
	<a href="index.html">トップへ</a>
	<%
	  session.invalidate();
	%>
</body>
</html>