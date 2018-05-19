package common.model;

import java.math.BigDecimal;

public class Book {
    private Integer id;

    private Integer isbn;

    private String bookName;

    private String author;

    private String press;

    private Integer pressTime;

    private Integer pageNumber;

    private String src;

    private BigDecimal pricing;

    private String pricingunit;

    private Integer sellerNumber;

    private Integer bookType2;

    private Integer bookType1;

    private String bookTypeName2;

    private String bookTypeName1;

    private Integer professionalType1;

    private Integer professionalType2;

    private String professionalTypeName1;

    private String professionalTypeName2;

    private Integer userableNum;

    private Integer useNum;

    private String introduce;

    private Integer preNum;

    private Integer cU;

    private Integer printUser;

    private Integer cT;

    private Integer printTime;

    private Integer importUser;

    private Integer importTime;

    private Integer exportUser;

    private Integer exportTime;

    public Book(Integer id, Integer isbn, String bookName, String author, String press, Integer pressTime, Integer pageNumber, String src, BigDecimal pricing, String pricingunit, Integer sellerNumber, Integer bookType2, Integer bookType1, String bookTypeName2, String bookTypeName1, Integer professionalType1, Integer professionalType2, String professionalTypeName1, String professionalTypeName2, Integer userableNum, Integer useNum, String introduce, Integer preNum, Integer cU, Integer printUser, Integer cT, Integer printTime, Integer importUser, Integer importTime, Integer exportUser, Integer exportTime) {
        this.id = id;
        this.isbn = isbn;
        this.bookName = bookName;
        this.author = author;
        this.press = press;
        this.pressTime = pressTime;
        this.pageNumber = pageNumber;
        this.src = src;
        this.pricing = pricing;
        this.pricingunit = pricingunit;
        this.sellerNumber = sellerNumber;
        this.bookType2 = bookType2;
        this.bookType1 = bookType1;
        this.bookTypeName2 = bookTypeName2;
        this.bookTypeName1 = bookTypeName1;
        this.professionalType1 = professionalType1;
        this.professionalType2 = professionalType2;
        this.professionalTypeName1 = professionalTypeName1;
        this.professionalTypeName2 = professionalTypeName2;
        this.userableNum = userableNum;
        this.useNum = useNum;
        this.introduce = introduce;
        this.preNum = preNum;
        this.cU = cU;
        this.printUser = printUser;
        this.cT = cT;
        this.printTime = printTime;
        this.importUser = importUser;
        this.importTime = importTime;
        this.exportUser = exportUser;
        this.exportTime = exportTime;
    }

    public Book() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIsbn() {
        return isbn;
    }

    public void setIsbn(Integer isbn) {
        this.isbn = isbn;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName == null ? null : bookName.trim();
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author == null ? null : author.trim();
    }

    public String getPress() {
        return press;
    }

    public void setPress(String press) {
        this.press = press == null ? null : press.trim();
    }

    public Integer getPressTime() {
        return pressTime;
    }

    public void setPressTime(Integer pressTime) {
        this.pressTime = pressTime;
    }

    public Integer getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src == null ? null : src.trim();
    }

    public BigDecimal getPricing() {
        return pricing;
    }

    public void setPricing(BigDecimal pricing) {
        this.pricing = pricing;
    }

    public String getPricingunit() {
        return pricingunit;
    }

    public void setPricingunit(String pricingunit) {
        this.pricingunit = pricingunit == null ? null : pricingunit.trim();
    }

    public Integer getSellerNumber() {
        return sellerNumber;
    }

    public void setSellerNumber(Integer sellerNumber) {
        this.sellerNumber = sellerNumber;
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

    public Integer getUserableNum() {
        return userableNum;
    }

    public void setUserableNum(Integer userableNum) {
        this.userableNum = userableNum;
    }

    public Integer getUseNum() {
        return useNum;
    }

    public void setUseNum(Integer useNum) {
        this.useNum = useNum;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce == null ? null : introduce.trim();
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

    public Integer getPrintUser() {
        return printUser;
    }

    public void setPrintUser(Integer printUser) {
        this.printUser = printUser;
    }

    public Integer getcT() {
        return cT;
    }

    public void setcT(Integer cT) {
        this.cT = cT;
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
}