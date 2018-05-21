/**
 * Copyright (C), 2018-2018
 * FileName: TypeProfessional1Query
 * Author:   jinshuai
 * Date:     2018/5/20 9:55
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package common.vo;

import common.model.TypeProfessional2;

import java.io.Serializable;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author jinshuai
 * @create 2018/5/20
 * @since 1.0.0
 */
public class TypeProfessional2Vo extends TypeProfessional2 implements Serializable {
    private String cUser;

    private String cTime;

    public String getcUser() {
        return cUser;
    }

    public void setcUser(String cUser) {
        this.cUser = cUser;
    }

    public String getcTime() {
        return cTime;
    }

    public void setcTime(String cTime) {
        this.cTime = cTime;
    }
}
