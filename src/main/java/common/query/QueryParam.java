package common.query;

import java.io.Serializable;
import java.util.List;

/**
 * Title: <br>
 * Description: <br>
 * Copyright: Copyright (c) 2017<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author :chujinshuai
 * @time :2018/4/10 14:08 星期二
 */
public class QueryParam  implements Serializable {

    private static final long serialVersionUID = 2926723122405744749L;


    private int startRecord;

    private int pageSize;

    private int pageNumber;

    private String sortName;

    private String sortOrder;


    public int getStartRecord () {
        return startRecord;
    }

    public void setStartRecord (int startRecord) {
        this.startRecord = this.pageSize * (this.pageNumber - 1);
        /*this.startRecord = startRecord;*/
    }


    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
        this.setStartRecord(0);
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
        this.setStartRecord(0);
    }

    public String getSortName() {
        return sortName;
    }

    public void setSortName(String sortName) {
        this.sortName = sortName;
    }

    public String getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(String sortOrder) {
        this.sortOrder = sortOrder;
    }

}
