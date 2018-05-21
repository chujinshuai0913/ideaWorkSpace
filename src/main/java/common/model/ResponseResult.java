/**
 * Copyright (C), 2018-2018
 * FileName: ResponseResult
 * Author:   jinshuai
 * Date:     2018/5/21 19:01
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package common.model;

import java.util.Map;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author jinshuai
 * @create 2018/5/21
 * @since 1.0.0
 */
public class ResponseResult {

        private Integer code;

        private String message;

        private Map<String, Object> result;

        public Integer getCode() {
            return this.code;
        }

        public void setCode(Integer code) {
            this.code = code;
        }

        public String getMessage() {
            return this.message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public Map<String, Object> getResult() {
            return this.result;
        }

        public void setResult(Map<String, Object> result) {
            this.result = result;
        }

        private static ResponseResult responseResult;
        /**
         * 返回结果
         * @param code
         * @param message
         * @param map
         * @return
         */
        public static ResponseResult result(int code, String message, Map<String, Object> map){
            responseResult = new ResponseResult();
            responseResult.setCode(code);
            responseResult.setMessage(message);
            responseResult.setResult(map);
            return responseResult;
        }

        public static ResponseResult result(int code, String message){
            responseResult = new ResponseResult();
            responseResult.setCode(code);
            responseResult.setMessage(message);
            return responseResult;
        }

        public ResponseResult() {}

    }
