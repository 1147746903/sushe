package com.controller;

import com.po.Admin;
import com.po.Student;
import com.po.Teacher;
import com.service.AdminService;
import com.service.StudentService;
import com.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

/**
 * 登陆的控制器类
 */
@Controller
public class LoginController {
    //依赖注入
    @Autowired
    private AdminService adminService;
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private StudentService studentService;
    /**
     * 用户登陆
     */
    @RequestMapping(value="/login.action",method=RequestMethod.POST)
    public String login( @RequestParam("type") String type,@RequestParam("username") String username, @RequestParam("password") String password, Model model, HttpSession session) {
        System.out.println(type);
        //系统管理员判断身份
        if (type.equals("系统管理员")) {
            //通过账号和密码查询用户
            Admin admin = adminService.CheckLogin(username, password);
            if (admin != null) {
                //将管理员对象添加到Session
                session.setAttribute("SESSION", admin);
                session.setAttribute("type",1);
                //跳转到主页 zhe  dou shi shen me dong xi ,跳到success.jsp
                //你就看下  密码错误跳到原来的界面也跳不到
                //你QQ语言我和你说，我现在其他东西没放过来。我只是先搞登陆 。它查询数据库 。
                return "Index";
            }
            model.addAttribute("msg", "账号或密码错误!");
            return "login";
        }
        //楼宇管理员判断身份
        if (type.equals("楼宇管理员")){
            Teacher teacher = teacherService.CheckLogin(username, password);
            if (teacher !=null){
                session.setAttribute("SESSION",teacher);
                session.setAttribute("type",2);
                return "Index";
            }
            model.addAttribute("msg", "账号或密码错误!");
            return "login";
        }
        //学生判断身份
        if (type.equals("学生")){
            Student student = studentService.CheckLogin(username, password);
            if (student !=null){
                session.setAttribute("SESSION",student);
                session.setAttribute("type",3);
                return "Index";
            }
            model.addAttribute("msg", "账号或密码错误!");
            return "login";
        }
        return "login";
    }


    //退出登陆
    @RequestMapping(value="/Quit.action")
    public String quit (HttpSession session){
        //清楚Session
        session.invalidate();
        //重定向登陆页面
        return "redirect:loginq.action";
    }
    //向用户登陆页面跳转
    @RequestMapping(value = "/loginq.action",method = RequestMethod.GET)
    public String login(){
        return "login";
    }
}
