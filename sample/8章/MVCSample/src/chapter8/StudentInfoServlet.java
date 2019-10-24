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
import chapter8.exception.SystemException;

@WebServlet("/StudentInfoServlet")
public class StudentInfoServlet extends HttpServlet {

  private StudentInfoBean studentInfoBean;

  @Override
  protected void doGet(HttpServletRequest request,
      HttpServletResponse response) throws ServletException,
      IOException {
    try {
      StudentDAO dao = new StudentDAO();
      studentInfoBean = dao.getStudentInfoBean();
      HttpSession session = request.getSession();
      session.setAttribute("stdInfoBean", studentInfoBean);
      getServletContext().getRequestDispatcher("/studentinfo.jsp")
          .forward(request, response);
    } catch (SystemException e) {
      e.printStackTrace();
      HttpSession session = request.getSession();
      session.setAttribute("Except", e);
      getServletContext().getRequestDispatcher("/error.jsp").forward(
          request, response);
    } catch (DatabaseException e) {
      e.printStackTrace();
      HttpSession session = request.getSession();
      session.setAttribute("Except", e);
      getServletContext().getRequestDispatcher("/error.jsp").forward(
          request, response);
    }
  }
}
