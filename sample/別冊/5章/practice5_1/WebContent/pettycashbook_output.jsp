<%@ page import="pac1.PaymentRecordBean" %>
<%@ page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>お小遣い帳Beans - 出力画面JSP</title>
</head>
<body>
<jsp:useBean id="pettyCashbookBean" class="pac1.PettyCashbookBean"
 scope="session" />

<h1>お小遣い帳Beans - 出力画面JSP</h1>
貯金履歴の一覧表示<p>

<table border="1">
<tr>
　　<th>履歴</th>
　　<th>貯金額</th>
　　<th>コメント</th>
</tr>
<%
ArrayList<PaymentRecordBean> paymentHistoryArray =
  pettyCashbookBean.getPaymentHistoryArray();

int i = 1;
for(PaymentRecordBean paymentRec : paymentHistoryArray){
  out.println("<tr><td>" + i + "回目</td><td>"
      + paymentRec.getPayment() + "円</td><td>"
      + paymentRec.getComment() + "</td></tr>");
  i++;
}
%>
</table>

<br>
<b>合計金額 ： <%= pettyCashbookBean.getTotalPayment()  %>円</b>
<br>
<br>
<a href="pettycashbook_input.html">さらに入金する</a><br>

</body>
</html>
