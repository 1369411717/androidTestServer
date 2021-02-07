package top.sisells.demo.server;

import org.springframework.stereotype.Service;
import top.sisells.demo.pojo.User;

import java.util.List;

public interface UserServer {
    List<User> selectAllUser(String userType, String classification, String searchTextValue);

    int insertUser(User user);

    List<User> selectUser(String userNumber, String password);

    int deleteUser(int userNumber);

    int updateUser(User user);
}
