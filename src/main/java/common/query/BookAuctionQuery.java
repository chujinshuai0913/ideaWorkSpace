package common.query;

import java.math.BigDecimal;
import java.util.List;


public class BookAuctionQuery extends QueryParam {
    private Integer id;

    private Long isbn;

    public Long getIsbn() {
        return isbn;
    }

    public void setIsbn(Long isbn) {
        this.isbn = isbn;
    }

    private List<Integer> ids;

    private List<Integer> sellerIds;

    private String sellerUser;

    private  Integer phoneNumber;

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

    private List<Integer> statusList;

    private String failReason;

    private String strTime;

    private String etrTime;

    private Integer cU;

    private Integer cT;

    private Integer sellerId;

    private Integer bookType2;

    private Integer bookType1;

    private String bookTypeName2;

    private String bookTypeName1;

    private Integer professionalType1;

    private Integer professionalType2;

    private String professionalTypeName1;

    private String professionalTypeName2;

    public List<Integer> getStatusList() {
        return statusList;
    }

    public void setStatusList(List<Integer> statusList) {
        this.statusList = statusList;
    }

    public String getStrTime() {
        return strTime;
    }

    public void setStrTime(String strTime) {
        this.strTime = strTime;
    }

    public String getEtrTime() {
        return etrTime;
    }

    public void setEtrTime(String etrTime) {
        this.etrTime = etrTime;
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
        this.bookTypeName2 = bookTypeName2;
    }

    public String getBookTypeName1() {
        return bookTypeName1;
    }

    public void setBookTypeName1(String bookTypeName1) {
        this.bookTypeName1 = bookTypeName1;
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
        this.professionalTypeName1 = professionalTypeName1;
    }

    public String getProfessionalTypeName2() {
        return professionalTypeName2;
    }

    public void setProfessionalTypeName2(String professionalTypeName2) {
        this.professionalTypeName2 = professionalTypeName2;
    }

    public Integer getSellerId() {
        return sellerId;
    }

    public void setSellerId(Integer sellerId) {
        this.sellerId = sellerId;
    }


    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Integer> getSellerIds() {
        return sellerIds;
    }

    public void setSellerIds(List<Integer> sellerIds) {
        this.sellerIds = sellerIds;
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
        this.auctionName = auctionName;
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
        this.pricingunit = pricingunit;
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
        this.remark = remark;
    }

    public String getSrc1() {
        return src1;
    }

    public void setSrc1(String src1) {
        this.src1 = src1;
    }

    public String getSrc2() {
        return src2;
    }

    public void setSrc2(String src2) {
        this.src2 = src2;
    }

    public String getSrc3() {
        return src3;
    }

    public void setSrc3(String src3) {
        this.src3 = src3;
    }

    public String getSrc4() {
        return src4;
    }

    public void setSrc4(String src4) {
        this.src4 = src4;
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
        this.failReason = failReason;
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

    public String getSellerUser() {
        return sellerUser;
    }

    public void setSellerUser(String sellerUser) {
        this.sellerUser = sellerUser;
    }

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
