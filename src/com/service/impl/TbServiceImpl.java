package com.service.impl;

import com.dao.TbDao;
import com.po.Building;
import com.po.TB;
import com.po.Teacher;
import com.service.TbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("tbService")
public class TbServiceImpl implements TbService {
    @Autowired
    private TbDao tbDao;
    @Override
    public List<Building> findTBByBuildingId(int TB_BuildingID) {
        List<Building> tbByBuildingId = tbDao.findTBByBuildingId(TB_BuildingID);
        return tbByBuildingId;
    }

    @Override
    public int addTeacherInBuildingId(int TB_TeacherID, int TB_BuildingID) {
        int i = this.tbDao.addTeacherInBuildingId(TB_TeacherID, TB_BuildingID);
        return i;
    }
    //通过楼宇号和楼宇管理员的ID查找.防止重复添加
    @Override
    public TB findTeacherInBuildingId(int TB_TeacherID, int TB_BuildingID) {
        TB teacherInBuildingId = this.tbDao.findTeacherInBuildingId(TB_TeacherID, TB_BuildingID);
        return teacherInBuildingId;
    }
    //移除楼宇管理员
    @Override
    public int deleteTeacherInBuildingId(int TB_TeacherID, int TB_BuildingID) {
        int i = this.tbDao.deleteTeacherInBuildingId(TB_TeacherID, TB_BuildingID);
        return i;
    }
}
