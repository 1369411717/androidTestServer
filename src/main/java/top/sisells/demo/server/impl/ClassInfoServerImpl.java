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

    @Override
    public List<ClassInfo> selectAllClassInfo(String semester, String leftStudentModel, String department, String searchTextValue) {
        return classInfoSql.selectAllClassInfo(semester, leftStudentModel, department, searchTextValue);
    }

    @Override
    public int insertClassInfo(String classNumber, String className, int studentCount,
                               int leftStudentCount, int teacherId, String teacherName, String semester, String department) {
        ClassInfo classInfo = new ClassInfo(classNumber, className, studentCount, leftStudentCount, teacherId, teacherName, semester, department);
        return classInfoSql.insertClassInfo(classInfo);
    }

    @Override
    public int deleteClassInfo(int classId) {
        return classInfoSql.deleteClassInfo(classId);
    }

    @Override
    public int updateClassInfoLeftStudentCount(@RequestParam(required = true) int classId, @RequestParam(required = true) int leftStudentCount) {
        return classInfoSql.updateClassInfoLeftStudentCount(leftStudentCount, classId);
    }

    ;

    @Override
    public List<ClassInfo> selectSemester() {
        return classInfoSql.selectSemester();
    }

    @Override
    public List<ClassInfo> selectByClassId(int classId) {
        return classInfoSql.selectByClassId(classId);
    }
}
