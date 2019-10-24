<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="chapter11.*"%>
<%@ page import="chapter11.parameter.*"%>
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
 <h2><%=request.getParameter("name")%>さんのつぶやき
 </h2>
 <table>
  <tr>
   <td><form action="TweetListServlet" method="get">
     <input type="submit" value="戻る">
    </form></td>
   <%
     if (request.isUserInRole(UserRoleParameters.ROLE_ADMINS)) {
   %>
   <td><form action="TweetDeleteServlet" method="get">
     <input type="hidden" name="name"
      value="<%=request.getParameter("name")%>"> <input
      type="submit" value="削除">
    </form></td>
   <%
     }
   %>
  </tr>
 </table>
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
   <td><%=record.getName()%></td>
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
