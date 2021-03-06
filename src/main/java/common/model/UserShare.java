package common.model;

import java.io.Serializable;

public class UserShare implements Serializable {
    private Integer id;

    private String userName;

    private String realName;

    private Integer password;

    private Long phoneNumber;

    private Long schoolCode;

    private Integer status;

    private Integer integral;

    private Integer registeredTime;

    private Integer loginTime;

    private Integer banTime;

    private Integer banLongtime;

    private Integer deleteTime;

    private Integer cU;

    private Integer cT;

    private Integer printUser;

    private Integer printTime;

    private Integer exportUser;

    private Integer exportTime;

    public UserShare(Integer id, String userName, String realName, Integer password, Long phoneNumber, Long schoolCode, Integer status, Integer integral, Integer registeredTime, Integer loginTime, Integer banTime, Integer banLongtime, Integer deleteTime, Integer cU, Integer cT, Integer printUser, Integer printTime, Integer exportUser, Integer exportTime) {
        this.id = id;
        this.userName = userName;
        this.realName = realName;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.schoolCode = schoolCode;
        this.status = status;
        this.integral = integral;
        this.registeredTime = registeredTime;
        this.loginTime = loginTime;
        this.banTime = banTime;
        this.banLongtime = banLongtime;
        this.deleteTime = deleteTime;
        this.cU = cU;
        this.cT = cT;
        this.printUser = printUser;
        this.printTime = printTime;
        this.exportUser = exportUser;
        this.exportTime = exportTime;
    }

    public UserShare() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName == null ? null : realName.trim();
    }

    public Integer getPassword() {
        return password;
    }

    public void setPassword(Integer password) {
        this.password = password;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Long getSchoolCode() {
        return schoolCode;
    }

    public void setSchoolCode(Long schoolCode) {
        this.schoolCode = schoolCode;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getIntegral() {
        return integral;
    }

    public void setIntegral(Integer integral) {
        this.integral = integral;
    }

    public Integer getRegisteredTime() {
        return registeredTime;
    }

    public void setRegisteredTime(Integer registeredTime) {
        this.registeredTime = registeredTime;
    }

    public Integer getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Integer loginTime) {
        this.loginTime = loginTime;
    }

    public Integer getBanTime() {
        return banTime;
    }

    public void setBanTime(Integer banTime) {
        this.banTime = banTime;
    }

    public Integer getBanLongtime() {
        return banLongtime;
    }

    public void setBanLongtime(Integer banLongtime) {
        this.banLongtime = banLongtime;
    }

    public Integer getDeleteTime() {
        return deleteTime;
    }

    public void setDeleteTime(Integer deleteTime) {
        this.deleteTime = deleteTime;
    }

    public Integer getcU() {
        return cU;
    }

    public void setcU(Integer cU) {
        this.cU = cU;
    }

    public Integer getcT() {
        return cT;
    }

    public void setcT(Integer cT) {
        this.cT = cT;
    }

    public Integer getPrintUser() {
        return printUser;
    }

    public void setPrintUser(Integer printUser) {
        this.printUser = printUser;
    }

    public Integer getPrintTime() {
        return printTime;
    }

    public void setPrintTime(Integer printTime) {
        this.printTime = printTime;
    }

    public Integer getExportUser() {
        return exportUser;
    }

    public void setExportUser(Integer exportUser) {
        this.exportUser = exportUser;
    }

    public Integer getExportTime() {
        return exportTime;
    }

    public void setExportTime(Integer exportTime) {
        this.exportTime = exportTime;
    }

}