<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>グラデーションJSP その1</title>
</head>
<body>
<% int add = 16; %>

<h1>グラデーションJSP その1</h1>
グラデーションの幅：<%= add %><p>

<table border="1">
  <tr>
<%
  for (int color = 0; color <= 255; color += add) {
    String colorHex = String.format("%02x", color);
                                           // colorを16進数(2ケタ)に変換
    String colorHTML = colorHex + colorHex + colorHex;
                                           // HTMLの色指定形式の作成
    out.println("    <td style=\"height: 30px; width: 30px; "
        + "background-color: #"
        + colorHTML + ";\"><br></td>");
  }
%>
  </tr>
</table>
</body>
</html>