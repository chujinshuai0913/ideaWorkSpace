/**
 * Copyright (C), 2018-2018
 * FileName: DataReportController
 * Author:   jinshuai
 * Date:     2018/5/21 23:07
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package sharebookmanager.controller;

import com.alibaba.fastjson.JSONObject;
import common.model.Book;
import common.query.BookQuery;
import common.service.BookService;
import common.util.DataResult;
import common.util.ServiceResult;
import common.vo.BookVo;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author jinshuai
 * @create 2018/5/21
 * @since 1.0.0
 */
@RestController("DataReportController")
@RequestMapping("/dataReport")

public class DataReportController {

    private static  final Logger logger = Logger.getLogger(DataReportController.class);
    @Autowired
    private BookService bookService;

    /***
     *查询指标事件规则
     * @param response
     * @param strJson
     * @return
     */
    @RequestMapping(value = "/bookten", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, ?> bookten(HttpServletResponse response, @RequestBody String strJson) {

        BookQuery query = JSONObject.parseObject(strJson,BookQuery.class);
        logger.info("DataReportController.bookten------->"+query);

        Map<String,Object> successMap = new HashMap<String,Object>();
        try{
            BookVo books=new BookVo();
            ServiceResult<BookVo> result = bookService.queryBookListTopTen(query);
            if(result.getSuccess()){
                books=result.getBody();
            }else{
                successMap.put("resultMassage", result.getMessage());
                return successMap;
            }
//          for(int i=0;i<100;i++){
//                query.setUseNum(i*100+3*(i-10));
//                query.setBookName(i+100+"_");
//             bookService.insertBook(query);
//           }
            return new DataResult<>(0,books).toMap();

        }catch(Exception e){
            logger.error("EventQuotaController.listData---------->",e);
            successMap.put("resultMassage", "获取指标信息异常!");
            return successMap;
        }
    }

}
