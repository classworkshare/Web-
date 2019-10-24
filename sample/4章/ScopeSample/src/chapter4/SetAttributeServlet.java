package chapter4;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SetAttributeServlet
 */
@WebServlet("/SetAttributeServlet")
public class SetAttributeServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request,
      HttpServletResponse response) throws ServletException,
      IOException {    

    HttpSession session = request.getSession();
    ServletContext application = getServletContext();
    session.setAttribute("something", "贈り物");
    session.setAttribute("this", "届け物");
    session.setAttribute("that", "袖の下");
    application.setAttribute("any", "どれか");

    PrintWriter out = response.getWriter();
    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<meta charset=\"UTF-8\">");
    out.println("<title>属性を設定</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h2>属性を設定します</h2>");
    out.println("<a href=\"GetAttributeServlet\">送信するよ</a>");
    out.println("</body>");
    out.println("</html>");
  }
}
