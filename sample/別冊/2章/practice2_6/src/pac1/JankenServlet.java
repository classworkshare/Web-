package pac1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class JankenServlet
 */
@WebServlet("/JankenServlet")
public class JankenServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request,
      HttpServletResponse response) throws ServletException,
      IOException {

    /**
     * 人が選んだ手を受け取る
     */
    String player = request.getParameter("hand");

    /**
     * コンピュータの手を決める
     */
    double jankenPon = Math.random();
    String computer = "";
    if (jankenPon <= 0.3d) {
      computer = "g";
    } else if (jankenPon <= 0.6d) {
      computer = "c";
    } else {
      computer = "p";
    }

    /**
     * 勝負の判定
     */
    String result = "";
    if (computer.equals(player)) {
      result = "あいこ";
    } else if ((computer.equals("g")) && (player.equals("c"))) {
      result = "Computer";
    } else if ((computer.equals("c")) && (player.equals("p"))) {
      result = "Computer";
    } else if ((computer.equals("p")) && (player.equals("g"))) {
      result = "Computer";
    } else {
      result = "Player";
    }
    if (result.equals("あいこ")) {
      result = "引き分け";
    } else if (result.equals("Computer")) {
      result = "プログラムの勝ち";
    } else {
      result = "あなたが勝ち";
    }

    PrintWriter out = response.getWriter();
    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<meta charset=\"UTF-8\"/>");
    out.println("<title>じゃんけん結果</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>じゃんけん結果</h1>");
    out.println("あなたが選んだ手：" + Judgment(player) + "<br>");
    out.println("プログラムが選んだ手：" + Judgment(computer) + "<br>");
    out.println("勝負の結果は、" + result + "でした！");
    out.println("<br>");    
    out.println("<br>");      
    out.println("<a href=\"janken.html\">もう一度やる</a>");
    out.println("</body>");
    out.println("</html>");
  }

  String Judgment(String hand) {
    switch (hand) {
    case "g":
      return "グー";
    case "c":
      return "チョキ";
    default:
      return "パー";
    }

  }
}
