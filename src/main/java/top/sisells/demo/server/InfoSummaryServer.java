package top.sisells.demo.server;

import java.util.List;
import java.util.Map;

public interface InfoSummaryServer {
    List<Map> selectDepartmentClassInfo(String semester);

    List<Map> selectThisSemesterClassInfo(String semester);

    List<Map> selectThisSemesterTestInfo(String startDate, String stopDate);

}
