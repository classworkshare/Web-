<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="chapter11.user.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>つぶやきアプリ</title>
</head>
<body>
 <jsp:useBean id="UserArrayBean" class="chapter11.user.UserArrayBean"
  scope="session" />
 <h1>つぶやきアプリ</h1>
 <h2>ユーザ管理</h2>
 <%=request.getRemoteUser()%>：
 <a href="LogoutServlet">ログアウト</a>
 <a href="TweetListServlet">つぶやきへ戻る</a>
 <br>
 <br>
 <table border="1">
  <tr>
   <th>ユーザID</th>
   <th>ロール</th>
   <td colspan=2><input type="button"
    onclick="location.href='userinput.html'" value="ユーザ作成"></td>
  </tr>
  <%
    ArrayList<UserBean> userArray = UserArrayBean.getUserArray();
    for (UserBean record : userArray) {
  %>
  <tr>
   <td><%=record.getUserid()%></td>
   <td><%=record.getRole()%></td>
   <td><a href="UserPersonServlet?userid=<%=record.getUserid()%>">編集</a></td>
   <td><a href="UserDeleteServlet?userid=<%=record.getUserid()%>">削除</a></td>
  </tr>
  <%
    }
  %>
 </table>
</body>
</html>
