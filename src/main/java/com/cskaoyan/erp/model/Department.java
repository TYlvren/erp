package com.cskaoyan.erp.model;

public class Department {
    private String departmentId;

    private String departmentName;

    private String note;

    @Override
    public String toString() {
        return "Department{" +
         "departmentId='" + departmentId + '\'' +
         ", departmentName='" + departmentName + '\'' +
         ", note='" + note + '\'' +
         '}';
    }

    public String getDepartmentId() {
        return departmentId;
    }


    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId == null ? null : departmentId.trim();
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName == null ? null : departmentName.trim();
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }
}