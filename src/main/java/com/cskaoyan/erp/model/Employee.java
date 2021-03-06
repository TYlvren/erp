package com.cskaoyan.erp.model;

import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class Employee {
    private String empId;

    private String empName;

    private String sex;

    private String idCode;

    private Date birthday;

    private Date joinDate;

    private String status;

    private String education;

    private String degree;

    private String major;

    private String graduateSchool;

    private String educationForm;

    private String departmentId;

    private Department department;

    @Override
    public String toString() {
        return "Employee{" +
         "empId='" + empId + '\'' +
         ", empName='" + empName + '\'' +
         ", sex='" + sex + '\'' +
         ", idCode='" + idCode + '\'' +
         ", birthday=" + birthday +
         ", joinDate=" + joinDate +
         ", status='" + status + '\'' +
         ", education='" + education + '\'' +
         ", degree='" + degree + '\'' +
         ", major='" + major + '\'' +
         ", graduateSchool='" + graduateSchool + '\'' +
         ", educationForm='" + educationForm + '\'' +
         ", departmentId='" + departmentId + '\'' +
         ", department=" + department +
         '}';
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getIdCode() {
        return idCode;
    }

    public void setIdCode(String idCode) {
        this.idCode = idCode;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Date getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(Date joinDate) {
        this.joinDate = joinDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getGraduateSchool() {
        return graduateSchool;
    }

    public void setGraduateSchool(String graduateSchool) {
        this.graduateSchool = graduateSchool;
    }

    public String getEducationForm() {
        return educationForm;
    }

    public void setEducationForm(String educationForm) {
        this.educationForm = educationForm;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}