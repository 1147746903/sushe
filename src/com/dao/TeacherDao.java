package com.dao;
import com.po.Teacher;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TeacherDao {
    //验证的登陆
    public Teacher CheckLogin(@Param("username") String username, @Param("password") String password);
    //查询所有的楼宇管理员
    public List<Teacher> findAll();
    //添加楼宇管理员
    public int addTeacher(Teacher teacher);
    //通过用户名查询所有楼宇管理员
    public Teacher findTeacherByUsername(@Param("username") String username);
    //通过id查询所有楼宇管理员
    public Teacher findTeacherById(@Param("id") int id);
    //通过id修改所有楼宇管理员
    public int TeacherUpdateSave(Teacher teacher);
    //通过名字查询
    public List<Teacher> findTeacherByName(@Param("Teacher_Name") String Teacher_Name);
    //通过电话查询
    public List<Teacher> findTeacherByTel(@Param("Teacher_Tel") String Teacher_Tel);
    //通过用户名查询
    public List<Teacher> findTeacherByUserId(@Param("Teacher_Username") String Teacher_Username);
    //通过id删除楼宇管理员
    public int deleteTeacherById(@Param("Teacher_ID") int Teacher_ID);
}
