package common.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class BookAuction implements Serializable{
    private Integer id;

    private Integer sellerId;

    private Integer bookId;

    private String auctionName;

    private BigDecimal price;

    private String pricingunit;

    private Integer buyerId;

    private BigDecimal dealPrice;

    private String remark;

    private String src1;

    private String src2;

    private String src3;

    private String src4;

    private Integer uploadTime;

    private Integer startTime;

    private Integer endTime;

    private Integer state;

    private Integer status;

    private String failReason;

    private Integer cU;

    private Integer cT;

    private Integer bookType2;

    private Integer bookType1;

    private String bookTypeName2;

    private String bookTypeName1;

    private Integer professionalType1;

    private Integer professionalType2;

    private String professionalTypeName1;

    private String professionalTypeName2;

    public BookAuction(Integer id, Integer sellerId, Integer bookId, String auctionName, BigDecimal price, String pricingunit, Integer buyerId, BigDecimal dealPrice, String remark, String src1, String src2, String src3, String src4, Integer uploadTime, Integer startTime, Integer endTime, Integer state, Integer status, String failReason, Integer cU, Integer cT, Integer bookType2, Integer bookType1, String bookTypeName2, String bookTypeName1, Integer professionalType1, Integer professionalType2, String professionalTypeName1, String professionalTypeName2) {
        this.id = id;
        this.sellerId = sellerId;
        this.bookId = bookId;
        this.auctionName = auctionName;
        this.price = price;
        this.pricingunit = pricingunit;
        this.buyerId = buyerId;
        this.dealPrice = dealPrice;
        this.remark = remark;
        this.src1 = src1;
        this.src2 = src2;
        this.src3 = src3;
        this.src4 = src4;
        this.uploadTime = uploadTime;
        this.startTime = startTime;
        this.endTime = endTime;
        this.state = state;
        this.status = status;
        this.failReason = failReason;
        this.cU = cU;
        this.cT = cT;
        this.bookType2 = bookType2;
        this.bookType1 = bookType1;
        this.bookTypeName2 = bookTypeName2;
        this.bookTypeName1 = bookTypeName1;
        this.professionalType1 = professionalType1;
        this.professionalType2 = professionalType2;
        this.professionalTypeName1 = professionalTypeName1;
        this.professionalTypeName2 = professionalTypeName2;
    }

    public BookAuction() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSellerId() {
        return sellerId;
    }

    public void setSellerId(Integer sellerId) {
        this.sellerId = sellerId;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getAuctionName() {
        return auctionName;
    }

    public void setAuctionName(String auctionName) {
        this.auctionName = auctionName == null ? null : auctionName.trim();
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

    public Integer getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(Integer buyerId) {
        this.buyerId = buyerId;
    }

    public BigDecimal getDealPrice() {
        return dealPrice;
    }

    public void setDealPrice(BigDecimal dealPrice) {
        this.dealPrice = dealPrice;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getSrc1() {
        return src1;
    }

    public void setSrc1(String src1) {
        this.src1 = src1 == null ? null : src1.trim();
    }

    public String getSrc2() {
        return src2;
    }

    public void setSrc2(String src2) {
        this.src2 = src2 == null ? null : src2.trim();
    }

    public String getSrc3() {
        return src3;
    }

    public void setSrc3(String src3) {
        this.src3 = src3 == null ? null : src3.trim();
    }

    public String getSrc4() {
        return src4;
    }

    public void setSrc4(String src4) {
        this.src4 = src4 == null ? null : src4.trim();
    }

    public Integer getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(Integer uploadTime) {
        this.uploadTime = uploadTime;
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

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getFailReason() {
        return failReason;
    }

    public void setFailReason(String failReason) {
        this.failReason = failReason == null ? null : failReason.trim();
    }

    public Integer getcU() {
        return cU;
    }

    public void setcU(Integer cU) {
        this.cU = cU;
    }

    public Integer getcT() {
        return cT;
    }

    public void setcT(Integer cT) {
        this.cT = cT;
    }

    public Integer getBookType2() {
        return bookType2;
    }

    public void setBookType2(Integer bookType2) {
        this.bookType2 = bookType2;
    }

    public Integer getBookType1() {
        return bookType1;
    }

    public void setBookType1(Integer bookType1) {
        this.bookType1 = bookType1;
    }

    public String getBookTypeName2() {
        return bookTypeName2;
    }

    public void setBookTypeName2(String bookTypeName2) {
        this.bookTypeName2 = bookTypeName2 == null ? null : bookTypeName2.trim();
    }

    public String getBookTypeName1() {
        return bookTypeName1;
    }

    public void setBookTypeName1(String bookTypeName1) {
        this.bookTypeName1 = bookTypeName1 == null ? null : bookTypeName1.trim();
    }

    public Integer getProfessionalType1() {
        return professionalType1;
    }

    public void setProfessionalType1(Integer professionalType1) {
        this.professionalType1 = professionalType1;
    }

    public Integer getProfessionalType2() {
        return professionalType2;
    }

    public void setProfessionalType2(Integer professionalType2) {
        this.professionalType2 = professionalType2;
    }

    public String getProfessionalTypeName1() {
        return professionalTypeName1;
    }

    public void setProfessionalTypeName1(String professionalTypeName1) {
        this.professionalTypeName1 = professionalTypeName1 == null ? null : professionalTypeName1.trim();
    }

    public String getProfessionalTypeName2() {
        return professionalTypeName2;
    }

    public void setProfessionalTypeName2(String professionalTypeName2) {
        this.professionalTypeName2 = professionalTypeName2 == null ? null : professionalTypeName2.trim();
    }
}