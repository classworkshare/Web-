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
 * Servlet implementation class CookieCreateServlet
 */
@WebServlet("/CookieCreateServlet")
public class CookieCreateServlet extends HttpServlet {

  @Override
  protected void doPost(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {

    String memberName = request.getParameter("membername");
    String memberDate = request.getParameter("memberdate");

    Cookie cookMemberName = new Cookie("MemberName", memberName);
    cookMemberName.setMaxAge(30);
    response.addCookie(cookMemberName);
    Cookie cookMemberDate = new Cookie("MemberDate", memberDate);
    cookMemberDate.setMaxAge(30);
    response.addCookie(cookMemberDate);

    PrintWriter out = response.getWriter();
    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<meta charset=\"UTF-8\">");
    out.println("<title>クッキー情報の見本1</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h2>その１～クッキーの生成</h2>");
    out.println("ようこそ、" + memberName);
    out.println("<br>");
    out.println("入力した内容");
    out.println("<br>");
    out.println("会員名：" + memberName);
    out.println("<br>");
    out.println("会員入会日：" + memberDate);
    out.println("<br>");
    out.println("<br>");

    out.println(
        "<form action=\"CookieGetServlet\" " + "method=\"post\">");
    out.println(
        "<input type=\"submit\" " + "value=\"次のサーブレット「その２」を呼び出し\">");
    out.println("</form>");
    out.println("<br>");

    out.println("<a href=\"startcookiesample.html\">" + "入力へ戻す</a>");
    out.println("</body>");
    out.println("</html>");
  }
}
