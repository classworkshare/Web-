package chapter11.user;

import java.io.Serializable;

public class UserBean implements Serializable {

  private String userid;
  private String passwd;
  private String role;

  public UserBean() {
  }

  public String getUserid() {
    return userid;
  }

  public void setUserid(String userid) {
    this.userid = userid;
  }

  public String getPasswd() {
    return passwd;
  }

  public void setPasswd(String passwd) {
    this.passwd = passwd;
  }

  public String getRole() {
    return role;
  }

  public void setRole(String role) {
    this.role = role;
  }

}
