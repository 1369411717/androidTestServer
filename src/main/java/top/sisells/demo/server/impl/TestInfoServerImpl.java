package top.sisells.demo.server.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.sisells.demo.dao.ClassInfoSql;
import top.sisells.demo.dao.TestInfoSql;
import top.sisells.demo.pojo.TestInfo;
import top.sisells.demo.server.TestInfoServer;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class TestInfoServerImpl implements TestInfoServer {

    @Autowired
    private TestInfoSql testInfoSql;
    @Autowired
    private ClassInfoSql classInfoSql;

    @Override
    public List<TestInfo> selectAllTestInfo() {
        return testInfoSql.selectAllTestInfo();
    }

    @Override
    public int insertTestInfo(TestInfo testInfo,int seatCount) {
        //检查考试的冲突逻辑
        //!同一门课id的考试要在用一天，同一时间段考试
        //课室，时间段和日期不能相同
        //修改课程剩余安排人数
        if (testInfoSql.selectOnlyOne(testInfo).size() != 0) {
            return -1;//有冲突
        } else {
            //课程剩余未安排人数
            int classId=testInfo.getClassId();
            int leftStudentCount = classInfoSql.selectByClassId(classId).get(0).getLeftStudentCount();
            if (leftStudentCount != 0) {
                if (seatCount >= leftStudentCount) {
                    testInfo.setTestStudentCount(leftStudentCount);
                    classInfoSql.updateClassInfoLeftStudentCount(0, testInfo.getClassId());//处理课程的剩余学生人数
                } else if (seatCount < leftStudentCount) {
                    testInfo.setTestStudentCount(seatCount);//处理考试学生人数
                    classInfoSql.updateClassInfoLeftStudentCount(leftStudentCount, testInfo.getClassId());
                }
            }
            return testInfoSql.insertTestInfo(testInfo);
        }
    }

    public int deleteTestInfo(int testId,int classId){
        //解决外键冲突
        //处理监考老师的删除
        //修改课程剩余安排人数,classId处理
        //修改前的考试人数
        int preStudentCount=testInfoSql.selectByTestId(testId).get(0).getTestStudentCount();
        //课程剩余未安排人数
        int leftStudentCount=classInfoSql.selectByClassId(classId).get(0).getLeftStudentCount();
        classInfoSql.updateClassInfoLeftStudentCount(leftStudentCount+preStudentCount,classId);
        return testInfoSql.deleteTestInfo(testId);
    };

    public List<TestInfo> selectByClassId(int classId){//该课程的考试信息
        return testInfoSql.selectByClassId(classId);
    }

    public  int updateTestInfoOnClassroom(TestInfo testInfo,int seatCount){
       //个别更新教室
        //修改课程剩余安排人数
        //教室应该没有冲突
        if (testInfoSql.selectOnlyOne(testInfo).size()!=0){
            return -1;//有冲突
        }else {
            //修改前的考试人数
            int preStudentCount=testInfoSql.selectByTestId(testInfo.getTestId()).get(0).getTestStudentCount();
            //课程剩余未安排人数
            int leftStudentCount=classInfoSql.selectByClassId(testInfo.getClassId()).get(0).getLeftStudentCount();
            if(leftStudentCount!=0) {
                int outStudentCount = preStudentCount + leftStudentCount;
                if (seatCount >= outStudentCount) {
                    testInfo.setTestStudentCount(outStudentCount);
                    classInfoSql.updateClassInfoLeftStudentCount(0, testInfo.getClassId());//处理课程的剩余学生人数
                } else if (seatCount < outStudentCount) {
                    testInfo.setTestStudentCount(seatCount);//处理考试学生人数
                    classInfoSql.updateClassInfoLeftStudentCount(outStudentCount - seatCount, testInfo.getClassId());
                }
            }
            //根据testId修改监考老师表的教室!!!!!!!!!!!!!!!!!!!!!!!
            return testInfoSql.updateTestInfoOnClassroom(testInfo);
        }
    }

    public int updateTestInfoDate(TestInfo testInfo){
        //判断修改日期后是否有冲突
        //修改日期后的监考老师冲突！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！
        //修改监考表的时间安排
        //1,寻找相同课程的所有教室列表
        List<String> testClassroomList=new ArrayList();
        List<TestInfo> testInfoList=selectByClassId(testInfo.getClassId());
        if (testInfoList.size()==0){
            return 0;//不存在需要升级的现有课程
        }else {
            for(int i=0;i<testInfoList.size();i++){
                testClassroomList.add(testInfoList.get(i).getTestClassroom());
            }
            System.out.println(testClassroomList.toString());
            if(testInfoSql.selectOnlyOneByList(testInfo.getTestDate(),
                    testInfo.getTestSegment(),testClassroomList).size()==0){ //2，查找相同时间按段是否有冲突
                return testInfoSql.updateTestInfoDate(testInfo);
            }else {
                return -1;//修改的时间段内有冲突的教室
            }
        }
    }
}
