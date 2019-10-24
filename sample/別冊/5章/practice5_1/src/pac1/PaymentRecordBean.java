package pac1;

import java.io.Serializable;

public class PaymentRecordBean implements Serializable {

  private int payment;    // 入金額
  private String comment; // コメント

  //Constructor
  public PaymentRecordBean() {
  }

  public void setPayment(int payment) {
    this.payment = payment;
  }

  public int getPayment() {
    return this.payment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }

  public String getComment() {
    return this.comment;
  }

}
