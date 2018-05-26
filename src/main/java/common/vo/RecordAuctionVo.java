package common.vo;

import common.model.RecordAuction;
import common.model.RecordBorrow;

/**
 * Title: <br>
 * Description: <br>
 * Copyright: Copyright (c) 2017<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author :chujinshuai
 * @time :2018/4/17 22:52 星期二
 */
public class RecordAuctionVo extends RecordAuction {

    private String userName;


    /*出价时间*/
    private String aTime;

    /*手机*/
    private  Long phoneNumber;

    //售卖书籍信息
    private Long sellPhoneNumber;

    private  String sellName;

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

    public String getaTime() {
        return aTime;
    }

    public void setaTime(String aTime) {
        this.aTime = aTime;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
