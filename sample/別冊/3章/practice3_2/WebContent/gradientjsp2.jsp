<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>グラデーションJSP その2</title>
</head>
<body>

<% int add = 42; %>

<h1>グラデーションJSP その2</h1>
グラデーションの幅：<%= add %><p>
<table border="1">
<%
  int color;

  for(int i=0; i<4; i++){
    out.println("  <tr>");
    color = i*add;

    for (int j=0; j<4; j++) {
      String colorHex = String.format("%02x", color);
                                         // colorを16進数(2ケタ)に変換
      String colorHTML = colorHex + colorHex + colorHex;
                                         // HTMLの色指定形式の作成
      out.println("    <td style=\"height: 50px; width: 50px; background-color: #"
          + colorHTML + ";\"><br></td>");
      color += add;
    }

    out.println("  </tr>");
  }
%>
</table>

</body>
</html>