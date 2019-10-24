package chapter9;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DirectoryTraversalServlet
 */
@WebServlet("/DirectoryTraversalServlet")
public class DirectoryTraversalServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    String str = request.getParameter("filename");
    if (isPermitPathName(str) == true) {
      getServletContext().getRequestDispatcher("/error.jsp").forward(
          request, response);
      return;
    }
    getServletContext().getRequestDispatcher("/folderA/" + str)
        .forward(request, response);
  }

  private boolean isPermitPathName(String filename) {

    if (filename.indexOf("..") != -1)
      return true; 
    else if (filename.indexOf("/") != -1)
      return true; 
    else if (filename.indexOf(":") != -1)
      return true;
    else if (filename.indexOf("\\") != -1)
      return true;
    return false;
  }
}
