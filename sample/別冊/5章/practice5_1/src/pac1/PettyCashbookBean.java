package pac1;

import java.io.Serializable;
import java.util.ArrayList;

public class PettyCashbookBean implements Serializable {

  private ArrayList<PaymentRecordBean> paymentHistoryArray
      = new ArrayList<PaymentRecordBean>(); // 貯金の履歴

  //Constructor
  public PettyCashbookBean() {
  }

  public ArrayList<PaymentRecordBean> getPaymentHistoryArray() {
    return paymentHistoryArray;
  }

  public void addPaymentHistoryArray(PaymentRecordBean payment) {
    paymentHistoryArray.add(payment);
  }

  public int getTotalPayment() {
    int total = 0;

    for (PaymentRecordBean rec : paymentHistoryArray) {
      total += rec.getPayment();
    }
    return total;
  }

}
