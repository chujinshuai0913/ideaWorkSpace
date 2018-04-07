package sharebook.model;

public class ShareUserName {
    private Integer id;

    private String userName;

    private String realName;

    private Long phoneNumber;

    private Integer schoolCode;

    private Integer status;

    private Integer integral;

    private Integer registeredTime;

    private Integer loginTime;

    private Integer banTime;

    private Integer deleteTime;

    private Integer cU;

    private Integer cT;

    private Integer banLongtime;

    public ShareUserName(Integer id, String userName, String realName, Long phoneNumber, Integer schoolCode, Integer status, Integer integral, Integer registeredTime, Integer loginTime, Integer banTime, Integer deleteTime, Integer cU, Integer cT, Integer banLongtime) {
        this.id = id;
        this.userName = userName;
        this.realName = realName;
        this.phoneNumber = phoneNumber;
        this.schoolCode = schoolCode;
        this.status = status;
        this.integral = integral;
        this.registeredTime = registeredTime;
        this.loginTime = loginTime;
        this.banTime = banTime;
        this.deleteTime = deleteTime;
        this.cU = cU;
        this.cT = cT;
        this.banLongtime = banLongtime;
    }

    public ShareUserName() {
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

    public Integer getBanLongtime() {
        return banLongtime;
    }

    public void setBanLongtime(Integer banLongtime) {
        this.banLongtime = banLongtime;
    }
}