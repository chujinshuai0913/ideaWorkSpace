package common.query;


import java.util.List;

public class BookProfessionalListQuery extends QueryParam {
    private Integer id;
    private List<Integer> ids;

    private String bookName;

    private Integer isbn;

    private Integer typeProfessional1;

    private String typeProfessionalname1;

    private Integer typeProfessional2;

    private String typeProfessionalname2;

    private Integer grade;

    private Integer semester;

    private Integer printUser;

    private Integer printTime;

    private Integer importUser;

    private Integer importTime;

    private Integer exportUser;

    private Integer exportTime;

    private Integer cU;

    private Integer cT;

    private Integer isDelete;

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }

    public BookProfessionalListQuery(Integer id, String bookName, Integer isbn, Integer typeProfessional1, String typeProfessionalname1, Integer typeProfessional2, String typeProfessionalname2, Integer grade, Integer semester, Integer printUser, Integer printTime, Integer importUser, Integer importTime, Integer exportUser, Integer exportTime, Integer cU, Integer cT) {
        this.id = id;
        this.bookName = bookName;
        this.isbn = isbn;
        this.typeProfessional1 = typeProfessional1;
        this.typeProfessionalname1 = typeProfessionalname1;
        this.typeProfessional2 = typeProfessional2;
        this.typeProfessionalname2 = typeProfessionalname2;
        this.grade = grade;
        this.semester = semester;
        this.printUser = printUser;
        this.printTime = printTime;
        this.importUser = importUser;
        this.importTime = importTime;
        this.exportUser = exportUser;
        this.exportTime = exportTime;
        this.cU = cU;
        this.cT = cT;
    }

    public BookProfessionalListQuery() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName == null ? null : bookName.trim();
    }

    public Integer getIsbn() {
        return isbn;
    }

    public void setIsbn(Integer isbn) {
        this.isbn = isbn;
    }

    public Integer getTypeProfessional1() {
        return typeProfessional1;
    }

    public void setTypeProfessional1(Integer typeProfessional1) {
        this.typeProfessional1 = typeProfessional1;
    }

    public String getTypeProfessionalname1() {
        return typeProfessionalname1;
    }

    public void setTypeProfessionalname1(String typeProfessionalname1) {
        this.typeProfessionalname1 = typeProfessionalname1 == null ? null : typeProfessionalname1.trim();
    }

    public Integer getTypeProfessional2() {
        return typeProfessional2;
    }

    public void setTypeProfessional2(Integer typeProfessional2) {
        this.typeProfessional2 = typeProfessional2;
    }

    public String getTypeProfessionalname2() {
        return typeProfessionalname2;
    }

    public void setTypeProfessionalname2(String typeProfessionalname2) {
        this.typeProfessionalname2 = typeProfessionalname2 == null ? null : typeProfessionalname2.trim();
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public Integer getSemester() {
        return semester;
    }

    public void setSemester(Integer semester) {
        this.semester = semester;
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
}