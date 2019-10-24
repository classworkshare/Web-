package chapter4;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class GetAttributeServlet
 */
@WebServlet("/GetAttributeServlet")
public class GetAttributeServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request,
      HttpServletResponse response) throws ServletException,
      IOException {

    HttpSession session = request.getSession();
    ServletContext application = getServletContext();

    PrintWriter out = response.getWriter();
    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<meta charset=\"UTF-8\">");
    out.println("<title>属性を取得</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h2>属性を取り出します</h2>");

    String x = (String) session.getAttribute("something");
    if (x == null) {
      out.println("something= 空です");
      out.println("<br>");
    } else {
      out.println("something=" + x);
      out.println("<br>");
    }

    String y = (String) session.getAttribute("this");
    if (y == null) {
      out.println("this= 空ですよ");
      out.println("<br>");
    } else {
      out.println("this=" + y);
      out.println("<br>");
    }

    String z = (String) session.getAttribute("that");
    if (z == null) {
      out.println("that= 空ですね");
      out.println("<br>");
    } else {
      out.println("that=" + z);
      out.println("<br>");
    }

    String w = (String) application.getAttribute("any");
    if (w == null) {
      out.println("any= 空です。");
      out.println("<br>");
    } else {
      out.println("any=" + w);
      out.println("<br>");
    }
    out.println("</body>");
    out.println("</html>");
  }
}
