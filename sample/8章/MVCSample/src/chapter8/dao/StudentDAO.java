package chapter8.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import chapter8.StudentInfoBean;
import chapter8.StudentRecordBean;
import chapter8.exception.DatabaseException;
import chapter8.exception.SystemException;
import chapter8.parameter.ExceptionParameters;
import chapter8.parameter.StudentParameters;

public class StudentDAO extends DAOBase {

  private Statement stmt;

  public StudentInfoBean getStudentInfoBean()
      throws DatabaseException, SystemException {
    StudentInfoBean studentInfoBean = new StudentInfoBean();
    this.open();
    try {
      stmt = con.createStatement();
      ResultSet rs = stmt.executeQuery("SELECT * FROM STUDENT");
      while (rs.next()) {
        StudentRecordBean record = new StudentRecordBean();
        record.setStudentNo(rs.getInt(StudentParameters.STUDENT_NO));
        record.setStudentName(rs
            .getString(StudentParameters.STUDENT_NAME));
        record
            .setSchoolYear(rs.getInt(StudentParameters.SCHOOL_YEAR));
        studentInfoBean.addStudentRecord(record);
      }
    } catch (SQLException e) {
      throw new DatabaseException(
          ExceptionParameters.DATABASE_CONNECTION_EXCEPTION_MESSAGE,
          e);
    } finally {
      this.close(stmt);
    }
    return studentInfoBean;
  }

  public int addStudentInfo(StudentRecordBean record)
      throws DatabaseException, SystemException {
    int ret = 0;
    this.open();
    try {
      stmt = con.createStatement();
      String sql = "INSERT INTO STUDENT VALUES("
          + record.getStudentNo() + ",\'" + record.getStudentName()
          + "\'," + record.getSchoolYear() + ")";

      ret = stmt.executeUpdate(sql);
    } catch (SQLException e) {
      throw new DatabaseException(
          ExceptionParameters.DATABASE_CONNECTION_EXCEPTION_MESSAGE,
          e);
    } finally {
      this.close(stmt);
    }
    return ret;
  }
}
