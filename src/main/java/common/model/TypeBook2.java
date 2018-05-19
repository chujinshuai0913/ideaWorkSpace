package common.model;

import common.query.QueryParam;

import java.io.Serializable;

public class TypeBook2  extends QueryParam implements Serializable {
    private Integer id;

    private Integer classId1;

    private String className2;

    private Integer printUser;

    private Integer printTime;

    private Integer importUser;

    private Integer importTime;

    private Integer exportUser;

    private Integer exportTime;

    private Integer cT;

    private Integer cU;

    private Integer status;

    public TypeBook2(Integer id, Integer classId1, String className2, Integer printUser, Integer printTime, Integer importUser, Integer importTime, Integer exportUser, Integer exportTime, Integer cT, Integer cU, Integer status) {
        this.id = id;
        this.classId1 = classId1;
        this.className2 = className2;
        this.printUser = printUser;
        this.printTime = printTime;
        this.importUser = importUser;
        this.importTime = importTime;
        this.exportUser = exportUser;
        this.exportTime = exportTime;
        this.cT = cT;
        this.cU = cU;
        this.status = status;
    }

    public TypeBook2() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getClassId1() {
        return classId1;
    }

    public void setClassId1(Integer classId1) {
        this.classId1 = classId1;
    }

    public String getClassName2() {
        return className2;
    }

    public void setClassName2(String className2) {
        this.className2 = className2 == null ? null : className2.trim();
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

    public Integer getcT() {
        return cT;
    }

    public void setcT(Integer cT) {
        this.cT = cT;
    }

    public Integer getcU() {
        return cU;
    }

    public void setcU(Integer cU) {
        this.cU = cU;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}