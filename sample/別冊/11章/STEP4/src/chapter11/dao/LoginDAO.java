package chapter11.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import chapter11.exception.DatabaseException;
import chapter11.exception.SystemException;
import chapter11.parameter.ExceptionParameters;
import chapter11.parameter.UserRoleParameters;
import chapter11.user.UserBean;

public class LoginDAO extends DAOBase {

  public UserBean getUser(String userid, String password)
      throws DatabaseException, SystemException {
    UserBean record = null;
    PreparedStatement stmt = null;
    this.open();
    try {
      stmt = con.prepareStatement(UserRoleParameters.SQL_SELECT_USER);
      stmt.setString(1, userid);
      stmt.setString(2, password);
      ResultSet rs = stmt.executeQuery();
      if (rs.next()) {
        record = new UserBean();
        record.setUserid(rs.getString(UserRoleParameters.USERID));
        record.setPasswd(rs.getString(UserRoleParameters.PASSWORD));
        record.setRole(rs.getString(UserRoleParameters.ROLE));
      }
    } catch (SQLException e) {
      throw new DatabaseException(
          ExceptionParameters.DATABASE_CONNECTION_EXCEPTION_MESSAGE,
          e);
    } finally {
      this.close(stmt);
    }
    return record;
  }
}
