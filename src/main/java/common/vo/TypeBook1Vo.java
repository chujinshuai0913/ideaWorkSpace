/**
 * Copyright (C), 2018-2018
 * FileName: TypeBook1Vo
 * Author:   jinshuai
 * Date:     2018/5/20 15:30
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package common.vo;

import common.model.TypeBook1;
import common.model.TypeBook2;

import java.io.Serializable;
import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author jinshuai
 * @create 2018/5/20
 * @since 1.0.0
 */
public class TypeBook1Vo extends TypeBook1 implements Serializable  {

    private String cUser;

    private String cTime;

    private List<TypeBook2> list;

    public List<TypeBook2> getList() {
        return list;
    }

    public void setList(List<TypeBook2> list) {
        this.list = list;
    }

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
