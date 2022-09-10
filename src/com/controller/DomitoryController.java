package com.controller;

import com.po.*;
import com.service.BuildingService;
import com.service.DomitoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class DomitoryController {
    //依赖注入
    @Autowired
    private DomitoryService domitoryService;
    @Autowired
    private BuildingService buildingService;
    //查询所有的宿舍
    @RequestMapping(value = "/DomitoryManager.action")
    public String findAll(Model model){
        List<DB> allDB = domitoryService.findAll();
        List<Building> allB = buildingService.findAll();
        model.addAttribute("domitory",allDB);
        model.addAttribute("building",allB);
        return "DomitoryManager";
    }
    //查询所有的楼到宿舍添加页面
    @RequestMapping("/DomitoryAdd.action")
    public String findBuildingAll(Model model){
        List<Building> allB = buildingService.findAll();
        model.addAttribute("building",allB);
        return "DomitoryAdd";
    }
    //添加宿舍
    @RequestMapping("/DomitoryAddSave.action")
    public String addDomitory(Domitory domitory,Model model){
        List<DB> domitoryByBuildingIdOrName = domitoryService.findDomitoryByBuildingIdOrName(domitory.getDomitory_BuildingID(),
                domitory.getDomitory_Name());
        if (domitoryByBuildingIdOrName.size() ==0) {
            int i = domitoryService.addDomitory(domitory);
            if (i > 0) {
                model.addAttribute("msg", "添加成功");
                findAll(model);
                return "DomitoryManager";
            }
            model.addAttribute("msg", "添加失败");
             findAll(model);
            return "DomitoryManager";
        }
        model.addAttribute("msg","已存在，不可重复添加");
           findAll(model);
        return "DomitoryManager";
    }
    //通过楼宇和寝室号或者空床查询
    @RequestMapping("/DomitoryManagerSelect.action")
    public String findDomitoryByBuildingIdOrName(@RequestParam("Domitory_BuildingID") int Domitory_BuildingID,
             @RequestParam("SearchKey") String SearchKey,  Model model){
        System.out.println(Domitory_BuildingID);
        System.out.println(SearchKey);
        if (Domitory_BuildingID==0 | SearchKey !="" ){
            List<DB> domitoryName = domitoryService.findDomitoryName(SearchKey);
            List<Building> allB = buildingService.findAll();
            model.addAttribute("domitory",domitoryName);
            model.addAttribute("building",allB);
            return "DomitoryManager";
        }
        if (SearchKey=="" | Domitory_BuildingID !=0){
            List<DB> domitoryBuildingId = domitoryService.findDomitoryBuildingId(Domitory_BuildingID);
            List<Building> allB = buildingService.findAll();
            model.addAttribute("domitory",domitoryBuildingId);
            model.addAttribute("building",allB);
            return "DomitoryManager";
        }
        if (SearchKey !="" |  Domitory_BuildingID !=0){
            List<DB> domitoryByBuildingIdOrName = domitoryService.findDomitoryByBuildingIdOrName(Domitory_BuildingID, SearchKey);
            List<Building> allB = buildingService.findAll();
            model.addAttribute("domitory",domitoryByBuildingIdOrName);
            model.addAttribute("building",allB);
            return "DomitoryManager";
        }else {
            findAll(model);
            return "DomitoryManager";
        }
    }
    //修改寝室
    @RequestMapping(value="/DomitoryUpdate.action",method= RequestMethod.GET)
    public String updateTeacher(@RequestParam("Domitory_ID") int Domitory_ID, Model model){
        Domitory domitoryById = domitoryService.findDomitoryById(Domitory_ID);
        List<Building> allB = buildingService.findAll();
        model.addAttribute("domitory",domitoryById);
        model.addAttribute("building",allB);
        return "DomitoryUpdate";
    }
    //保存修改寝室数据
    @RequestMapping("/DomitoryUpdateSave.action")
    public String TeacherUpdateSave(Domitory domitory ,Model model ) {
        List<DB> domitoryByBuildingIdOrName = domitoryService.findDomitoryByBuildingIdOrName(domitory.getDomitory_BuildingID(),
                domitory.getDomitory_Name());
        if (domitoryByBuildingIdOrName.size() ==0) {
        //判断用户名是否存在
            int i = domitoryService.DomitoryUpdateSave(domitory);
            if (i > 0){
                model.addAttribute("msg", "修改成功");
                findAll(model);
                return "DomitoryManager";
            }
            model.addAttribute("msg", "修改失败");
             findAll(model);
            return "DomitoryManager";
        }
        model.addAttribute("msg", "该宿舍已存在");
           findAll(model);
        return "DomitoryManager";
    }
    //通过id删除宿舍
    @RequestMapping(value="/DomitoryDel.action",method= RequestMethod.GET)
    public String deleteTeacherById(@RequestParam("Domitory_ID") int Domitory_ID,Model model){
        int i = domitoryService.deleteDomitoryById(Domitory_ID);
        if (i>0){
            model.addAttribute("msg", "删除成功");
            findAll(model);
            return "DomitoryManager";
        }
        model.addAttribute("msg", "删除失败");
        findAll(model);
        return "DomitoryManager";
    }
    //通过楼宇查询寝室的学生
    @RequestMapping(value="/MyStudentList.action",method= RequestMethod.GET)
    public String findDomitoryAndStudent(@RequestParam("Building_ID") int Building_ID,Model model){
        List<Domitory> domitoryAndStudent = domitoryService.findDomitoryAndStudent(Building_ID);
        model.addAttribute("dss",domitoryAndStudent);
        return "MyStudentList";
    }
    //通过学号和寝室号查询
    @RequestMapping(value = "/MyStudenthao.action")
    @Autowired(required = false)
    public String findDomitoryAndStudentByDomitoryId(@RequestParam("Student_DomitoryID") int Student_DomitoryID,
                                                     @RequestParam("Student_Username") String Student_Username ,Model model) {
        if (Student_DomitoryID !=0 & Student_Username != "") {
            List<Domitory> domitoryAndStudentByDomitoryId = domitoryService.findDomitoryAndStudentByDomitoryId(Student_DomitoryID, Student_Username);
            model.addAttribute("dss", domitoryAndStudentByDomitoryId);
            return "MyStudentList";
        } else {
            List<Domitory> domitoryAndStudentByDomitoryId2 = domitoryService.findDomitoryAndStudentByDomitoryId2(Student_DomitoryID);
            model.addAttribute("msg", "请输入学号,选择寝室");
            model.addAttribute("dss",domitoryAndStudentByDomitoryId2);
            return "MyStudentList";
        }
    }

    //查询学生和该学生的寝室信息返回给缺寝界面
    @RequestMapping("/LogAdd.action")
    public String findStudentWithDomitoryById(@RequestParam("Student_ID") int Student_ID,Model model){
        SD studentWithDomitoryById = domitoryService.findStudentWithDomitoryById(Student_ID);
        model.addAttribute("SD",studentWithDomitoryById);
        return "LogAdd";
    }
}
