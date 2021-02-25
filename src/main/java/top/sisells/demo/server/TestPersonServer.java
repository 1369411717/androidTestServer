package top.sisells.demo.server;

import top.sisells.demo.pojo.TestPerson;

import java.util.List;

public interface TestPersonServer {
    List<TestPerson> selectAllTestPerson(String searchText);

    List<TestPerson> selectTestPersonByTestId(int testId);

    int insertTestPerson(TestPerson testPerson);

    int deleteTestPerson(int personId);
}
