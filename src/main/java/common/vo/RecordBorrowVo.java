package common.vo;

import common.model.RecordBorrow;
import common.model.RecordSelling;

/**
 * Title: <br>
 * Description: <br>
 * Copyright: Copyright (c) 2017<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author :chujinshuai
 * @time :2018/4/17 22:52 星期二
 */
public class RecordBorrowVo extends RecordBorrow {

    private String userName;

    /*开始时间*/
    private String sTime;

    /*应该结束时间*/
    private  String eTime;

    /*实际结束时间*/
    private  String rTime;

    /*手机*/
    private  Long phoneNumber;

    //售卖书籍信息
    private Long sellPhoneNumber;

    private  String sellName;

    private String price;
    private  String depositPricer;
    private  String beyondPrice;

    private String bookName;

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDepositPricer() {
        return depositPricer;
    }

    public void setDepositPricer(String depositPricer) {
        this.depositPricer = depositPricer;
    }

    public String getBeyondPrice() {
        return beyondPrice;
    }

    public void setBeyondPrice(String beyondPrice) {
        this.beyondPrice = beyondPrice;
    }

    public Long getSellPhoneNumber() {
        return sellPhoneNumber;
    }

    public void setSellPhoneNumber(Long sellPhoneNumber) {
        this.sellPhoneNumber = sellPhoneNumber;
    }

    public String getSellName() {
        return sellName;
    }

    public void setSellName(String sellName) {
        this.sellName = sellName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getsTime() {
        return sTime;
    }

    public void setsTime(String sTime) {
        this.sTime = sTime;
    }

    public String geteTime() {
        return eTime;
    }

    public void seteTime(String eTime) {
        this.eTime = eTime;
    }

    public String getrTime() {
        return rTime;
    }

    public void setrTime(String rTime) {
        this.rTime = rTime;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
