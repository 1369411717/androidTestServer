package top.sisells.demo.server;


import org.springframework.web.bind.annotation.RequestParam;
import top.sisells.demo.pojo.ClassInfo;
import java.util.List;

public interface ClassInfoServer {
    List<ClassInfo> selectAllClassInfo(String semester, String leftStudentModel);
    int insertClassInfo(String classNumber,String className,int studentCount,
                               int leftStudentCount,int teacherId,String teacherName,String semester);

    int deleteClassInfo(int classId);

    int updateClassInfoLeftStudentCount(@RequestParam(required = true) int classId, @RequestParam(required = true)int leftStudentCount);

    List<ClassInfo> selectSemester();

    List<ClassInfo> selectByClassId(int classId);
}
