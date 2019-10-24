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
 * Servlet implementation class SessionRemoveServlet
 */
@WebServlet("/SessionRemoveServlet")
public class SessionRemoveServlet extends HttpServlet {

  @Override
  protected void doPost(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {
    
    HttpSession session = request.getSession();
    session.invalidate();

    PrintWriter out = response.getWriter();
    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<meta charset=\"UTF-8\">");
    out.println("<title>セッション情報の見本３</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<hr><h2>その３～値の削除</h2>");
    out.println("値を削除しました。");
    out.println("<br>");
    out.println("<br>");
    out.println("<hr>");

    out.println(
        "<form action=\"SessionGetServlet\" " + "method=\"post\">");
    out.println("<input type=\"submit\" "
        + "value=\"前のサーブレット「その２」セッション取得を呼び出し\">");
    out.println("</form>");
    out.println("<br>");

    out.println("<form action=\"SessionRemoveServlet\" "
        + "method=\"post\">");
    out.println("<input type=\"submit\" "
        + "value=\"もう一度サーブレット「その３」値の削除を呼び出し\">");
    out.println("</form>");
    out.println("<br>");

    out.println("<a href=\"startsessionsample.html\">入力へ戻す</a>");
    out.println("</body>");
    out.println("</html>");
  }
}
