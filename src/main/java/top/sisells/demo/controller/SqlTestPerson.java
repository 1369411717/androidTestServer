package top.sisells.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
@RequestMapping("/testPerson")
public class SqlTestPerson {
    @Autowired
    private SqlTestPerson sqlTestPerson;

    @RequestMapping("/selectAllTestPerson")
    public String selectAllTestPerson(){
        return sqlTestPerson.selectAllTestPerson();
    }
}
