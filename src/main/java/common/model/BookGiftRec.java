package common.model;

public class BookGiftRec {
    private Integer id;

    private Integer giftId;

    private Integer giftTime;

    private Integer num;

    private Integer success;

    private Integer cu;

    private Integer ct;

    private String remark;

    public BookGiftRec(Integer id, Integer giftId, Integer giftTime, Integer num, Integer success, Integer cu, Integer ct, String remark) {
        this.id = id;
        this.giftId = giftId;
        this.giftTime = giftTime;
        this.num = num;
        this.success = success;
        this.cu = cu;
        this.ct = ct;
        this.remark = remark;
    }

    public BookGiftRec() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGiftId() {
        return giftId;
    }

    public void setGiftId(Integer giftId) {
        this.giftId = giftId;
    }

    public Integer getGiftTime() {
        return giftTime;
    }

    public void setGiftTime(Integer giftTime) {
        this.giftTime = giftTime;
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
        this.remark = remark == null ? null : remark.trim();
    }
}