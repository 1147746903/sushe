package com.test;

import com.dao.AdminDao;
import com.dao.StudentDao;
import com.po.Admin;
import com.po.Building;
import com.po.Student;
import com.po.Teacher;
import com.service.AdminService;
import com.service.StudentService;
import com.service.TbService;
import com.service.TeacherService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class Test {
    public static void main(String args[]){
        ApplicationContext act=new ClassPathXmlApplicationContext("applicationContext.xml");
        //根据容器中的Bean的id来获取指定的Bean
        //CustomerDao customerDao= (CustomerDao) act.getBean("customerDao");
        //获取baan的另外一种方式
        AdminService adminDao= act.getBean(AdminService.class);
        Admin admin=adminDao.CheckLogin("java1234","123");
        System.out.println(admin);

        StudentService studentDao = act.getBean(StudentService.class);
        Student student= studentDao.CheckLogin("191", "123");
        System.out.println(student);

        TeacherService teacherDao = act.getBean(TeacherService.class);
        Teacher teacher = teacherDao.CheckLogin("1234", "123");
        System.out.println(teacher);

        List<Teacher> all = teacherDao.findAll();
        for (Teacher teacher1:all)
              {
                  System.out.println(teacher1.getTeacher_Sex());
        }
        TbService tbDao = act.getBean(TbService.class);
        List<Building> tbByBuildingId = tbDao.findTBByBuildingId(2);
        System.out.println(tbByBuildingId);
        for (Building buildings:tbByBuildingId){
           for (Teacher teachers:buildings.getTeacherList()){
               System.out.println(teachers.getTeacher_Username());
           }
        }
        System.out.println("111111111");

    }
}
