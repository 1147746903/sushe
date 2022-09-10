package com.controller;
import com.po.Teacher;
import com.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;

@Controller
public class TeacherController {
    //依赖注入
    @Autowired
    private TeacherService teacherService;

    //查询所有楼宇管理员
    @RequestMapping(value = "/TeacherManager.action")
    public String findAll(Model model){
        List<Teacher> all = teacherService.findAll();
        model.addAttribute("teacher",all);
        return "TeacherManager";
    }
    //添加楼宇管理员
    @RequestMapping("/TeacherAddSave.action")
    public String addteacher(Teacher teacher, @RequestParam("Teacher_Username") String Teacher_Username , Model model){
        System.out.println(Teacher_Username);
        System.out.println(teacher);
        Teacher teacherByUsername = teacherService.findTeacherByUsername(Teacher_Username);
        if (teacherByUsername ==null){
            teacher.setTeacher_Name(Teacher_Username);
            int i = teacherService.addTeacher(teacher);
            if (i>0) {
                model.addAttribute("msg", "添加成功");
                findAll(model);
                return "TeacherManager";
            }
            model.addAttribute("msg","添加失败");
            return "TeacherAdd";
        }
        model.addAttribute("msg","用户名已存在");
        return "TeacherAdd";
    }
    //修改楼宇管理员
    @RequestMapping(value="/TeacherUpdate.action",method= RequestMethod.GET)
    public String updateTeacher(@RequestParam("Teacher_ID") int Teacher_ID, Model model){
        Teacher teacherById = teacherService.findTeacherById(Teacher_ID);
        model.addAttribute("teacher",teacherById);
        return "TeacherUpdate";
    }
    //保存修改楼宇管理员数据
    @RequestMapping("/TeacherUpdateSave.action")
    public String TeacherUpdateSave(Teacher teacher ,Model model ) {
        Teacher teacherByUsername = teacherService.findTeacherByUsername(teacher.getTeacher_Username());
        //判断用户名是否存在
        if (teacherByUsername == null) {
            int i = teacherService.TeacherUpdateSave(teacher);
            if (i > 0){
                model.addAttribute("msg", "修改成功");
                findAll(model);
                return "TeacherManager";
            }
            model.addAttribute("msg", "修改失败");
            return "TeacherUpdate";
        }
        model.addAttribute("msg", "用户名已存在");
        return "TeacherUpdate";
    }
    //通过名字或者电话或者查询楼宇管理员
    @RequestMapping("/TeacherManagerSelect.action")
    public String findTeacherByNameOrTel(@RequestParam("SearchRow") String SearchRow,@RequestParam("SearchKey") String SearchKey
    ,Model model){
        System.out.println(SearchRow);
        System.out.println(SearchKey);
        if (SearchKey !="") {
            if (SearchRow.equals("姓名")) {
                List<Teacher> teacherByName = teacherService.findTeacherByName(SearchKey);
                model.addAttribute("teacher", teacherByName);
                return "TeacherManager";
            }
            if (SearchRow.equals("电话")) {
                List<Teacher> teacherByTel = teacherService.findTeacherByTel(SearchKey);
                model.addAttribute("teacher", teacherByTel);
                return "TeacherManager";
            }
            if (SearchRow.equals("用户名")){
                List<Teacher> teacherByUserId = teacherService.findTeacherByUserId(SearchKey);
                model.addAttribute("teacher", teacherByUserId);
                return "TeacherManager";
            }
        }
         findAll(model);
         return "TeacherManager";
    }
    //通过id删除楼宇管理员
    @RequestMapping(value="/TeacherDel.action",method= RequestMethod.GET)
    public String deleteTeacherById(@RequestParam("Teacher_ID") int Teacher_ID,Model model){
        int i = teacherService.deleteTeacherById(Teacher_ID);
        if (i>0){
            model.addAttribute("msg", "删除成功");
            findAll(model);
            return "TeacherManager";
        }
        model.addAttribute("msg", "删除失败");
           findAll(model);
           return "TeacherManager";
    }
}
