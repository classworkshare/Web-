<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>アクションタグの説明 - 出力画面JSP</title>
</head>
<body>
<jsp:useBean id="jspActTagBean" class="chapter5.JSPActionTagBean"
 scope="page" />
<jsp:setProperty name="jspActTagBean" property="namae" param="data" />

<h1>アクションタグの説明 - 出力画面JSP</h1>

こんにちは、
<jsp:getProperty name="jspActTagBean" property="namae" />
さん！

</body>
</html>