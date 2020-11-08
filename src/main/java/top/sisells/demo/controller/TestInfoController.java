package top.sisells.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import top.sisells.demo.pojo.TestInfo;
import top.sisells.demo.server.TestInfoServer;

import java.sql.Date;
import java.util.List;

@Controller
@RequestMapping("testInfo")
@ResponseBody
public class TestInfoController {
    @Autowired
    private TestInfoServer testInfoServer;

    @RequestMapping("selectAllTestInfo")
    private List<TestInfo> selectAllTestInfo(){return testInfoServer.selectAllTestInfo();}

    @RequestMapping("/insertTestInfo")
    private int insertTestInfo(int classId,String testName,String testDate,int testSegment,String testClassroom,int seatCount){
        TestInfo testInfo=new TestInfo(classId,testName,Date.valueOf(testDate),testSegment,testClassroom);
        return testInfoServer.insertTestInfo(testInfo,seatCount);
    };

    @RequestMapping("/deleteTestInfo")
    private int deleteTestInfo(int testId,int classId){
        return testInfoServer.deleteTestInfo(testId,classId);
    }

    @RequestMapping("/selectByClassId")
    public List<TestInfo> selectByClassId(@RequestParam(required=true) int classId){
        return testInfoServer.selectByClassId(classId);
    }
    @RequestMapping("/updateTestInfoOnClassroom")
    public int updateTestInfoOnClassroom(int testId,int classId,String testDate,
                               int testSegment,String testClassroom,int seatCount){
        TestInfo testInfo=new TestInfo();
        testInfo.setTestId(testId);
        testInfo.setClassId(classId);
        testInfo.setTestDate(Date.valueOf(testDate));
        testInfo.setTestSegment(testSegment);
        testInfo.setTestClassroom(testClassroom);
        return testInfoServer.updateTestInfoOnClassroom(testInfo,seatCount);
    }

    @RequestMapping("/updateTestInfoDate")
    public int updateTestInfoDate(@RequestParam(required =true) int classId,String testDate,int testSegment){
        TestInfo testInfo=new TestInfo();
        testInfo.setClassId(classId);
        testInfo.setTestDate(Date.valueOf(testDate));
        testInfo.setTestSegment(testSegment);
        return testInfoServer.updateTestInfoDate(testInfo);
    }
}
