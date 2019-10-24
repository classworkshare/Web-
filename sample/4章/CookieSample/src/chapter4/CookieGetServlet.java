package chapter4;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CookieGetServlet
 */
@WebServlet("/CookieGetServlet")
public class CookieGetServlet extends HttpServlet {

  @Override
  protected void doPost(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {

    String memberName = "";
    String memberDate = "";

    Cookie[] cookies = request.getCookies();
    if (cookies != null) {
      for (Cookie cook : cookies) {
        if (cook.getName().equals("MemberName")) {
          memberName = cook.getValue();
        }
        if (cook.getName().equals("MemberDate")) {
          memberDate = cook.getValue();
        }
      }
    }

    PrintWriter out = response.getWriter();
    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<meta charset=\"UTF-8\">");
    out.println("<title>クッキー情報の見本２</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<hr>");
    out.println("<h2>その２～クッキーの取得</h2>");
    out.println("ようこそ、" + memberName + "さん");
    out.println("<br>");
    out.println("その１から取得した内容");
    out.println("<br>");
    out.println("会員名：" + memberName);
    out.println("<br>");
    out.println("会員入会日：" + memberDate);
    out.println("<br>");
    out.println("<br>");

    out.println(
        "<form action=\"CookieGetServlet\" " + "method=\"post\">");
    out.println("<input type=\"submit\" "
        + "value=\"もう一度サーブレット「その２」取得を呼び出し\">");
    out.println("</form>");
    out.println("<br>");

    out.println(
        "<form action=\"CookieRemoveServlet\" " + "method=\"post\">");
    out.println("<input type=\"submit\" "
        + "value=\"サーブレット「その３」クッキー削除を呼び出し\">");
    out.println("</form>");
    out.println("<br>");

    out.println("<a href=\"startcookiesample.html\">" + "入力へ戻す</a>");
    out.println("</body>");
    out.println("</html>");
  }
}
