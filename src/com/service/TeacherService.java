package com.service;

import com.po.Teacher;

import java.util.List;

/**
 * 管理员service层接口
 */
public interface TeacherService {
    //通过账号和密码查询
    public Teacher CheckLogin(String username, String password);
    //查询所有的楼宇管理员
    public List<Teacher> findAll();
    //添加楼宇管理员
    public int addTeacher(Teacher teacher);
    //通过id查询所有楼宇管理员
    public Teacher findTeacherByUsername(String username);
    //通过id查询所有楼宇管理员
    public Teacher findTeacherById(int id);
    //通过id修改所有楼宇管理员
    public int TeacherUpdateSave(Teacher teacher);
    //通过电话查询
    public List<Teacher> findTeacherByName(String Teacher_Name);
    //通过名字查询
    public List<Teacher> findTeacherByTel(String Teacher_Tel);
    //通过用户名查询
    public List<Teacher> findTeacherByUserId(String Teacher_Username);
    //通过id删除楼宇管理员
    public int deleteTeacherById(int Teacher_ID);
}
