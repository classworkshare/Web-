<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="chapter5.StudentRecordBean"
    import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>学生登録 Beans ‐ 出力画面 JSP</title>
</head>
<body>
<jsp:useBean id="stdInfoBean" class="chapter5.StudentInfoBean"
 scope="session" />
<h1>学生登録 Beans ‐ 出力画面 JSP</h1>
登録されている学生一覧<br><br>

<table border="1">
<tr><th>学生番号</th><th>氏名</th><th>学年</th></tr>
<%
ArrayList<StudentRecordBean> stdRecordArray =
stdInfoBean.getStudentRecordArray();

for(StudentRecordBean rcd : stdRecordArray){
  out.println("<tr><td>" + rcd.getStudentNo() + "</td><td>"
      + rcd.getStudentName() + "</td><td>" + rcd.getSchoolYear()
      + "</td></tr>");
}
%>
</table>

<br>
<a href="javascript:history.back()">戻る</a><br>
<a href="studentinfo_input.html">続けて学生を登録する</a><br>
</body>
</html>