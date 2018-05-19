package common.util;

import java.io.Serializable;
import java.util.Map;

/**
 * Title: <br>
 * Description: <br>
 * Copyright: Copyright (c) 2017<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author :chujinshuai
 * @time :2018/4/14 10:37 星期六
 */

public abstract class Result implements Serializable {
    private int errorCode;

    public Result(int errorCode) {
        this.errorCode = errorCode;
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public abstract Map<String, ?> toMap();
}
