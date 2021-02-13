package top.sisells.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.sisells.demo.dao.DepartmentSql;
import top.sisells.demo.pojo.Department;

import java.util.List;

/**
 * 说明：院系信息控制器
 *
 * @author: SISE_LiuLiShun
 * 2021年02月09日02:49:39
 */
@Controller
@RequestMapping("/department")
@ResponseBody
public class DepartmentController {
    @Autowired
    private DepartmentSql departmentSql;

    @RequestMapping("/selectAllDepartment")
    public List<Department> selectAllDepartment() {
        return departmentSql.selectAllDepartment();
    }
}
