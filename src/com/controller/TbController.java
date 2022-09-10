package com.controller;

import com.po.Building;
import com.po.TB;
import com.po.Teacher;
import com.service.TbService;
import com.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class TbController {
    //依赖注入
    @Autowired
    private TbService tbService;
    @Autowired
    private TeacherService teacherService;

    //根据楼号查询改楼的管理员
    @RequestMapping(value = "/TBManager.action", method = RequestMethod.GET)
    public String findTBByBuildingId(@RequestParam("Building_ID") int Building_ID, Model model) {
        List<Building> tbByBuildingId = tbService.findTBByBuildingId(Building_ID);
        List<Teacher> all = teacherService.findAll();
        model.addAttribute("tAdnB", tbByBuildingId);
        model.addAttribute("teacher", all);
        model.addAttribute("Building_ID", Building_ID);
        return "TBManager";
    }

    //添加楼宇的管理员
    @RequestMapping("/TBAddSave.action")
    public String addTeacherInBuildingId(@RequestParam("TB_TeacherID") int TB_TeacherID, @RequestParam("TB_BuildingID")
            int TB_BuildingID, Model model) {
        TB teacherInBuildingId = tbService.findTeacherInBuildingId(TB_TeacherID, TB_BuildingID);
        //判断数据库中是否存在该数据。
        if (TB_TeacherID != 0) {
            if (teacherInBuildingId == null) {
                int i = tbService.addTeacherInBuildingId(TB_TeacherID, TB_BuildingID);
                if (i > 0) {
                    model.addAttribute("msg", "添加成功");
                    findTBByBuildingId(TB_BuildingID, model);
                    return "TBManager";
                }
                model.addAttribute("msg", "添加失败");
                return "TBManager";
            }
            findTBByBuildingId(TB_BuildingID,model);
            model.addAttribute("msg", "已存在，不可重复添加");
            return "TBManager";
        }
        findTBByBuildingId(TB_BuildingID,model);
        model.addAttribute("msg", "请选择管理员");
        return "TBManager";
    }

    //移除楼宇管理员
    @RequestMapping("/TBDel.action")
    public String deleteTeacherInBuildingId(@RequestParam("TB_TeacherID") int TB_TeacherID, @RequestParam("TB_BuildingID")
            int TB_BuildingID ,Model model){
        int i = tbService.deleteTeacherInBuildingId(TB_TeacherID, TB_BuildingID);
        if (i > 0) {
            model.addAttribute("msg", "移除成功");
            findTBByBuildingId(TB_BuildingID,model);
            return "TBManager";
        }
        model.addAttribute("msg", "移除失败");
        return "TBManager";
    }
}
