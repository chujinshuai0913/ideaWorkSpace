package common.model;

import java.math.BigDecimal;

public class RecordAuction {
    private Integer id;

    private Integer auctionId;

    private Integer userId;

    private Integer auctionTime;

    private BigDecimal price;

    private String pricingunit;

    public RecordAuction(Integer id, Integer auctionId, Integer userId, Integer auctionTime, BigDecimal price, String pricingunit) {
        this.id = id;
        this.auctionId = auctionId;
        this.userId = userId;
        this.auctionTime = auctionTime;
        this.price = price;
        this.pricingunit = pricingunit;
    }

    public RecordAuction() {
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

    public Integer getAuctionTime() {
        return auctionTime;
    }

    public void setAuctionTime(Integer auctionTime) {
        this.auctionTime = auctionTime;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getPricingunit() {
        return pricingunit;
    }

    public void setPricingunit(String pricingunit) {
        this.pricingunit = pricingunit == null ? null : pricingunit.trim();
    }
}