package common.model;

import java.math.BigDecimal;

public class BookSelling {
    private Integer id;

    private Integer skuId;

    private Integer sellerId;

    private String bookName;

    private BigDecimal price;

    private String remark;

    private String src1;

    private String src2;

    private String src3;

    private String src4;

    private Integer status;

    private Integer state;

    private Integer uploadTime;

    private Integer dealTime;

    private Integer useableNum;

    private Integer useNum;

    private Integer preNum;

    private Integer cU;

    private Integer cT;

    private Integer printUser;

    private Integer printTime;

    private Integer importUser;

    private Integer importTime;

    private Integer exportUser;

    private Integer exportTime;

    private String pricingunit;

    public BookSelling(Integer id, Integer skuId, Integer sellerId, String bookName, BigDecimal price, String remark, String src1, String src2, String src3, String src4, Integer status, Integer state, Integer uploadTime, Integer dealTime, Integer useableNum, Integer useNum, Integer preNum, Integer cU, Integer cT, Integer printUser, Integer printTime, Integer importUser, Integer importTime, Integer exportUser, Integer exportTime, String pricingunit) {
        this.id = id;
        this.skuId = skuId;
        this.sellerId = sellerId;
        this.bookName = bookName;
        this.price = price;
        this.remark = remark;
        this.src1 = src1;
        this.src2 = src2;
        this.src3 = src3;
        this.src4 = src4;
        this.status = status;
        this.state = state;
        this.uploadTime = uploadTime;
        this.dealTime = dealTime;
        this.useableNum = useableNum;
        this.useNum = useNum;
        this.preNum = preNum;
        this.cU = cU;
        this.cT = cT;
        this.printUser = printUser;
        this.printTime = printTime;
        this.importUser = importUser;
        this.importTime = importTime;
        this.exportUser = exportUser;
        this.exportTime = exportTime;
        this.pricingunit = pricingunit;
    }

    public BookSelling() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSkuId() {
        return skuId;
    }

    public void setSkuId(Integer skuId) {
        this.skuId = skuId;
    }

    public Integer getSellerId() {
        return sellerId;
    }

    public void setSellerId(Integer sellerId) {
        this.sellerId = sellerId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName == null ? null : bookName.trim();
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(Integer uploadTime) {
        this.uploadTime = uploadTime;
    }

    public Integer getDealTime() {
        return dealTime;
    }

    public void setDealTime(Integer dealTime) {
        this.dealTime = dealTime;
    }

    public Integer getUseableNum() {
        return useableNum;
    }

    public void setUseableNum(Integer useableNum) {
        this.useableNum = useableNum;
    }

    public Integer getUseNum() {
        return useNum;
    }

    public void setUseNum(Integer useNum) {
        this.useNum = useNum;
    }

    public Integer getPreNum() {
        return preNum;
    }

    public void setPreNum(Integer preNum) {
        this.preNum = preNum;
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

    public Integer getPrintUser() {
        return printUser;
    }

    public void setPrintUser(Integer printUser) {
        this.printUser = printUser;
    }

    public Integer getPrintTime() {
        return printTime;
    }

    public void setPrintTime(Integer printTime) {
        this.printTime = printTime;
    }

    public Integer getImportUser() {
        return importUser;
    }

    public void setImportUser(Integer importUser) {
        this.importUser = importUser;
    }

    public Integer getImportTime() {
        return importTime;
    }

    public void setImportTime(Integer importTime) {
        this.importTime = importTime;
    }

    public Integer getExportUser() {
        return exportUser;
    }

    public void setExportUser(Integer exportUser) {
        this.exportUser = exportUser;
    }

    public Integer getExportTime() {
        return exportTime;
    }

    public void setExportTime(Integer exportTime) {
        this.exportTime = exportTime;
    }

    public String getPricingunit() {
        return pricingunit;
    }

    public void setPricingunit(String pricingunit) {
        this.pricingunit = pricingunit == null ? null : pricingunit.trim();
    }
}