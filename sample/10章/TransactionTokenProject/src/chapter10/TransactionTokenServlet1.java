package chapter10;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class TransactionTokenServlet1
 */
@WebServlet("/TransactionTokenServlet1")
public class TransactionTokenServlet1 extends HttpServlet {

  TransactionTokenBean tranTokenBean = new TransactionTokenBean();
  
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    int studentNo;
    String studentName;
    int schoolYear;

    try {
      studentNo = 
          Integer.parseInt(request.getParameter("studentno"));
      studentName = request.getParameter("studentname");
      schoolYear = Integer.parseInt(request
          .getParameter("schoolyear"));

    } catch (NumberFormatException e) {
      getServletContext().getRequestDispatcher("/errorinput.html")
          .forward(request, response);
      return;
    }

    tranTokenBean.setStudentNo(studentNo);
    tranTokenBean.setStudentName(studentName);
    tranTokenBean.setSchoolYear(schoolYear);

    HttpSession session = request.getSession();
    session.setAttribute("tranTokenBean", tranTokenBean);

    String tokenID = UUID.randomUUID().toString();
    session.setAttribute("tokenID", tokenID);

    getServletContext().getRequestDispatcher(
        "/transactiontoken_check.jsp").forward(request, response);
	}

}
