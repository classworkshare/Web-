package pac1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Kuku")
public class Kuku extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request,
      HttpServletResponse response) throws ServletException,
      IOException {

    PrintWriter out = response.getWriter();
    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<meta charset=\"UTF-8\"/>");
    out.println("<title>九九の表</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h3>九九の表</h3>");
    out.println("<table border=\"3\">");
    for (int i = 0; i < 10; i++) {
      out.println("<tr>");
      for (int j = 0; j < 10; j++) {
        if (i == 0) {
          if (j == 0) {
            out.println("<td> </td>");
          } else {
            out.println("<th>" + j + "</th>");
          }
        } else {
          if (j == 0) {
            out.println("<th>" + i + "</th>");
          } else {
            out.println("<td style=\"text-align: right\">" + (i * j)
                + "</td>");
          }
        }
      }
      out.println("</tr>");
    }
    out.println("</table>");
    out.println("<p>以上");
    out.println("</body>");
    out.println("</html>");
  }
}
