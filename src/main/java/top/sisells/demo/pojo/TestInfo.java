package top.sisells.demo.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class TestInfo {
   private int testId;
   private int classId;
   private String testName;
   private Date testDate;
   private int testSegment;
   private String testClassroom;
   private int testStudentCount;

   public TestInfo(int classId,String testName, Date testDate, int testSegment, String testClassroom, int testStudentCount) {
      this.classId=classId;
      this.testName = testName;
      this.testDate = testDate;
      this.testSegment = testSegment;
      this.testClassroom = testClassroom;
      this.testStudentCount = testStudentCount;
   }
}
