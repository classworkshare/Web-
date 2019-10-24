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
 * Servlet implementation class SimpleSessionCreateServlet
 */
@WebServlet("/SimpleSessionCreateServlet")
public class SimpleSessionCreateServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

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
    out.println("<title>簡単なセッション情報の見本1</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h2>その１～セッションの生成</h2>");
    out.println("現在のセッションＩＤ : 「" + session.getId() + "」");
    out.println("<br>");
    out.println("<a href=\"SimpleSessionGetServlet\">"
        + "次のサーブレット「その２」を呼び出し</a>");
    out.println("</body>");
    out.println("</html>");
  }
}
