package com.po;

import java.util.List;

public class Domitory {

    private int Domitory_ID;
    private int Domitory_BuildingID;
    private String Domitory_Name;
    private int Domitory_Number;
    private int Domitory_NullNumber;
    private String Domitory_Remarks;
    private List<Student> studentList;
    private int Building_ID;
    private List<Log> logList;

    public List<Log> getLogList() {
        return logList;
    }

    public void setLogList(List<Log> logList) {
        this.logList = logList;
    }

    public int getBuilding_ID() {
        return Building_ID;
    }

    public void setBuilding_ID(int building_ID) {
        Building_ID = building_ID;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    public int getDomitory_ID() {
        return Domitory_ID;
    }

    public void setDomitory_ID(int domitory_ID) {
        Domitory_ID = domitory_ID;
    }

    public int getDomitory_BuildingID() {
        return Domitory_BuildingID;
    }

    public void setDomitory_BuildingID(int domitory_BuildingID) {
        Domitory_BuildingID = domitory_BuildingID;
    }

    public String getDomitory_Name() {
        return Domitory_Name;
    }

    public void setDomitory_Name(String domitory_Name) {
        Domitory_Name = domitory_Name;
    }

    public int getDomitory_NullNumber() {
        return Domitory_NullNumber;
    }

    public int getDomitory_Number() {
        return Domitory_Number;
    }

    public void setDomitory_Number(int domitory_Number) {
        Domitory_Number = domitory_Number;
    }

    public int getDomitory_NullNumber(String searchKey) {
        return Domitory_NullNumber;
    }

    public void setDomitory_NullNumber(int domitory_NullNumber) {
        Domitory_NullNumber = domitory_NullNumber;
    }

    public String getDomitory_Remarks() {
        return Domitory_Remarks;
    }

    public void setDomitory_Remarks(String domitory_Remarks) {
        Domitory_Remarks = domitory_Remarks;
    }

    @Override
    public String toString() {
        return "Domitory{" +
                "Domitory_ID=" + Domitory_ID +
                ", Domitory_BuildingID=" + Domitory_BuildingID +
                ", Domitory_Name='" + Domitory_Name + '\'' +
                ", Domitory_Number=" + Domitory_Number +
                ", Domitory_NullNumber=" + Domitory_NullNumber +
                ", Domitory_Remarks='" + Domitory_Remarks + '\'' +
                '}';
    }
}
