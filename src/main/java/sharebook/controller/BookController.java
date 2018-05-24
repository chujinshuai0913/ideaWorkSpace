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
import common.util.*;
import common.vo.*;
import jdk.nashorn.internal.objects.annotations.Function;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Future;

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
    //专业/分类图书推荐
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
            if(query.getPreNum()>0){
                query.setPageSize(query.getPreNum());
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
  /*  //所在专业图书推荐
    @RequestMapping(value = "/proselfbooktop", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, ?> proselfbookTop(HttpServletResponse response, @RequestBody String strJson) {
        BookQuery query = JSONObject.parseObject(strJson.trim(),BookQuery.class);
        logger.info("BookController.probooktop------->"+query);
        Map<String,Object> successMap = new HashMap<String,Object>();
        try{
            BookVo books=new BookVo();
            query.setPageSize(ConstantsUtils.BookTop.BookTopProNum);
            //拿到当前user的专业
            query.setProfessionalTypeName2("");
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
*/
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
    //图书一二分类
    @RequestMapping(value = "/bookclass12information", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, ?> bookclass12information(HttpServletResponse response, @RequestBody String strJson) {
        TypeBook1Query query = new TypeBook1Query();
        logger.info("BookController.bookclass12information------->"+query);
        Map<String,Object> successMap = new HashMap<String,Object>();
        try{
            List<TypeBook1Vo> list=new ArrayList<>();
            query.setPageSize(ConstantsUtils.BookClassTop.BookClass1TopNum);
            query.setSortName("c_t");
            query.setSortOrder("ASC");
            ServiceResult<List<TypeBook1Vo>> result = classTypeService.queryTypeBook12List(query);
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
    //图书一二分类
    @RequestMapping(value = "/bookpro12information", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, ?> bookpro12information(HttpServletResponse response, @RequestBody String strJson) {
        TypeProfessional1Query query = new TypeProfessional1Query();
        logger.info("BookController.bookpro12information------->"+query);
        Map<String,Object> successMap = new HashMap<String,Object>();
        try{
            List<TypeProfessional1Vo> list=new ArrayList<>();
            query.setPageSize(ConstantsUtils.BookClassTop.BookClass1TopNum);
            query.setSortName("c_t");
            query.setSortOrder("ASC");
            ServiceResult<List<TypeProfessional1Vo>> result = classTypeService.queryTypeProfessional12List(query);
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

    //浏览历史
    @RequestMapping(value = "/searchistory", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, ?> searchistory(HttpServletResponse response, @RequestBody String strJson) {
        SearchHistory searchHistory = new SearchHistory();
        logger.info("BookController.bookclass12information------->");
        Map<String,Object> successMap = new HashMap<String,Object>();
        try{

            List<BookVo> list=new ArrayList<>();
            List<Integer> ids=new ArrayList<>();
            List<SearchHistory> searchHistoryList=new ArrayList<>();
            searchHistory.setUserId(1);

            ServiceResult<List<SearchHistory>> listServiceResult=classTypeService.getSearchHistoryList(searchHistory);
            if(listServiceResult.getSuccess()){
                searchHistoryList=listServiceResult.getBody();
                int count=ConstantsUtils.BookClassTop.BookHistoryTopNum;
                if(count>searchHistoryList.size()){
                    count=searchHistoryList.size();
                }
                for(int i=0;i<count;i++){
                    ids.add(Integer.parseInt( searchHistoryList.get(i).getBookId()));
                }
                ServiceResult<List<BookVo>> listBook=bookService.queryBookListByBookIds(ids);
                if(listBook.getSuccess()){
                    list=listBook.getBody();
                }

            }else{
                successMap.put("resultMassage", listServiceResult.getMessage());
                return successMap;
            }
            return new DataResultList<>(0,list).toMap();

        }catch(Exception e){
            logger.error("BookController.bookhot---------->",e);
            successMap.put("resultMassage", "获取信息异常!");
            return successMap;
        }
    }

    @RequestMapping(value = "/searchresult", method = RequestMethod.POST)
    public ModelAndView searchResult(String bookName,String author, Integer ISBN,String press,Integer classType) {
        logger.info("BookController.searchResult------->");
        ModelAndView mv = new ModelAndView();
        BookQuery query=new BookQuery();
        query.setBookName(bookName.trim());
        query.setIsbn(ISBN);
        query.setAuthor(author.trim());
        query.setPress(press.trim());
        if(classType==null){}
        else if(classType==1){
            query.setSellStatus(1);
        }
         else if(classType==2){
             query.setBorrowStatus(1);
        }
        else if(classType==3){
             query.setGiftStatus(1);
        }
        query.setPreNum(1);
        List<BookVo> list =new ArrayList<>();
        ServiceResult<List<BookVo>> result=bookService.queryBookList(query);
        if(result.getSuccess()&&result.getBody()!=null){
            list=result.getBody();
            mv.addObject("searchResult", list);
            mv.addObject("total",list.size());
        }else {
            mv.addObject("searchResult", "");
            mv.addObject("total",0);
        }
        mv.addObject("bookName",bookName);
        mv.addObject("ISBN",ISBN);
        mv.addObject("press",press);
        mv.addObject("author",author);
        mv.addObject("classType",classType);
        mv.setViewName("sharebook/jsp/searchResult");
        return mv;
    }
    @RequestMapping(value = "/searchresult1", method = RequestMethod.POST)
    public ModelAndView searchResult(String bookName1,Integer classType1) {
        logger.info("BookController.searchResult------->");
        ModelAndView mv = new ModelAndView();
        BookQuery query=new BookQuery();
        query.setBookName(bookName1.trim());
        if(classType1==null){}
        else if(classType1==1){
            query.setSellStatus(1);
        }
        else if(classType1==2){
            query.setBorrowStatus(1);
        }
        else if(classType1==3){
            query.setGiftStatus(1);
        }
        query.setPreNum(1);
        List<BookVo> list =new ArrayList<>();
        ServiceResult<List<BookVo>> result=bookService.queryBookList(query);
        if(result.getSuccess()&&result.getBody()!=null){
            list=result.getBody();
            mv.addObject("searchResult", list);
            mv.addObject("total",list.size());
        }else {
            mv.addObject("searchResult", "");
            mv.addObject("total",0);
        }
        mv.addObject("bookName",bookName1);
        mv.addObject("classType",classType1);
        mv.addObject("bookName1",bookName1);
        mv.addObject("classType1",classType1);
        mv.setViewName("sharebook/jsp/searchResult");
        return mv;
    }
    //分类查询
    @RequestMapping(value = "/protype", method = RequestMethod.POST)
    public ModelAndView protype(String class2Name) {
        logger.info("BookController.protype------->");
        ModelAndView mv = new ModelAndView();
        BookQuery query=new BookQuery();
        query.setProfessionalTypeName2(class2Name.trim());
        List<BookVo> list =new ArrayList<>();
        ServiceResult<List<BookVo>> result=bookService.queryBookList(query);
        if(result.getSuccess()&&result.getBody()!=null){
            list=result.getBody();
            mv.addObject("searchResult", list);
            mv.addObject("total",list.size());
        }else {
            mv.addObject("searchResult", "");
            mv.addObject("total",0);
        }
        mv.addObject("class2Name",class2Name);
        mv.setViewName("sharebook/jsp/searchResult");
        return mv;
    }
    @RequestMapping(value = "/classtype", method = RequestMethod.POST)
    public ModelAndView classtype(String class2Name) {
        logger.info("BookController.classtype------->");
        ModelAndView mv = new ModelAndView();
        BookQuery query=new BookQuery();
        query.setBookTypeName2(class2Name.trim());
        List<BookVo> list =new ArrayList<>();
        ServiceResult<List<BookVo>> result=bookService.queryBookList(query);
        if(result.getSuccess()&&result.getBody()!=null){
            list=result.getBody();
            mv.addObject("searchResult", list);
            mv.addObject("total",list.size());
        }else {
            mv.addObject("searchResult", "");
            mv.addObject("total",0);
        }
        mv.addObject("class2Name",class2Name);
        mv.setViewName("sharebook/jsp/searchResult");
        return mv;
    }

    //详情
    @RequestMapping(value = "/bookdetails", method = RequestMethod.GET)
    public ModelAndView bookdetail(int id) {
        logger.info("BookController.searchResult------->");
        ModelAndView mv = new ModelAndView();
        BookSellingQuery query=new BookSellingQuery();
        BookVo bookVo =new BookVo();
        BookSellingVo bookSellingVo =new BookSellingVo();
        List<BookSellingVo> bookSellingVos =new ArrayList<>();
        query.setSkuId(id);
        query.setSortName("use_num");
        query.setSortOrder("desc");
        ServiceResult<BookVo> result=bookService.queryBookByBookId(id);
        if(result.getSuccess()&&result.getBody()!=null){
            bookVo=result.getBody();
            query.setStatus(ConstantsUtils.BookAuditCode.AUDIT);
            ServiceResult<List<BookSellingVo>> serviceResult=bookService.queryBookSellingVoList(query);
            int flag=0;
            if(serviceResult.getSuccess()&&serviceResult.getBody().size()>0){
                 bookSellingVos=serviceResult.getBody();
                 for (BookSellingVo bookSellingVo1:bookSellingVos){
                     if(bookSellingVo1.getSelfStatus()==ConstantsUtils.UserShareCode.USER_SELF_STATUS)
                     {
                         bookVo.setBookSellingVo(bookSellingVo1);
                         bookVo.setSelfStatus(ConstantsUtils.SelfBook.SELF);
                         flag=1;
                         continue;
                     }
                 }
                 if(flag==0){
                     bookVo.setBookSellingVo(bookSellingVos.get(0));
                     bookVo.setSelfStatus(ConstantsUtils.SelfBook.NOT_SELF);
                 }
            }
            mv.addObject("bookVo", bookVo);
        }else {
            mv.addObject("bookVo", "");
        }
        mv.setViewName("sharebook/jsp/bookdetails");
        return mv;
    }



    /***
     *
     * @param response
     * @param strJson
     * @return
     */
    //个人图书详情
    @RequestMapping(value = "/bookuserdetails", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, ?> bookuserdetails(HttpServletResponse response, @RequestBody String strJson) {
        logger.info("BookController.bookuserdetails---------->"+strJson);
        BookQuery query = JSONObject.parseObject(strJson,BookQuery.class);
        BookSellingQuery sellingQuery=new BookSellingQuery();
        BookBorrowQuery bookBorrowQuery=new BookBorrowQuery();
        BookAuctionQuery bookAuctionQuery=new BookAuctionQuery();
        BookGiftRecQuery giftRecQuery=new BookGiftRecQuery();
        Map<String,Object> successMap = new HashMap<String,Object>();
        try{
            ListResult results=null;
            //买卖书籍
            if (query.getPageNum()==1) {
                sellingQuery.setSkuId(query.getId());
                ServiceResult<Integer> countRes = bookService.queryBookSellingCount(sellingQuery);
                List<BookSellingVo> list  = new ArrayList<BookSellingVo>();
                long total = 0;
                if(countRes.getSuccess()  && countRes.getBody() > 0){
                    total = countRes.getBody();
                    sellingQuery.setSortName("use_num");
                    sellingQuery.setSortOrder("desc");
                    ServiceResult<List<BookSellingVo>> result = bookService.queryBookSellingVoList(sellingQuery);
                    if(result.getSuccess()){
                        list = result.getBody();
                    }else{
                        successMap.put("resultMassage", result.getMessage());//"获取书籍信息异常，请稍后重试!");
                        return successMap;
                    }
                }
                results = new ListResult(0, total, query.getPageSize(), query.getPageNumber(), list);
            }

            return results.toMap();
        }catch(Exception e){
            logger.error("BookController.bookuserdetails---------->",e);
            successMap.put("resultMassage", "获取书籍信息异常，请稍后重试!");
            return successMap;
        }
    }

}


