package chapter11.parameter;

public class UserRoleParameters {
  public static final String ROLE_ADMINS = "admins";
  public static final String ROLE_USERS = "users";

  public static final String SQL_SELECT_ALL = "SELECT * FROM USER_ROLES";
  public static final String SQL_SELECT_PERSON = "SELECT * FROM USERS,USER_ROLES WHERE USERS.USERID = USER_ROLES.USERID AND USERS.USERID=?";
  public static final String SQL_INSERT_USERTABLE = "INSERT INTO USERS VALUES(?,?)";
  public static final String SQL_INSERT_USERROLETABLE = "INSERT INTO USER_ROLES VALUES(?,?)";
  public static final String SQL_UPDATE_USER = "UPDATE USERS SET PASSWORD=? WHERE USERID=?";
  public static final String SQL_UPDATE_ROLE = "UPDATE USER_ROLES SET ROLE=? WHERE USERID=?";
  public static final String SQL_DELETE_USER = "DELETE FROM USERS WHERE USERID=?";
  public static final String SQL_DELETE_ROLE = "DELETE FROM USER_ROLES WHERE USERID=?";

  public static final String USERID = "userid";
  public static final String PASSWORD = "password";
  public static final String ROLE = "role";

}
