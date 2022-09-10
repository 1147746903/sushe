package com.service;
import com.po.Student;
import java.util.List;

/**
 * 管理员service层接口
 */
public interface StudentService {
    //通过账号和密码查询
    public Student CheckLogin(String username, String password);
    //查询所有的楼宇管理员
    public List<Student> findAll();
    //添加学生
    public int addStudent(Student student);
    //通过学号查询学生
    public Student findStudentByUsername(String Student_Username);
    //通过id查询所有楼宇管理员
    public Student findStudentById(int Student_ID);
    //通过id修改所有楼宇管理员
    public int StudentUpdateSave(Student student);
    //通过姓名查询
    public List<Student> findStudentByName(String Student_Name);
    //通过班级查询
    public List<Student> findStudentByClass(String Student_Class);
    //通过学号查询
    public List<Student> findStudentByUserId(String Student_Username);
    //通过id删除学生
    public int deleteStudentById(int Student_ID);
    //通过宿舍号查询该宿舍的所有学生
    public List<Student> findStudentByDomitoryId(int Domitory_ID);
    //添加学生到寝室
    public int addStudentInDomitory(int Student_DomitoryID,String Student_Username);
    //查找学生是否入住
    public String findStudendState(String Student_Username);
    //填加学生到宿舍 寝室人数加以空床数减一
    public int updateDomitoryjiay(int Domitory_ID);
    //寝室人数减一空床数加一
    public int updateDomitoryjiany(int Domitory_ID);
    //查询寝室空床数
    public int selectDomitoryNullNumber(int Domitory_ID);
    //查询学生信息和所在楼宇和寝室的信息
    public Student findStudentAndDomitory(String Student_Username);
    //修改学生的寝室号
    public int updateStudentTH(int Student_ID,int Domitory_ID);
}
