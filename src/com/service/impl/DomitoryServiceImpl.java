package com.service.impl;

import com.dao.DomitoryDao;
import com.po.*;
import com.service.DomitoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("domitoryService")
public class DomitoryServiceImpl implements DomitoryService {
    @Autowired
    private DomitoryDao domitoryDao;
    //查询所有的寝室
    @Override
    public List<DB> findAll() {
        List<DB> all = this.domitoryDao.findAll();
        return all;
    }
    //添加寝室
    @Override
    public int addDomitory(Domitory domitory) {
        int i = this.domitoryDao.addDomitory(domitory);
        return i;
    }
    //通过楼宇和寝室号查询
    @Override
    public List<DB> findDomitoryByBuildingIdOrName(int Domitory_BuildingID,String Domitory_Name) {
        List<DB> domitoryByBuildingIdOrName
                = this.domitoryDao.findDomitoryByBuildingIdOrName(Domitory_BuildingID,Domitory_Name);
        return domitoryByBuildingIdOrName;
    }
    //通过寝室号查询
    @Override
    public List<DB> findDomitoryName(String Domitory_Name) {
        List<DB> domitoryName = this.domitoryDao.findDomitoryName(Domitory_Name);
        return domitoryName;
    }
    //通过楼宇号查询
    @Override
    public List<DB> findDomitoryBuildingId(int Domitory_BuildingID) {
        List<DB> domitoryBuildingId = this.domitoryDao.findDomitoryBuildingId(Domitory_BuildingID);
        return domitoryBuildingId;
    }
    //通过宿舍id查询
    @Override
    public Domitory findDomitoryById(int Domitory_ID) {
        Domitory domitoryById = this.domitoryDao.findDomitoryById(Domitory_ID);
        return domitoryById;
    }
    //通过id修改宿舍
    @Override
    public int DomitoryUpdateSave(Domitory domitory) {
        int i = this.domitoryDao.DomitoryUpdateSave(domitory);
        return i;
    }
    //通过id删除宿舍
    @Override
    public int deleteDomitoryById(int Domitory_ID) {
        int i = this.domitoryDao.deleteDomitoryById(Domitory_ID);
        return i;
    }
    //通过楼宇查询寝室的学生
    @Override
    public List<Domitory> findDomitoryAndStudent(int Domitory_BuildingID) {
        List<Domitory> domitoryAndStudent = this.domitoryDao.findDomitoryAndStudent(Domitory_BuildingID);
        return domitoryAndStudent;
    }
    //通过学号和寝室号查询
    @Override
    public List<Domitory> findDomitoryAndStudentByDomitoryId(int Student_DomitoryID,String Student_Username) {
        List<Domitory> domitoryAndStudentByDomitoryId = this.domitoryDao.findDomitoryAndStudentByDomitoryId(Student_DomitoryID,Student_Username);
        return domitoryAndStudentByDomitoryId;
    }

    @Override
    public List<Domitory> findDomitoryAndStudentByDomitoryId2(int Student_DomitoryID) {
        List<Domitory> domitoryAndStudentByDomitoryId2 = this.domitoryDao.findDomitoryAndStudentByDomitoryId2(Student_DomitoryID);
        return domitoryAndStudentByDomitoryId2;
    }

    @Override
    public SD findStudentWithDomitoryById(int Student_ID) {
        SD studentWithDomitoryById = this.domitoryDao.findStudentWithDomitoryById(Student_ID);
        return studentWithDomitoryById;
    }
}
