package common.model;

public class StudentTeacherList {
    private Integer id;

    private Long idNumber;

    private String stName;

    private Integer professional1;

    private Integer professional2;

    private String professional1Name;

    private String professional2Name;

    private String grade;

    private Integer time;

    public StudentTeacherList(Integer id, Long idNumber, String stName, Integer professional1, Integer professional2, String professional1Name, String professional2Name, String grade, Integer time) {
        this.id = id;
        this.idNumber = idNumber;
        this.stName = stName;
        this.professional1 = professional1;
        this.professional2 = professional2;
        this.professional1Name = professional1Name;
        this.professional2Name = professional2Name;
        this.grade = grade;
        this.time = time;
    }

    public StudentTeacherList() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(Long idNumber) {
        this.idNumber = idNumber;
    }

    public String getStName() {
        return stName;
    }

    public void setStName(String stName) {
        this.stName = stName == null ? null : stName.trim();
    }

    public Integer getProfessional1() {
        return professional1;
    }

    public void setProfessional1(Integer professional1) {
        this.professional1 = professional1;
    }

    public Integer getProfessional2() {
        return professional2;
    }

    public void setProfessional2(Integer professional2) {
        this.professional2 = professional2;
    }

    public String getProfessional1Name() {
        return professional1Name;
    }

    public void setProfessional1Name(String professional1Name) {
        this.professional1Name = professional1Name == null ? null : professional1Name.trim();
    }

    public String getProfessional2Name() {
        return professional2Name;
    }

    public void setProfessional2Name(String professional2Name) {
        this.professional2Name = professional2Name == null ? null : professional2Name.trim();
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade == null ? null : grade.trim();
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }
}