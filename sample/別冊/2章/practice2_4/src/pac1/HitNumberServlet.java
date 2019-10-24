package pac1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class NumberateServlet
 */
@WebServlet("/HitNumberServlet")
public class HitNumberServlet extends HttpServlet {

  int targetNumber = 0;
  int times = 0;

  @Override
  protected void doGet(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {
    
    if (times == 0) {
      targetNumber = (int) (Math.random() * 9d) + 1;
    }
    times++;
    String Number_s = request.getParameter("number");
    int enteredNumber = Integer.parseInt(Number_s);

    String result = "はずれ～！";
    if (enteredNumber == targetNumber) {
      result = "当たり";
    }

    PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset=\"UTF-8\"/>");
    out.println("<title>数当てゲーム結果</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>数当てゲーム結果</h1>");
    out.println(times + "回目　あなたが選んだ数：" + enteredNumber);
    out.println("<br>");
    out.println("<br>");
    out.println("結果は、" + result);
    out.println("<br>");
    out.println("<br>");
    out.println("<a href=\"hitnumber.html\">もう一度やる</a>");
    out.println("</body>");
    out.println("</html>");
    if (enteredNumber == targetNumber) {
      times = 0;
    }
  }
}
