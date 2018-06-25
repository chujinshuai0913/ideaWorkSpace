package common.query;

import java.util.List;

/**
 * Title: <br>
 * Description: <br>
 * Copyright: Copyright (c) 2017<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author :chujinshuai
 * @time :2018/4/15 16:04 星期日
 */
public class BookGiftRecQuery extends QueryParam {

    private Integer id;

    private String gTime;

    private Integer giftTime;


    private Integer giftId;


    private Integer num;

    private Integer success;

    private Integer cu;

    private Integer ct;

    private String remark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getgTime() {
        return gTime;
    }

    public void setgTime(String gTime) {
        this.gTime = gTime;
    }

    public void setGiftTime(Integer giftTime) {
        this.giftTime = giftTime;
    }

    public Integer getGiftTime() {
        return giftTime;
    }

    public void setGTime(String gTime) {
        this.gTime = gTime;
    }

    public String getGTime() {
        return gTime;
    }

    public Integer getGiftId() {
        return giftId;
    }

    public void setGiftId(Integer giftId) {
        this.giftId = giftId;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Integer getSuccess() {
        return success;
    }

    public void setSuccess(Integer success) {
        this.success = success;
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
