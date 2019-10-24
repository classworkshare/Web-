package chapter11.tweet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import chapter11.dao.TweetDAO;
import chapter11.exception.DatabaseException;
import chapter11.exception.SystemException;
import chapter11.user.UserBean;

@WebServlet("/TweetDeleteServlet")
public class TweetDeleteServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request,
      HttpServletResponse response) throws ServletException,
      IOException {

    try {
      HttpSession session = request.getSession(false);
      if (session != null) {
        System.out.println("TweetPersonServlet session != null");
        UserBean user = (UserBean) session.getAttribute(
            "LoginUser");
        if (user != null) {
          String name = request.getParameter("name");

          TweetDAO dao = new TweetDAO();
          if(dao.deleteTweet(name) == 1) {
            response.sendRedirect("TweetListServlet");
          } else {
            response.sendRedirect("LogoutServlet");
          }
        } else {
          response.sendRedirect("LogoutServlet");
        }
      } else {
        getServletContext().getRequestDispatcher("/login.html").forward(
            request, response);
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
