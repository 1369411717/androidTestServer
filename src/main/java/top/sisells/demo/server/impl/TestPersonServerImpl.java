package top.sisells.demo.server.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.sisells.demo.dao.TestPersonSql;
import top.sisells.demo.pojo.TestPerson;
import top.sisells.demo.server.TestPersonServer;

import java.util.List;

@Service
@Transactional
public class TestPersonServerImpl implements TestPersonServer {
    @Autowired
    TestPersonSql testPersonSql;

    @Override
    public List<TestPerson> selectAllTestPerson() {
        return testPersonSql.selectAllTestPerson();
    }

    @Override
    public List<TestPerson> selectTestPersonByTestId(int testId) {
        return testPersonSql.selectTestPersonByTestId(testId);
    }

    @Override
    public int insertTestPerson(TestPerson testPerson) {
        return testPersonSql.insertTestPerson(testPerson);
    }

    @Override
    public int deleteTestPerson(int personId) {
        return testPersonSql.deleteTestPerson(personId);
    }
}
