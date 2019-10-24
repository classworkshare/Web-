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
 * Servlet implementation class WriteCookieServlet
 */
@WebServlet("/WriteCookieServlet")
public class WriteCookieServlet extends HttpServlet {

  @Override
  protected void doPost(HttpServletRequest request,
      HttpServletResponse response) throws ServletException,
      IOException {
    
    String myno = request.getParameter("myno");
    String myname = request.getParameter("myname");
    String mymail = request.getParameter("mymail");

    Cookie cookMyNo = new Cookie("MyNo", myno);
    cookMyNo.setMaxAge(30);
    response.addCookie(cookMyNo);
    Cookie cookMyName = new Cookie("MyName", myname);
    cookMyName.setMaxAge(30);
    response.addCookie(cookMyName);
    Cookie cookMyMail = new Cookie("MyMail", mymail);
    cookMyMail.setMaxAge(30);
    response.addCookie(cookMyMail);
    Cookie cookCount = new Cookie("Count", "1");
    cookCount.setMaxAge(30);
    response.addCookie(cookCount);

    PrintWriter out = response.getWriter();
    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<meta charset=\"UTF-8\">");
    out.println("<title>クッキー書き込み</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>クッキー情報</h1>");
    out.println("<p>");
    out.println("MyNo: " + myno);
    out.println("<p>");
    out.println("MyName: " + myname);
    out.println("<p>");
    out.println("MyMail: " + mymail);
    out.println("<p>");
    out.println("クッキーを書きました");
    out.println("<p>");
    out.println("<a href=\"ReadCookieServlet\">戻る</a>");
    out.println("</body>");
    out.println("</html>");
  }

}
