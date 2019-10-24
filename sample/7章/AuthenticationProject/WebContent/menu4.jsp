<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ユーザ認証</title>
</head>
<body style="text-align: center;">
  <h2>ようこそ、<%= request.getRemoteUser() %>さん</h2>
  <%
  if (request.isUserInRole("teacher")) {
  %>
  あなたのロールは、teacherです。
  <%
  } else if (request.isUserInRole("admin")) {
  %>
  あなたのロールは、adminです。
  <%
  }
  %>
  <br>
  <h2>ここは管理画面（JSP）です。</h2>
  このページは、認証の必要があります。<br><br>
  <a href="index.html">トップへ</a>
  <br>
  <a href="logout.jsp">ログアウト</a>
</body>
</html>