package top.sisells.demo.dao;


import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import top.sisells.demo.pojo.TestInfo;

import java.sql.Date;
import java.util.List;

@Mapper
@Repository
public interface TestInfoSql {
    List<TestInfo> selectAllTestInfo();
    int insertTestInfo(TestInfo testInfo);
    int deleteTestInfo(int testId);
    List<TestInfo> selectByClassId(int classId);
    int updateTestInfoOnClassroom(TestInfo testInfo);
    List<TestInfo>selectOnlyOne(TestInfo testInfo);
    int updateTestInfoDate(TestInfo testInfo);
    List<TestInfo> selectOnlyOneByList(Date testDate,int testSegment,List<String> testClassroomList);
    List<TestInfo> selectByTestId(int testId);
}
