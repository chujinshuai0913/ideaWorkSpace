/**
 * Copyright (C), 2018-2018
 * FileName: ShareActivityQuery
 * Author:   jinshuai
 * Date:     2018/5/21 10:10
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
public class ShareActivityQuery extends QueryParam {

    private Integer id;

    private String name;

    private String activityRoom;

    private Integer activityTime;

    private String remark;

    private Integer cu;

    private Integer ct;

    private Integer exportUser;

    private Integer exportTime;

    private String startTime;

    private String finshTime;

    private Integer sTime;

    private Integer fTime;

    private List<Integer> ids;

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }

    public List<Integer> getIds() {
        return ids;
    }

    private Integer isDelete;

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getActivityRoom() {
        return activityRoom;
    }

    public void setActivityRoom(String activityRoom) {
        this.activityRoom = activityRoom;
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
        this.remark = remark;
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
