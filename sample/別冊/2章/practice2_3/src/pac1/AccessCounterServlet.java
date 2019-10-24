package pac1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AccessCounterServlet
 */
@WebServlet("/AccessCounterServlet")
public class AccessCounterServlet extends HttpServlet {

  int accessCount = 0;

  @Override
  protected void doGet(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {
    
    accessCount++;
    PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset=\"UTF-8\"/>");
    out.println("<title>アクセスカウンタ</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>アクセスカウンタ</h1>");
    out.println("あなたは、" + accessCount + "人目の訪問者です！");
    out.println("</body>");
    out.println("</html>");
  }
}
