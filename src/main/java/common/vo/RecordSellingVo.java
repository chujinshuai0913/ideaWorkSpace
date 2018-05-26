package common.vo;

import common.model.RecordSelling;

import javax.print.DocFlavor;

/**
 * Title: <br>
 * Description: <br>
 * Copyright: Copyright (c) 2017<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author :chujinshuai
 * @time :2018/4/17 22:52 星期二
 */
public class RecordSellingVo extends RecordSelling {

    private String buyerName;

    /*上次交易时间*/
    private String cTime;

    /*下单时间*/
    private  String oTime;

    /*交状态*/
    private  String statusStr;

    /*手机*/
    private  Long phoneNumber;

    //售卖书籍信息
    private Long sellPhoneNumber;

    private  String sellName;

    private  String bookName;

    private String price;

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

    public String getBuyerName() {
        return buyerName;
    }

    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }

    public String getcTime() {
        return cTime;
    }

    public void setcTime(String cTime) {
        this.cTime = cTime;
    }

    public String getoTime() {
        return oTime;
    }

    public void setoTime(String oTime) {
        this.oTime = oTime;
    }

    public String getStatusStr() {
        return statusStr;
    }

    public void setStatusStr(String statusStr) {
        this.statusStr = statusStr;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
