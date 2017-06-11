package com.kotlintopic.moudle;

import com.google.gson.annotations.SerializedName;

/**
 * 功能
 */

public class AirQuality {


    /**
     * SiteName : 二林
     * County : 彰化縣
     * PSI : 36
     * MajorPollutant :
     * Status : 良好
     * SO2 : 2
     * CO : 0.13
     * O3 : 11
     * PM10 : 28
     * PM2.5 : 2
     * NO2 : 6.5
     * WindSpeed : 1.6
     * WindDirec : 142
     * FPMI : 1
     * NOx : 7.16
     * NO : .71
     * PublishTime : 2017-06-10 22:00
     */

    private String SiteName;
    private String County;
    private String PSI;
    private String MajorPollutant;
    private String Status;
    private String SO2;
    private String CO;
    private String O3;
    private String PM10;
    private String NO2;
    private String WindSpeed;
    private String WindDirec;
    private String FPMI;
    private String NOx;
    private String NO;
    private String PublishTime;

    public String getSiteName() {
        return SiteName;
    }

    public void setSiteName(String SiteName) {
        this.SiteName = SiteName;
    }

    public String getCounty() {
        return County;
    }

    public void setCounty(String County) {
        this.County = County;
    }

    public String getPSI() {
        return PSI;
    }

    public void setPSI(String PSI) {
        this.PSI = PSI;
    }

    public String getMajorPollutant() {
        return MajorPollutant;
    }

    public void setMajorPollutant(String MajorPollutant) {
        this.MajorPollutant = MajorPollutant;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    public String getSO2() {
        return SO2;
    }

    public void setSO2(String SO2) {
        this.SO2 = SO2;
    }

    public String getCO() {
        return CO;
    }

    public void setCO(String CO) {
        this.CO = CO;
    }

    public String getO3() {
        return O3;
    }

    public void setO3(String O3) {
        this.O3 = O3;
    }

    public String getPM10() {
        return PM10;
    }

    public void setPM10(String PM10) {
        this.PM10 = PM10;
    }

    public String getNO2() {
        return NO2;
    }

    public void setNO2(String NO2) {
        this.NO2 = NO2;
    }

    public String getWindSpeed() {
        return WindSpeed;
    }

    public void setWindSpeed(String WindSpeed) {
        this.WindSpeed = WindSpeed;
    }

    public String getWindDirec() {
        return WindDirec;
    }

    public void setWindDirec(String WindDirec) {
        this.WindDirec = WindDirec;
    }

    public String getFPMI() {
        return FPMI;
    }

    public void setFPMI(String FPMI) {
        this.FPMI = FPMI;
    }

    public String getNOx() {
        return NOx;
    }

    public void setNOx(String NOx) {
        this.NOx = NOx;
    }

    public String getNO() {
        return NO;
    }

    public void setNO(String NO) {
        this.NO = NO;
    }

    public String getPublishTime() {
        return PublishTime;
    }

    public void setPublishTime(String PublishTime) {
        this.PublishTime = PublishTime;
    }
}
