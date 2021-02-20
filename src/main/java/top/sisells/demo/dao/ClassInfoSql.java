package top.sisells.demo.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import top.sisells.demo.pojo.ClassInfo;

import java.util.List;

/**
 * 说明: 课程信息dao
 *
 * @author: SISE_LiuLiShun
 * @date:2021/2/7
 * @parma:
 * @return:
 */
@Mapper
@Repository
public interface ClassInfoSql {
    List<ClassInfo> selectAllClassInfo(String semester, String leftStudentModel, String department, String searchTextValue);

    int insertClassInfo(ClassInfo classInfo);

    int deleteClassInfo(int classId);

    int updateClassInfoLeftStudentCount(int leftStudentCount, int classId);

    List<ClassInfo> selectSemester();

    List<ClassInfo> selectByTeacherId(int teacherId);

    List<ClassInfo> selectByClassId(int classId);

    List<ClassInfo> selectOnlyOne(String classNumber, int teacherId, String semester);
}
