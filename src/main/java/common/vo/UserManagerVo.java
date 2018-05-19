package common.vo;

import common.model.UserManager;
import common.model.UserShare;

import java.io.Serializable;

/**
 * Title: <br>
 * Description: <br>
 * Copyright: Copyright (c) 2017<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author :chujinshuai
 * @time :2018/4/14 11:53 星期六
 */
public class UserManagerVo extends UserManager implements Serializable {
    private String sTime;

    private String lTime;

    private String role;

    private String dTime;

    public String getsTime() {
        return sTime;
    }

    public void setsTime(String sTime) {
        this.sTime = sTime;
    }

    public String getlTime() {
        return lTime;
    }

    public void setlTime(String lTime) {
        this.lTime = lTime;
    }

    public String getdTime() {
        return dTime;
    }

    public void setdTime(String dTime) {
        this.dTime = dTime;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
