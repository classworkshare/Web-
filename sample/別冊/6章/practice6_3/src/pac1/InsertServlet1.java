package pac1;

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
 * Servlet implementation class InsertSampleServlet
 */
@WebServlet("/InsertServlet1")
public class InsertServlet1 extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request,
      HttpServletResponse response) throws ServletException,
      IOException {

    int ret = 0;
    int id = 0;
    String name = null;

    try {
      id = Integer.parseInt(request.getParameter("subjectid"));
    } catch (NumberFormatException e) {
      return;
    }
    name = request.getParameter("subjectname");

    try {
      Class.forName("com.mysql.jdbc.Driver"); // 検索に失敗する場合は必要
      try (Connection conn = DriverManager.getConnection(
          "jdbc:mysql://localhost:3306/sampledb?serverTimezone=JST",
          "user", "password");
          Statement stmt = conn.createStatement()) {
        ret = stmt.executeUpdate("INSERT INTO SUBJECT VALUES(" + id
            + ",\'" + name + "\')");
      }
    } catch (Exception e) {
      e.printStackTrace();
    }

    PrintWriter out = response.getWriter();

    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<meta charset=\"UTF-8\">");
    out.println("<title>練習6-3</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>練習6-3</h1>");
    out.println("<h2>" + ret + "件追加しました。</h2>");
    out.println("<p>");
    out.println("科目ID：" + id + "<br>");
    out.println("科目名：" + name + "<br>");
    out.println("</body>");
    out.println("</html>");
  }
}
