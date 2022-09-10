package com.po;

import java.util.List;

public class Teacher {

    private int Teacher_ID;
    private String Teacher_Username;
    private String Teacher_Password;
    private String Teacher_Name;
    private String Teacher_Sex;
    private String Teacher_Tel;
    private List<Building> buildingList;//关联宿舍楼的信息

    public List<Building> getBuildingList() {
        return buildingList;
    }

    public void setBuildingList(List<Building> buildingList) {
        this.buildingList = buildingList;
    }

    public int getTeacher_ID() {
        return Teacher_ID;
    }

    public void setTeacher_ID(int teacherID) {
        Teacher_ID = teacherID;
    }

    public String getTeacher_Username() {
        return Teacher_Username;
    }

    public void setTeacher_Username(String teacherUsername) {
        Teacher_Username = teacherUsername;
    }

    public String getTeacher_Password() {
        return Teacher_Password;
    }

    public void setTeacher_Password(String teacherPassword) {
        Teacher_Password = teacherPassword;
    }

    public String getTeacher_Name() {
        return Teacher_Name;
    }

    public void setTeacher_Name(String teacherName) {
        Teacher_Name = teacherName;
    }

    public String getTeacher_Sex() {
        return Teacher_Sex;
    }

    public void setTeacher_Sex(String teacherSex) {
        Teacher_Sex = teacherSex;
    }

    public String getTeacher_Tel() {
        return Teacher_Tel;
    }

    public void setTeacher_Tel(String teacherTel) {
        Teacher_Tel = teacherTel;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "Teacher_ID=" + Teacher_ID +
                ", Teacher_Username='" + Teacher_Username + '\'' +
                ", Teacher_Password='" + Teacher_Password + '\'' +
                ", Teacher_Name='" + Teacher_Name + '\'' +
                ", Teacher_Sex='" + Teacher_Sex + '\'' +
                ", Teacher_Tel='" + Teacher_Tel + '\'' +
                ", buildingList=" + buildingList +
                '}';
    }
}
