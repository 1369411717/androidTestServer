package top.sisells.demo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
