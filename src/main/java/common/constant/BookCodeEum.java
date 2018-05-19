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
public enum BookCodeEum implements Serializable {
    AUDIT(ConstantsUtils.BookAuditCode.AUDIT,"已审核"),
    AUDIT_NOT(ConstantsUtils.BookAuditCode.AUDIT_NOT,"未审核"),
    STOP(ConstantsUtils.BookAuditCode.STOP,"禁卖");
    private int code;
    private String name;

    BookCodeEum(int code, String name){
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

