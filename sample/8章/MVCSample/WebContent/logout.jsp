<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>学生情報システム ログアウト</title>
</head>
<body>
<%
  session.invalidate();
%>
<h1>学生情報システム ログアウト</h1>
<p>ログアウトしました。
<p>
<a href="index.html">メニューへ</a>
</body>
</html>
