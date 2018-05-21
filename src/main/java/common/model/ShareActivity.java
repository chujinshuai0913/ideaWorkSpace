package common.model;

public class ShareActivity {
    private Integer id;

    private String name;

    private String activityRoom;

    private Integer activityTime;

    private String remark;

    private Integer cu;

    private Integer ct;

    private Integer isDelete;

    private Integer exportUser;

    private Integer exportTime;

    public ShareActivity(Integer id, String name, String activityRoom, Integer activityTime, String remark, Integer cu, Integer ct, Integer isDelete, Integer exportUser, Integer exportTime) {
        this.id = id;
        this.name = name;
        this.activityRoom = activityRoom;
        this.activityTime = activityTime;
        this.remark = remark;
        this.cu = cu;
        this.ct = ct;
        this.isDelete = isDelete;
        this.exportUser = exportUser;
        this.exportTime = exportTime;
    }

    public ShareActivity() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getActivityRoom() {
        return activityRoom;
    }

    public void setActivityRoom(String activityRoom) {
        this.activityRoom = activityRoom == null ? null : activityRoom.trim();
    }

    public Integer getActivityTime() {
        return activityTime;
    }

    public void setActivityTime(Integer activityTime) {
        this.activityTime = activityTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Integer getCu() {
        return cu;
    }

    public void setCu(Integer cu) {
        this.cu = cu;
    }

    public Integer getCt() {
        return ct;
    }

    public void setCt(Integer ct) {
        this.ct = ct;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
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