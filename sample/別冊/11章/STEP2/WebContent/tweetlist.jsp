<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="chapter11.*"%>
<%@ page import="java.net.URLEncoder"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>つぶやきアプリ</title>
</head>
<body>
 <jsp:useBean id="TweetArrayBean"
  class="chapter11.TweetArrayBean" scope="session" />
 <h1>つぶやきアプリ</h1>
 <%=request.getRemoteUser()%>：
 <a href="LogoutServlet">ログアウト</a>
 <br>
  <br>
 <form action="tweetinput.html" method="get">
  <input type="submit" value="書き込み">
 </form>
 <br>
 <table border="1">
  <tr>
   <th>名前</th>
   <th>つぶやき</th>
   <th>日時</th>
  </tr>
  <%
    ArrayList<TweetBean> tweetArray = TweetArrayBean
      .getTweetArray();
      for (TweetBean record : tweetArray) {
  %>
  <tr>
   <td>
       <a href="TweetPersonServlet?name=<%=URLEncoder.encode(record.getName(),"UTF-8")%>"><%=record.getName()%></a>
   </td>
   <td><%=record.getTweet()%></td>
   <td><%=new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(record
            .getDatetime())%></td>
  </tr>
  <%
    }
  %>
 </table>
</body>
</html>
