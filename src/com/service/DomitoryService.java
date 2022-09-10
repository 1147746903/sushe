package com.service;
import com.po.DB;
import com.po.Domitory;
import com.po.SD;
import com.po.Student;

import java.util.List;

public interface DomitoryService {
    //查询所有的寝室
    public List<DB> findAll();
    //添加寝室
    public int addDomitory(Domitory domitory);
    //通过楼宇和寝室号查询
    public List<DB> findDomitoryByBuildingIdOrName(int Domitory_BuildingID,String Domitory_Name);
    //通过寝室号查询
    public List<DB> findDomitoryName(String Domitory_Name);
    //通过楼宇号查询
    public List<DB> findDomitoryBuildingId(int Domitory_BuildingID);
    //通过宿舍id查询
    public Domitory findDomitoryById(int Domitory_ID);
    //通过id修改宿舍
    public int DomitoryUpdateSave(Domitory domitory);
    //通过宿舍id删除
    public int deleteDomitoryById(int Domitory_ID);
    //通过楼宇查询寝室的学生
    public List<Domitory> findDomitoryAndStudent(int Domitory_BuildingID);
    //通过学号和寝室号查询
    public List<Domitory> findDomitoryAndStudentByDomitoryId(int Student_DomitoryID,String Student_Username);
    //通过寝室号查询
    public List<Domitory> findDomitoryAndStudentByDomitoryId2(int Student_DomitoryID);
    //查询学生和该学生的寝室信息
    public SD findStudentWithDomitoryById(int Student_ID);

}
