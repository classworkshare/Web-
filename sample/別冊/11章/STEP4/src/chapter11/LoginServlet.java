package chapter11;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import chapter11.dao.LoginDAO;
import chapter11.dao.TweetDAO;
import chapter11.exception.DatabaseException;
import chapter11.exception.SystemException;
import chapter11.tweet.TweetArrayBean;
import chapter11.user.UserBean;

/**
 * Servlet implementation class TweetloginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

  @Override
  protected void doPost(HttpServletRequest request,
      HttpServletResponse response) throws ServletException,
      IOException {

    String actionName = request.getParameter("action");
    if (actionName.equals("login")) {

      String userid = request.getParameter("login_id");
      String password = request.getParameter("login_pass");

      try {
        LoginDAO loginDao = new LoginDAO();
        UserBean user = loginDao.getUser(userid, password);
        String retUrl = "/loginerror.jsp";
        HttpSession session = request.getSession();
        if(user != null) {
          session.setAttribute("LoginUser", user);

          TweetArrayBean tweetArray;

          TweetDAO dao = new TweetDAO();
          tweetArray = dao.getTweetArray();
          session.setAttribute("TweetArrayBean", tweetArray);
          retUrl = "/tweetlist.jsp";
        }
        getServletContext().getRequestDispatcher(retUrl)
            .forward(request, response);
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

    } else {
      getServletContext().getRequestDispatcher("/error.jsp")
          .forward(request, response);
    }
  }

  @Override
  protected void doGet(HttpServletRequest request,
      HttpServletResponse response) throws ServletException,
      IOException {

    HttpSession session = request.getSession(false);
    if (session != null) {
      session.invalidate();
    }
    response.sendRedirect("login.html");
  }
}
