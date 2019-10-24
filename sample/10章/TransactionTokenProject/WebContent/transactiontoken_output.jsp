<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>トランザクショントークン - 登録完了画面JSP</title>
</head>
<body>
<jsp:useBean id="tranTokenBean" class="chapter10.TransactionTokenBean" scope="session" />

<h1>トランザクショントークン - 登録完了画面JSP</h1>
以下の学生の登録が<b>完了</b>しました。<p>

学生番号：　
<jsp:getProperty name="tranTokenBean" property="studentNo" /><br>
氏名：　
<jsp:getProperty name="tranTokenBean" property="studentName" /><br>
学年：　
<jsp:getProperty name="tranTokenBean" property="schoolYear" /><br>

<br>
サーブレットで比較チェックされたトークン
<table>
  <tr><td>セッションのトークンID：　</td>
    <td><%= request.getAttribute("sessionTokenID") %></td></tr>
  <tr><td>クライアントから送信したトークンID：　</td>
    <td><%= request.getAttribute("sendedTokenID") %></td></tr>
</table>
</body>
</html>