package com.po;

import java.util.List;

public class Building {

    private int Building_ID;
    private String Building_Name;
    private String Building_Introduction;
    private List<Teacher> teacherList;
    private List<Domitory> domitoryList;

    public List<Domitory> getDomitoryList() {
        return domitoryList;
    }

    public void setDomitoryList(List<Domitory> domitoryList) {
        this.domitoryList = domitoryList;
    }

    public List<Teacher> getTeacherList() {
        return teacherList;
    }

    public void setTeacherList(List<Teacher> teacherList) {
        this.teacherList = teacherList;
    }

    public int getBuilding_ID() {
        return Building_ID;
    }

    public void setBuilding_ID(int buildingID) {
        Building_ID = buildingID;
    }

    public String getBuilding_Name() {
        return Building_Name;
    }

    public void setBuilding_Name(String buildingName) {
        Building_Name = buildingName;
    }

    public String getBuilding_Introduction() {
        return Building_Introduction;
    }

    public void setBuilding_Introduction(String buildingIntroduction) {
        Building_Introduction = buildingIntroduction;
    }

    @Override
    public String toString() {
        return "Building{" +
                "Building_ID=" + Building_ID +
                ", Building_Name='" + Building_Name + '\'' +
                ", Building_Introduction='" + Building_Introduction + '\'' +
                ", teacherList=" + teacherList +
                ", domitoryList=" + domitoryList +
                '}';
    }
}
