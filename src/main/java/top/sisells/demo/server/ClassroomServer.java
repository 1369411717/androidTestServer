package top.sisells.demo.server;

import top.sisells.demo.pojo.ClassroomInfo;

import java.util.List;

public interface ClassroomServer {

    List<ClassroomInfo> selectAllClassroomInfo(String classroomName);

    int deleteClassroom(String classroomName);

    int insertClassroom(ClassroomInfo classroomInfo);

}
