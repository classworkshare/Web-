package pac1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TenkiServlet
 */
@WebServlet("/WeatherServlet")
public class WeatherServlet extends HttpServlet {
 
  @Override
  protected void doGet(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {

    PrintWriter out = response.getWriter();
    out.println("<html>");
    out.println("<head>");
    out.println("<title>お天気予想</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>お天気を予想します</h1>");
    double weather = Math.random();
    if (weather <= 0.5d) {
      out.println("天気は、晴れです。<p>");
    } else if (weather <= 0.8d) {
      out.println("天気は、くもりですねぇ。<p>");
    } else {
      out.println("天気は、雨でしょう。<p>");
    }
    out.println("</body>");
    out.println("</html>");
  }
}
