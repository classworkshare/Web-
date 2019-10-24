<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
  String title = "Webアプリケーション構築入門";
  int price = 1000;
%>
商品名 ： <%= title %><br>
値段 ： <%= price %>円<br>
（税込　<%= (int)(price*1.08) %>円）

</body>
</html>