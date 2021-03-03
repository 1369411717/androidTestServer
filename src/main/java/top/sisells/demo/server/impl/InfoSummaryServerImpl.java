package top.sisells.demo.server.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.sisells.demo.dao.InfoSummarySql;
import top.sisells.demo.server.InfoSummaryServer;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 说明：信息汇总
 *
 * @author: SISE_LiuLiShun
 * 2021年02月24日03:17:59
 */
@Service
@Transactional
public class InfoSummaryServerImpl implements InfoSummaryServer {
    @Autowired
    InfoSummarySql infoSummarySql;

    @Override
    public List<Map> selectDepartmentClassInfo(String semester) {
        List<Map> unFinishList = infoSummarySql.countClassInfo("未安排", semester);
        List<Map> allList = infoSummarySql.countClassInfo("全部", semester);

        for (int i = 0; i < allList.size(); i++) {
            for (int z = 0; z < unFinishList.size(); z++) {
                if (unFinishList.get(z).get("department").equals(allList.get(i).get("department"))) {
                    allList.get(i).put("unFinishCount", unFinishList.get(z).get("count"));
                    break;
                }
                if ((z + 1) == unFinishList.size()) {
                    allList.get(i).put("unFinishCount", 0);
                }
            }
        }
        return allList;
    }

    /**
    * 说明: 本学期课程信息
    *
    * @author: SISE_LiuLiShun
    * @date:2021/3/3
    * @parma:[semester]
    * @return: java.util.List<java.util.Map>

    */
    @Override
    public List<Map> selectThisSemesterClassInfo(String semester) {
        List<Map> allClassList = infoSummarySql.selectThisSemesterClassInfo("全部", semester);
        List<Map> unFinishList = infoSummarySql.selectThisSemesterClassInfo("未安排", semester);
        allClassList.get(0).put("unFinishCount", unFinishList.get(0).get("count"));
        return allClassList;
    }

    @Override
    public List<Map> selectThisSemesterTestInfo(String startDate, String stopDate) {
        List<Map> allTestList = infoSummarySql.selectThisSemesterTestInfo(startDate, stopDate);
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        List<Map> unFinishList = infoSummarySql.selectThisSemesterTestInfo(formatter.format(date), stopDate);
        allTestList.get(0).put("unFinishCount", unFinishList.get(0).get("count"));
        return allTestList;
    }
}
