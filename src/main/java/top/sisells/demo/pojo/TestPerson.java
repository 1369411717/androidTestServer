package top.sisells.demo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;


/**
 * 说明: 监考人员信息
 *
 * @author: SISE_LiuLiShun
 * @date:2021/2/7
 * @parma:
 * @return:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TestPerson {
    private int personId;
    private int testId;
    private String testName;
    private Date testDate;
    private int testSegment;
    private String testClassroom;
    private int userNumber;
    private String userName;
}
