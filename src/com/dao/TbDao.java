package com.dao;
import com.po.Building;
import com.po.TB;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TbDao {
    //查询该楼宇的所有管理员
    public List<Building> findTBByBuildingId(@Param("TB_BuildingID") int TB_BuildingID);
    //添加楼宇的管理员
    public int addTeacherInBuildingId(@Param("TB_TeacherID") int TB_TeacherID,@Param("TB_BuildingID") int TB_BuildingID);
    //通过楼宇号和楼宇管理员的ID查找.防止重复添加
    public TB findTeacherInBuildingId(@Param("TB_TeacherID") int TB_TeacherID, @Param("TB_BuildingID") int TB_BuildingID);
    //移除楼宇管理员
    public int deleteTeacherInBuildingId(@Param("TB_TeacherID") int TB_TeacherID,@Param("TB_BuildingID") int TB_BuildingID);
}
