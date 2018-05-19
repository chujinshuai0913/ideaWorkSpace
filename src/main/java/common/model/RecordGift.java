package common.model;

public class RecordGift {
    private Integer id;

    private Integer sellingId;

    private Integer buyer;

    private Integer total;

    private Integer orderTime;

    private Integer status;

    private String failureReason;

    private Integer completeTime;

    public RecordGift(Integer id, Integer sellingId, Integer buyer, Integer total, Integer orderTime, Integer status, String failureReason, Integer completeTime) {
        this.id = id;
        this.sellingId = sellingId;
        this.buyer = buyer;
        this.total = total;
        this.orderTime = orderTime;
        this.status = status;
        this.failureReason = failureReason;
        this.completeTime = completeTime;
    }

    public RecordGift() {
        super();
    }

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

    public Integer getBuyer() {
        return buyer;
    }

    public void setBuyer(Integer buyer) {
        this.buyer = buyer;
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
        this.failureReason = failureReason == null ? null : failureReason.trim();
    }

    public Integer getCompleteTime() {
        return completeTime;
    }

    public void setCompleteTime(Integer completeTime) {
        this.completeTime = completeTime;
    }
}