package common.model;

import java.math.BigDecimal;

public class Book {
    private Integer id;

    private Long isbn;

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

    private Integer preNum;

    private Integer cU;

    private Integer printUser;

    private Integer cT;

    private Integer printTime;

    private Integer importUser;

    private Integer importTime;

    private Integer exportUser;

    private Integer exportTime;

    private Integer sellStatus;

    private Integer borrowStatus;

    private Integer giftStatus;

    private Integer auctionStatus;

    private String binding;

    private String subtitle;

    private Long isbn10;

    private String translator;

    private String tag;

    private String src2;

    private String src3;

    private String introduce;

    private String authorIntro;

    private String catalog;


    public Book(Integer id, Long isbn, String bookName, String author, String press, Integer pressTime, Integer pageNumber, String src, BigDecimal pricing, String pricingunit, Integer sellerNumber, Integer bookType2, Integer bookType1, String bookTypeName2, String bookTypeName1, Integer professionalType1, Integer professionalType2, String professionalTypeName1, String professionalTypeName2, Integer userableNum, Integer useNum, Integer preNum, Integer cU, Integer printUser, Integer cT, Integer printTime, Integer importUser, Integer importTime, Integer exportUser, Integer exportTime, Integer sellStatus, Integer borrowStatus,
                Integer giftStatus, Integer auctionStatus, String binding, String subtitle,
                Long isbn10, String translator, String tag, String src2, String src3, String introduce, String authorIntro, String catalog) {
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
        this.preNum = preNum;
        this.cU = cU;
        this.printUser = printUser;
        this.cT = cT;
        this.printTime = printTime;
        this.importUser = importUser;
        this.importTime = importTime;
        this.exportUser = exportUser;
        this.exportTime = exportTime;
        this.sellStatus = sellStatus;
        this.borrowStatus = borrowStatus;
        this.giftStatus = giftStatus;
        this.auctionStatus = auctionStatus;
        this.binding = binding;
        this.subtitle = subtitle;
        this.isbn10 = isbn10;
        this.translator = translator;
        this.tag = tag;
        this.src2 = src2;
        this.src3 = src3;
        this.introduce = introduce;
        this.authorIntro = authorIntro;
        this.catalog = catalog;
    }

    public Book() {
        super();
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public String getAuthorIntro() {
        return authorIntro;
    }

    public void setAuthorIntro(String authorIntro) {
        this.authorIntro = authorIntro;
    }

    public String getCatalog() {
        return catalog;
    }

    public void setCatalog(String catalog) {
        this.catalog = catalog;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getIsbn() {
        return isbn;
    }

    public void setIsbn(Long isbn) {
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

    public Integer getSellStatus() {
        return sellStatus;
    }

    public void setSellStatus(Integer sellStatus) {
        this.sellStatus = sellStatus;
    }

    public Integer getBorrowStatus() {
        return borrowStatus;
    }

    public void setBorrowStatus(Integer borrowStatus) {
        this.borrowStatus = borrowStatus;
    }

    public Integer getGiftStatus() {
        return giftStatus;
    }

    public void setGiftStatus(Integer giftStatus) {
        this.giftStatus = giftStatus;
    }

    public Integer getAuctionStatus() {
        return auctionStatus;
    }

    public void setAuctionStatus(Integer auctionStatus) {
        this.auctionStatus = auctionStatus;
    }

    public String getBinding() {
        return binding;
    }

    public void setBinding(String binding) {
        this.binding = binding == null ? null : binding.trim();
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle == null ? null : subtitle.trim();
    }

    public Long getIsbn10() {
        return isbn10;
    }

    public void setIsbn10(Long isbn10) {
        this.isbn10 = isbn10;
    }

    public String getTranslator() {
        return translator;
    }

    public void setTranslator(String translator) {
        this.translator = translator == null ? null : translator.trim();
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag == null ? null : tag.trim();
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
}