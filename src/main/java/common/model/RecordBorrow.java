package common.model;

import java.math.BigDecimal;

public class RecordBorrow {
    private Integer id;

    private Integer auctionId;

    private Integer userId;

    private BigDecimal totalPrice;

    private Integer startTime;

    private Integer endTime;

    private Integer realEndTime;

    private Integer num;

    private Integer returnNum;

    private BigDecimal totalDeposit;

    private BigDecimal returnDeposit;

    private String pricingunit;

    public RecordBorrow(Integer id, Integer auctionId, Integer userId, BigDecimal totalPrice, Integer startTime, Integer endTime, Integer realEndTime, Integer num, Integer returnNum, BigDecimal totalDeposit, BigDecimal returnDeposit, String pricingunit) {
        this.id = id;
        this.auctionId = auctionId;
        this.userId = userId;
        this.totalPrice = totalPrice;
        this.startTime = startTime;
        this.endTime = endTime;
        this.realEndTime = realEndTime;
        this.num = num;
        this.returnNum = returnNum;
        this.totalDeposit = totalDeposit;
        this.returnDeposit = returnDeposit;
        this.pricingunit = pricingunit;
    }

    public RecordBorrow() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAuctionId() {
        return auctionId;
    }

    public void setAuctionId(Integer auctionId) {
        this.auctionId = auctionId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Integer getStartTime() {
        return startTime;
    }

    public void setStartTime(Integer startTime) {
        this.startTime = startTime;
    }

    public Integer getEndTime() {
        return endTime;
    }

    public void setEndTime(Integer endTime) {
        this.endTime = endTime;
    }

    public Integer getRealEndTime() {
        return realEndTime;
    }

    public void setRealEndTime(Integer realEndTime) {
        this.realEndTime = realEndTime;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Integer getReturnNum() {
        return returnNum;
    }

    public void setReturnNum(Integer returnNum) {
        this.returnNum = returnNum;
    }

    public BigDecimal getTotalDeposit() {
        return totalDeposit;
    }

    public void setTotalDeposit(BigDecimal totalDeposit) {
        this.totalDeposit = totalDeposit;
    }

    public BigDecimal getReturnDeposit() {
        return returnDeposit;
    }

    public void setReturnDeposit(BigDecimal returnDeposit) {
        this.returnDeposit = returnDeposit;
    }

    public String getPricingunit() {
        return pricingunit;
    }

    public void setPricingunit(String pricingunit) {
        this.pricingunit = pricingunit == null ? null : pricingunit.trim();
    }
}