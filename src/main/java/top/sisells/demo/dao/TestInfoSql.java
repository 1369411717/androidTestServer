package top.sisells.demo.dao;


import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import top.sisells.demo.pojo.TestInfo;

import java.sql.Date;
import java.util.List;

/**
 * 说明: 考试信息dao
 *
 * @author: SISE_LiuLiShun
 * @date:2021/2/7
 * @parma:
 * @return:
 */
@Mapper
@Repository
public interface TestInfoSql {
    List<TestInfo> selectAllTestInfo(String searchText);

    int insertTestInfo(TestInfo testInfo);

    int deleteTestInfo(int testId);

    List<TestInfo> selectByClassId(int classId);

    int updateTestInfoOnClassroom(TestInfo testInfo);

    List<TestInfo> selectOnlyOne(TestInfo testInfo);

    int updateTestInfoDate(TestInfo testInfo);

    List<TestInfo> selectOnlyOneByList(Date testDate, int testSegment, List<String> testClassroomList);

    List<TestInfo> selectByTestId(int testId);

    List<TestInfo> selectByClassroom(String testClassroom);
}
