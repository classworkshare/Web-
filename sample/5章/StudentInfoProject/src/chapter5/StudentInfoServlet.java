package chapter5;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class StudentInfoServlet
 */
@WebServlet("/StudentInfoServlet")
public class StudentInfoServlet extends HttpServlet {

  StudentInfoBean stdInfoBean = new StudentInfoBean();

  @Override
  protected void doGet(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {
    int studentNo;
    String studentName;
    int schoolYear;

    try {
      studentNo = Integer.parseInt(request.getParameter("studentno"));
      studentName = request.getParameter("studentname");
      schoolYear = Integer
          .parseInt(request.getParameter("schoolyear"));

    } catch (NumberFormatException e) {
      getServletContext().getRequestDispatcher("/errorinput.html")
          .forward(request, response);
      return;
    }

    StudentRecordBean stdRecord = new StudentRecordBean();
    stdRecord.setStudentNo(studentNo);
    stdRecord.setStudentName(studentName);
    stdRecord.setSchoolYear(schoolYear);
    stdInfoBean.addStudentRecord(stdRecord);

    HttpSession session = request.getSession();
    session.setAttribute("stdInfoBean", stdInfoBean);
    getServletContext().getRequestDispatcher("/studentinfo_check.jsp")
        .forward(request, response);
  }

}
