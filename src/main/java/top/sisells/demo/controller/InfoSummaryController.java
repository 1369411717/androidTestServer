package top.sisells.demo.controller;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.sisells.demo.server.InfoSummaryServer;

import java.util.List;
import java.util.Map;

/**
 * 说明：信息汇总
 *
 * @author: SISE_LiuLiShun
 * 2021年02月24日03:16:44
 */
@Controller
@ResponseBody
@RequestMapping("/infoSummary")
public class InfoSummaryController {
    @Autowired
    private InfoSummaryServer infoSummaryServer;

    @RequestMapping("/thisSemesterClassInfo")
    public List<Map> selectThisSemesterClassInfo(String semester) {
        return infoSummaryServer.selectThisSemesterClassInfo(semester);
    }

    @RequestMapping("/thisSemesterTestInfo")
    public List<Map> selectThisSemesterTestInfo(String startDate, String stopDate) {
        return infoSummaryServer.selectThisSemesterTestInfo(startDate, stopDate);
    }

    /**
     * 说明: 本学期各系课程信息
     *
     * @author: SISE_LiuLiShun
     * @date:2021/2/24
     */
    @RequestMapping("/departmentClassInfo")
    public List<Map> selectDepartmentClassInfo(String semester) {
        return infoSummaryServer.selectDepartmentClassInfo(semester);
    }
}
