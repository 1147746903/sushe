package com.service.impl;

import com.dao.TeacherDao;
import com.po.Teacher;
import com.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("teacherService")
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    private TeacherDao teacherDao;
    //验证登陆
    @Override
    public Teacher CheckLogin(String username, String password) {
        Teacher teacher = this.teacherDao.CheckLogin(username, password);
        return teacher;
    }
    //查询所有楼宇管理员
    @Override
    public List<Teacher> findAll() {
        List<Teacher> all = this.teacherDao.findAll();
        return all;
    }
    //添加楼宇管理员
    @Override
    public int addTeacher(Teacher teacher) {
        int teacher1 = this.teacherDao.addTeacher(teacher);
        return teacher1;
    }
    //通过用户名查询楼宇管理员
    @Override
    public Teacher findTeacherByUsername(String username) {
        Teacher teacherByUsername = this.teacherDao.findTeacherByUsername(username);
        return teacherByUsername;
    }
    //通过id查询楼宇管理员
    @Override
    public Teacher findTeacherById(int id) {
        Teacher teacherById = this.teacherDao.findTeacherById(id);
        return teacherById;
    }
    //保存楼宇管理员信息
    @Override
    public int TeacherUpdateSave(Teacher teacher) {
        int i = this.teacherDao.TeacherUpdateSave(teacher);
        return i;
    }
    //通过名字查询楼宇管理员
    @Override
    public List<Teacher> findTeacherByName(String Teacher_Name) {
        List<Teacher> teacherByName = this.teacherDao.findTeacherByName(Teacher_Name);
        return teacherByName;
    }
    //通过电话查询楼宇管理员
    @Override
    public List<Teacher> findTeacherByTel(String Teacher_Tel) {
        List<Teacher> teacherByTel = this.teacherDao.findTeacherByTel(Teacher_Tel);
        return teacherByTel;
    }

    @Override
    public List<Teacher> findTeacherByUserId(String Teacher_Username) {
        List<Teacher> teacherByUserId = this.teacherDao.findTeacherByUserId(Teacher_Username);
        return teacherByUserId;
    }

    @Override
    public int deleteTeacherById(int Teacher_ID) {
        int i = this.teacherDao.deleteTeacherById(Teacher_ID);
        return i;
    }
}
