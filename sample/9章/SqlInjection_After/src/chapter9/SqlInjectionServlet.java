package chapter9;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SqlInjectionServlet
 */
@WebServlet("/SqlInjectionServlet")
public class SqlInjectionServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request,
      HttpServletResponse response) throws ServletException,
      IOException {

    String studentName;
    studentName = request.getParameter("studentname");
    String sql = "SELECT * FROM STUDENT, SUBJECT, GRADE "
        + "WHERE STUDENTNAME = ? "
        + "AND STUDENT.STUDENTNO = GRADE.STUDENTNO "
        + "AND SUBJECT.SUBJECTID = GRADE.SUBJECTID";
    String htmlstr = "";

    try {
      Class.forName("com.mysql.jdbc.Driver"); // 検索に失敗する場合は必要
      try (Connection con = DriverManager.getConnection(
          "jdbc:mysql://localhost:3306/sampledb?serverTimezone=JST",
          "user", "password");
          PreparedStatement prestmt = con.prepareStatement(sql)) {
        prestmt.setString(1, studentName);
        try (ResultSet rs = prestmt.executeQuery()) {
          while (rs.next()) {
            htmlstr += "<tr>" + "<td>" + rs.getInt("schoolyear")
                + "</td>" + "<td>" + rs.getInt("studentno")
                + "</td>" + "<td>" + rs.getString("studentname")
                + "</td>" + "<td>" + rs.getString("subjectname")
                + "</td>" + "<td>" + rs.getInt("score") + "</td>"
                + "</tr>";
          }
        }
      }
    } catch (Exception e) {
      System.out.println(e);
    }
    PrintWriter out = response.getWriter();
    out.println("<html>");
    out.println("<head>");
    out.println("<title>SQLインジェクション（脆弱性なし）</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h2>科目試験  結果確認</h2>");
    if (htmlstr.length() == 0) {
      out.println("該当データはありません。");
    } else {
      out.println("<table border=\"1\">");
      out.println("<tr>");
      out.println("<th>学年</th><th>出席番号</th><th>氏名</th>");
      out.println("<th>科目名</th><th>点数</th>");
      out.println("</tr>");
      out.println(htmlstr);
      out.println("</table>");
    }
    out.println("</body>");
    out.println("</html>");
  }
}
