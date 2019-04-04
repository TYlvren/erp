package com.cskaoyan.erp.model;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Date;
@Component
public class Device {
    private String deviceId;

    private String deviceName;

    private String deviceTypeId;

    private String deviceStatusId;

    private String deviceStatus;

    private String devicePurchaseDate;

    private int devicePurchasePrice;

    private String deviceManufactureDate;

    private String deviceServiceLife;

    private String deviceKeeperId;

    private String note;

    private DeviceType deviceType;

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getDeviceTypeId() {
        return deviceTypeId;
    }

    public void setDeviceTypeId(String deviceTypeId) {
        this.deviceTypeId = deviceTypeId;
    }

    public String getDeviceStatusId() {
        return deviceStatusId;
    }

    public void setDeviceStatusId(String deviceStatusId) {
        this.deviceStatusId = deviceStatusId;
    }

    public String getDeviceStatus() {
        return deviceStatus;
    }

    public void setDeviceStatus(String deviceStatus) {
        this.deviceStatus = deviceStatus;
    }

    public String getDevicePurchaseDate() {
        return devicePurchaseDate;
    }

    public void setDevicePurchaseDate(String devicePurchaseDate) {
        this.devicePurchaseDate = devicePurchaseDate;
    }

    public int getDevicePurchasePrice() {
        return devicePurchasePrice;
    }

    public void setDevicePurchasePrice(int devicePurchasePrice) {
        this.devicePurchasePrice = devicePurchasePrice;
    }

    public String getDeviceManufactureDate() {
        return deviceManufactureDate;
    }

    public void setDeviceManufactureDate(String deviceManufactureDate) {
        this.deviceManufactureDate = deviceManufactureDate;
    }

    public String getDeviceServiceLife() {
        return deviceServiceLife;
    }

    public void setDeviceServiceLife(String deviceServiceLife) {
        this.deviceServiceLife = deviceServiceLife;
    }

    public String getDeviceKeeperId() {
        return deviceKeeperId;
    }

    public void setDeviceKeeperId(String deviceKeeperId) {
        this.deviceKeeperId = deviceKeeperId;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public DeviceType getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(DeviceType deviceType) {
        this.deviceType = deviceType;
    }

    public Device(String deviceId, String deviceName, String deviceTypeId, String deviceStatusId, String deviceStatus, String devicePurchaseDate, int devicePurchasePrice, String deviceManufactureDate, String deviceServiceLife, String deviceKeeperId, String note, DeviceType deviceType) {
        this.deviceId = deviceId;
        this.deviceName = deviceName;
        this.deviceTypeId = deviceTypeId;
        this.deviceStatusId = deviceStatusId;
        this.deviceStatus = deviceStatus;
        this.devicePurchaseDate = devicePurchaseDate;
        this.devicePurchasePrice = devicePurchasePrice;
        this.deviceManufactureDate = deviceManufactureDate;
        this.deviceServiceLife = deviceServiceLife;
        this.deviceKeeperId = deviceKeeperId;
        this.note = note;
        this.deviceType = deviceType;
    }

    public Device() {
    }


    @Override
    public String toString() {
        return "Device{" +
                "deviceId='" + deviceId + '\'' +
                ", deviceName='" + deviceName + '\'' +
                ", deviceTypeId='" + deviceTypeId + '\'' +
                ", deviceStatusId='" + deviceStatusId + '\'' +
                ", deviceStatus='" + deviceStatus + '\'' +
                ", devicePurchaseDate=" + devicePurchaseDate +
                ", devicePurchasePrice=" + devicePurchasePrice +
                ", deviceManufactureDate=" + deviceManufactureDate +
                ", deviceServiceLife=" + deviceServiceLife +
                ", deviceKeeperId='" + deviceKeeperId + '\'' +
                ", note='" + note + '\'' +
                ", deviceType=" + deviceType +
                '}';
    }
}