package common.model;

public class ShareAnnouncement {
    private Integer id;

    private Integer activityId;

    private String src;

    private String remark;

    private Integer uploadTime;

    private Integer endTime;

    private Integer isDelete;

    private Integer cu;

    private Integer ct;

    private Integer status;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public ShareAnnouncement(Integer id, Integer activityId, String src, String remark, Integer uploadTime, Integer endTime, Integer isDelete,Integer status, Integer cu, Integer ct) {
        this.id = id;
        this.activityId = activityId;
        this.src = src;
        this.remark = remark;
        this.uploadTime = uploadTime;
        this.endTime = endTime;
        this.isDelete = isDelete;
        this.status = status;
        this.cu = cu;
        this.ct = ct;
    }

    public ShareAnnouncement() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getActivityId() {
        return activityId;
    }

    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src == null ? null : src.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Integer getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(Integer uploadTime) {
        this.uploadTime = uploadTime;
    }

    public Integer getEndTime() {
        return endTime;
    }

    public void setEndTime(Integer endTime) {
        this.endTime = endTime;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
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
}