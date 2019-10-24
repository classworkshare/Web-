package chapter5;

import java.io.Serializable;
import java.util.ArrayList;

public class StudentInfoBean implements Serializable {

  private ArrayList<StudentRecordBean> studentRecordArray = new ArrayList<StudentRecordBean>();

// Constructor
  public StudentInfoBean() {
  }

  public ArrayList<StudentRecordBean> getStudentRecordArray() {
    return studentRecordArray;
  }

  public void addStudentRecord(StudentRecordBean obj) {
    studentRecordArray.add(obj);
  }

  public int getArraySize() {
    return studentRecordArray.size();
  }

}
