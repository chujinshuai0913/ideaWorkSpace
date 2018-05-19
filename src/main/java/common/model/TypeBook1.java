package common.model;

import common.query.QueryParam;

import java.io.Serializable;

public class TypeBook1 extends QueryParam implements Serializable{
    private Integer id;

    private String className1;

    private Integer printUser;

    private Integer printTime;

    private Integer importUser;

    private Integer importTime;

    private Integer exportUser;

    private Integer exportTime;

    private Integer cT;

    private Integer cU;

    private Integer status;

    public TypeBook1(Integer id, String className1, Integer printUser, Integer printTime, Integer importUser, Integer importTime, Integer exportUser, Integer exportTime, Integer cT, Integer cU, Integer status) {
        this.id = id;
        this.className1 = className1;
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

    public TypeBook1() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getClassName1() {
        return className1;
    }

    public void setClassName1(String className1) {
        this.className1 = className1 == null ? null : className1.trim();
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