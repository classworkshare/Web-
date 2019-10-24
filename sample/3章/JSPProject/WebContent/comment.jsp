<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%-- JSPのコメントは、HTMLソースには出力されない --%>
<!-- HTMLのコメントは、HTMLソースに出力される -->
<%
  String str = "コメントの説明を行うページ。";
  out.println(str); // Javaのコメントは、HTMLソースには出力されない
%>

</body>
</html>