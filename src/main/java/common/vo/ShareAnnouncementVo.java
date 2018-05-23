/**
 * Copyright (C), 2018-2018
 * FileName: ShareAnnouncementVo
 * Author:   jinshuai
 * Date:     2018/5/21 10:12
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package common.vo;

import common.model.ShareAnnouncement;

import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author jinshuai
 * @create 2018/5/21
 * @since 1.0.0
 */
public class ShareAnnouncementVo extends ShareAnnouncement {
    private String name;

    private String uTime;

    private String eTime;

    private String cUser;

    private String cTime;

    private List<ShareAnnouncement> list;

    public List<ShareAnnouncement> getList() {
        return list;
    }

    public void setList(List<ShareAnnouncement> list) {
        this.list = list;
    }

    public String geteTime() {
        return eTime;
    }

    public void seteTime(String eTime) {
        this.eTime = eTime;
    }

    public String getcUser() {
        return cUser;
    }

    public void setcUser(String cUser) {
        this.cUser = cUser;
    }

    public String getcTime() {
        return cTime;
    }

    public void setcTime(String cTime) {
        this.cTime = cTime;
    }

    public String getuTime() {
        return uTime;
    }

    public void setuTime(String uTime) {
        this.uTime = uTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
