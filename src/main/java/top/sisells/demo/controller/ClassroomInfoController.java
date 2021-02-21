package top.sisells.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.sisells.demo.dao.ClassroomInfoSql;
import top.sisells.demo.pojo.ClassroomInfo;
import top.sisells.demo.server.ClassroomServer;

import java.util.List;

@Controller
@ResponseBody
@RequestMapping("/classroomInfo")
public class ClassroomInfoController {
    @Autowired
    ClassroomServer classroomServer;

    @RequestMapping("/selectAllClassroomInfo")
    private List<ClassroomInfo> selectAllClassroomInfo(String classroomName) {
        return classroomServer.selectAllClassroomInfo(classroomName);
    }

    @RequestMapping("/deleteClassroom")
    int deleteClassroom(String classroomName) {
        return classroomServer.deleteClassroom(classroomName);
    }

    @RequestMapping("/insertClassroom")
    int insertClassroom(String classroomName, int seatCount) {
        ClassroomInfo classroomInfo = new ClassroomInfo(classroomName, seatCount);
        //如果考场重复返回0
        return classroomServer.insertClassroom(classroomInfo);
    }
}
