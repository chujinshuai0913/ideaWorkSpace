/**
 * Copyright (C), 2018-2018
 * FileName: StudenteacherVo
 * Author:   jinshuai
 * Date:     2018/5/19 20:19
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package common.vo;

import common.model.StudentTeacherList;
import common.model.UserManager;

import java.io.Serializable;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author jinshuai
 * @create 2018/5/19
 * @since 1.0.0
 */
public class StudenteacherVo  extends StudentTeacherList implements Serializable {

    private String strT;

    public String getStrT() {
        return strT;
    }

    public void setStrT(String strT) {
        this.strT = strT;
    }
}
