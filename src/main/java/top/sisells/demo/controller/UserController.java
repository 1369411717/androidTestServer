package top.sisells.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import top.sisells.demo.pojo.User;
import top.sisells.demo.server.UserServer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("user")
@ResponseBody
public class UserController {

    @Autowired
    private UserServer userServer;

    @RequestMapping("/checkLogin")
    public List<User> checkLogin(String userNumber, String password) {
        return userServer.selectUser(userNumber, password);
    }

    @RequestMapping("/selectAllUser")
    public List<User> selectAllUser(String userType, String classification, String searchTextValue) {
        return userServer.selectAllUser(userType,classification,searchTextValue);
    }

    @RequestMapping("/insertUser")
    public int insertUser(int userNumber, String userName, String password, String classification, String userType) {
        User user = new User(userNumber, userName, password, classification, userType);
        return userServer.insertUser(user);
    }

    @RequestMapping("/deleteUser")
    public int deleteUser(int userNumber) {
        return userServer.deleteUser(userNumber);
    }

    @RequestMapping("/updateUser")
    public int updateUser(@RequestParam(required = true) int userNumber, String userName, String password,
                          String classification, String userType) {
        User user = new User(userNumber, userName, password, classification, userType);
        return userServer.updateUser(user);
    }
}
