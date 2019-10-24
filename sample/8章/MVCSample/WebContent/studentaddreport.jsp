<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ page import="chapter8.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>学生登録完了</title>
</head>
<body>
<jsp:useBean id="StudentRecord" class="chapter8.StudentRecordBean"
  scope="session" />
<h1>学生登録完了画面</h1>
<p><%=session.getAttribute("RecordCount") %>件登録しました。
<table border="1">
  <tr>
<td>学生番号</td>
<td><jsp:getProperty name="StudentRecord" property="studentNo"/></td>
</tr>
  <tr>
<td>氏名</td>
<td><jsp:getProperty name="StudentRecord" property="studentName"/></td>
</tr>
  <tr>
<td>学年</td>
<td><jsp:getProperty name="StudentRecord" property="schoolYear"/></td>
</tr>
</table>
<a href="studentinput.html">戻る</a>
</body>
</html>
