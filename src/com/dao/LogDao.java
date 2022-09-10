package com.dao;

import com.po.Domitory;
import com.po.Log;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LogDao {
    //查询所有缺寝记录
    public List<Log> findAll();
    //添加缺寝记录
    public int addLog(Log log);
    //通过楼宇号查询学生的缺寝记录
    public List<Domitory> findLog(@Param("Domitory_BuildingID")int Domitory_BuildingID);
    //根据学号和寝室号查询缺寝记录
    public List<Domitory> findLogByDid(@Param("Student_DomitoryID") int Student_DomitoryID
            ,@Param("Student_Username") String Student_Username);
    //通过寝室号查询缺寝记录
    public List<Domitory> findLogByDid2(@Param("Student_DomitoryID") int Student_DomitoryID);
    //学生端查询缺寝记录
    public List<Domitory> findLogByStudentId(@Param("Student_ID")int Student_ID);
}
