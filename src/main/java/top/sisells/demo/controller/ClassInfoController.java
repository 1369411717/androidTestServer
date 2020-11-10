package top.sisells.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import top.sisells.demo.dao.ClassInfoSql;
import top.sisells.demo.pojo.ClassInfo;
import top.sisells.demo.server.ClassInfoServer;

import java.util.List;

@Controller
@ResponseBody
@RequestMapping("/classInfo")
public class ClassInfoController {
    @Autowired
    private ClassInfoServer classInfoServer;

    @RequestMapping("/selectAllClassInfo")
    private List<ClassInfo> selectAllClassInfo(String semester,String leftStudentModel){
        //System.out.println(semester+leftStudentModel);
        return classInfoServer.selectAllClassInfo(semester,leftStudentModel);
    }

    @RequestMapping("/insertClassInfo")
    private int insertClassInfo(String classNumber,String className,int studentCount,
                                int leftStudentCount,int teacherId,String teacherName,String semester){
        return classInfoServer.insertClassInfo(classNumber,className,studentCount,leftStudentCount,teacherId,teacherName,semester);
    }

    @RequestMapping("/deleteClassInfo")
    private int deleteClassInfo(int classId){
        return classInfoServer.deleteClassInfo(classId);
    }

    @RequestMapping("updateClassInfoLeftStudentCount")
    private int updateClassInfoLeftStudentCount(@RequestParam(required = true) int classId,@RequestParam(required = true)int leftStudentCount){
        return classInfoServer.updateClassInfoLeftStudentCount(leftStudentCount,classId);
    };

    @RequestMapping("/selectSemester")
    private List<ClassInfo> selectSemester(){
        return classInfoServer.selectSemester();
    }

    @RequestMapping("selectByClassId")
    private List<ClassInfo> selectByClassId(int classId){
        return classInfoServer.selectByClassId(classId);
    }
}
