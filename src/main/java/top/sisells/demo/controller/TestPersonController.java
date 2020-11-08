package top.sisells.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.sisells.demo.dao.TestPersonSql;
import top.sisells.demo.pojo.TestPerson;

import java.util.List;

@Controller
@ResponseBody
@RequestMapping("/testPerson")
public class TestPersonController {
    @Autowired
    private TestPersonSql testPersonSql;

    @RequestMapping("/selectAllTestPerson")
    public List<TestPerson> selectAllTestPerson(){
        return testPersonSql.selectAllTestPerson();
    }
}
