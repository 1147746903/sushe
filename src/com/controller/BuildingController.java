package com.controller;

import com.po.Building;
import com.po.Domitory;
import com.service.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class BuildingController {
    //依赖注入
    @Autowired
    private BuildingService buildingService;
    //查询所有的楼宇
    @RequestMapping("/BuildingManager.action")
    public String findAll(Model model ){
        List<Building> all = buildingService.findAll();
        model.addAttribute("building",all);
        return "BuildingManager";
    }
    //添加楼宇
    @RequestMapping("/BuildingAddSave.action")
    public String addBuilding(Building building , Model model){
        Building buildingByName = buildingService.findBuildingByName(building.getBuilding_Name());
        if (buildingByName ==null){
            int i = buildingService.addBuilding(building);
            if (i>0) {
                model.addAttribute("msg", "添加成功");
                findAll(model);
                return "BuildingManager";
            }
            model.addAttribute("msg","添加失败");
            return "BuildingAdd";
        }
        model.addAttribute("msg","名字已存在");
        return "BuildingAdd";
    }
    //修改楼宇
    @RequestMapping(value="/BuildingUpdate.action",method= RequestMethod.GET)
    public String updateTeacher(@RequestParam("Building_ID") int Building_ID, Model model){
        Building buildingById = buildingService.findBuildingById(Building_ID);
        model.addAttribute("building",buildingById);
        return "BuildingUpdate";
    }
    //保存修改楼
    @RequestMapping("/BuildingUpdateSave.action")
    public String TeacherUpdateSave(Building building ,Model model ) {
        Building buildingByName = buildingService.findBuildingByName(building.getBuilding_Name());
        //判断用户名是否存在
        if (buildingByName == null) {
            int i = buildingService.BuildingUpdateSave(building);
            if (i > 0){
                model.addAttribute("msg", "修改成功");
                findAll(model);
                return "BuildingManager";
            }
            model.addAttribute("msg", "修改失败");
            return "BuildingUpdate";
        }
        model.addAttribute("msg", "用户名已存在");
        return "BuildingUpdate";
    }
    //名称查询楼
    @RequestMapping("/BuildingManagerSelect.action")
    public String findTeacherByNameOrTel(@RequestParam("SearchKey") String SearchKey ,Model model){
        System.out.println(SearchKey);
        if (SearchKey !="") {
            List<Building> buildingByName1 = buildingService.findBuildingByName1(SearchKey);
            model.addAttribute("building", buildingByName1);
                return "BuildingManager";
            }
        findAll(model);
        return "BuildingManager";
    }
    //通过id删除楼宇管理员
    @RequestMapping(value="/BuildingDel.action",method= RequestMethod.GET)
    public String deleteBuildingById(@RequestParam("Building_ID") int Building_ID, Model model){
        int i = buildingService.deleteBuildingById(Building_ID);
        if (i>0){
            model.addAttribute("msg", "删除成功");
            findAll(model);
            return "BuildingManager";
        }
        model.addAttribute("msg", "删除失败");
        findAll(model);
        return "BuildingManager";
    }
    //查询所有楼中的所有寝室
    @RequestMapping("/StudentRZ.action")
    public String findAllBuildingAndDomitory(Model model){
        List<Building> allBuildingAndDomitory = this.buildingService.findAllBuildingAndDomitory();
        model.addAttribute("BD",allBuildingAndDomitory);
        return "StudentRZ";
    }
    //用ajax获取所有楼宇所有寝室的信息
    @RequestMapping("/StudentRZZ.action")
    @ResponseBody
    public List<Building> findAllBuildingAndDomitory1(){
        List<Building> allBuildingAndDomitory = this.buildingService.findAllBuildingAndDomitory();
        System.out.println(allBuildingAndDomitory);
        return allBuildingAndDomitory;
    }
    //老师端的学生管理--查询所有的楼
    @RequestMapping("/MyStudent.action")
    public String findAllBuilding(Model model){
        List<Building> all = buildingService.findAll();
        model.addAttribute("building",all);
        System.out.println(all);
        return "MyStudent";
    }
    //老师端的学生管理--查询所有的楼
    @RequestMapping("/MyLog.action")
    public String findAllBuilding2(Model model){
        List<Building> all = buildingService.findAll();
        model.addAttribute("building",all);
        return "MyLog";
    }
}
