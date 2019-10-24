package pac1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class KeisanServlet
 */
@WebServlet("/CalcServlet")
public class CalcServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {
    
    String strnumber1 = request.getParameter("number1");
    int number1 = Integer.parseInt(strnumber1);
    String strnumber2 = request.getParameter("number2");
    int number2 = Integer.parseInt(strnumber2);
    String execute = request.getParameter("execute");

    PrintWriter out = response.getWriter();
    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<meta charset=\"UTF-8\"/>");
    out.println("<title>四則演算結果</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>四則演算の結果</h1>");
    out.println("<table>");
    out.println("<tr><td>数字1つ目</td><td>　</td><td>数字2つ目</td><td>　</td><td>結果</td></tr>");
    out.println("<tr style=\"text-align: center\"><td>" + number1 + "</td><td>");
    switch (execute) {
      case "addition": out.print("＋");break;
      case "subtraction": out.print("－");break;
      case "multiplication": out.print("×");break;
      case "division": out.print("÷");break;
    }
    out.println("</td><td>" + number2 + "</td><td>＝</td><td>");
    switch (execute) {
      case "addition":out.print(number1 + number2);break;
      case "subtraction":out.print(number1 - number2);break;
      case "multiplication":out.print(number1 * number2);break;
      case "division":out.print(number1 / number2);break;
    }
    out.println("</td></tr>");
    out.println("</table>");
    out.println("</body>");
    out.println("</html>");
  }
}
