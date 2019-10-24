<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>学生登録 Beans ‐ 確認画面 JSP</title>
</head>
<body>
<jsp:useBean id="stdInfoBean" class="chapter5.StudentInfoBean"
 scope="session" />
<h1>学生登録 Beans ‐ 確認画面 JSP</h1>
学生が登録されました。<br><br>

現在の登録数： <%= stdInfoBean.getArraySize() %>件<br><br>

<a href="studentinfo_input.html">続けて学生を登録する</a><br>
<a href="studentinfo_output.jsp">登録されている学生を一覧表示</a>
</body>
</html>