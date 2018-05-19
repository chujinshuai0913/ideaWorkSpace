package common.vo;

import common.model.BookBorrow;
import common.query.QueryParam;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Title: <br>
 * Description: <br>
 * Copyright: Copyright (c) 2017<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author :chujinshuai
 * @time :2018/4/15 16:06 星期日
 */
public class BookBorrowVo extends BookBorrow implements Serializable {

    private String sellerName;

    private String statusStr;

    private String uTime;

    private String cName;

    private String cTime;

    private String prUser;

    private String prTime;

    private String iUser;

    private String iTime;

    private String eUser;

    private String eTime;

    private Long phoneNumber;

    public String getStatusStr() {
        return statusStr;
    }

    public void setStatusStr(String statusStr) {
        this.statusStr = statusStr;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public String getuTime() {
        return uTime;
    }

    public void setuTime(String uTime) {
        this.uTime = uTime;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public String getcTime() {
        return cTime;
    }

    public void setcTime(String cTime) {
        this.cTime = cTime;
    }

    public String getPrUser() {
        return prUser;
    }

    public void setPrUser(String prUser) {
        this.prUser = prUser;
    }

    public String getPrTime() {
        return prTime;
    }

    public void setPrTime(String prTime) {
        this.prTime = prTime;
    }

    public String getiUser() {
        return iUser;
    }

    public void setiUser(String iUser) {
        this.iUser = iUser;
    }

    public String getiTime() {
        return iTime;
    }

    public void setiTime(String iTime) {
        this.iTime = iTime;
    }

    public String geteUser() {
        return eUser;
    }

    public void seteUser(String eUser) {
        this.eUser = eUser;
    }

    public String geteTime() {
        return eTime;
    }

    public void seteTime(String eTime) {
        this.eTime = eTime;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
