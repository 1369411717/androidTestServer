package top.sisells.demo.server.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.sisells.demo.dao.ClassroomInfoSql;
import top.sisells.demo.dao.TestInfoSql;
import top.sisells.demo.pojo.ClassroomInfo;
import top.sisells.demo.pojo.TestInfo;
import top.sisells.demo.server.ClassroomServer;

import java.util.List;

/**
 * 说明：考场信息管理
 *
 * @author: SISE_LiuLiShun
 * 2021年02月21日04:12:00
 */
@Service
@Transactional
public class ClassroomServerImpl implements ClassroomServer {

    @Autowired
    private ClassroomInfoSql classroomInfoSql;
    @Autowired
    private TestInfoSql testInfoSql;

    @Override
    public List<ClassroomInfo> selectAllClassroomInfo() {
        return classroomInfoSql.selectAllClassroomInfo();
    }

    @Override
    public int deleteClassroom(String classroomName) {
        List<TestInfo> testInfos = testInfoSql.selectByClassroom(classroomName);
        if (testInfos.size() == 0) {
            return classroomInfoSql.deleteClassroom(classroomName);
        } else {
            //考场有考试安排
            return -1;
        }
    }

    @Override
    public int insertClassroom(ClassroomInfo classroomInfo) {
        return classroomInfoSql.insertClassroom(classroomInfo);
    }
}
