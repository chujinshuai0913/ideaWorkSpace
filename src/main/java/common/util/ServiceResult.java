package common.util;

import java.io.Serializable;

/**
 * Title: <br>
 * Description: <br>
 * Copyright: Copyright (c) 2017<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author :chujinshuai
 * @time :2018/4/13 23:41 星期五
 */
public class ServiceResult<T> implements Serializable {
    private Boolean success = true;
    private int errorCode;
    private String message;
    private T body;

    public ServiceResult() {
    }

    public ServiceResult(T body) {
        this.body = body;
    }

    public ServiceResult(int errorCode, String message) {
        this.success = false;
        this.errorCode = errorCode;
        this.message = message;
    }

    public Boolean getSuccess() {
        return this.success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getBody() {
        return this.body;
    }

    public void setBody(T body) {
        this.body = body;
    }
}
