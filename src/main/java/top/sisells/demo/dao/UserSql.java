package top.sisells.demo.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import top.sisells.demo.pojo.User;

import java.util.List;

/**
 * 说明: 系统用户dao
 *
 * @author: SISE_LiuLiShun
 * @date:2021/2/7
 * @parma:
 * @return:
 */
@Repository
@Mapper
public interface UserSql {
    List<User> selectAllUser();

    int insertUser(User user);

    List<User> selectUser(String userNumber, String password);

    int deleteUser(int userNumber);

    int updateUser(User user);
}
