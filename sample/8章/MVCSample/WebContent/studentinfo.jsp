<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="chapter8.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>学生一覧</title>
</head>
<body>
<jsp:useBean id="stdInfoBean" class="chapter8.StudentInfoBean"
  scope="session" />
<h1>学生一覧表示画面</h1>
登録されている学生一覧
<p>
<a href="index.html">メニューへ戻る</a>
<table border=1>
  <tr>
    <th>学生番号</th>
    <th>氏名</th>
    <th>学年</th>
  </tr>
<%
  ArrayList<StudentRecordBean> stdInfoArray = stdInfoBean
  .getStudentRecordArray();
  for (StudentRecordBean record : stdInfoArray) {
%>
  <tr>
    <td><%= record.getStudentNo() %></td>
    <td><%= record.getStudentName() %></td>
    <td><%= record.getSchoolYear() %></td>
  </tr>
<%
  }
%>
</table>
</body>
</html>
