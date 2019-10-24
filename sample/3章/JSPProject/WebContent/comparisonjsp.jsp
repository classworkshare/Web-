<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSPでこんにちは</title>
</head>
<body>

<%
  String str = "こんにちは";

  for(int i=0; i<5; i++) {
    out.print(str);
    out.println("<br>");
  }
%>

</body>
</html>