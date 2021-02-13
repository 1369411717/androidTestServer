package top.sisells.demo.server.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.sisells.demo.dao.ClassInfoSql;
import top.sisells.demo.dao.TestInfoSql;
import top.sisells.demo.dao.TestPersonSql;
import top.sisells.demo.dao.UserSql;
import top.sisells.demo.pojo.ClassInfo;
import top.sisells.demo.pojo.TestInfo;
import top.sisells.demo.pojo.TestPerson;
import top.sisells.demo.pojo.User;
import top.sisells.demo.server.UserServer;

import java.util.List;

@Transactional
@Service
public class UserServerImpl implements UserServer {


    @Autowired
    private UserSql userSql;
    @Autowired
    private ClassInfoSql classInfoSql;
    @Autowired
    private TestPersonSql testPersonSql;

    @Override
    public List<User> selectAllUser(String userType, String classification, String searchTextValue) {
        return userSql.selectAllUser(userType, classification, searchTextValue);
    }

    @Override
    public int insertUser(User user) {
        return userSql.insertUser(user);
    }

    @Override
    public List<User> selectUser(String userNumber, String password) {
        List<User> userList = userSql.selectUser(userNumber, password);
        if (userList.size() == 0) {
            return null;
        } else {
            return userList;
        }
    }

    @Override
    public int deleteUser(int userNumber) {
        //还有监考人员外键约束
        List<ClassInfo> classInfos = classInfoSql.selectByTeacherId(userNumber);
        List<TestPerson> people = testPersonSql.selectTestPersonByUserNumber(userNumber);
        if (classInfos.size() == 0 && people.size() == 0) {
            return userSql.deleteUser(userNumber);
        } else {
            System.out.println("外键约束！：请求删除用户");
            return 0;
        }
    }

    @Override
    public int updateUser(User user) {
        return userSql.updateUser(user);
    }
}
