package common.constant;

import java.io.Serializable;

/**
 * Title: <br>
 * Description: <br>
 * Copyright: Copyright (c) 2017<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author :chujinshuai
 * @time :2018/4/14 12:19 星期六
 */
public enum UserShareCodeEum implements Serializable {
    STAUS(ConstantsUtils.UserShareCode.STATUS,"可用"),
    STATUS_NOT(ConstantsUtils.UserShareCode.STATUS_NOT,"不可用");

    private int code;
    private String name;

    UserShareCodeEum(int code, String name){
        this.code = code;
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
}

