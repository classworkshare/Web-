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
 * Servlet implementation class TransactionTokenServlet2
 */
@WebServlet("/TransactionTokenServlet2")
public class TransactionTokenServlet2 extends HttpServlet {

  TransactionTokenBean tranTokenBean = new TransactionTokenBean();
  
  @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    HttpSession session = request.getSession();
    String sessionTokenID = session.getAttribute("tokenID")
        .toString();
    String sendedTokenID = request.getParameter("tokenid");

    request.setAttribute("sessionTokenID", sessionTokenID);
    request.setAttribute("sendedTokenID", sendedTokenID);

    if (sessionTokenID.equals(sendedTokenID)) {

      String newTokenID = UUID.randomUUID().toString();
      session.setAttribute("tokenID", newTokenID);

      int studentNo;
      String studentName;
      int schoolYear;

      try {
        studentNo = Integer.parseInt(request
            .getParameter("studentno"));
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
      session.setAttribute("tranTokenBean", tranTokenBean);

      getServletContext().getRequestDispatcher(
          "/transactiontoken_output.jsp").forward(request, response);

    } else {
      getServletContext().getRequestDispatcher("/errormovement.jsp")
          .forward(request, response);
    }
  }
}
