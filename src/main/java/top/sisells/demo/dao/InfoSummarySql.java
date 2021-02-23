package top.sisells.demo.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface InfoSummarySql {
    List<Map> countClassInfo(String flag, String semester);

    List<Map> selectThisSemesterClassInfo(String flag, String semester);

    List<Map> selectThisSemesterTestInfo(String startDate, String stopDate);
}
