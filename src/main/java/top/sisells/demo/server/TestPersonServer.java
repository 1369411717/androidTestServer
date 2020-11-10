package top.sisells.demo.server;

import top.sisells.demo.pojo.TestPerson;

import java.util.List;

public interface TestPersonServer {
    List<TestPerson> selectAllTestPerson();
}
