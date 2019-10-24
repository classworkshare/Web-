package chapter8.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import chapter8.exception.DatabaseException;
import chapter8.exception.SystemException;
import chapter8.parameter.DAOParameters;
import chapter8.parameter.ExceptionParameters;

public class DAOBase {

  Connection con;

  protected void open() throws DatabaseException, SystemException {
    try {
      Class.forName(DAOParameters.DRIVER_NAME);
      con = DriverManager.getConnection(DAOParameters.CONNECT_STRING,
          DAOParameters.USERID, DAOParameters.PASSWORD);
    } catch (ClassNotFoundException e) {
      throw new SystemException(
          ExceptionParameters.SYSTEM_EXCEPTION_MESSAGE, e);
    } catch (SQLException e) {
      throw new DatabaseException(
          ExceptionParameters.DATABASE_CONNECTION_EXCEPTION_MESSAGE,
          e);
    }
  }

  protected void close(Statement stmt) throws DatabaseException {
    try {
      if (stmt != null) {
        stmt.close();
      }
      if (con != null) {
        con.close();
      }
    } catch (SQLException e) {
      throw new DatabaseException(
          ExceptionParameters.DATABASE_CLOSE_EXCEPTION_MESSAGE, e);
    }
  }

}
