package com.service.impl;

import com.dao.StudentDao;
import com.po.Student;
import com.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 学生service层接口实现类
 */
@Service("studentService")
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentDao studentDao;
    @Override
    public Student CheckLogin(String username, String password) {
        Student student = this.studentDao.CheckLogin(username, password);
        return student;
    }
    //查询所有学生
    @Override
    public List<Student> findAll() {
        List<Student> all = this.studentDao.findAll();
        return all;
    }

    @Override
    public int addStudent(Student student) {
        int i = this.studentDao.addStudent(student);
        return i;
    }

    @Override
    public Student findStudentByUsername(String Student_Username) {
        Student studentByUsername = this.studentDao.findStudentByUsername(Student_Username);
        return studentByUsername;
    }

    @Override
    public Student findStudentById(int Student_ID) {
        Student studentById = this.studentDao.findStudentById(Student_ID);
        return studentById;
    }

    @Override
    public int StudentUpdateSave(Student student) {
        int i = this.studentDao.StudentUpdateSave(student);
        return i;
    }

    @Override
    public List<Student> findStudentByName(String Student_Name) {
        List<Student> studentByName = this.studentDao.findStudentByName(Student_Name);
        return studentByName;
    }

    @Override
    public List<Student> findStudentByClass(String Student_Class) {
        List<Student> studentByClass = this.studentDao.findStudentByClass(Student_Class);
        return studentByClass;
    }

    @Override
    public List<Student> findStudentByUserId(String Student_Username) {
        List<Student> studentByUserId = this.studentDao.findStudentByUserId(Student_Username);
        return studentByUserId;
    }

    @Override
    public int deleteStudentById(int Student_ID) {
        int i = this.studentDao.deleteStudentById(Student_ID);
        return i;
    }

    @Override
    public List<Student> findStudentByDomitoryId(int Domitory_ID) {
        List<Student> studentByDomitoryId = this.studentDao.findStudentByDomitoryId(Domitory_ID);
        return studentByDomitoryId;
    }
    //添加学生到寝室
    @Override
    public int addStudentInDomitory(int Student_DomitoryID, String Student_Username) {
        int i = this.studentDao.addStudentInDomitory(Student_DomitoryID, Student_Username);
        return i;
    }
    //查询学生是否入住
    @Override
    public String findStudendState(String Student_Username) {
        String studendState = this.studentDao.findStudendState(Student_Username);
        return studendState;
    }
    //寝室空床数减一
    @Override
    public int updateDomitoryjiay(int Domitory_ID) {
        int i = this.studentDao.updateDomitoryjiay(Domitory_ID);
        return i;
    }
     //寝室人数建议 空床上加一
    @Override
    public int updateDomitoryjiany(int Domitory_ID) {
        int i = this.studentDao.updateDomitoryjiany(Domitory_ID);
        return i;
    }

    //查询寝室空床数
    @Override
    public int selectDomitoryNullNumber(int Domitory_ID) {
        int i = this.studentDao.selectDomitoryNullNumber(Domitory_ID);
        return i;
    }
    //查询学生的宿舍和寝室的名字
    @Override
    public Student findStudentAndDomitory(String Student_Username) {
        Student studentAndDomitory = this.studentDao.findStudentAndDomitory(Student_Username);
        return studentAndDomitory;
    }
    //修改学生的寝室
    @Override
    public int updateStudentTH(int Student_ID, int Domitory_ID) {
        int i = this.studentDao.updateStudentTH(Student_ID, Domitory_ID);
        return i;
    }
}
