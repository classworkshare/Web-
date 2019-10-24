package chapter8;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import chapter8.dao.StudentDAO;
import chapter8.exception.DatabaseException;
import chapter8.exception.ParameterException;
import chapter8.exception.SystemException;
import chapter8.parameter.ExceptionParameters;

/**
 * Servlet implementation class StudentAddServlet
 */
@WebServlet("/StudentAddServlet")
public class StudentAddServlet extends HttpServlet {

  @Override
  protected void doPost(HttpServletRequest request,
      HttpServletResponse response) throws ServletException,
      IOException {
    

    int studentNo = 0;
    String studentName = null;
    int schoolYear = 0;

    try {
      studentNo = Integer.parseInt(request.getParameter("studentno"));
      studentName = request.getParameter("studentname");
      schoolYear = Integer.parseInt(request
          .getParameter("schoolyear"));
    } catch (NumberFormatException e) {
      ParameterException pe = new ParameterException(
          ExceptionParameters.PARAMETER_FORMAT_EXCEPTION_MESSAGE, e);
      pe.printStackTrace();
      HttpSession session = request.getSession();
      session.setAttribute("Except", pe);
      getServletContext().getRequestDispatcher("/error.jsp").forward(
          request, response);
      return;
    }

    StudentRecordBean stdrecord = new StudentRecordBean();
    stdrecord.setStudentNo(studentNo);
    stdrecord.setStudentName(studentName);
    stdrecord.setSchoolYear(schoolYear);

    try {
      StudentDAO dao = new StudentDAO();
      int ret = dao.addStudentInfo(stdrecord);

      HttpSession session = request.getSession();
      session.setAttribute("RecordCount", ret);
      session.setAttribute("StudentRecord", stdrecord);
      getServletContext().getRequestDispatcher(
          "/studentaddreport.jsp").forward(request, response);

    } catch (SystemException e) {
      e.printStackTrace();
      HttpSession session = request.getSession();
      session.setAttribute("Except", e);
      getServletContext().getRequestDispatcher("/error.jsp").forward(
          request, response);
      return;
    } catch (DatabaseException e) {
      e.printStackTrace();
      HttpSession session = request.getSession();
      session.setAttribute("Except", e);
      getServletContext().getRequestDispatcher("/error.jsp").forward(
          request, response);
      return;
    }

  }

}
