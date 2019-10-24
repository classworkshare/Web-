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
 * Servlet implementation class SimpleSessionGetServlet
 */
@WebServlet("/SimpleSessionGetServlet")
public class SimpleSessionGetServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {

    PrintWriter out = response.getWriter();
    HttpSession session = request.getSession();

    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<meta charset=\"UTF-8\">");
    out.println("<title>簡単なセッション情報の見本2</title>");
    out.println("<h2>その２～セッションＩＤの取得</h2>");
    out.println("現在のセッションＩＤ : 「" + session.getId() + "」");
    out.println("<br>");
    out.println("<a href=\"SimpleSessionCreateServlet\">"
        + "前のサーブレット「その１」を呼び出し</a>");
    out.println("</body>");
    out.println("</html>");
  }
}
