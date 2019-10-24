package chapter11;

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

@WebServlet("/TweetListServlet")
public class TweetListServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    TweetArrayBean TweetArray;

    try {
      TweetDAO dao = new TweetDAO();
      TweetArray = dao.getTweetArray();
      HttpSession session = request.getSession();
      session.setAttribute("TweetArrayBean", TweetArray);
      getServletContext().getRequestDispatcher("/tweetlist.jsp").forward(
          request, response);
    } catch (SystemException e) {
      e.printStackTrace();
      HttpSession session = request.getSession();
      session.setAttribute("Except", e);
      getServletContext().getRequestDispatcher("/error.jsp").forward(request,
          response);
    } catch (DatabaseException e) {
      e.printStackTrace();
      HttpSession session = request.getSession();
      session.setAttribute("Except", e);
      getServletContext().getRequestDispatcher("/error.jsp").forward(request,
          response);
    }
  }
}
