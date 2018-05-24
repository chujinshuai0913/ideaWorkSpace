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

import com.sun.scenario.effect.impl.prism.PrImage;
import common.model.TypeProfessional1;
import common.model.TypeProfessional2;
import common.query.QueryParam;

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
public class TypeProfessional1Vo extends TypeProfessional1 implements Serializable {
    private String cUser;

    private String cTime;

    private List<TypeProfessional2> list;

    public List<TypeProfessional2> getList() {
        return list;
    }

    public void setList(List<TypeProfessional2> list) {
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
