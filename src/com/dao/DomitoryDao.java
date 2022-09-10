package com.dao;
import com.po.DB;
import com.po.Domitory;
import com.po.SD;
import com.po.Student;
import org.apache.ibatis.annotations.Param;
import java.util.List;

public interface DomitoryDao {
    //查询所有的寝室
    public List<DB> findAll();
    //添加寝室
    public int addDomitory(Domitory domitory);
    //通过楼宇和寝室号查询
    public List<DB> findDomitoryByBuildingIdOrName(@Param("Domitory_BuildingID") int Domitory_BuildingID,
                                                         @Param("Domitory_Name") String Domitory_Name);
    //通过寝室号查询
    public List<DB> findDomitoryName(@Param("Domitory_Name") String Domitory_Name);
    //通过楼宇号查询
    public List<DB> findDomitoryBuildingId(@Param("Domitory_BuildingID") int Domitory_BuildingID);
    //通过宿舍id查询
    public Domitory findDomitoryById(@Param("Domitory_ID") int Domitory_ID);
    //通过id修改宿舍
    public int DomitoryUpdateSave(Domitory domitory);
    //通过宿舍id删除
    public int deleteDomitoryById(@Param("Domitory_ID") int Domitory_ID);
    //通过楼宇查询寝室的学生
    public List<Domitory> findDomitoryAndStudent(@Param("Domitory_BuildingID") int Domitory_BuildingID);
    //通过学号和寝室号查询
    public List<Domitory> findDomitoryAndStudentByDomitoryId(@Param("Student_DomitoryID") int Student_DomitoryID
                                                             ,@Param("Student_Username") String Student_Username);
    //通过寝室号查询
    public List<Domitory> findDomitoryAndStudentByDomitoryId2(@Param("Student_DomitoryID") int Student_DomitoryID);
    //查询学生和该学生的寝室信息
    public SD findStudentWithDomitoryById(@Param("Student_ID") int Student_ID);

}
