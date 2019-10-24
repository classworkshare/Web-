package pac1;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class PettyCashbookServlet
 */
@WebServlet("/PettyCashbookServlet")
public class PettyCashbookServlet extends HttpServlet {

  PettyCashbookBean pettyCashbookBean = new PettyCashbookBean();

  @Override
  protected void doGet(HttpServletRequest request,
      HttpServletResponse response) throws ServletException,
      IOException {

    int payment;    // 入金額
    String comment; // コメント

    /* Formから入力された値の取り出し */
    try {
      payment = Integer.parseInt(request.getParameter("payment"));
      comment = request.getParameter("comment");

    } catch (NumberFormatException e) {
      getServletContext().getRequestDispatcher("/errorinput.html")
          .forward(request, response);
      return;
    }

    /* 入金レコードの作成 */
    PaymentRecordBean paymentRec = new PaymentRecordBean();
    paymentRec.setPayment(payment);
    paymentRec.setComment(comment);

    /* Beans実行 */
    pettyCashbookBean.addPaymentHistoryArray(paymentRec); // 入金レコードをBeansへ追加

    /* セッションにBeansを登録し、JSPで出力 */
    HttpSession session = request.getSession();
    session.setAttribute("pettyCashbookBean", pettyCashbookBean);
    getServletContext().getRequestDispatcher(
        "/pettycashbook_output.jsp").forward(request, response);

  }
}
