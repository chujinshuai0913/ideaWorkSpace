/**
 * Copyright (C), 2018-2018
 * FileName: DataResult
 * Author:   jinshuai
 * Date:     2018/5/22 10:42
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package common.util;

import java.util.HashMap;
import java.util.Map;
/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author jinshuai
 * @create 2018/5/22
 * @since 1.0.0
 */



public class DataResult<T> extends Result {

    private static final long serialVersionUID = -3148778572856143638L;
    private T data;

    public DataResult(int errorCode, T data) {
        super(errorCode);
        this.data = data;
    }

    @Override
    public Map<String, ?> toMap() {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("data", data);
        result.put("error_code", this.getErrorCode());
        return result;
    }

}