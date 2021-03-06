package top.sisells.demo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 说明: 课室信息
 *
 * @author: SISE_LiuLiShun
 * @date:2021/2/7
 * @parma:
 * @return:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClassroomInfo {
    private String classroomName;
    private int seatCount;
}
