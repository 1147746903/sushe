package com.controller;

import com.po.Domitory;
import com.po.Log;
import com.service.DomitoryService;
import com.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class LogController {
    //依赖注入
    @Autowired
    private LogService logService;
    @Autowired
    private DomitoryService domitoryService;
    //查询所有楼宇管理员
    @RequestMapping(value = "/AdminLog.action")
    public String findAll(Model model){
        final List<Log> all = logService.findAll();
        model.addAttribute("log",all);
        return "AdminLogList";
    }
    //添加学生缺寝记录
    @RequestMapping(value = "/LogAddSave.action")
    public String addLog(Log log ,Model model ) {
        int i = logService.addLog(log);
        if (i > 0) {
            model.addAttribute("msg","保存成功");
            return "LogAdd";
        }
        model.addAttribute("msg","保存失败");
        return "LogAdd";
    }
    //通过楼宇号查询学生的缺寝记录
    @RequestMapping(value = "/MyLogList.action")
    public String findLog(@RequestParam("Building_ID") int Building_ID , Model model){
        System.out.println(Building_ID);
        List<Domitory> log = this.logService.findLog(Building_ID);
        System.out.println(log);
        model.addAttribute("dsl",log);
        return "MyLogList";
    }

    //通过学号和寝室号查询缺寝记录
    @RequestMapping(value = "/MyLogList2.action")
    @Autowired(required = false)
    public String findLogByDid(@RequestParam("Student_DomitoryID") int Student_DomitoryID,
                                                     @RequestParam("Student_Username") String Student_Username ,Model model) {
        if (Student_DomitoryID !=0 & Student_Username != "") {
            List<Domitory> logByDid = this.logService.findLogByDid(Student_DomitoryID, Student_Username);
            model.addAttribute("dsl", logByDid);
            return "MyLogList";
        } else {
            List<Domitory> logByDid2 = this.logService.findLogByDid2(Student_DomitoryID);
            model.addAttribute("msg", "请输入学号,选择寝室");
            model.addAttribute("dsl",logByDid2);
            return "MyLogList";
        }
    }

    //学生端查询缺寝记录
    @RequestMapping(value = "/StudentLog.action")
    public String findLogByStudentId(@RequestParam("Student_ID") int Student_ID , Model model){
        List<Domitory> logByStudentId = this.logService.findLogByStudentId(Student_ID);
        model.addAttribute("dsl",logByStudentId);
        System.out.println(logByStudentId);
        return "StudentLog";
    }
}
