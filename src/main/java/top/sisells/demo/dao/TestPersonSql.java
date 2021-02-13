package top.sisells.demo.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import top.sisells.demo.pojo.TestPerson;

import java.sql.Date;
import java.util.List;

/**
 * 说明: 监考信息dao
 *
 * @author: SISE_LiuLiShun
 * @date:2021/2/7
 * @parma:
 * @return:
 */
@Mapper
@Repository
public interface TestPersonSql {
    List<TestPerson> selectAllTestPerson();

    List<TestPerson> selectTestPersonByTestId(int testId);

    List<TestPerson> selectTestPersonByUserNumber(int userNumber);

    List<TestPerson> selectTestPersonByTime(Date testDate, int testSegment, List<Integer> userNumberList);

    int insertTestPerson(TestPerson testPerson);

    int deleteTestPerson(int personId);

    int deleteTestPersonByTestId(int testId);

    int updateTestPersonByTestId(int testId, String testClassroom);
}
