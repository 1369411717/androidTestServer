package top.sisells.demo.server;

import top.sisells.demo.pojo.TestInfo;

import java.sql.Date;
import java.util.List;

/**
 * @author 大江户时代
 */
public interface TestInfoServer {
    List<TestInfo> selectAllTestInfo(String searchText);
    int insertTestInfo(TestInfo testInfo,int seatCount);
    int deleteTestInfo(int testId,int classId);
    List<TestInfo> selectByClassId(int classId);
    int updateTestInfoOnClassroom(TestInfo testInfo,int seatCount);
    int updateTestInfoDate(TestInfo testInfo);
}
