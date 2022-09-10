package com.controller;
import com.po.Student;
import com.service.DomitoryService;
import com.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class StudentController {
    //依赖注入
    @Autowired
    private StudentService studentService;
    //查询所有学生
    @RequestMapping("/StudentManager.action")
    public String findAll(Model model){
        List<Student> all = studentService.findAll();
        model.addAttribute("student",all);
        return "StudentManager";
    }
    //添加学生
    @RequestMapping("/StudentAddSave.action")
    public String addStudent(Student student,Model model){
        Student studentByUsername = studentService.findStudentByUsername(student.getStudent_Username());
        if (studentByUsername==null){
            int i = studentService.addStudent(student);
            if (i>0){
                model.addAttribute("msg", "添加成功");
                findAll(model);
                return "StudentManager";
            }
            model.addAttribute("msg","添加失败");
            return "StudentAdd";
        }
        model.addAttribute("msg","学号已存在");
        return "StudentAdd";
    }
    //修改楼宇管理员
    @RequestMapping(value="/StudentUpdate.action",method= RequestMethod.GET)
    public String updateStudent(@RequestParam("Student_ID") int Student_ID, Model model){
        Student studentById = studentService.findStudentById(Student_ID);
        model.addAttribute("student",studentById);
        return "StudentUpdate";
    }
    //保存修改学生数据
    @RequestMapping("/StudentUpdateSave.action")
    public String StudentUpdateSave(Student student ,Model model ) {
        Student studentByUsername = studentService.findStudentByUsername(student.getStudent_Username());
        //判断用户名是否存在
        if (studentByUsername == null) {
            int i = studentService.StudentUpdateSave(student);
            if (i > 0){
                model.addAttribute("msg", "修改成功");
                findAll(model);
                return "StudentManager";
            }
            model.addAttribute("msg", "修改失败");
            return "StudentUpdate";
        }
        model.addAttribute("msg", "学号已存在");
        return "StudentUpdate";
    }
    //通过名字或者班级或学号查询楼宇管理员
    @RequestMapping("/StudentManagerSelect.action")
    public String findStudentByNameOrClass(@RequestParam("SearchRow") String SearchRow,@RequestParam("SearchKey") String SearchKey
            ,Model model){
        System.out.println(SearchRow);
        System.out.println(SearchKey);
        if (SearchKey !=""){
            if (SearchRow.equals("姓名")) {
                List<Student> studentByName = studentService.findStudentByName(SearchKey);
                model.addAttribute("student", studentByName);
                return "StudentManager";
            }
            if (SearchRow.equals("学号")) {
                List<Student> studentByUserId = studentService.findStudentByUserId(SearchKey);
                model.addAttribute("student", studentByUserId);
                return "StudentManager";
            }
            if (SearchRow.equals("班级")){
                List<Student> studentByClass = studentService.findStudentByClass(SearchKey);
                model.addAttribute("student", studentByClass);
                return "StudentManager";
            }
        }
        findAll(model);
        return "StudentManager";
    }
    //通过id删除学生
    @RequestMapping(value="/StudentDel.action",method= RequestMethod.GET)
    public String deleteStudentById(@RequestParam("Student_ID") int Student_ID,Model model){
        int i = studentService.deleteStudentById(Student_ID);
        if (i>0){
            model.addAttribute("msg", "删除成功");
            findAll(model);
            return "StudentManager";
        }
        model.addAttribute("msg", "删除失败");
        findAll(model);
        return "StudentManager";
    }
    //通过宿舍号查询学生信息
    @RequestMapping(value="/DSManager.action",method= RequestMethod.GET)
    public String findStudentByDomitoryId(@RequestParam("Domitory_ID") int Domitory_ID,Model model){
        List<Student> studentByDomitoryId = studentService.findStudentByDomitoryId(Domitory_ID);
        model.addAttribute("student",studentByDomitoryId);
        return "StudentManager";
    }
    //添加学生到寝室中
    @RequestMapping("/StudentRZSave.action")
    public String addStudentInDomitory(@RequestParam("Domitory_ID") int Domitory_ID,
                                       @RequestParam("Student_Username") String Student_Username,Model model) {
        String studendState = studentService.findStudendState(Student_Username);
        Student studentByUsername = studentService.findStudentByUsername(Student_Username);
        int nullNumber = studentService.selectDomitoryNullNumber(Domitory_ID);
        System.out.println(studendState);
        System.out.println(studentByUsername);
        System.out.println(nullNumber);
        if (nullNumber > 0) {
            if (studendState == null && studentByUsername != null) {
                //空床数减一寝室人数加以
                int i1 = studentService.updateDomitoryjiay(Domitory_ID);
                int i = studentService.addStudentInDomitory(Domitory_ID, Student_Username);
                if (i > 0) {
                    model.addAttribute("msg", "添加成功");
                    findAll(model);
                    return "StudentManager";
                }
                model.addAttribute("msg", "添加失败");
                findAll(model);
                return "StudentManager";
            }
            model.addAttribute("msg", "该学生已入住，或该学号不存在");
            findAll(model);
            return "StudentManager";
        }
        model.addAttribute("msg", "宿舍已满，无法添加");
        findAll(model);
        return "StudentManager";
    }
    //查询学生的宿舍和寝室的名字
    @RequestMapping("/StudentTH.action")
    public String findStudentAndDomitory(@RequestParam("Student_Username") String Student_Username,Model model ){
        Student studentAndDomitory = this.studentService.findStudentAndDomitory(Student_Username);
        if (studentAndDomitory !=null) {
            model.addAttribute("student", studentAndDomitory);
            return "StudentTH2";
        }
        model.addAttribute("msg", "该学生未入住");
        return "StudentTH";
    }

    //修改学生的寝室
    @RequestMapping("/StudentTHSave.action")
    public String updateStudentTH(@RequestParam("Student_ID") int Student_ID,@RequestParam("Domitory_ID") int Domitory_ID,
                                  @RequestParam("OldDomitory_ID") int OldDomitory_ID, Model model ){
        System.out.println(Student_ID);
        System.out.println(Domitory_ID);
        System.out.println(OldDomitory_ID);
        //查询要填加寝室的空床人数
        int nullNumber = studentService.selectDomitoryNullNumber(Domitory_ID);
        if (nullNumber>0){
            //旧宿舍减一
            int i = studentService.updateDomitoryjiany(OldDomitory_ID);
            System.out.println(i);
            //修改宿舍
            int i2=studentService.updateStudentTH(Student_ID,Domitory_ID);
            //新宿舍加一
            int i3 = studentService.updateDomitoryjiay(Domitory_ID);
            model.addAttribute("msg", "修改宿舍成功");
            return "StudentTH2";
        }
        model.addAttribute("msg", "宿舍已满，无法添加");
        return "StudentTH2";
    }
}
