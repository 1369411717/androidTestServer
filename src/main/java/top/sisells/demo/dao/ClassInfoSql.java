package top.sisells.demo.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import top.sisells.demo.pojo.ClassInfo;

import java.util.List;

@Mapper
@Repository
public interface ClassInfoSql {
    List<ClassInfo> selectAllClassInfo(String semester,String leftStudentModel);
    int insertClassInfo(ClassInfo classInfo);
    int deleteClassInfo(int classId);
    int updateClassInfoLeftStudentCount(int leftStudentCount,int classId);
    List<ClassInfo> selectSemester();
    List<ClassInfo> selectByTeacherId(int teacherId);
    List<ClassInfo> selectByClassId(int classId);
}
