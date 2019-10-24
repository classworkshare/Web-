package chapter4;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SimpleDispatchServlet2
 */
@WebServlet("/SimpleDispatchServlet2")
public class SimpleDispatchServlet2 extends HttpServlet {

  @Override
  protected void doPost(HttpServletRequest request,
      HttpServletResponse response) throws ServletException,
      IOException {

    String memberName = request.getParameter("membername");
    String memberDate = request.getParameter("memberdate");
    String sampleAttribute1 = (String) request.getAttribute(
        "SampleAttribute1");

    PrintWriter out = response.getWriter();
    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<meta charset=\"UTF-8\">");
    out.println("<title>RequestDispatcherの簡単な見本</title>");
    out.println("</head>");
    out.println("<body>");

    out.println("<h2>RequestDispatcherで呼ばれたサーブレット</h2>");
    out.println("ようこそ、" + memberName + "さん");
    out.println("<br>");
    out.println("入力した内容");
    out.println("<br>");
    out.println("会員名：" + memberName);
    out.println("<br>");
    out.println("会員入会日：" + memberDate);
    out.println("<br>");
    out.println("SampleAttribute1：" + sampleAttribute1);
    out.println("<br>");
    out.println("<br>");
    out.println("</body>");
    out.println("</html>");
  }
}
