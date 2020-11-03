package top.sisells.demo.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import top.sisells.demo.pojo.ClassroomInfo;

import java.util.List;

@Mapper
@Repository
public interface ClassroomInfoSql {
    List<ClassroomInfo> selectAllClassroomInfo();
}
