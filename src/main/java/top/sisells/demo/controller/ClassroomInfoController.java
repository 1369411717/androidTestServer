package top.sisells.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.sisells.demo.dao.ClassroomInfoSql;
import top.sisells.demo.pojo.ClassroomInfo;

import java.util.List;

@Controller
@ResponseBody
@RequestMapping("/classroomInfo")
public class ClassroomInfoController {
    @Autowired
    private ClassroomInfoSql classroomInfoSql;

    @RequestMapping("/selectAllClassroomInfo")
    private List<ClassroomInfo> selectAllClassroomInfo(){
        return classroomInfoSql.selectAllClassroomInfo();
    }

}
