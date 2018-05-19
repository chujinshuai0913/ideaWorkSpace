package common.query;

import java.util.List;

/**
 * Title: <br>
 * Description: <br>
 * Copyright: Copyright (c) 2017<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author :chujinshuai
 * @time :2018/4/14 17:23 星期六
 */
public class RecordGiftQuery extends QueryParam {
    private Integer id;

    private Integer sellingId;

    private List<Integer> buyers;

    private  String  buyerName;

    private Integer total;

    private Integer orderTime;

    private Integer status;

    private String failureReason;

    private Integer completeTime;

    private String eneCompleteTime;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSellingId() {
        return sellingId;
    }

    public void setSellingId(Integer sellingId) {
        this.sellingId = sellingId;
    }

    public List<Integer> getBuyers() {
        return buyers;
    }

    public void setBuyers(List<Integer> buyers) {
        this.buyers = buyers;
    }

    public String getBuyerName() {
        return buyerName;
    }

    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Integer orderTime) {
        this.orderTime = orderTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getFailureReason() {
        return failureReason;
    }

    public void setFailureReason(String failureReason) {
        this.failureReason = failureReason;
    }

    public Integer getCompleteTime() {
        return completeTime;
    }

    public void setCompleteTime(Integer completeTime) {
        this.completeTime = completeTime;
    }

    public String getEneCompleteTime() {
        return eneCompleteTime;
    }

    public void setEneCompleteTime(String eneCompleteTime) {
        this.eneCompleteTime = eneCompleteTime;
    }
}
