<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>足し算Beans - 出力画面JSP</title>
</head>
<body>
<jsp:useBean id="addBean" class="chapter5.AdditionBean"
 scope="request" />

<h1>足し算Beans - 出力画面JSP</h1>

入力された2つの値の和を求めます。<p>
<jsp:getProperty name="addBean" property="value1" /> ＋
<jsp:getProperty name="addBean" property="value2" /> ＝
<jsp:getProperty name="addBean" property="ans" />

</body>
</html>