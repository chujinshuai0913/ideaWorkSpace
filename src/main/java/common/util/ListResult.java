package common.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Title: <br>
 * Description: <br>
 * Copyright: Copyright (c) 2017<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author :chujinshuai
 * @time :2018/4/14 10:36 星期六
 */
public class ListResult extends Result {
    private long totalRecords;
    private int recoredsPerPage;
    private int currentPage;
    private List<?> data;

    public ListResult(int errorCode, long totalRecords, int recoredsPerPage, int currentPage, List<?> data) {
        super(errorCode);
        this.totalRecords = totalRecords;
        this.recoredsPerPage = recoredsPerPage;
        this.currentPage = currentPage;
        this.data = data;
    }

    public long getTotalRecords() {
        return this.totalRecords;
    }

    public void setTotalRecords(long totalRecords) {
        this.totalRecords = totalRecords;
    }

    public int getRecoredsPerPage() {
        return this.recoredsPerPage;
    }

    public void setRecoredsPerPage(int recoredsPerPage) {
        this.recoredsPerPage = recoredsPerPage;
    }

    public int getCurrentPage() {
        return this.currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public List<?> getData() {
        return this.data;
    }

    public void setData(List<?> data) {
        this.data = data;
    }

    public Map<String, ?> toMap() {
        Map<String, Object> result = new HashMap();
        result.put("error_code", this.getErrorCode());
        result.put("total_records", this.getTotalRecords());
        result.put("recoreds_perpage", this.getRecoredsPerPage());
        result.put("current_page", this.getCurrentPage());
        result.put("data", this.data);
        return result;
    }
}


