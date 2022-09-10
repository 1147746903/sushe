package com.service;

import com.po.Domitory;
import com.po.Log;

import java.util.List;

public interface LogService {
    //查询所有缺寝记录
    public List<Log> findAll();
    //添加缺寝记录
    public int addLog(Log log);
    //通过楼宇号查询学生的缺寝记录
    public List<Domitory> findLog(int Domitory_BuildingID);
    //根据学号和寝室号查询缺寝记录
    public List<Domitory> findLogByDid(int Student_DomitoryID , String Student_Username);
    //通过寝室号查询缺寝记录
    public List<Domitory> findLogByDid2(int Student_DomitoryID);
    //学生端查询缺寝记录
    public List<Domitory> findLogByStudentId(int Student_ID);
}
