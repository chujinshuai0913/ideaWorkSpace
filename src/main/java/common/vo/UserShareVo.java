package common.vo;

import common.model.UserShare;

import java.io.Serializable;

/**
 * Title: <br>
 * Description: <br>
 * Copyright: Copyright (c) 2017<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author :chujinshuai
 * @time :2018/4/14 11:10 星期六
 */
public class UserShareVo extends UserShare implements Serializable {

    private String rTime;

    private String lTime;

    private String bTime;

    private String bltime;

    private String stime;

    private  String statusName;
    private String dTime;

    private String cName;

    private String cTime;

    private String pUser;

    private String pTime;

    private String eUser;

    private String eTime;
    private Integer num;

    private Integer garde;

    private  String professionalName1;

    private  String professionalName2;

    public String getProfessionalName1() {
        return professionalName1;
    }

    public void setProfessionalName1(String professionalName1) {
        this.professionalName1 = professionalName1;
    }

    public String getProfessionalName2() {
        return professionalName2;
    }

    public void setProfessionalName2(String professionalName2) {
        this.professionalName2 = professionalName2;
    }

    public String getrTime() {
        return rTime;
    }

    public void setrTime(String rTime) {
        this.rTime = rTime;
    }

    public String getlTime() {
        return lTime;
    }

    public void setlTime(String lTime) {
        this.lTime = lTime;
    }

    public String getbTime() {
        return bTime;
    }

    public void setbTime(String bTime) {
        this.bTime = bTime;
    }

    public String getBltime() {
        return bltime;
    }

    public void setBltime(String bltime) {
        this.bltime = bltime;
    }

    public String getdTime() {
        return dTime;
    }

    public void setdTime(String dTime) {
        this.dTime = dTime;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public String getcTime() {
        return cTime;
    }

    public void setcTime(String cTime) {
        this.cTime = cTime;
    }

    public String getpUser() {
        return pUser;
    }

    public void setpUser(String pUser) {
        this.pUser = pUser;
    }

    public String getpTime() {
        return pTime;
    }

    public void setpTime(String pTime) {
        this.pTime = pTime;
    }

    public String geteUser() {
        return eUser;
    }

    public void seteUser(String eUser) {
        this.eUser = eUser;
    }

    public String geteTime() {
        return eTime;
    }

    public String getStime() {
        return stime;
    }

    public void setStime(String stime) {
        this.stime = stime;
    }

    public void seteTime(String eTime) {
        this.eTime = eTime;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Integer getGarde() {
        return garde;
    }

    public void setGarde(Integer garde) {
        this.garde = garde;
    }
}
