package com.service;

import com.po.Building;

import java.util.List;

public interface BuildingService {
    //查询所有楼宇
    public List<Building> findAll();
    //添加楼宇信息
    public int addBuilding(Building building);
    //通过楼的名字查询所有楼
    public Building findBuildingByName(String Building_Name);
    //通过id查询所有楼宇
    public Building findBuildingById(int Building_ID);
    //通过id修改所有楼宇
    public int BuildingUpdateSave(Building building);
    //通过名字查询
    public List<Building>findBuildingByName1(String Building_Name);
    //通过id删除楼宇
    public int deleteBuildingById(int Building_ID);
    //查询所有楼中的所有寝室
    public List<Building> findAllBuildingAndDomitory();
}
