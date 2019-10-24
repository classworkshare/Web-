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
 * Servlet implementation class CookieRemoveServlet
 */
@WebServlet("/CookieRemoveServlet")
public class CookieRemoveServlet extends HttpServlet {

  @Override
  protected void doPost(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {

    Cookie cookMemberName = new Cookie("MemberName", "");
    cookMemberName.setMaxAge(0);
    response.addCookie(cookMemberName);
    Cookie cookMemberDate = new Cookie("MemberDate", "");
    cookMemberDate.setMaxAge(0);
    response.addCookie(cookMemberDate);

    PrintWriter out = response.getWriter();
    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<meta charset=\"UTF-8\">");
    out.println("<title>クッキー情報の見本３</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<hr>");
    out.println("<h2>その３～クッキーの削除</h2>");
    out.println("クッキーを削除しました。");
    out.println("<br>");
    out.println("<br>");
    out.println("<hr>");

    out.println(
        "<form action=\"CookieGetServlet\" " + "method=\"post\">");
    out.println("<input type=\"submit\" "
        + "value=\"前のサーブレット「その２」クッキー取得を呼び出し\">");
    out.println("</form>");
    out.println("<br>");

    out.println(
        "<form action=\"CookieRemoveServlet\" " + "method=\"post\">");
    out.println("<input type=\"submit\" "
        + "value=\"もう一度サーブレット「その３」クッキー削除を呼び出し\">");
    out.println("</form>");
    out.println("<br>");

    out.println("<a href=\"startcookiesample.html\">" + "入力へ戻す</a>");
    out.println("</body>");
    out.println("</html>");
  }
}
