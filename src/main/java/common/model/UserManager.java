package common.model;

public class UserManager {
    private Integer id;

    private String username;

    private Integer password;

    private Integer signTime;

    private Integer loginTime;

    private Integer loginNum;

    private Integer roleId;

    private Long workId;

    private Integer deleteTime;

    private Long phoneNumber;

    public UserManager(Integer id, String username, Integer password, Integer signTime, Integer loginTime, Integer loginNum, Integer roleId, Long workId, Integer deleteTime, Long phoneNumber) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.signTime = signTime;
        this.loginTime = loginTime;
        this.loginNum = loginNum;
        this.roleId = roleId;
        this.workId = workId;
        this.deleteTime = deleteTime;
        this.phoneNumber = phoneNumber;
    }

    public UserManager() {
        super();
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
        this.username = username == null ? null : username.trim();
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
}