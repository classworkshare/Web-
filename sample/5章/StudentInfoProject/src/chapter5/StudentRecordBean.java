package chapter5;

import java.io.Serializable;

public class StudentRecordBean implements Serializable {

  private int studentNo;
  private String studentName;
  private int schoolYear;

  // Constructor
  public StudentRecordBean() {
  }

  public void setStudentNo(int studentNo) {
    this.studentNo = studentNo;
  }

  public int getStudentNo() {
    return this.studentNo; 
  }

  public void setStudentName(String studentName) {
    this.studentName = studentName;
  }

  public String getStudentName() {
    return this.studentName;
  }

  public void setSchoolYear(int schoolYear) {
    this.schoolYear = schoolYear;
  }

  public int getSchoolYear() {
    return this.schoolYear;
  }

}
