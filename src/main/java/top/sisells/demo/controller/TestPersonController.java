package top.sisells.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import top.sisells.demo.pojo.TestPerson;
import top.sisells.demo.server.TestPersonServer;

import java.sql.Date;
import java.util.List;

@Controller
@ResponseBody
@RequestMapping("/testPerson")
public class TestPersonController {
    @Autowired
    private TestPersonServer testPersonServer;

    @RequestMapping("/selectAllTestPerson")
    public List<TestPerson> selectAllTestPerson() {
        return testPersonServer.selectAllTestPerson();
    }

    @RequestMapping("/selectTestPersonByTestId")
    public List<TestPerson> selectTestPersonByTestId(int testId) {
        return testPersonServer.selectTestPersonByTestId(testId);
    }

    @RequestMapping("/insertTestPerson")
    public int insertTestPerson(int testId, String testName, String testDate, int testSegment,
                                String testClassroom, int userNumber, String userName, int leader) {
        TestPerson testPerson = new TestPerson(testId, testName, Date.valueOf(testDate), testSegment,
                testClassroom, userNumber, userName, leader);
        return testPersonServer.insertTestPerson(testPerson);
    }

    @RequestMapping("/deleteTestPerson")
    public int deleteTestPerson(int personId) {
        return testPersonServer.deleteTestPerson(personId);
    }
}
