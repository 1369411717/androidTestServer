package top.sisells.demo.server.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.sisells.demo.dao.ClassInfoSql;
import top.sisells.demo.pojo.ClassInfo;
import top.sisells.demo.server.ClassInfoServer;

import java.util.List;

@Service
public class ClassInfoServerImpl implements ClassInfoServer {
    @Autowired
    private ClassInfoSql classInfoSql;

    public List<ClassInfo> selectAllClassInfo(String semester, String leftStudentModel){
        return classInfoSql.selectAllClassInfo(semester,leftStudentModel);
    }
}
