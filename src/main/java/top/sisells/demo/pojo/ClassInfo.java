package top.sisells.demo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClassInfo {
    private int classId;
    private String classNumber;
    private String className;
    private int studentCount;
    private int leftStudentCount;
    private int teacherId;
    private String teacherName;
    private String semester;

    public ClassInfo(String classNumber, String className, int studentCount,
                     int leftStudentCount, int teacherId, String teacherName, String semester) {
        this.classNumber = classNumber;
        this.className = className;
        this.studentCount = studentCount;
        this.leftStudentCount = leftStudentCount;
        this.teacherId = teacherId;
        this.teacherName = teacherName;
        this.semester = semester;
    }
}
