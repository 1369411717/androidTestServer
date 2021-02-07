package top.sisells.demo.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import top.sisells.demo.pojo.ClassroomInfo;

import java.util.List;

/**
 * 说明: 课室dao
 *
 * @author: SISE_LiuLiShun
 * @date:2021/2/7
 * @parma:
 * @return:
 */
@Mapper
@Repository
public interface ClassroomInfoSql {
    List<ClassroomInfo> selectAllClassroomInfo();
}
