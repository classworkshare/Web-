package chapter11.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import chapter11.dao.UserDAO;
import chapter11.exception.DatabaseException;
import chapter11.exception.SystemException;
import chapter11.parameter.UserRoleParameters;

@WebServlet("/UserListServlet")
public class UserListServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request,
      HttpServletResponse response) throws ServletException,
      IOException {

    try {
      HttpSession session = request.getSession(false);
      if (session != null) {
        UserBean user = (UserBean) session.getAttribute(
            "LoginUser");
        if (user != null && user.getRole().equals(
            UserRoleParameters.ROLE_ADMINS)) {
          UserArrayBean userArray;
          UserDAO dao = new UserDAO();
          userArray = dao.getUserArray();
          session.setAttribute("UserArrayBean", userArray);
          getServletContext().getRequestDispatcher("/userlist.jsp")
              .forward(request, response);
        } else {
          response.sendRedirect("LogoutServlet");
        }
      } else {
        response.sendRedirect("login.html");
      }
    } catch (SystemException e) {
      e.printStackTrace();
      HttpSession session = request.getSession();
      session.setAttribute("Except", e);
      getServletContext().getRequestDispatcher("/error.jsp")
          .forward(request, response);
    } catch (DatabaseException e) {
      e.printStackTrace();
      HttpSession session = request.getSession();
      session.setAttribute("Except", e);
      getServletContext().getRequestDispatcher("/error.jsp")
          .forward(request, response);
    }
  }
}
