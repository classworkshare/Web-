package chapter8;

import java.io.Serializable;

public class StudentRecordBean implements Serializable {

  private int studentNo;
  private String studentName;
  private int schoolYear;

  public StudentRecordBean() {
    super();
  }

  public int getStudentNo() {
    return studentNo;
  }

  public void setStudentNo(int studentNo) {
    this.studentNo = studentNo;
  }

  public String getStudentName() {
    return studentName;
  }

  public void setStudentName(String studentName) {
    this.studentName = studentName;
  }

  public int getSchoolYear() {
    return schoolYear;
  }

  public void setSchoolYear(int schoolYear) {
    this.schoolYear = schoolYear;
  }
}
