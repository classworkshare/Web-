package chapter5;

import java.io.Serializable;

public class JSPActionTagBean implements Serializable {

  private String namae;

  // Constructor
  public JSPActionTagBean() {
  }

  public void setNamae(String namae) {
    this.namae = namae;
  }

  public String getNamae() {
    return this.namae;
  }

}
