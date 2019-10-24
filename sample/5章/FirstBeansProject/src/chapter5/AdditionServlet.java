package chapter5;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AdditionServlet
 */
@WebServlet("/AdditionServlet")
public class AdditionServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {

    int val1, val2;

    try {
      val1 = Integer.parseInt(request.getParameter("value1"));
      val2 = Integer.parseInt(request.getParameter("value2"));

    } catch (NumberFormatException e) {
      getServletContext().getRequestDispatcher("/errorinput.html")
          .forward(request, response);
      return;
    }

    AdditionBean addBean = new AdditionBean();
    addBean.setValue1(val1);
    addBean.setValue2(val2);
    addBean.additionExecution();

    request.setAttribute("addBean", addBean);
    getServletContext().getRequestDispatcher("/addition_output.jsp")
        .forward(request, response);

  }
}
