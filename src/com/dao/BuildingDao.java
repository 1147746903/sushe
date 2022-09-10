package com.dao;

import com.po.Building;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BuildingDao {
    //查询所有楼宇
    public List<Building> findAll();
    //添加楼宇信息
    public int addBuilding(Building building);
    //通过楼的名字查询所有楼
    public Building findBuildingByName(@Param("Building_Name") String Building_Name);
    //通过id查询所有楼宇管理员
    public Building findBuildingById(@Param("Building_ID") int Building_ID);
    //通过id修改所有楼宇管理员
    public int BuildingUpdateSave(Building building);
    //通过名字查询
    public List<Building>findBuildingByName1(@Param("Building_Name") String Building_Name);
    //通过id删除楼宇
    public int deleteBuildingById(@Param("Building_ID") int Building_ID);
    //查询所有楼中的所有寝室
    public List<Building> findAllBuildingAndDomitory();

}
