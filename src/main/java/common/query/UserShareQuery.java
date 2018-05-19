/**
 * Copyright (C), 2018-2018
 * FileName: UserShareQuery
 * Author:   jinshuai
 * Date:     2018/4/12 22:44
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package common.query;

import common.model.UserShare;

import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author jinshuai
 * @create 2018/4/12
 * @since 1.0.0
 */
public class UserShareQuery extends QueryParam {

     private String startSignDate;
     private String endSignDate;
     private int sSignDate;
     private int eSignDate;

    private Integer id;

    private String userName;

    private String realName;

    private Integer password;

    private Long phoneNumber;

    private Integer schoolCode;

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

    private List<Integer> ids;


    public String getStartSignDate() {
        return startSignDate;
    }

    public void setStartSignDate(String startSignDate) {
        this.startSignDate = startSignDate;
    }

    public String getEndSignDate() {
        return endSignDate;
    }

    public void setEndSignDate(String endSignDate) {
        this.endSignDate = endSignDate;
    }

    public int getsSignDate() {
        return sSignDate;
    }

    public void setsSignDate(int sSignDate) {
        this.sSignDate = sSignDate;
    }

    public int geteSignDate() {
        return eSignDate;
    }

    public void seteSignDate(int eSignDate) {
        this.eSignDate = eSignDate;
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
        this.userName = userName;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
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

    public Integer getSchoolCode() {
        return schoolCode;
    }

    public void setSchoolCode(Integer schoolCode) {
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

    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }
}
