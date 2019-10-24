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
  int age = 20;
                
  if(age<20) {
%>
    <h2>未成年です。</h2>
<%
  } else {
%>
    <h2>成人です。</h2>
<%
  }
%>

</body>
</html>