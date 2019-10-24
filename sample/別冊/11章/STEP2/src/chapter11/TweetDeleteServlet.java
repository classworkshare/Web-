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

@WebServlet("/TweetDeleteServlet")
public class TweetDeleteServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    try {
      String name = request.getParameter("name");

      TweetDAO dao = new TweetDAO();
      dao.deleteTweet(name);

      response.sendRedirect("TweetListServlet");
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
