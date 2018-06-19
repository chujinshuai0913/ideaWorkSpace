/**
 * Copyright (C), 2018-2018
 * FileName: UserLogin
 * Author:   jinshuai
 * Date:     2018/5/27 14:14
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package common.model;

import sun.security.util.Password;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author jinshuai
 * @create 2018/5/27
 * @since 1.0.0
 */
public class UserLogin {

    private Integer userId;

    private String userName;

    private  String realUserName;

    private Long phoneNumber;

    private Integer password;

    //积分
    private Integer integral;

    //学院
    private String professionalName1;

    //专业
    private  String professionalName2;


    //学号/学校认证的id
    private  Long studentCode;

    //是否可用 被禁号
    private  Integer status;

    private  Integer grade;

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRealUserName() {
        return realUserName;
    }

    public void setRealUserName(String realUserName) {
        this.realUserName = realUserName;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Integer getPassword() {
        return password;
    }

    public void setPassword(Integer password) {
        this.password = password;
    }

    public Integer getIntegral() {
        return integral;
    }

    public void setIntegral(Integer integral) {
        this.integral = integral;
    }

    public String getProfessionalName1() {
        return professionalName1;
    }

    public void setProfessionalName1(String professionalName1) {
        this.professionalName1 = professionalName1;
    }

    public String getProfessionalName2() {
        return professionalName2;
    }

    public void setProfessionalName2(String professionalName2) {
        this.professionalName2 = professionalName2;
    }

    public Long getStudentCode() {
        return studentCode;
    }

    public void setStudentCode(Long studentCode) {
        this.studentCode = studentCode;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
