package top.sisells.demo.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import top.sisells.demo.pojo.TestPerson;

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

    int insertTestPerson(TestPerson testPerson);

    int deleteTestPerson(int personId);
}
