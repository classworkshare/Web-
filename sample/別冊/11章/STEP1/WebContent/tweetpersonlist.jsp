<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="chapter11.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>つぶやきアプリ</title>
</head>
<body>
 <jsp:useBean id="TweetArrayBean"
  class="chapter11.TweetArrayBean" scope="session" />
 <h1>つぶやきアプリ</h1>
 <h2><%=request.getParameter("name")%>さんのつぶやき
 </h2>
 <form action="TweetListServlet" method="get">
 <input type="submit" value="戻る">
 </form>
 <br>   
 <table border="1">
  <tr>
   <th>名前</th>
   <th>つぶやき</th>
   <th>日時</th>
  </tr>
  <%
    ArrayList<TweetBean> TweetArray = TweetArrayBean
      .getTweetArray();
      for (TweetBean record : TweetArray) {
  %>
  <tr>
   <td><%=record.getName()%></td>
   <td><%=record.getTweet()%></td>
   <td><%=new SimpleDateFormat("yyyy/MM/dd HH:mm:ss")
          .format(record.getDatetime())%></td>
  </tr>
  <%
    }
  %>
 </table>
</body>
</html>
