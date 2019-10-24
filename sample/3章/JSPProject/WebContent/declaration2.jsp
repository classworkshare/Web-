<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>スクリプトレット&lt;%　%&gt;で変数定義</h2>

<%
  int cnt = 0;

  cnt++;
  out.println("訪問： " + cnt + "人");
%>

</body>
</html>