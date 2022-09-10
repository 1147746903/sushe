package com.service.impl;

import com.dao.LogDao;
import com.po.Domitory;
import com.po.Log;
import com.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("logService")
public class LogServiceImpl implements LogService {
    @Autowired
    private LogDao logDao;
    //查询所有学生缺寝记录
    @Override
    public List<Log> findAll() {
        List<Log> all = this.logDao.findAll();
        return all;
    }
    //添加缺寝记录
    @Override
    public int addLog(Log log) {
        int i = this.logDao.addLog(log);
        return i;
    }
    //通过楼宇号查询学生的缺寝记录
    @Override
    public List<Domitory> findLog(int Domitory_BuildingID) {
        List<Domitory> log = this.logDao.findLog(Domitory_BuildingID);
        return log;
    }
    //根据学号和寝室号查询缺寝记录
    @Override
    public List<Domitory> findLogByDid(int Student_DomitoryID, String Student_Username) {
        List<Domitory> logByDid = this.logDao.findLogByDid(Student_DomitoryID, Student_Username);
        return logByDid;
    }
    //通过寝室号查询缺寝记录
    @Override
    public List<Domitory> findLogByDid2(int Student_DomitoryID) {
        List<Domitory> logByDid2 = this.logDao.findLogByDid2(Student_DomitoryID);
        return logByDid2;
    }
    //学生端查询缺寝记录
    @Override
    public List<Domitory> findLogByStudentId(int Student_ID) {
        List<Domitory> logByStudentId = this.logDao.findLogByStudentId(Student_ID);
        return logByStudentId;
    }
}
