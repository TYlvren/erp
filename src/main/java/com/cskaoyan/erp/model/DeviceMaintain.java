package com.cskaoyan.erp.model;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Date;
@Component
public class DeviceMaintain {
    private String deviceMaintainId;

    private String deviceFaultId;

    private String deviceMaintainEmpId;

    private Date deviceMaintainDate;

    private String deviceMaintainResult;

    private BigDecimal deviceMaintainCost;

    private String note;

    private String deviceMaintainEmp;

    public String getDeviceMaintainEmp() {
        return deviceMaintainEmp;
    }

    public void setDeviceMaintainEmp(String deviceMaintainEmp) {
        this.deviceMaintainEmp = deviceMaintainEmp;
    }

    public String getDeviceMaintainId() {
        return deviceMaintainId;
    }

    public void setDeviceMaintainId(String deviceMaintainId) {
        this.deviceMaintainId = deviceMaintainId == null ? null : deviceMaintainId.trim();
    }

    public String getDeviceFaultId() {
        return deviceFaultId;
    }

    public void setDeviceFaultId(String deviceFaultId) {
        this.deviceFaultId = deviceFaultId == null ? null : deviceFaultId.trim();
    }

    public String getDeviceMaintainEmpId() {
        return deviceMaintainEmpId;
    }

    public void setDeviceMaintainEmpId(String deviceMaintainEmpId) {
        this.deviceMaintainEmpId = deviceMaintainEmpId == null ? null : deviceMaintainEmpId.trim();
    }

    public Date getDeviceMaintainDate() {
        return deviceMaintainDate;
    }

    public void setDeviceMaintainDate(Date deviceMaintainDate) {
        this.deviceMaintainDate = deviceMaintainDate;
    }

    public String getDeviceMaintainResult() {
        return deviceMaintainResult;
    }

    public void setDeviceMaintainResult(String deviceMaintainResult) {
        this.deviceMaintainResult = deviceMaintainResult == null ? null : deviceMaintainResult.trim();
    }

    public BigDecimal getDeviceMaintainCost() {
        return deviceMaintainCost;
    }

    public void setDeviceMaintainCost(BigDecimal deviceMaintainCost) {
        this.deviceMaintainCost = deviceMaintainCost;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }

    public DeviceMaintain() {
    }

    public DeviceMaintain(String deviceMaintainId, String deviceFaultId, String deviceMaintainEmpId, Date deviceMaintainDate, String deviceMaintainResult, BigDecimal deviceMaintainCost, String note) {
        this.deviceMaintainId = deviceMaintainId;
        this.deviceFaultId = deviceFaultId;
        this.deviceMaintainEmpId = deviceMaintainEmpId;
        this.deviceMaintainDate = deviceMaintainDate;
        this.deviceMaintainResult = deviceMaintainResult;
        this.deviceMaintainCost = deviceMaintainCost;
        this.note = note;
    }

    @Override
    public String toString() {
        return "DeviceMaintain{" +
                "deviceMaintainId='" + deviceMaintainId + '\'' +
                ", deviceFaultId='" + deviceFaultId + '\'' +
                ", deviceMaintainEmpId='" + deviceMaintainEmpId + '\'' +
                ", deviceMaintainDate=" + deviceMaintainDate +
                ", deviceMaintainResult='" + deviceMaintainResult + '\'' +
                ", deviceMaintainCost=" + deviceMaintainCost +
                ", note='" + note + '\'' +
                ", deviceMaintainEmp='" + deviceMaintainEmp + '\'' +
                '}';
    }
}