package chapter6;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UpdateSampleServlet
 */
@WebServlet("/UpdateSampleServlet")
public class UpdateSampleServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request,
      HttpServletResponse response) throws ServletException,
      IOException {

    int ret = 0;

    try {
      Class.forName("com.mysql.jdbc.Driver"); // 検索に失敗する場合は必要
      try (Connection conn = DriverManager.getConnection(
          "jdbc:mysql://localhost:3306/sampledb?serverTimezone=JST",
          "user", "password");
          Statement stmt = conn.createStatement()) {
        ret = stmt.executeUpdate(
            "UPDATE STUDENT SET STUDENTNAME='情報花子' WHERE STUDENTNO=1010");
      }
    } catch (Exception e) {
      e.printStackTrace();
    }

    PrintWriter out = response.getWriter();

    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<meta charset=\"UTF-8\">");
    out.println("<title>データベース接続のサンプルサーブレットUpdate</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>" + ret + "件更新しました。</h1>");
    out.println("</body>");
    out.println("</html>");
  }
}
