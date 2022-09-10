package com.service.impl;

import com.dao.BuildingDao;
import com.po.Building;
import com.service.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("buildingService")
public class BuildingServiceImpl implements BuildingService {
    @Autowired
    private BuildingDao buildingDao;
    @Override
    public List<Building> findAll() {
        List<Building> all = this.buildingDao.findAll();
        return all;
    }

    @Override
    public int addBuilding(Building building) {
        int i = this.buildingDao.addBuilding(building);
        return i;
    }

    @Override
    public Building findBuildingByName(String Building_Name) {
        Building buildingByName = this.buildingDao.findBuildingByName(Building_Name);
        return buildingByName;
    }

    @Override
    public Building findBuildingById(int Building_ID) {
        Building buildingById = this.buildingDao.findBuildingById(Building_ID);
        return buildingById;
    }

    @Override
    public int BuildingUpdateSave(Building building) {
        int i = this.buildingDao.BuildingUpdateSave(building);
        return i;
    }

    @Override
    public List<Building> findBuildingByName1(String Building_Name) {
        List<Building> buildingByName1 = this.buildingDao.findBuildingByName1(Building_Name);
        return buildingByName1;
    }

    @Override
    public int deleteBuildingById(int Building_ID) {
        int i = this.buildingDao.deleteBuildingById(Building_ID);
        return i;
    }

    @Override
    public List<Building> findAllBuildingAndDomitory() {
        List<Building> allBuildingAndDomitory = this.buildingDao.findAllBuildingAndDomitory();
        return allBuildingAndDomitory;
    }
}
