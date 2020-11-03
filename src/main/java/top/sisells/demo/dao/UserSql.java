package top.sisells.demo.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import top.sisells.demo.pojo.User;

import java.util.List;

@Repository
@Mapper
public interface UserSql {
    public List<User> selectAllUser();
    public int insertUser(User user);
    public List<User> selectUser(String userNumber, String password);
    public int deleteUser(int userNumber);
    public int updateUser(User user);
}
