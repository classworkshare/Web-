package chapter5;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AdditionServlet_BeansIsNotUsed")
public class AdditionServlet_BeansIsNotUsed extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request,
      HttpServletResponse response) throws ServletException,
      IOException {

    int val1, val2, ans;

    try {
      val1 = Integer.parseInt(request.getParameter("value1"));
      val2 = Integer.parseInt(request.getParameter("value2"));

    } catch (NumberFormatException e) {
      getServletContext().getRequestDispatcher("/errorinput.html")
          .forward(request, response); 
      return;
    }

    ans = val1 + val2; 

    PrintWriter out = response.getWriter();
    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<meta charset=\"UTF-8\"/>");
    out.println("<title> 足し算（Beans未使用）-出力画面Servlet</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>足し算（Beans未使用） - 出力画面Servlet</h1>");
    out.println("入力された2つの値の和を求めます。<p>");
    out.println(val1 + " ＋ " + val2 + " ＝ " + ans); 
    out.println("</body>");
    out.println("</html>");
  }

}
