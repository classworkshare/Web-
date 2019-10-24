package chapter5;

import java.io.Serializable;

public class ExampleBean implements Serializable {


  private static final long serialVersionUID = 1L;
  private int value;

  // Constructor
  public ExampleBean() {
  }

  public void setValue(int value) {
    this.value = value;
  }

  public int getValue() {
    return this.value; 
  }
}
