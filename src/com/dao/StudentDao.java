package com.dao;
import com.po.Student;
import org.apache.ibatis.annotations.Param;
import java.util.List;

public interface StudentDao {
    //验证的登陆
    public Student CheckLogin(@Param("username") String username, @Param("password") String password);
    //查询所有的学生
    public List<Student> findAll();
    //添加学生
    public int addStudent(Student student);
    //通过学号查询学生
    public Student findStudentByUsername(@Param("Student_Username") String Student_Username);
    //通过id查询所有学生
    public Student findStudentById(@Param("Student_ID") int Student_ID);
    //修改学生
    public int StudentUpdateSave(Student student);
    //通过姓名查询
    public List<Student> findStudentByName(@Param("Student_Name") String Student_Name);
    //通过班级查询
    public List<Student> findStudentByClass(@Param("Student_Class") String Student_Class);
    //通过学号查询
    public List<Student> findStudentByUserId(@Param("Student_Username") String Student_Username);
    //通过id删除学生
    public int deleteStudentById(@Param("Student_ID") int Student_ID);
    //通过宿舍号查询该宿舍的所有学生
    public List<Student> findStudentByDomitoryId(@Param("Domitory_ID") int Domitory_ID);
    //添加学生到寝室
    public int addStudentInDomitory(@Param("Student_DomitoryID") int Student_DomitoryID,@Param("Student_Username") String Student_Username);
    //查找学生是否入住
    public String findStudendState(@Param("Student_Username") String Student_Username);
    //填加学生到宿舍 寝室人数加一空床数减一
    public int updateDomitoryjiay(@Param("Domitory_ID") int Domitory_ID);
    //寝室人数减一空床数加一
    public int updateDomitoryjiany(@Param("Domitory_ID") int Domitory_ID);
    //查询寝室空床数
    public int selectDomitoryNullNumber(@Param("Domitory_ID") int Domitory_ID);
    //查询学生信息和所在楼宇和寝室的信息
    public Student findStudentAndDomitory(@Param("Student_Username") String Student_Username);
    //修改学生的寝室号
    public int updateStudentTH(@Param("Student_ID") int Student_ID,@Param("Student_DomitoryID") int Student_DomitoryID);

}
