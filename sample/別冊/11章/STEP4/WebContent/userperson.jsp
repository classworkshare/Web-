<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@ page import="chapter11.parameter.*"%>
<%@ page import="chapter11.user.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>つぶやきアプリ</title>
</head>
<body>
 <jsp:useBean id="UserBean" class="chapter11.user.UserBean" scope="session" />
 <jsp:useBean id="LoginUser" class="chapter11.user.UserBean" scope="session" />
 <h1>つぶやきアプリ</h1>
 <h2>ユーザ情報変更</h2>

 <form action="UserUpdateServlet" method="post">
  ユーザID:<input type="hidden" name="userid"
   value="<%=UserBean.getUserid()%>"><%=UserBean.getUserid()%><br>
  パスワード：<input type="password" name="passwd"
   value="<%=UserBean.getPasswd()%>"><br>
  <%
    String users = "checked";
    String admins = "";
    if (LoginUser.getRole().equals(UserRoleParameters.ROLE_ADMINS)) {
      users = "";
      admins = "checked";
    }
  %>
  ロール： <input type="radio" name="role" value="users" <%=users%>>
<%=UserRoleParameters.ROLE_USERS%>
  <input type="radio" name="role" value="admins" <%=admins%>>
<%=UserRoleParameters.ROLE_ADMINS%>
  <br> <input type="submit" value="変更"> <input type="reset">
  <input type="button" onclick="location.href='./UserListServlet'"
   value="戻る">
 </form>
</body>
</html>
