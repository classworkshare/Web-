package pac1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ReadCookieServlet
 */
@WebServlet("/ReadCookieServlet")
public class ReadCookieServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request,
      HttpServletResponse response) throws ServletException,
      IOException {
    
    PrintWriter out = response.getWriter();

    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<meta charset=\"UTF-8\">");
    out.println("<title>クッキー情報</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>クッキー情報</h1>");
    Cookie[] cookies = request.getCookies();
    if (cookies != null) {
      String name = "";
      int count = 0;
      for (Cookie cookie : cookies) {
        if (cookie.getName().equals("MyName")) {
          name = cookie.getValue();
        }
        if (cookie.getName().equals("Count")) {
          count = Integer.parseInt(cookie.getValue());
          count++;
          String strCount = count + "";
          Cookie cookCount = new Cookie("Count", strCount);
          cookCount.setMaxAge(30);
          response.addCookie(cookCount);
        }
      }
      out.println("<p>");
      out.println(name + "さん");
      out.println("<p>");
      out.println("こんにちは" + count + "回目の訪問ですね");
    } else {
      out.println("<p>");
      out.println("初めての訪問ですね。");
      out.println("<p>");
      out.println("My情報を登録しましょう");
      out.println("<p>");
      out.println("<a href=\"cookieinfo.html\">登録</a>");
    }
    out.println("</body>");
    out.println("</html>");
  }
}
