package chapter4;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SessionCreateServlet
 */
@WebServlet("/SessionCreateServlet")
public class SessionCreateServlet extends HttpServlet {

  @Override
  protected void doPost(HttpServletRequest request,
      HttpServletResponse response) throws ServletException,
      IOException {

    String memberName = request.getParameter("membername");
    String memberDate = request.getParameter("memberdate");

    HttpSession session = request.getSession();
    session.setAttribute("MemberName", memberName);
    session.setAttribute("MemberDate", memberDate);

    PrintWriter out = response.getWriter();
    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<meta charset=\"UTF-8\">");
    out.println("<title>セッション情報の見本1</title>");
    out.println("</head>");
    out.println("<body>");

    out.println("<h2>その１　セッションで値の生成</h2>");
    out.println("ようこそ、" + memberName + "さん");
    out.println("<br>");
    out.println("入力した内容");
    out.println("<br>");
    out.println("会員名：" + memberName);
    out.println("<br>");
    out.println("会員入会日：" + memberDate);
    out.println("<br>");
    out.println("<br>");
    out.println("現在のセッションＩＤ : 「" + session.getId() + "」");
    out.println("<br>");
    out.println("<br>");

    out.println("<form action=\"SessionGetServlet\" "
        + "method=\"post\">");
    out.println("<input type=\"submit\" "
        + "value=\"次のサーブレット「その２」を呼び出し\">");
    out.println("</form>");
    out.println("<br>");

    out.println("<a href=\"startsessionsample.html\">"
        + "入力へ戻す</a>");
    out.println("</body>");
    out.println("</html>");
  }
}
