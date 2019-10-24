package chapter3;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ComparisonServlet
 */
@WebServlet("/ComparisonServlet")
public class ComparisonServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {

    PrintWriter out = response.getWriter();
    out.println("<!DOCTYPE html>");
    out.println("<html");
    out.println("<head>");
    out.println("<meta charset=\"UTF-8\"/>");
    out.println("<title>Servletでこんにちは</title>");
    out.println("</head>");
    out.println("<body>");

    String str = "こんにちは";

    for (int i = 0; i < 5; i++) {
      out.print(str);
      out.println("<br>");
    }

    out.println("</body>");
    out.println("</html>");
  }

}
