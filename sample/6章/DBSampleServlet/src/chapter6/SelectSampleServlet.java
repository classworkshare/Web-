package chapter6;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InsertSampleServlet
 */
@WebServlet("/SelectSampleServlet")
public class SelectSampleServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request,
      HttpServletResponse response) throws ServletException,
      IOException {

    ArrayList<String> list = new ArrayList<String>();

    try {
      Class.forName("com.mysql.jdbc.Driver"); // 検索に失敗する場合は必要
      try (Connection conn = DriverManager.getConnection(
          "jdbc:mysql://localhost:3306/sampledb?serverTimezone=JST",
          "user", "password");
          Statement stmt = conn.createStatement();
          ResultSet rs = stmt.executeQuery(
              "SELECT * FROM STUDENT")) {
        while (rs.next()) {
          String s = "<td>" + rs.getInt("STUDENTNO") + "</td>"
              + "<td>" + rs.getString("STUDENTNAME") + "</td>"
              + "<td>" + rs.getInt("SCHOOLYEAR") + "</td>";
          list.add(s);
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }

    PrintWriter out = response.getWriter();

    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<meta charset=\"UTF-8\">");
    out.println("<title>データベース接続のサンプルサーブレットSelect</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<table border=\"1\">");
    out.println("<tr>");
    out.println("<th>学籍番号</th>");
    out.println("<th>学生氏名</th>");
    out.println("<th>学年</th>");
    out.println("</tr>");
    for (String str : list) {
      out.println("<tr>" + str + "</tr>");
    }
    out.println("</table>");
    out.println("</body>");
    out.println("</html>");
  }
}
