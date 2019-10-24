package chapter9;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class XssServlet
 */
@WebServlet("/XssServlet")
public class XssServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String studentname, str;

    str = request.getParameter("studentname");

    studentname = getESCEncodingString(str);

    PrintWriter out = response.getWriter();
    out.println("<html>");
    out.println("<head>");
    out.println("<title>XSS（脆弱性なし）</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("ようこそ、" + studentname + " さん");
    out.println("</body>");
    out.println("</html>");
  }

  private String getESCEncodingString(String str) {
    str = str.replaceAll("&", "&amp;"); 
    str = str.replaceAll("<", "&lt;");
    str = str.replaceAll(">", "&gt;"); 
    str = str.replaceAll("\"", "&quot;");
    str = str.replaceAll("\'", "&apos;");
    return str;
  }
}
