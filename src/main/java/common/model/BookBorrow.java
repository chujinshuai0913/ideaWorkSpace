package common.model;

import java.math.BigDecimal;

public class BookBorrow {
    private Integer id;

    private Integer skuId;

    private Integer sellerId;

    private String bookName;

    private BigDecimal price;

    private BigDecimal depositPrice;

    private BigDecimal beyondPrice;

    private String remark;

    private String src1;

    private String src2;

    private String src3;

    private String src4;

    private Integer status;

    private Integer uploadTime;

    private Integer useableNum;

    private Integer useNum;

    private Integer preNum;

    private Integer state;

    private Integer cU;

    private Integer cT;

    private Integer printUser;

    private Integer printTime;

    private Integer importUser;

    private Integer importTime;

    private Integer exportUser;

    private Integer exportTime;

    private String pricingunit;

    private Integer bookType2;

    private Integer bookType1;

    private String bookTypeName2;

    private String bookTypeName1;

    private Integer professionalType1;

    private Integer professionalType2;

    private String professionalTypeName1;

    private String professionalTypeName2;

    public BookBorrow(Integer id, Integer skuId, Integer sellerId, String bookName, BigDecimal price, BigDecimal depositPrice, BigDecimal beyondPrice, String remark, String src1, String src2, String src3, String src4, Integer status, Integer uploadTime, Integer useableNum, Integer useNum, Integer preNum, Integer state, Integer cU, Integer cT, Integer printUser, Integer printTime, Integer importUser, Integer importTime, Integer exportUser, Integer exportTime, String pricingunit, Integer bookType2, Integer bookType1, String bookTypeName2, String bookTypeName1, Integer professionalType1, Integer professionalType2, String professionalTypeName1, String professionalTypeName2) {
        this.id = id;
        this.skuId = skuId;
        this.sellerId = sellerId;
        this.bookName = bookName;
        this.price = price;
        this.depositPrice = depositPrice;
        this.beyondPrice = beyondPrice;
        this.remark = remark;
        this.src1 = src1;
        this.src2 = src2;
        this.src3 = src3;
        this.src4 = src4;
        this.status = status;
        this.uploadTime = uploadTime;
        this.useableNum = useableNum;
        this.useNum = useNum;
        this.preNum = preNum;
        this.state = state;
        this.cU = cU;
        this.cT = cT;
        this.printUser = printUser;
        this.printTime = printTime;
        this.importUser = importUser;
        this.importTime = importTime;
        this.exportUser = exportUser;
        this.exportTime = exportTime;
        this.pricingunit = pricingunit;
        this.bookType2 = bookType2;
        this.bookType1 = bookType1;
        this.bookTypeName2 = bookTypeName2;
        this.bookTypeName1 = bookTypeName1;
        this.professionalType1 = professionalType1;
        this.professionalType2 = professionalType2;
        this.professionalTypeName1 = professionalTypeName1;
        this.professionalTypeName2 = professionalTypeName2;
    }

    public BookBorrow() {
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

    public BigDecimal getDepositPrice() {
        return depositPrice;
    }

    public void setDepositPrice(BigDecimal depositPrice) {
        this.depositPrice = depositPrice;
    }

    public BigDecimal getBeyondPrice() {
        return beyondPrice;
    }

    public void setBeyondPrice(BigDecimal beyondPrice) {
        this.beyondPrice = beyondPrice;
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

    public Integer getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(Integer uploadTime) {
        this.uploadTime = uploadTime;
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

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
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