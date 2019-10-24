package chapter11.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import chapter11.exception.DatabaseException;
import chapter11.exception.SystemException;
import chapter11.parameter.ExceptionParameters;
import chapter11.parameter.UserRoleParameters;
import chapter11.user.UserArrayBean;
import chapter11.user.UserBean;

public class UserDAO extends DAOBase {

  public UserArrayBean getUserArray() throws DatabaseException,
      SystemException {
    Statement stmt = null;
    UserArrayBean userArray = new UserArrayBean();
    this.open();
    try {
      stmt = con.createStatement();
      ResultSet rs = stmt
          .executeQuery(UserRoleParameters.SQL_SELECT_ALL);
      while (rs.next()) {
        UserBean record = new UserBean();
        record.setUserid(rs.getString(UserRoleParameters.USERID));
        record.setRole(rs.getString(UserRoleParameters.ROLE));
        userArray.addUser(record);
      }
    } catch (SQLException e) {
      throw new DatabaseException(
          ExceptionParameters.DATABASE_CONNECTION_EXCEPTION_MESSAGE, e);
    } finally {
      this.close(stmt);
    }
    return userArray;
  }

  public UserBean getUser(String userid) throws DatabaseException,
      SystemException {
    UserBean record = null;
    PreparedStatement stmt = null;
    this.open();
    try {
      stmt = con.prepareStatement(UserRoleParameters.SQL_SELECT_PERSON);
      stmt.setString(1, userid);
      ResultSet rs = stmt.executeQuery();
      rs.next();
      record = new UserBean();
      record.setUserid(rs.getString(UserRoleParameters.USERID));
      record.setPasswd(rs.getString(UserRoleParameters.PASSWORD));
      record.setRole(rs.getString(UserRoleParameters.ROLE));
    } catch (SQLException e) {
      throw new DatabaseException(
          ExceptionParameters.DATABASE_CONNECTION_EXCEPTION_MESSAGE, e);
    } finally {
      this.close(stmt);
    }
    return record;
  }

  public void addUser(UserBean user) throws DatabaseException,
      SystemException {

    PreparedStatement stmt = null;
    this.open();
    try {
      stmt = con
          .prepareStatement(UserRoleParameters.SQL_INSERT_USERTABLE);
      stmt.setString(1, user.getUserid());
      stmt.setString(2, user.getPasswd());
      stmt.executeUpdate();
    } catch (SQLException e) {
      throw new DatabaseException(
          ExceptionParameters.DATABASE_CONNECTION_EXCEPTION_MESSAGE, e);
    } finally {
      this.close(stmt);
    }
    this.open();
    try {
      stmt = con
          .prepareStatement(UserRoleParameters.SQL_INSERT_USERROLETABLE);
      stmt.setString(1, user.getUserid());
      stmt.setString(2, user.getRole());
      stmt.executeUpdate();
    } catch (SQLException e) {
      throw new DatabaseException(
          ExceptionParameters.DATABASE_CONNECTION_EXCEPTION_MESSAGE, e);
    } finally {
      this.close(stmt);
    }

  }

  public void updateUser(UserBean user) throws DatabaseException,
      SystemException {
    PreparedStatement stmt = null;
    this.open();
    try {
      stmt = con.prepareStatement(UserRoleParameters.SQL_UPDATE_USER);
      stmt.setString(1, user.getPasswd());
      stmt.setString(2, user.getUserid());
      stmt.executeUpdate();
    } catch (SQLException e) {
      throw new DatabaseException(
          ExceptionParameters.DATABASE_CONNECTION_EXCEPTION_MESSAGE, e);
    } finally {
      this.close(stmt);
    }
    this.open();
    try {
      stmt = con.prepareStatement(UserRoleParameters.SQL_UPDATE_ROLE);
      stmt.setString(1, user.getRole());
      stmt.setString(2, user.getUserid());
      stmt.executeUpdate();
    } catch (SQLException e) {
      throw new DatabaseException(
          ExceptionParameters.DATABASE_CONNECTION_EXCEPTION_MESSAGE, e);
    } finally {
      this.close(stmt);
    }

  }

  public void deleteUser(String userid) throws DatabaseException,
      SystemException {
    PreparedStatement stmt = null;
    this.open();
    try {
      stmt = con.prepareStatement(UserRoleParameters.SQL_DELETE_ROLE);
      stmt.setString(1, userid);
      stmt.executeUpdate();
    } catch (SQLException e) {
      throw new DatabaseException(
          ExceptionParameters.DATABASE_CONNECTION_EXCEPTION_MESSAGE, e);
    } finally {
      this.close(stmt);
    }
    this.open();
    try {
      stmt = con.prepareStatement(UserRoleParameters.SQL_DELETE_USER);
      stmt.setString(1, userid);
      stmt.executeUpdate();
    } catch (SQLException e) {
      throw new DatabaseException(
          ExceptionParameters.DATABASE_CONNECTION_EXCEPTION_MESSAGE, e);
    } finally {
      this.close(stmt);
    }

  }

}
