package chapter11.user;

import java.io.Serializable;
import java.util.ArrayList;

public class UserArrayBean implements Serializable {

  private ArrayList<UserBean> userArray;

  public UserArrayBean() {
    userArray = new ArrayList<UserBean>();
  }

  public void addUser(UserBean obj) {
    userArray.add(obj);
  }

  public int getArraySize() {
    return userArray.size();
  }

  public ArrayList<UserBean> getUserArray() {
    return userArray;
  }

  public void setUserArray(ArrayList<UserBean> userArray) {
    this.userArray = userArray;
  }

}
