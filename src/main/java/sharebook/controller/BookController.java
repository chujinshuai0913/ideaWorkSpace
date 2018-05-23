/**
 * Copyright (C), 2018-2018
 * FileName: BookController
 * Author:   jinshuai
 * Date:     2018/5/22 13:45
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package sharebook.controller;

import com.alibaba.fastjson.JSONObject;
import common.constant.ConstantsUtils;
import common.model.*;
import common.query.*;
import common.service.BookService;
import common.service.ClassTypeService;
import common.service.ShareManagerService;
import common.service.UserService;
import common.util.DataResult;
import common.util.DataResultList;
import common.util.ServiceResult;
import common.util.StringUtils;
import common.vo.BookVo;
import common.vo.ShareAnnouncementVo;
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
 * @create 2018/5/22
 * @since 1.0.0
 */
@RestController("BookController")
@RequestMapping("/bookshare")
public class BookController {
    private static  final Logger logger = Logger.getLogger(BookController.class);


    @Autowired
    private BookService bookService;

    @Autowired
    private UserService userService;

    @Autowired
    private ClassTypeService classTypeService;

    @Autowired
    private ShareManagerService shareManagerService;

    @RequestMapping(value = "/imgcycle", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, ?> imgCycle(HttpServletResponse response, @RequestBody String strJson) {

        logger.info("BookController.imgCycle------->");
        ShareAnnouncementQuery shareAnnouncementQuery=new ShareAnnouncementQuery();
        int num= ConstantsUtils.ShareAnnouncementImgNum.NUM;

        Map<String,Object> successMap = new HashMap<String,Object>();
        try{
            List<ShareAnnouncement>  shareAnnouncements=new ArrayList<>();
                int total=0;
                shareAnnouncementQuery.setPageSize(num);
                ServiceResult<List<Integer>> conRes=shareManagerService.getShareAnnouncementImgCount(shareAnnouncementQuery);
                if (conRes.getSuccess()&&conRes.getBody()!=null){
                      List<Integer> list=conRes.getBody();
                      for(int j=0;j<list.size();j++) {
                          total = total + list.get(j);
                          if(total>=num){
                              continue;
                          }
                      }
                    shareAnnouncementQuery.setPageSize(total);
                      shareAnnouncementQuery.setStartRecord(1);
                    ServiceResult<List<ShareAnnouncement>> result = shareManagerService.getShareAnnouncementImgList(shareAnnouncementQuery);
                    if(result.getSuccess()){
                        shareAnnouncements=result.getBody();
                    }
                  }
                return new DataResultList<>(0,shareAnnouncements).toMap();
        }catch(Exception e){
            logger.error("BookController.imgCycle---------->",e);
            return successMap;
        }
    }
    @RequestMapping(value = "/bookhot", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, ?> bookten(HttpServletResponse response, @RequestBody String strJson) {

        BookQuery query = new BookQuery();
        logger.info("BookController.bookhot------->"+query);
        Map<String,Object> successMap = new HashMap<String,Object>();
        try{
            BookVo books=new BookVo();
            query.setPageSize(ConstantsUtils.BookHotNum.BookHotNum);
            query.setSortName("use_num");
            query.setSortOrder("DESC");
            ServiceResult<BookVo> result = bookService.queryBookListTopTen(query);
            if(result.getSuccess()){
                books=result.getBody();
            }else{
                successMap.put("resultMassage", result.getMessage());
                return successMap;
            }
            return new DataResultList<>(0,books.getList()).toMap();

        }catch(Exception e){
            logger.error("BookController.bookhot---------->",e);
            successMap.put("resultMassage", "获取信息异常!");
            return successMap;
        }
    }
    //图书推荐
    @RequestMapping(value = "/booktop", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, ?> bookTop(HttpServletResponse response, @RequestBody String strJson) {

        BookQuery query = new BookQuery();
        logger.info("BookController.booktop------->"+query);
        Map<String,Object> successMap = new HashMap<String,Object>();
        try{
            BookVo books=new BookVo();
            query.setPageSize(ConstantsUtils.BookTop.BookTopIndexNum);
            query.setSortName("press_time");
            query.setSortOrder("DESC");
            ServiceResult<BookVo> result = bookService.queryBookListTopTen(query);
            if(result.getSuccess()){
                books=result.getBody();
            }else{
                successMap.put("resultMassage", result.getMessage());
                return successMap;
            }
            return new DataResultList<>(0,books.getList()).toMap();

        }catch(Exception e){
            logger.error("BookController.bookhot---------->",e);
            successMap.put("resultMassage", "获取信息异常!");
            return successMap;
        }
    }
    //专业图书推荐
    @RequestMapping(value = "/probooktop", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, ?> probookTop(HttpServletResponse response, @RequestBody String strJson) {
        BookQuery query = JSONObject.parseObject(strJson.trim(),BookQuery.class);
        logger.info("BookController.probooktop------->"+query);
        Map<String,Object> successMap = new HashMap<String,Object>();
        try{
            BookVo books=new BookVo();
            query.setPageSize(ConstantsUtils.BookTop.BookTopProNum);
            if(StringUtils.isNotEmpty(query.getBookTypeName2())){
                query.setBookTypeName2(query.getBookTypeName2().trim());

            }
            if(StringUtils.isNotEmpty(query.getProfessionalTypeName2())){
                query.setProfessionalTypeName2(query.getProfessionalTypeName2().trim());
            }
            query.setSortName("use_num");
            query.setSortOrder("DESC");
            ServiceResult<BookVo> result = bookService.queryBookListTopTen(query);
            if(result.getSuccess()){
                books=result.getBody();
            }else{
                successMap.put("resultMassage", result.getMessage());
                return successMap;
            }
            return new DataResultList<>(0,books.getList()).toMap();

        }catch(Exception e){
            logger.error("BookController.bookhot---------->",e);
            successMap.put("resultMassage", "获取信息异常!");
            return successMap;
        }
    }
    //图书分类
    @RequestMapping(value = "/bookclassinformation", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, ?> bookclassinformation(HttpServletResponse response, @RequestBody String strJson) {
        TypeBook1Query query = new TypeBook1Query();
        logger.info("BookController.bookclassinformation------->"+query);
        Map<String,Object> successMap = new HashMap<String,Object>();
        try{
            List<TypeBook1> list=new ArrayList<>();
            query.setPageSize(ConstantsUtils.BookClassTop.BookClass1TopNum);
            query.setSortName("c_t");
            query.setSortOrder("ASC");
            ServiceResult<List<TypeBook1>> result = classTypeService.queryTypeBook1List(query);
            if(result.getSuccess()){
                list=result.getBody();
            }else{
                successMap.put("resultMassage", result.getMessage());
                return successMap;
            }
            return new DataResultList<>(0,list).toMap();

        }catch(Exception e){
            logger.error("BookController.bookhot---------->",e);
            successMap.put("resultMassage", "获取信息异常!");
            return successMap;
        }
    }
    //图书分类
    @RequestMapping(value = "/bookclass2information", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, ?> bookclass2information(HttpServletResponse response, @RequestBody String strJson) {
        TypeBook2Query query=JSONObject.parseObject(strJson.trim(),TypeBook2Query.class);
        logger.info("BookController.bookclass2information------->"+query);
        Map<String,Object> successMap = new HashMap<String,Object>();
        try{
            List<TypeBook2> list=new ArrayList<>();
            query.setSortName("c_t");
            query.setSortOrder("ASC");
            ServiceResult<List<TypeBook2>> result = classTypeService.queryTypeBook2List(query);
            if(result.getSuccess()){
                list=result.getBody();
            }else{
                successMap.put("resultMassage", result.getMessage());
                return successMap;
            }
            return new DataResultList<>(0,list).toMap();

        }catch(Exception e){
            logger.error("BookController.bookhot---------->",e);
            successMap.put("resultMassage", "获取信息异常!");
            return successMap;
        }
    }

    //专业分类
    @RequestMapping(value = "/bookpro1information", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, ?> bookpro1information(HttpServletResponse response, @RequestBody String strJson) {
        TypeProfessional1Query query = new TypeProfessional1Query();
        logger.info("BookController.bookpro1information------->"+query);
        Map<String,Object> successMap = new HashMap<String,Object>();
        try{
            List<TypeProfessional1> list=new ArrayList<>();
            query.setPageSize(ConstantsUtils.BookClassTop.BookPro1TopNum);
            query.setSortName("c_t");
            query.setSortOrder("ASC");
            ServiceResult<List<TypeProfessional1>> result = classTypeService.queryTypeProfessional1List(query);
            if(result.getSuccess()){
                list=result.getBody();
            }else{
                successMap.put("resultMassage", result.getMessage());
                return successMap;
            }
            return new DataResultList<>(0,list).toMap();

        }catch(Exception e){
            logger.error("BookController.bookhot---------->",e);
            successMap.put("resultMassage", "获取信息异常!");
            return successMap;
        }
    }
    //图书分类
    @RequestMapping(value = "/bookpro2information", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, ?> bookpro2information(HttpServletResponse response, @RequestBody String strJson) {
        TypeProfessional2Query query = new TypeProfessional2Query();
        logger.info("BookController.bookpro2information------->"+query);
        Map<String,Object> successMap = new HashMap<String,Object>();
        try{
            List<TypeProfessional2> list=new ArrayList<>();
            query.setPageSize(ConstantsUtils.BookClassTop.BookPro2TopNum);
            query.setSortName("c_t");
            query.setSortOrder("ASC");
            ServiceResult<List<TypeProfessional2>> result = classTypeService.queryTypeProfessional2List(query);
            if(result.getSuccess()){
                list=result.getBody();
            }else{
                successMap.put("resultMassage", result.getMessage());
                return successMap;
            }
            return new DataResultList<>(0,list).toMap();

        }catch(Exception e){
            logger.error("BookController.bookhot---------->",e);
            successMap.put("resultMassage", "获取信息异常!");
            return successMap;
        }
    }
}


