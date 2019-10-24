<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%! int cnt = 0; %>

<h2>宣言&lt;%!　%&gt;で変数定義</h2>
<%
  cnt++;
  out.println("訪問： " + cnt + "人");
%>

</body>
</html>