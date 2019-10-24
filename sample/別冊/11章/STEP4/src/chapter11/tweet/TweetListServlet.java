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

@WebServlet("/TweetListServlet")
public class TweetListServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request,
      HttpServletResponse response) throws ServletException,
      IOException {

    String retUrl = "/login.html";
    try {
      TweetArrayBean tweetArray;
      HttpSession session = request.getSession(false);
      if(session != null) {
        UserBean user = (UserBean) session.getAttribute("LoginUser");
        if (user != null) {
          TweetDAO dao = new TweetDAO();
          tweetArray = dao.getTweetArray();
          session.setAttribute("TweetArrayBean", tweetArray);
          retUrl = "/tweetlist.jsp";
        }        
      }
    } catch (SystemException e) {
      e.printStackTrace();
      HttpSession session = request.getSession();
      session.setAttribute("Except", e);
      retUrl = "/error.jsp";
    } catch (DatabaseException e) {
      e.printStackTrace();
      HttpSession session = request.getSession();
      session.setAttribute("Except", e);      
      retUrl = "/error.jsp";
    }
    getServletContext().getRequestDispatcher(retUrl).forward(
        request, response);
  }
}
