package common.query;

/**
 * Title: <br>
 * Description: <br>
 * Copyright: Copyright (c) 2017<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author :chujinshuai
 * @time :2018/4/14 11:51 星期六
 */
public class UserManagerQuery extends QueryParam {
    private Integer id;

    private String username;

    private Integer password;

    private Integer newpassword;

    private Integer signTime;

    private Integer loginTime;

    private Integer loginNum;

    private Integer roleId;

    private Long workId;

    private Integer deleteTime;

    private Long phoneNumber;

    private String startSignDate;
    private String endSignDate;

    private int sSignDate;
    private int eSignDate;

    public Integer getNewpassword() {
        return newpassword;
    }

    public void setNewpassword(Integer newpassword) {
        this.newpassword = newpassword;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getPassword() {
        return password;
    }

    public void setPassword(Integer password) {
        this.password = password;
    }

    public Integer getSignTime() {
        return signTime;
    }

    public void setSignTime(Integer signTime) {
        this.signTime = signTime;
    }

    public Integer getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Integer loginTime) {
        this.loginTime = loginTime;
    }

    public Integer getLoginNum() {
        return loginNum;
    }

    public void setLoginNum(Integer loginNum) {
        this.loginNum = loginNum;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Long getWorkId() {
        return workId;
    }

    public void setWorkId(Long workId) {
        this.workId = workId;
    }

    public Integer getDeleteTime() {
        return deleteTime;
    }

    public void setDeleteTime(Integer deleteTime) {
        this.deleteTime = deleteTime;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

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
}
