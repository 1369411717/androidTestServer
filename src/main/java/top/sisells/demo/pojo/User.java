package top.sisells.demo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * 说明: 系统用户信息
 *
 * @author: SISE_LiuLiShun
 * @date:2021/2/7
 * @parma:
 * @return:
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {
    private int userNumber;
    private String userName;
    private String password;
    private String classification;
    private String userType;
}
