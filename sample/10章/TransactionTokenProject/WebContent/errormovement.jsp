<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Error!!</title>
</head>
<body>
<h1 style="color: red">不正な操作が行われました。</h1>

サーブレットで比較チェックされたトークン
<table>
  <tr><td>セッションのトークンID：　</td>
    <td><%= request.getAttribute("sessionTokenID") %></td></tr>
  <tr><td>クライアントから送信したトークンID：　</td>
    <td><%= request.getAttribute("sendedTokenID") %></td></tr>
</table>

<br>
最初の入力からやり直してください。
</body>
</html>