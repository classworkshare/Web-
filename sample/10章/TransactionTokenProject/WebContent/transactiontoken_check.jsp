<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>トランザクショントークン - 確認画面JSP</title>
</head>
<body>
<jsp:useBean id="tranTokenBean" class="chapter10.TransactionTokenBean" scope="session" />

<h1>トランザクショントークン - 確認画面JSP</h1>
以下の学生を登録しますか？<p>

学生番号：　
<jsp:getProperty name="tranTokenBean" property="studentNo" /><br>
氏名：　
<jsp:getProperty name="tranTokenBean" property="studentName" /><br>
学年：　
<jsp:getProperty name="tranTokenBean" property="schoolYear" /><p>

クライアントのトークンID：　<%= session.getAttribute("tokenID") %>

<form action="TransactionTokenServlet2" method="post" >
  <div>
    <input type="hidden" name="studentno"
     value="<%= tranTokenBean.getStudentNo() %>" />
    <input type="hidden" name="studentname"
     value="<%= tranTokenBean.getStudentName() %>" />
    <input type="hidden" name="schoolyear"
     value="<%= tranTokenBean.getSchoolYear() %>" />
    <input type="hidden" name="tokenid"
     value="<%= session.getAttribute("tokenID") %>" />
  </div>
  <input type="submit" value="送信">
</form>
</body>
</html>