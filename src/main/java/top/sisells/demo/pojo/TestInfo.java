package top.sisells.demo.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

/**
 * 说明: 考试信息
 *
 * @author: SISE_LiuLiShun
 * @date:2021/2/7
 * @parma:
 * @return:
 */

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

    public TestInfo(int classId, String testName, Date testDate, int testSegment, String testClassroom) {
        this.classId = classId;
        this.testName = testName;
        this.testDate = testDate;
        this.testSegment = testSegment;
        this.testClassroom = testClassroom;
    }
}
