/**
 * Copyright (C), 2018-2018
 * FileName: ShareAnnouncementQuery
 * Author:   jinshuai
 * Date:     2018/5/21 10:11
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package common.query;

import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author jinshuai
 * @create 2018/5/21
 * @since 1.0.0
 */
public class ShareAnnouncementQuery extends QueryParam {

    private Integer id;

    private Integer activityId;

    private String src;

    private String remark;

    private Integer uploadTime;

    private Integer upTime;

    private Integer endTime;

    private Integer enTime;
    private Integer isDelete;

    private Integer cu;

    private Integer ct;

    private String startTime;

    private String finshTime;

    private Integer sTime;

    private Integer fTime;
    private Integer status;

    public Integer getEnTime() {
        return enTime;
    }

    public void setEnTime(Integer enTime) {
        this.enTime = enTime;
    }

    public Integer getUpTime() {
        return upTime;
    }

    public void setUpTime(Integer upTime) {
        this.upTime = upTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    private List<Integer> ids;

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }

    public List<Integer> getIds() {
        return ids;
    }
    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public Integer getsTime() {
        return sTime;
    }

    public void setsTime(Integer sTime) {
        this.sTime = sTime;
    }

    public String getFinshTime() {
        return finshTime;
    }

    public void setFinshTime(String finshTime) {
        this.finshTime = finshTime;
    }

    public Integer getfTime() {
        return fTime;
    }

    public void setfTime(Integer fTime) {
        this.fTime = fTime;
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
        this.src = src;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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
