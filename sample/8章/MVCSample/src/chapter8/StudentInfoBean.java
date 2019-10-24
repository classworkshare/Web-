package chapter8;

import java.io.Serializable;
import java.util.ArrayList;

public class StudentInfoBean implements Serializable {

  private ArrayList<StudentRecordBean> studentRecordArray;

  public StudentInfoBean() {
    studentRecordArray = new ArrayList<StudentRecordBean>();
  }

  public void addStudentRecord(StudentRecordBean obj) {
    studentRecordArray.add(obj);
  }

  public int getArraySize() {
    return studentRecordArray.size();
  }

  public ArrayList<StudentRecordBean> getStudentRecordArray() {
    return studentRecordArray;
  }

  public void setStudentRecordArray(
      ArrayList<StudentRecordBean> studentRecordArray) {
    this.studentRecordArray = studentRecordArray;
  }
}
