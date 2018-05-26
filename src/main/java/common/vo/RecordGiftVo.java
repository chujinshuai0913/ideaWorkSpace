package common.vo;

import common.model.RecordBorrow;
import common.model.RecordGift;

/**
 * Title: <br>
 * Description: <br>
 * Copyright: Copyright (c) 2017<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author :chujinshuai
 * @time :2018/4/17 22:52 星期二
 */
public class RecordGiftVo extends RecordGift {

    private String buyerName;

    /*赠予时间*/
    private String oTime;

    /*完成时间*/
    private String cTime;

    /*手机*/
    private  Long phoneNumber;


    /*交状态*/
    private  String statusStr;

    //售卖书籍信息
    private Long sellPhoneNumber;

    private  String sellName;

    private  String bookName;

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
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

    public String getoTime() {
        return oTime;
    }

    public void setoTime(String oTime) {
        this.oTime = oTime;
    }

    public String getcTime() {
        return cTime;
    }

    public void setcTime(String cTime) {
        this.cTime = cTime;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getStatusStr() {
        return statusStr;
    }

    public void setStatusStr(String statusStr) {
        this.statusStr = statusStr;
    }
}
