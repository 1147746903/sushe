package com.service;
import com.po.Building;
import com.po.TB;

import java.util.List;

public interface TbService {
    //查询该楼宇的所有管理员
    public List<Building> findTBByBuildingId(int TB_BuildingID);
    //添加楼宇的管理员
    public int addTeacherInBuildingId(int TB_TeacherID,int TB_BuildingID);
    //通过楼宇号和楼宇管理员的ID查找.防止重复添加
    public TB findTeacherInBuildingId(int TB_TeacherID, int TB_BuildingID);
    //移除楼宇管理员
    public int deleteTeacherInBuildingId(int TB_TeacherID,int TB_BuildingID);
}
