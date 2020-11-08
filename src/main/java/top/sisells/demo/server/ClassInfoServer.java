package top.sisells.demo.server;


import top.sisells.demo.pojo.ClassInfo;
import java.util.List;

public interface ClassInfoServer {
    List<ClassInfo> selectAllClassInfo(String semester, String leftStudentModel);
}
