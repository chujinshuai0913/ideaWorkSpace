package common.query;

/**
 * Title: <br>
 * Description: <br>
 * Copyright: Copyright (c) 2017<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author :chujinshuai
 * @time :2018/4/14 15:52 星期六
 */
public class StudentTeacherQuery extends QueryParam {
    private Integer id;

    private Long idNumber;

    private String stName;

    private Integer professional1;

    private Integer professional2;

    private String professional1Name;

    private String professional2Name;

    private String grade;

    private Integer time;

    private String strTime;

    private Long schoolCode;
    private Long workId;

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
        this.stName = stName;
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
        this.professional1Name = professional1Name;
    }

    public String getProfessional2Name() {
        return professional2Name;
    }

    public void setProfessional2Name(String professional2Name) {
        this.professional2Name = professional2Name;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public Long getSchoolCode() {
        return schoolCode;
    }

    public void setSchoolCode(Long schoolCode) {
        this.schoolCode = schoolCode;
    }

    public Long getWorkId() {
        return workId;
    }

    public void setWorkId(Long workId) {
        this.workId = workId;
    }

    public String getStrTime() {
        return strTime;
    }

    public void setStrTime(String strTime) {
        this.strTime = strTime;
    }
}
