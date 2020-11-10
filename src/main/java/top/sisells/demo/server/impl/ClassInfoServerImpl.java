package top.sisells.demo.server.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;
import top.sisells.demo.dao.ClassInfoSql;
import top.sisells.demo.pojo.ClassInfo;
import top.sisells.demo.server.ClassInfoServer;

import java.util.List;

@Service
@Transactional
public class ClassInfoServerImpl implements ClassInfoServer {
    @Autowired
    private ClassInfoSql classInfoSql;

    public List<ClassInfo> selectAllClassInfo(String semester, String leftStudentModel){
        return classInfoSql.selectAllClassInfo(semester,leftStudentModel);
    }

    public int insertClassInfo(String classNumber,String className,int studentCount,
                                int leftStudentCount,int teacherId,String teacherName,String semester){
        ClassInfo classInfo=new ClassInfo(classNumber,className,studentCount,leftStudentCount,teacherId,teacherName,semester);
        return classInfoSql.insertClassInfo(classInfo);
    }

    public int deleteClassInfo(int classId){
        return classInfoSql.deleteClassInfo(classId);
    }

    public int updateClassInfoLeftStudentCount(@RequestParam(required = true) int classId, @RequestParam(required = true)int leftStudentCount){
        return classInfoSql.updateClassInfoLeftStudentCount(leftStudentCount,classId);
    };

    public List<ClassInfo> selectSemester(){
        return classInfoSql.selectSemester();
    }

    public List<ClassInfo> selectByClassId(int classId){
        return classInfoSql.selectByClassId(classId);
    }
}
