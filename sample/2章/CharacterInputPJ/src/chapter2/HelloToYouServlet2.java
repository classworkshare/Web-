package chapter2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloToYouServlet2
 */
@WebServlet("/HelloToYouServlet2")
public class HelloToYouServlet2 extends HttpServlet {

  @Override
  public void doGet(HttpServletRequest request,
      HttpServletResponse response) throws IOException,
      ServletException {

    String yourName = request.getParameter("your");
    String myName = request.getParameter("my");

    PrintWriter out = response.getWriter();
    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<title>Hello To You!</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>Hello To You!</h1>");
    out.println("はじめてのサーブレット<p>");
    out.println("こんにちは、" + yourName + "さん");
    out.println("<br>私は、" + myName + "です");
    out.println("</body>");
    out.println("</html>");
    
  }

  @Override
  protected void doPost(HttpServletRequest request,
      HttpServletResponse response) throws ServletException,
      IOException {
    
    doGet(request, response);
    
  }
}
