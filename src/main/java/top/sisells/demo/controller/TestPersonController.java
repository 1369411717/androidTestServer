package top.sisells.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.sisells.demo.pojo.TestPerson;
import top.sisells.demo.server.TestPersonServer;

import java.util.List;

@Controller
@ResponseBody
@RequestMapping("/testPerson")
public class TestPersonController {
    @Autowired
    private TestPersonServer testPersonServer;

    @RequestMapping("/selectAllTestPerson")
    public List<TestPerson> selectAllTestPerson(){
        return testPersonServer.selectAllTestPerson();
    }
}
