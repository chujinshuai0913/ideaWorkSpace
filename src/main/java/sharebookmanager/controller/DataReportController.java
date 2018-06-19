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
import common.constant.ConstantsUtils;
import common.model.UserManagerLogin;
import common.query.BookQuery;
import common.service.BookService;
import common.service.UserService;
import common.util.DataResult;
import common.util.ServiceResult;
import common.vo.BookVo;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
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
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/bookten1", method = RequestMethod.GET)
    public ModelAndView bookten1() {
        logger.info("DataReportController.bookten1------->");
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        HttpSession session = request.getSession();
        //用户
        UserManagerLogin userManagerLogin=(UserManagerLogin)session.getAttribute("userManagerLogin");
        String uri="";
        if(userManagerLogin==null){
            return new ModelAndView(request.getContextPath()+"/sso/sharemanager/login.jsp");
        }
        String url=request.getServletPath();
        int count=userService.isTrue(url,userManagerLogin.getRoleId());
        if(count<1){
            return new ModelAndView("redirect:/sso/ssono/no_per.jsp");
        }
        return new ModelAndView("redirect:/sharebookmanager/jsp/booktenstatistics.jsp");

    }
    @RequestMapping(value = "/bookten", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, ?> bookten(HttpServletResponse response, @RequestBody String strJson) {

        BookQuery query = JSONObject.parseObject(strJson,BookQuery.class);
        logger.info("DataReportController.bookten------->"+query);
        query.setPageSize(ConstantsUtils.BookTop.BookTopNum);
        query.setSortName("use_num");
        query.setSortOrder("DESC");
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
