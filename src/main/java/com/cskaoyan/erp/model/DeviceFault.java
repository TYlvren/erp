package com.cskaoyan.erp.model;

import org.springframework.stereotype.Component;

import java.util.Date;
@Component
public class DeviceFault {
    private String deviceFaultId;

    private String deviceId;

    private String deviceFaultCause;

    private String deviceFaultDetail;

    private Date deviceFaultDate;

    private String deviceFaultMaintenance;

    private String deviceName;

    public String getDeviceFaultId() {
        return deviceFaultId;
    }

    public void setDeviceFaultId(String deviceFaultId) {
        this.deviceFaultId = deviceFaultId == null ? null : deviceFaultId.trim();
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId == null ? null : deviceId.trim();
    }

    public String getDeviceFaultCause() {
        return deviceFaultCause;
    }

    public void setDeviceFaultCause(String deviceFaultCause) {
        this.deviceFaultCause = deviceFaultCause == null ? null : deviceFaultCause.trim();
    }

    public String getDeviceFaultDetail() {
        return deviceFaultDetail;
    }

    public void setDeviceFaultDetail(String deviceFaultDetail) {
        this.deviceFaultDetail = deviceFaultDetail == null ? null : deviceFaultDetail.trim();
    }

    public Date getDeviceFaultDate() {
        return deviceFaultDate;
    }

    public void setDeviceFaultDate(Date deviceFaultDate) {
        this.deviceFaultDate = deviceFaultDate;
    }

    public String getDeviceFaultMaintenance() {
        return deviceFaultMaintenance;
    }

    public void setDeviceFaultMaintenance(String deviceFaultMaintenance) {
        this.deviceFaultMaintenance = deviceFaultMaintenance == null ? null : deviceFaultMaintenance.trim();
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public DeviceFault() {
    }

    public DeviceFault(String deviceFaultId, String deviceId, String deviceFaultCause, String deviceFaultDetail, Date deviceFaultDate, String deviceFaultMaintenance) {
        this.deviceFaultId = deviceFaultId;
        this.deviceId = deviceId;
        this.deviceFaultCause = deviceFaultCause;
        this.deviceFaultDetail = deviceFaultDetail;
        this.deviceFaultDate = deviceFaultDate;
        this.deviceFaultMaintenance = deviceFaultMaintenance;
    }

    @Override
    public String toString() {
        return "DeviceFault{" +
                "deviceFaultId='" + deviceFaultId + '\'' +
                ", deviceId='" + deviceId + '\'' +
                ", deviceFaultCause='" + deviceFaultCause + '\'' +
                ", deviceFaultDetail='" + deviceFaultDetail + '\'' +
                ", deviceFaultDate=" + deviceFaultDate +
                ", deviceFaultMaintenance='" + deviceFaultMaintenance + '\'' +
                ", deviceName='" + deviceName + '\'' +
                '}';
    }
}