/**
 * Copyright (C), 2018-2018
 * FileName: BookDto
 * Author:   jinshuai
 * Date:     2018/4/9 22:47
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package common.vo;


import common.model.Book;

import java.io.Serializable;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author jinshuai
 * @create 2018/4/9
 * @since 1.0.0
 */
public class BookVo extends Book implements Serializable {

    private String pTime;

    private String iTime;

    private String cTime;

    private String prTime;
    private String eTime;

    private  String eUser;
    private String cName;

    private String prUser;


    private String iUser;
    public String getpTime() {
        return pTime;
    }

    public void setpTime(String pTime) {
        this.pTime = pTime;
    }

    public String getiTime() {
        return iTime;
    }

    public void setiTime(String iTime) {
        this.iTime = iTime;
    }

    public String getcTime() {
        return cTime;
    }

    public void setcTime(String cTime) {
        this.cTime = cTime;
    }

    public String getPrTime() {
        return prTime;
    }

    public void setPrTime(String prTime) {
        this.prTime = prTime;
    }

    public String geteTime() {
        return eTime;
    }

    public void seteTime(String eTime) {
        this.eTime = eTime;
    }

    public String geteUser() {
        return eUser;
    }

    public void seteUser(String eUser) {
        this.eUser = eUser;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public String getPrUser() {
        return prUser;
    }

    public void setPrUser(String prUser) {
        this.prUser = prUser;
    }

    public String getiUser() {
        return iUser;
    }

    public void setiUser(String iUser) {
        this.iUser = iUser;
    }
}
