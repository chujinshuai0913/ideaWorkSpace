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
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.util.*;
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

    //点击图书分类查询
    @RequestMapping(value = "/classsearchresult", method = RequestMethod.POST)
    public ModelAndView classsearchresult( String bookNameClass,String authorClass,String pressClass,Long ISBNClass,String bookTypeName2) {
        logger.info("BookController.classsearchresult------->");
        ModelAndView mv = new ModelAndView();
        BookQuery query = new BookQuery();
        List<BookVo> list =new ArrayList<>();
        query.setPreNum(1);
        query.setBookName(bookNameClass);
        query.setAuthor(authorClass);
        query.setPress(pressClass);
        query.setIsbn(ISBNClass);
        query.setBookTypeName2(bookTypeName2);
        ServiceResult<List<BookVo>> result=bookService.queryBookList(query);
        if(result.getSuccess()&&result.getBody()!=null){
            list=result.getBody();
            if(list.size()>0) {
                mv.addObject("searchResult", list);
                mv.addObject("bookTypeName2", list.get(0).getBookTypeName2());
                mv.addObject("bookTypeName1", list.get(0).getBookTypeName1());
                mv.addObject("total", list.size());
            }
        }else {
            mv.addObject("searchResult", "");
            mv.addObject("total",0);
        }

        mv.addObject("bookNameClass",query.getBookName());

        mv.addObject("ISBNClass",query.getIsbn());
        mv.addObject("authorClass",query.getAuthor());
        mv.addObject("pressClass",query.getPress());
        mv.setViewName("sharebook/jsp/bookClassResult");
        return mv;
    }
    @RequestMapping(value = "/classResult", method = RequestMethod.GET)
    public ModelAndView classResult(String bookTypeName2) {
        logger.info("BookController.classResult------->");
        ModelAndView mv = new ModelAndView();
        BookQuery query = new BookQuery();
        List<BookVo> list =new ArrayList<>();
        query.setPreNum(1);
        if(bookTypeName2!=null){
            if(StringUtils.isNotEmpty(bookTypeName2.trim())){
                query.setBookTypeName2(bookTypeName2.trim());

            }
        }
        ServiceResult<List<BookVo>> result=bookService.queryBookList(query);
        if(result.getSuccess()&&result.getBody()!=null){
            list=result.getBody();
            if(list.size()>0) {
                mv.addObject("searchResult", list);
                mv.addObject("bookTypeName2", list.get(0).getBookTypeName2());
                mv.addObject("bookTypeName1", list.get(0).getBookTypeName1());
                mv.addObject("total", list.size());
            }
        }else {
            mv.addObject("searchResult", "");
            mv.addObject("total",0);
        }
        mv.setViewName("sharebook/jsp/bookClassResult");
        return mv;
    }
    //点击专业分类查询
    @RequestMapping(value = "/prosearchresult", method = RequestMethod.POST)
    public ModelAndView prosearchresult( String bookNameClass,String authorClass,String pressClass,Long ISBNClass,String professionalTypeName2) {
        logger.info("BookController.prosearchresult------->");
        ModelAndView mv = new ModelAndView();
        BookQuery query = new BookQuery();
        List<BookVo> list =new ArrayList<>();
        query.setPreNum(1);
        query.setBookName(bookNameClass);
        query.setAuthor(authorClass);
        query.setPress(pressClass);
        query.setIsbn(ISBNClass);
        query.setProfessionalTypeName2(professionalTypeName2);
        ServiceResult<List<BookVo>> result=bookService.queryBookList(query);
        if(result.getSuccess()&&result.getBody()!=null){
            list=result.getBody();
            if(list.size()>0) {
                mv.addObject("searchResult", list);
                mv.addObject("professionalTypeName2", list.get(0).getProfessionalTypeName2());
                mv.addObject("professionalTypeName1", list.get(0).getProfessionalTypeName1());
                mv.addObject("total", list.size());
            }
        }else {
            mv.addObject("searchResult", "");
            mv.addObject("total",0);
        }

        mv.addObject("bookNameClass",query.getBookName());

        mv.addObject("ISBNClass",query.getIsbn());
        mv.addObject("authorClass",query.getAuthor());
        mv.addObject("pressClass",query.getPress());
        mv.setViewName("sharebook/jsp/bookProResult");
        return mv;
    }
    @RequestMapping(value = "/proResult", method = RequestMethod.GET)
    public ModelAndView proResult(String professionalTypeName2) {
        logger.info("BookController.proResult------->");
        ModelAndView mv = new ModelAndView();
        BookQuery query = new BookQuery();
        List<BookVo> list =new ArrayList<>();
        query.setPreNum(1);
        if(professionalTypeName2!=null){
            if(StringUtils.isNotEmpty(professionalTypeName2.trim())){
                query.setProfessionalTypeName2(professionalTypeName2.trim());
            }
        }
        ServiceResult<List<BookVo>> result=bookService.queryBookList(query);
        if(result.getSuccess()&&result.getBody()!=null){
            list=result.getBody();
            if(list.size()>0) {
                mv.addObject("searchResult", list);
                mv.addObject("professionalTypeName2", list.get(0).getProfessionalTypeName2());
                mv.addObject("professionalTypeName1", list.get(0).getProfessionalTypeName1());
                mv.addObject("total", list.size());
            }
        }else {
            mv.addObject("searchResult", "");
            mv.addObject("total",0);
        }
        mv.setViewName("sharebook/jsp/bookProResult");
        return mv;
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
    public ModelAndView searchResult(String bookName,String author, Long ISBN,String press,Integer classType) {
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
                Iterator<BookSellingVo> it = bookSellingVos.iterator();
                while(it.hasNext()){
                    BookSellingVo bookSellingVo = it.next();
                    if(bookSellingVo.getSelfStatus()==ConstantsUtils.UserShareCode.STATUS_NOT){
                        it.remove();
                    }
                }
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
                    if(bookSellingVos.size()>0) {
                        bookVo.setBookSellingVo(bookSellingVos.get(0));
                        bookVo.setSelfStatus(ConstantsUtils.SelfBook.NOT_SELF);
                    }
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
    //图书售卖人详情
    @RequestMapping(value = "/bookuserdetails", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, ?> bookuserdetails(HttpServletResponse response, @RequestBody String strJson) {
        logger.info("BookController.bookuserdetails---------->"+strJson);
        BookQuery query = JSONObject.parseObject(strJson,BookQuery.class);
        BookSellingQuery sellingQuery=new BookSellingQuery();
        BookBorrowQuery bookBorrowQuery=new BookBorrowQuery();
        BookAuctionQuery bookAuctionQuery=new BookAuctionQuery();
        BookGiftQuery giftQuery=new BookGiftQuery();
        Map<String,Object> successMap = new HashMap<String,Object>();
        try{
            ListResult results=null;
            //买卖书籍
            if (query.getPageNum()==1){
                sellingQuery.setSkuId(query.getId());
                sellingQuery.setUseNum(1);
                sellingQuery.setStatus(ConstantsUtils.BookAuditCode.AUDIT);
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
                        Iterator<BookSellingVo> it = list.iterator();
                        while(it.hasNext()){
                            BookSellingVo bookSellingVo = it.next();
                            if(bookSellingVo.getSelfStatus()==ConstantsUtils.UserShareCode.STATUS_NOT){
                                total=total-1;
                                it.remove();
                            }
                        }
                    }else{
                        successMap.put("resultMassage", result.getMessage());//"获取书籍信息异常，请稍后重试!");
                        return successMap;
                    }
                }
                results = new ListResult(0, total, query.getPageSize(), query.getPageNumber(), list);
            }
            //租借
            if (query.getPageNum()==2) {
                bookBorrowQuery.setSkuId(query.getId());
                bookBorrowQuery.setUseNum(1);
                bookBorrowQuery.setStatus(ConstantsUtils.BookAuditCode.AUDIT);
                ServiceResult<Integer> countRes = bookService.queryBookBorrowCount(bookBorrowQuery);
                List<BookBorrowVo> list  = new ArrayList<BookBorrowVo>();
                long total = 0;
                if(countRes.getSuccess()  && countRes.getBody() > 0){
                    total = countRes.getBody();
                    bookBorrowQuery.setSortName("use_num");
                    bookBorrowQuery.setSortOrder("desc");
                    ServiceResult<List<BookBorrowVo>> result = bookService.queryBookBorrowVoList(bookBorrowQuery);
                    if(result.getSuccess()){
                        list = result.getBody();
                        Iterator<BookBorrowVo> it = list.iterator();
                        while(it.hasNext()){
                            BookBorrowVo bookBorrowVo = it.next();
                            if(bookBorrowVo.getSelfStatus()==ConstantsUtils.UserShareCode.STATUS_NOT){
                                total=total-1;
                                it.remove();
                            }
                        }
                    }else{
                        successMap.put("resultMassage", result.getMessage());//"获取书籍信息异常，请稍后重试!");
                        return successMap;
                    }
                }
                results = new ListResult(0, total, query.getPageSize(), query.getPageNumber(), list);
            }
            //赠予
            if (query.getPageNum()==3) {
                giftQuery.setSkuId(query.getId());
                giftQuery.setUseNum(1);
                giftQuery.setStatus(ConstantsUtils.BookAuditCode.AUDIT);
                ServiceResult<Integer> countRes = bookService.queryBookGiftCount(giftQuery);
                List<BookGiftVo> list  = new ArrayList<BookGiftVo>();
                long total = 0;
                if(countRes.getSuccess()  && countRes.getBody() > 0){
                    total = countRes.getBody();
                    giftQuery.setSortName("use_num");
                    giftQuery.setSortOrder("desc");
                    ServiceResult<List<BookGiftVo>> result = bookService.queryBookBookGiftVoList(giftQuery);
                    if(result.getSuccess()){
                        list = result.getBody();
                        Iterator<BookGiftVo> it = list.iterator();
                        while(it.hasNext()){
                            BookGiftVo bookGiftVo = it.next();
                            if(bookGiftVo.getSelfStatus()==ConstantsUtils.UserShareCode.STATUS_NOT){
                                total=total-1;
                                it.remove();
                            }
                        }
                    }else{
                        successMap.put("resultMassage", result.getMessage());//"获取书籍信息异常，请稍后重试!");
                        return successMap;
                    }
                }
                results = new ListResult(0, total, query.getPageSize(), query.getPageNumber(), list);
            }
            //竞拍
            if (query.getPageNum()==4) {
                bookAuctionQuery.setBookId(query.getId());
                bookAuctionQuery.setEndTime(DateUtils.getNowTimeStamp());
                bookAuctionQuery.setStatus(ConstantsUtils.BookAuditCode.AUDIT);
                ServiceResult<Integer> countRes = bookService.queryBookAuctionCount(bookAuctionQuery);
                List<BookAuctionVo> list  = new ArrayList<BookAuctionVo>();
                long total = 0;
                if(countRes.getSuccess()  && countRes.getBody() > 0){
                    total = countRes.getBody();
                    bookAuctionQuery.setSortName("end_time");
                    bookAuctionQuery.setSortOrder("asc");
                    ServiceResult<List<BookAuctionVo>> result = bookService.queryBookAutionVoList(bookAuctionQuery);
                    if(result.getSuccess()){
                        list = result.getBody();
                        Iterator<BookAuctionVo> it = list.iterator();
                        while(it.hasNext()){
                            BookAuctionVo bookAuctionVo = it.next();
                            if(bookAuctionVo.getSelfStatus()==ConstantsUtils.UserShareCode.STATUS_NOT){
                                total=total-1;
                                it.remove();
                            }
                        }
                    }else{
                        successMap.put("resultMassage", result.getMessage());//"获取书籍信息异常，请稍后重试!");
                        return successMap;
                    }
                }
                results = new ListResult(0, total, query.getPageSize(), query.getPageNumber(), list);  }
            return results.toMap();
        }catch(Exception e){
            logger.error("BookController.bookuserdetails---------->",e);
            successMap.put("resultMassage", "获取书籍信息异常，请稍后重试!");
            return successMap;
        }
    }

    //个人图书详情
    @RequestMapping(value = "/bookselldetail", method = RequestMethod.GET)
    public ModelAndView bookselldetail(int id) {
        logger.info("BookController.bookselldetail------->");
        ModelAndView mv = new ModelAndView();
        BookSellingQuery query=new BookSellingQuery();
        query.setId(id);
        query.setStatus(ConstantsUtils.BookAuditCode.AUDIT);
        ServiceResult<BookSellingVo> serviceResult=bookService.selectSellByPrimaryKey(query);
        if(serviceResult.getSuccess()&&serviceResult.getBody()!=null){
                mv.addObject("bookSellingVo", serviceResult.getBody());
        }else {
            mv.addObject("bookSellingVo", "");
        }
          mv.setViewName("sharebook/jsp/bookselldetail");
        return mv;
    }
    //个人图书详情
    @RequestMapping(value = "/bookborrowdetail", method = RequestMethod.GET)
    public ModelAndView bookborrowdetail(int id) {
        logger.info("BookController.bookborrowdetail------->");
        ModelAndView mv = new ModelAndView();
        BookBorrowQuery query=new BookBorrowQuery();
        query.setId(id);
        query.setStatus(ConstantsUtils.BookAuditCode.AUDIT);
        ServiceResult<BookBorrowVo> serviceResult=bookService.selectBorrowByPrimaryKey(query);
        if(serviceResult.getSuccess()&&serviceResult.getBody()!=null){
            mv.addObject("bookBorrowVo", serviceResult.getBody());
        }else {
            mv.addObject("bookBorrowVo", "");
        }
          mv.setViewName("sharebook/jsp/bookborrowdetail");
        return mv;
    }
    //个人图书详情
    @RequestMapping(value = "/bookgiftdetail", method = RequestMethod.GET)
    public ModelAndView bookgiftdetail(int id) {
        logger.info("BookController.bookgiftdetail------->");
        ModelAndView mv = new ModelAndView();
        BookGiftQuery query=new BookGiftQuery();
        query.setId(id);
        query.setStatus(ConstantsUtils.BookAuditCode.AUDIT);
        ServiceResult<BookGiftVo> serviceResult=bookService.selectGiftByPrimaryKey(query);
        if(serviceResult.getSuccess()&&serviceResult.getBody()!=null){
            mv.addObject("bookGiftVo", serviceResult.getBody());
        }else {
            mv.addObject("bookGiftVo", "");
        }
         mv.setViewName("sharebook/jsp/bookgiftdetail");
        return mv;
    }

    //个人图书详情
    @RequestMapping(value = "/bookauctiondetail", method = RequestMethod.GET)
    public ModelAndView bookauctiondetail(int id) {
        logger.info("BookController.bookauctiondetail------->");
        ModelAndView mv = new ModelAndView();
        BookAuctionQuery query=new BookAuctionQuery();
        query.setId(id);
        query.setStatus(ConstantsUtils.BookAuditCode.AUDIT);
        ServiceResult<BookAuctionVo> serviceResult=bookService.selectAuctionByPrimaryKey(query);
        if(serviceResult.getSuccess()&&serviceResult.getBody()!=null){
            mv.addObject("bookAuctionVo", serviceResult.getBody());
        }else {
            mv.addObject("bookAuctionVo", "");
        }
        //  mv.setViewName("sharebook/jsp/bookauctiondetail");
        return mv;
    }
    //用户所在专业书籍推荐
    @RequestMapping(value = "/bookuserselftop", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, ?> bookuserselftop(HttpServletResponse response, @RequestBody String strJson) {
        BookQuery query = new BookQuery();
        logger.info("BookController.bookuserselftop------->"+query);
        Map<String,Object> successMap = new HashMap<String,Object>();
        try{
            BookVo books=new BookVo();
            query.setPageSize(ConstantsUtils.BookTop.BookDetailTopProNum);
            //获取当前用户所在专业
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
    //加入书箱
    @RequestMapping(value = "/insertBookCat", method = RequestMethod.POST)
    @ResponseBody
    @Transactional
    public Map<String, ?> insertBookCat(HttpServletResponse response, @RequestBody String strJson) {
        CatQuery query = JSONObject.parseObject(strJson,CatQuery.class);
        logger.info("BookController.insertBookCat------->"+query);
        RecordSellingQuery sellingQuery=new RecordSellingQuery();
        RecordBorrowQuery bookBorrowQuery=new RecordBorrowQuery();
        RecordAuctionQuery bookAuctionQuery=new RecordAuctionQuery();
        RecordGiftQuery giftQuery=new RecordGiftQuery();
        Map<String,Object> successMap = new HashMap<String,Object>();

        UserLogin userLogin=new UserLogin();
        userLogin.setUserId(1);
        try{
            ListResult results=null;
          /*  if(query.getUserId()==userLogin.getUserId()){
                results = new ListResult(1, 0, query.getPageSize(), query.getPageNumber(), new ArrayList<>());
            }*/
            //买卖书籍
            if (query.getStatus()==1) {
                sellingQuery.setSellingId(query.getBookId());
                sellingQuery.setBuyer(query.getUserId());
                sellingQuery.setTotal(query.getNum());
                sellingQuery.setStatus(ConstantsUtils.BookTradeCode.TRADE);
                sellingQuery.setPriceunit("元");
                sellingQuery.setOrderTime(DateUtils.getNowTimeStamp());
                sellingQuery.setCompleteTime(DateUtils.getNowTimeStamp());
                if(query.getPrice()!=null){
                    sellingQuery.setTotalPrice(query.getPrice().multiply(new BigDecimal(query.getNum())));
                }
                ServiceResult<Integer> countRes = bookService.insertRSellBook(sellingQuery);
                if(countRes.getSuccess()  && countRes.getBody() > 0) {
                    BookQuery bookQuery=new BookQuery();
                    bookQuery.setPreNum(query.getNum());
                    bookQuery.setId(query.getBookFatherId());
                    bookService.upateBookUserNumRed(bookQuery);
                    BookSellingQuery bookSellingQuery=new BookSellingQuery();
                    bookSellingQuery.setPreNum(query.getNum());
                    bookSellingQuery.setId(query.getBookId());
                    bookService.upateBookSellUserNumRed(bookSellingQuery);
                    results = new ListResult(0, 0, query.getPageSize(), query.getPageNumber(), new ArrayList<>());
                }
            }
            //租借书籍
            if (query.getStatus()==2) {
                bookBorrowQuery.setUserId(query.getUserId());
                bookBorrowQuery.setAuctionId(query.getBookId());
                bookBorrowQuery.setNum(query.getNum());
                bookBorrowQuery.setStartTime(DateUtils.getNowTimeStamp());
                //最长借阅30天
                bookBorrowQuery.setEndTime(DateUtils.getPreDayBy(bookBorrowQuery.getStartTime(),ConstantsUtils.BookBorrowDate.BookBorrowLongDate));
                bookBorrowQuery.setPricingunit("元");
                if(query.getPrice()!=null){
                    bookBorrowQuery.setTotalDeposit(query.getPrice().multiply(new BigDecimal(query.getNum())));
                }
                ServiceResult<Integer> countRes = bookService.insertRBorrowBook(bookBorrowQuery);
                if(countRes.getSuccess()  && countRes.getBody() > 0) {
                    BookQuery bookQuery=new BookQuery();
                    bookQuery.setPreNum(query.getNum());
                    bookQuery.setId(query.getBookFatherId());
                    bookService.upateBookUserNumRed(bookQuery);
                    BookBorrowQuery borrowQuery=new BookBorrowQuery();
                    borrowQuery.setPreNum(query.getNum());
                    borrowQuery.setId(query.getBookId());
                    bookService.upateBookBorrowUserNumRed(borrowQuery);
                    results = new ListResult(0, 0, query.getPageSize(), query.getPageNumber(), new ArrayList<>());
                }
            }
            //赠予
            if (query.getStatus()==3) {
                giftQuery.setBuyer(query.getUserId());
                giftQuery.setSellingId(query.getBookId());
                giftQuery.setTotal(query.getNum());
                giftQuery.setOrderTime(DateUtils.getNowTimeStamp());
                giftQuery.setCompleteTime(DateUtils.getNowTimeStamp());
                giftQuery.setStatus(ConstantsUtils.BookTradeCode.TRADE);
                ServiceResult<Integer> countRes = bookService.insertRGiftBook(giftQuery);
                if(countRes.getSuccess()  && countRes.getBody() > 0) {
                    BookQuery bookQuery=new BookQuery();
                    bookQuery.setPreNum(query.getNum());
                    bookQuery.setId(query.getBookFatherId());
                    bookService.upateBookUserNumRed(bookQuery);
                    BookGiftQuery bookGiftQuery=new BookGiftQuery();
                    bookGiftQuery.setPreNum(query.getNum());
                    bookGiftQuery.setId(query.getBookId());
                    bookService.upateBookGiftUserNumRed(bookGiftQuery);
                    results = new ListResult(0, 0, query.getPageSize(), query.getPageNumber(), new ArrayList<>());
                }
            }
            //竞拍
            if (query.getStatus()==2) {

            }
            return results.toMap();
        }catch(Exception e){
            logger.error("BookController.bookuserdetails---------->",e);
            successMap.put("resultMassage", "获取书籍信息异常，请稍后重试!");
            return successMap;
        }
    }

    /***
     *
     * @param response
     * @param strJson
     * @return
     */
    //我的书箱
    @RequestMapping(value = "/mycatselldetail", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, ?> mysellcatdetail(HttpServletResponse response, @RequestBody String strJson) {
        logger.info("BookController.mycatselldetail---------->"+strJson);
        //获取登入用户的id
        int userId=1;
        RecordSellingQuery query=JSONObject.parseObject(strJson,RecordSellingQuery.class);
        Map<String,Object> successMap = new HashMap<String,Object>();
        try{
            //买卖书籍
            query.setBuyer(userId);
                ServiceResult<Integer> countRes = bookService.getRecordsellingCount(query);
                List<RecordSellingVo> list = new ArrayList<>();
                long total = 0;
                if (countRes.getSuccess() && countRes.getBody() > 0) {
                    total = countRes.getBody();
                    query.setSortName("order_time");
                    query.setSortOrder("desc");
                    ServiceResult<List<RecordSellingVo>> result = bookService.getRecordsellingList(query);
                    if (result.getSuccess()) {
                        list = result.getBody();
                    } else {
                        successMap.put("resultMassage", result.getMessage());//"获取书籍信息异常，请稍后重试!");
                        return successMap;
                    }
                }
            ListResult results = new ListResult(0, total, query.getPageSize(), query.getPageNumber(), list);
            return results.toMap();
        }catch(Exception e){
            logger.error("BookController.mycatselldetail---------->",e);
            successMap.put("resultMassage", "获取书籍信息异常，请稍后重试!");
            return successMap;
        }
    }
    /***
     *
     * @param response
     * @param strJson
     * @return
     */
    //我的书箱
    @RequestMapping(value = "/mycatborrowdetail", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, ?> mycatborrowdetail(HttpServletResponse response, @RequestBody String strJson) {
        logger.info("BookController.mycatborrowdetail---------->"+strJson);
        RecordBorrowQuery query=JSONObject.parseObject(strJson,RecordBorrowQuery.class);
        //获取登入用户的id
        int userId=1;
        Map<String,Object> successMap = new HashMap<String,Object>();
        try{
            query.setUserId(userId);
            ServiceResult<Integer> countRes = bookService.getRecordBorrowCount(query);
            List<RecordBorrowVo> list  = new ArrayList<>();
            long total = 0;
            if(countRes.getSuccess()  && countRes.getBody() > 0){
                total = countRes.getBody();
                query.setSortName("start_time");
                query.setSortOrder("desc");
                ServiceResult<List<RecordBorrowVo>> result = bookService.getRecordBorrowList(query);
                if(result.getSuccess()){
                    list = result.getBody();
                }else{
                    successMap.put("resultMassage", result.getMessage());//"获取书籍信息异常，请稍后重试!");
                    return successMap;
                }
            }
            ListResult results = new ListResult(0, total, query.getPageSize(), query.getPageNumber(), list);
            return results.toMap();
        }catch(Exception e){
            logger.error("BookController.bookuserdetails---------->",e);
            successMap.put("resultMassage", "获取书籍信息异常，请稍后重试!");
            return successMap;
        }
    }
    /***
     *
     * @param response
     * @param strJson
     * @return
     */
    //我的书箱
    @RequestMapping(value = "/mycatgiftdetail", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, ?> mycatgiftdetail(HttpServletResponse response, @RequestBody String strJson) {
        logger.info("BookController.mycatborrowdetail---------->"+strJson);
        RecordGiftQuery query=JSONObject.parseObject(strJson,RecordGiftQuery.class);
        //获取登入用户的id
        int userId=1;
        Map<String,Object> successMap = new HashMap<String,Object>();
        try{
            query.setBuyer(userId);
            ServiceResult<Integer> countRes = bookService.getRecordGiftCount(query);
            List<RecordGiftVo> list  = new ArrayList<>();
            long total = 0;
            if(countRes.getSuccess()  && countRes.getBody() > 0){
                total = countRes.getBody();
                query.setSortName("order_time");
                query.setSortOrder("desc");
                ServiceResult<List<RecordGiftVo>> result = bookService.getRecordGiftList(query);
                if(result.getSuccess()){
                    list = result.getBody();
                }else{
                    successMap.put("resultMassage", result.getMessage());//"获取书籍信息异常，请稍后重试!");
                    return successMap;
                }
            }
            ListResult results = new ListResult(0, total, query.getPageSize(), query.getPageNumber(), list);
            return results.toMap();
        }catch(Exception e){
            logger.error("BookController.bookuserdetails---------->",e);
            successMap.put("resultMassage", "获取书籍信息异常，请稍后重试!");
            return successMap;
        }
    }
    /***
     *
     * @param response
     * @param strJson
     * @return
     */
    //我的书箱
    @RequestMapping(value = "/mycatauctiondetail", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, ?> mycatauctiondetail(HttpServletResponse response, @RequestBody String strJson) {
        logger.info("BookController.mycatauctiondetail---------->"+strJson);
        BookAuctionQuery query=JSONObject.parseObject(strJson,BookAuctionQuery.class);
        //获取登入用户的id
        int userId=1;
        Map<String,Object> successMap = new HashMap<String,Object>();
        try{
               Integer userid=query.getState();
                 query.setState(null);
                RecordAuctionQuery recordAuctionQuery=new RecordAuctionQuery();
                recordAuctionQuery.setUserId(userId);
                List<Integer> ids=bookService.getRecordAuctionIds(recordAuctionQuery);
                query.setIds(ids);
                ServiceResult<Integer> countRes = bookService.queryBookAuctionCountByIds(query);
                List<BookAuctionVo> list  = new ArrayList<>();
                long total = 0;
                if(countRes.getSuccess()  && countRes.getBody() > 0) {
                    total = countRes.getBody();
                    query.setSortName("end_time");
                    query.setSortOrder("desc");
                    ServiceResult<List<BookAuctionVo>> result = bookService.queryBookAutionVoListByIds(query);
                    if (result.getSuccess()) {
                        list = result.getBody();
                        if(userid!=null){
                            if(userid==1){
                                Iterator<BookAuctionVo> it = list.iterator();
                                while(it.hasNext()){
                                    BookAuctionVo bookAuctionVo = it.next();
                                    if(bookAuctionVo.getBuyerId()!=userid){
                                        it.remove();
                                    }
                                }
                            }
                            if(userid==0){
                                    Iterator<BookAuctionVo> it = list.iterator();
                                    while(it.hasNext()){
                                        BookAuctionVo bookAuctionVo = it.next();
                                        if(bookAuctionVo.getBuyerId()!=null){
                                            it.remove();
                                        }
                                    }
                                }
                            if(userid==-1){
                                Iterator<BookAuctionVo> it = list.iterator();
                                while(it.hasNext()){
                                    BookAuctionVo bookAuctionVo = it.next();
                                    if(bookAuctionVo.getBuyerId()==userId){
                                        it.remove();
                                    }
                                }
                            }
                       }
                    } else {
                        successMap.put("resultMassage", result.getMessage());//"获取书籍信息异常，请稍后重试!");
                        return successMap;
                    }
                }
              ListResult results = new ListResult(0, list.size(), query.getPageSize(), query.getPageNumber(), list);
             return results.toMap();
        }catch(Exception e){
            logger.error("BookController.mycatauctiondetail---------->",e);
            successMap.put("resultMassage", "获取书籍信息异常，请稍后重试!");
            return successMap;
        }
    }

    /*----------------------------------------------------------------------------------------------*/

   //我的闲置书
    /***
     *
     * @param response
     * @param strJson
     * @return
     */
    @RequestMapping(value = "/bookselling", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, ?> bookSellingData(HttpServletResponse response, @RequestBody String strJson) {
        logger.info("BookManagerController.bookSellingData---------->"+strJson);
        BookSellingQuery query = JSONObject.parseObject(strJson,BookSellingQuery.class);
        Map<String,Object> successMap = new HashMap<String,Object>();
        try{
            //获取用户
            UserLogin userLogin =new UserLogin();
            userLogin.setUserId(1);
            query.setSellerId(userLogin.getUserId());
            ServiceResult<Integer> countRes = bookService.queryBookSellingCount(query);
            List<BookSellingVo> list  = new ArrayList<BookSellingVo>();
            long total = 0;
            if(countRes.getSuccess()  && countRes.getBody() > 0){
                total = countRes.getBody();
                query.setSortName("upload_time");
                query.setSortOrder("desc");
                ServiceResult<List<BookSellingVo>> result = bookService.queryBookSellingVoList(query);
                if(result.getSuccess()){
                    list=result.getBody();
                }else{
                    successMap.put("resultMassage", result.getMessage());//"获取书籍信息异常，请稍后重试!");
                    return successMap;
                }
            }
            ListResult results= new ListResult(0, total, query.getPageSize(), query.getPageNumber(), list);
            return results.toMap();

        }catch(Exception e){
            logger.error("BookManagerController.bookselling---------->",e);
            successMap.put("resultMassage", "获取书籍信息异常，请稍后重试!");
            return successMap;
        }
    }
    /***
     *
     * @param response
     * @param strJson
     * @return
     */
    @RequestMapping(value = "/recordselling", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, ?> recordsellingData(HttpServletResponse response, @RequestBody String strJson) {


        logger.info("BookManagerController.recordsellingData---------->"+strJson);
        RecordSellingQuery query = JSONObject.parseObject(strJson,RecordSellingQuery.class);
        Map<String,Object> successMap = new HashMap<String,Object>();
        try{
            if(query.getBuyerName()!=null&&!query.getBuyerName().equals("")){
                ServiceResult<List<Integer>> serviceResult=userService.getIdByUserName(query.getBuyerName());
                if(serviceResult.getSuccess()&&serviceResult.getBody()!=null&&serviceResult.getBody().size()>0){
                    query.setBuyers(serviceResult.getBody());
                }
            }
            ServiceResult<Integer> countRes = bookService.getRecordsellingCount(query);
            List<RecordSellingVo> list  = new ArrayList<RecordSellingVo>();
            long total = 0;
            if(countRes.getSuccess()  && countRes.getBody() > 0){
                total = countRes.getBody();
                query.setSortName("order_time");
                query.setSortOrder("desc");
                ServiceResult<List<RecordSellingVo>> result = bookService.getRecordsellingList(query);
                if(result.getSuccess()){
                    list=result.getBody();
                }else{
                    successMap.put("resultMassage", result.getMessage());//"获取书籍信息异常，请稍后重试!");
                    return successMap;
                }
            }
            ListResult results= new ListResult(0, total, query.getPageSize(), query.getPageNumber(), list);
            return results.toMap();

        }catch(Exception e){
            logger.error("BookManagerController.bookListData---------->",e);
            successMap.put("resultMassage", "获取书籍信息异常，请稍后重试!");
            return successMap;
        }
    }

    /***
     *
     * @param response
     * @param strJson
     * @return
     */
    @RequestMapping(value = "/bookborrow", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, ?> bookborrowData(HttpServletResponse response, @RequestBody String strJson) {
        logger.info("BookManagerController.bookborrowData---------->"+strJson);
        BookBorrowQuery query = JSONObject.parseObject(strJson,BookBorrowQuery.class);
        Map<String,Object> successMap = new HashMap<String,Object>();
        try{
            //获取用户
            UserLogin userLogin =new UserLogin();
            userLogin.setUserId(1);
            query.setSellerId(userLogin.getUserId());
            ServiceResult<Integer> countRes = bookService.queryBookBorrowCount(query);
            List<BookBorrowVo> list  = new ArrayList<BookBorrowVo>();
            long total = 0;
            if(countRes.getSuccess()  && countRes.getBody() > 0){
                total = countRes.getBody();
                query.setSortName("upload_time");
                query.setSortOrder("desc");
                ServiceResult<List<BookBorrowVo>> result = bookService.queryBookBorrowVoList(query);
                if(result.getSuccess()){
                    list=result.getBody();
                }else{
                    successMap.put("resultMassage", result.getMessage());//"获取书籍信息异常，请稍后重试!");
                    return successMap;
                }
            }
            ListResult results= new ListResult(0, total, query.getPageSize(), query.getPageNumber(), list);
            return results.toMap();

        }catch(Exception e){
            logger.error("BookManagerController.bookListData---------->",e);
            successMap.put("resultMassage", "获取书籍信息异常，请稍后重试!");
            return successMap;
        }
    }

    /***
     *
     * @param response
     * @param strJson
     * @return
     */
    @RequestMapping(value = "/recordborrow", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, ?> recordborrowData(HttpServletResponse response, @RequestBody String strJson) {


        logger.info("BookManagerController.recordborrowData---------->"+strJson);
        RecordBorrowQuery query = JSONObject.parseObject(strJson,RecordBorrowQuery.class);
        Map<String,Object> successMap = new HashMap<String,Object>();
        try{
            if(query.getUserName()!=null&&!query.getUserName().equals("")){
                ServiceResult<List<Integer>> serviceResult=userService.getIdByUserName(query.getUserName());
                if(serviceResult.getSuccess()&&serviceResult.getBody()!=null&&serviceResult.getBody().size()>0){
                    query.setUserIds(serviceResult.getBody());
                }
            }
            ServiceResult<Integer> countRes = bookService.getRecordBorrowCount(query);
            List<RecordBorrowVo> list  = new ArrayList<RecordBorrowVo>();
            long total = 0;
            if(countRes.getSuccess()  && countRes.getBody() > 0){
                total = countRes.getBody();
                query.setSortName("start_time");
                query.setSortOrder("desc");
                ServiceResult<List<RecordBorrowVo>> result = bookService.getRecordBorrowList(query);
                if(result.getSuccess()){
                    list=result.getBody();
                }else{
                    successMap.put("resultMassage", result.getMessage());//"获取书籍信息异常，请稍后重试!");
                    return successMap;
                }
            }
            ListResult results= new ListResult(0, total, query.getPageSize(), query.getPageNumber(), list);
            return results.toMap();

        }catch(Exception e){
            logger.error("BookManagerController.recordborrowData---------->",e);
            successMap.put("resultMassage", "获取书籍信息异常，请稍后重试!");
            return successMap;
        }
    }

    /***
     *
     * @param response
     * @param strJson
     * @return
     */
    @RequestMapping(value = "/bookgift", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, ?> bookgiftData(HttpServletResponse response, @RequestBody String strJson) {


        logger.info("BookManagerController.bookborrowData---------->"+strJson);
        BookGiftQuery query = JSONObject.parseObject(strJson,BookGiftQuery.class);
        Map<String,Object> successMap = new HashMap<String,Object>();
        try{
            //获取用户
            UserLogin userLogin =new UserLogin();
            userLogin.setUserId(1);
            query.setSellerId(userLogin.getUserId());
            ServiceResult<Integer> countRes = bookService.queryBookGiftCount(query);
            List<BookGiftVo> list  = new ArrayList<BookGiftVo>();
            long total = 0;
            if(countRes.getSuccess()  && countRes.getBody() > 0){
                total = countRes.getBody();
                query.setSortName("upload_time");
                query.setSortOrder("desc");
                ServiceResult<List<BookGiftVo>> result = bookService.queryBookBookGiftVoList(query);
                if(result.getSuccess()) {
                    list = result.getBody();
                }else{
                    successMap.put("resultMassage", result.getMessage());//"获取书籍信息异常，请稍后重试!");
                    return successMap;
                }
            }
            ListResult results= new ListResult(0, total, query.getPageSize(), query.getPageNumber(), list);
            return results.toMap();

        }catch(Exception e){
            logger.error("BookManagerController.bookListData---------->",e);
            successMap.put("resultMassage", "获取书籍信息异常，请稍后重试!");
            return successMap;
        }
    }

    /***
     *
     * @param response
     * @param strJson
     * @return
     */
    @RequestMapping(value = "/recordgift", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, ?> recordgiftData(HttpServletResponse response, @RequestBody String strJson) {


        logger.info("BookManagerController.recordborrowData---------->"+strJson);
        RecordGiftQuery query = JSONObject.parseObject(strJson,RecordGiftQuery.class);
        Map<String,Object> successMap = new HashMap<String,Object>();
        try{
            if(query.getBuyerName()!=null&&!query.getBuyerName().equals("")){
                ServiceResult<List<Integer>> serviceResult=userService.getIdByUserName(query.getBuyerName());
                if(serviceResult.getSuccess()&&serviceResult.getBody()!=null&&serviceResult.getBody().size()>0){
                    query.setBuyers(serviceResult.getBody());
                }
            }
            ServiceResult<Integer> countRes = bookService.getRecordGiftCount(query);
            List<RecordGiftVo> list  = new ArrayList<RecordGiftVo>();
            long total = 0;
            if(countRes.getSuccess()  && countRes.getBody() > 0){
                total = countRes.getBody();
                query.setSortName("order_time");
                query.setSortOrder("desc");
                ServiceResult<List<RecordGiftVo>> result = bookService.getRecordGiftList(query);
                if(result.getSuccess()){
                    list=result.getBody();
                }else{
                    successMap.put("resultMassage", result.getMessage());//"获取书籍信息异常，请稍后重试!");
                    return successMap;
                }
            }
            ListResult results= new ListResult(0, total, query.getPageSize(), query.getPageNumber(), list);
            return results.toMap();

        }catch(Exception e){
            logger.error("BookManagerController.recordborrowData---------->",e);
            successMap.put("resultMassage", "获取书籍信息异常，请稍后重试!");
            return successMap;
        }
    }


    /***
     *
     * @param response
     * @param strJson
     * @return
     */
    @RequestMapping(value = "/bookauction", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, ?> bookauctionData(HttpServletResponse response, @RequestBody String strJson) {


        logger.info("BookManagerController.bookauctionData---------->"+strJson);
        BookAuctionQuery query = JSONObject.parseObject(strJson,BookAuctionQuery.class);
        Map<String,Object> successMap = new HashMap<String,Object>();
        try{
            //获取用户
            UserLogin userLogin =new UserLogin();
            userLogin.setUserId(1);
            query.setSellerId(userLogin.getUserId());
            query.setEndTime(DateUtils.getNowTimeStamp());
            ServiceResult<Integer> countRes = bookService.queryBookAuctionCount(query);
            List<BookAuctionVo> list  = new ArrayList<BookAuctionVo>();
            long total = 0;
            if(countRes.getSuccess()  && countRes.getBody() > 0){
                total = countRes.getBody();
                query.setSortName("upload_time");
                query.setSortOrder("desc");
                ServiceResult<List<BookAuctionVo>> result = bookService.queryBookAutionVoList(query);
                if(result.getSuccess()){
                    list=result.getBody();
                }else{
                    successMap.put("resultMassage", result.getMessage());//"获取书籍信息异常，请稍后重试!");
                    return successMap;
                }
            }
            ListResult results= new ListResult(0, total, query.getPageSize(), query.getPageNumber(), list);
            return results.toMap();

        }catch(Exception e){
            logger.error("BookManagerController.bookauctionData---------->",e);
            successMap.put("resultMassage", "获取书籍信息异常，请稍后重试!");
            return successMap;
        }
    }
    /***
     *
     * @param response
     * @param strJson
     * @return
     */
    @RequestMapping(value = "/recordauction", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, ?> recordauctionData(HttpServletResponse response, @RequestBody String strJson) {


        logger.info("BookManagerController.recordauctionData---------->"+strJson);
        RecordAuctionQuery query = JSONObject.parseObject(strJson,RecordAuctionQuery.class);
        Map<String,Object> successMap = new HashMap<String,Object>();
        try{
            if(query.getUserName()!=null&&!query.getUserName().equals("")){
                ServiceResult<List<Integer>> serviceResult=userService.getIdByUserName(query.getUserName());
                if(serviceResult.getSuccess()&&serviceResult.getBody()!=null&&serviceResult.getBody().size()>0){
                    query.setUserIds(serviceResult.getBody());
                }
            }
            ServiceResult<Integer> countRes = bookService.getRecordAuctionCount(query);
            List<RecordAuctionVo> list  = new ArrayList<RecordAuctionVo>();
            long total = 0;
            if(countRes.getSuccess()  && countRes.getBody() > 0){
                total = countRes.getBody();
                query.setSortName("auction_time");
                query.setSortOrder("desc");
                ServiceResult<List<RecordAuctionVo>> result = bookService.getRecordAuctionList(query);
                if(result.getSuccess()){
                    list=result.getBody();
                }else{
                    successMap.put("resultMassage", result.getMessage());//"获取书籍信息异常，请稍后重试!");
                    return successMap;
                }
            }
            ListResult results= new ListResult(0, total, query.getPageSize(), query.getPageNumber(), list);
            return results.toMap();

        }catch(Exception e){
            logger.error("BookManagerController.recordauctionData---------->",e);
            successMap.put("resultMassage", "获取书籍信息异常，请稍后重试!");
            return successMap;
        }
    }
    /*----------------------------------------------------------------------------------------------------------------------------------------------------------------------*/
    //获取书籍 详细信息 如果 不存在 前端自己填写
    @RequestMapping(value = "/uploadbook", method = RequestMethod.GET)
    public ModelAndView uploadbook(Integer status,Long isbn) {
        logger.info("BookController.uploadbook------->");
        ModelAndView mv = new ModelAndView();
        ServiceResult<BookVo> result=bookService.queryBookByBookISBN(isbn);
         String blankUrl="";
         String url="";
         if(status==1){
            blankUrl="sharebook/jsp/insertsellblankbook";
            url="sharebook/jsp/insertsellbook";
         }
         if(status==2){
             blankUrl="sharebook/jsp/insertborrowblankbook";
             url="sharebook/jsp/insertborrowbook";
         }
        if(status==3){
            blankUrl="sharebook/jsp/insertgiftblankbook";
            url="sharebook/jsp/insertgiftbook";
        }
        if(status==4){
            blankUrl="sharebook/jsp/insertauctionblankbook";
            url="sharebook/jsp/insertauctionbook";
        }
        if(isbn==null||isbn<=0){
            mv.setViewName(blankUrl);
        }else {
            if(result.getSuccess()&&result.getBody()!=null&&result.getBody().getId()!=null){
                mv.addObject("book",result.getBody());
                mv.setViewName(url);
            }else{
                Book book=new Book();
                book=GetBookDetailByIsbn.getBook(isbn+"");
                if(book!=null){
                    mv.addObject("book",book);
                    mv.setViewName(url);
                }else{
                    mv.setViewName(blankUrl);
                }
            }
        }
        return mv;
    }

    //买卖书籍上传
    @RequestMapping(value = "/insertsellbook", method = RequestMethod.POST)
    @ResponseBody
    @Transactional
    public Map<String, ?> insertsellbook(HttpServletResponse response, @RequestBody String strJson) {
        logger.info("BookManagerController.insertsellbook---------->"+strJson);
        BookSellingQuery query = JSONObject.parseObject(strJson.trim(),BookSellingQuery.class);
        Map<String,Object> successMap = new HashMap<String,Object>();
        try{
            //用户id
            //登陆的用户
            UserLogin userLogin=new UserLogin();
            userLogin.setUserId(1);
            query.setSellerId(userLogin.getUserId());
            query.setcT(DateUtils.getNowTimeStamp());
            query.setcU(userLogin.getUserId());
            query.setSellerId(userLogin.getUserId());
            query.setStatus(ConstantsUtils.BookAuditCode.AUDIT_NOT);
            query.setPricingunit("元");
            query.setUploadTime(DateUtils.getNowTimeStamp());
            query.setProfessionalTypeName1(userLogin.getProfessionalName1());
            query.setProfessionalTypeName2(userLogin.getProfessionalName2());
            query.setState(1);
            query.setUseNum(0);
            ServiceResult<BookVo> result=bookService.queryBookByBookISBN(query.getIsbn());
            if(result.getSuccess()&&result.getBody()!=null&&result.getBody().getId()!=null){
              //数据库存在该书籍 上传到此书籍下
                BookVo bookVo=result.getBody();
                query.setSkuId(bookVo.getId());
                BookQuery bookQuery=new BookQuery();
                bookQuery.setId(bookVo.getId());
                //买卖书籍审核后添加数量
               /* bookQuery.setPreNum(query.getUseableNum());*/
                bookQuery.setSellerNumber(bookVo.getSellerNumber()+1);
                bookQuery.setProfessionalTypeName1(bookVo.getProfessionalTypeName1()+','+query.getProfessionalTypeName1());
                bookQuery.setProfessionalTypeName2(bookVo.getProfessionalTypeName2()+','+query.getProfessionalTypeName2());
                bookService.upateBookUserNumAdd(bookQuery);
                query.setBookName(bookVo.getBookName());
            }else{
                Book book=new Book();
                BookQuery bookQuery =new BookQuery();
                book=GetBookDetailByIsbn.getBook(query.getIsbn()+"");
                if(book!=null&&book.getIsbn()!=null){
                    bookQuery = JSONObject.parseObject(JSONObject.toJSONString(book),BookQuery.class);
                    bookQuery.setPageNum(book.getPageNumber());
                    query.setBookName(book.getBookName());
                }else{
                    bookQuery.setBookName(query.getBookName());
                    bookQuery.setIntroduce(query.getRemark());
                    bookQuery.setPressTime(DateUtils.getNowTimeStamp());
                    bookQuery.setPress(userLogin.getRealUserName());
                    bookQuery.setAuthor(userLogin.getRealUserName());
                    bookQuery.setPricing(query.getPrice());
                    bookQuery.setSrc(query.getSrc1());
                    bookQuery.setPricingunit(query.getPricingunit());
                    bookQuery.setIntroduce(query.getRemark());
                }

                bookQuery.setSellStatus(1);
                bookQuery.setProfessionalTypeName1(query.getProfessionalTypeName1());
                bookQuery.setProfessionalTypeName2(query.getProfessionalTypeName2());
                bookQuery.setSellerNumber(1);
                bookQuery.setUserableNum(0);
              /*  bookQuery.setUserableNum(query.getUseableNum());*/
                bookQuery.setUseNum(0);
                bookQuery.setBookTypeName1(query.getBookTypeName1());
                bookQuery.setBookTypeName2(query.getBookTypeName2());
                bookQuery.setProfessionalTypeName2(query.getProfessionalTypeName2());
                bookQuery.setProfessionalTypeName1(query.getProfessionalTypeName1());
                bookQuery.setcU(userLogin.getUserId());
                bookQuery.setcT(DateUtils.getNowTimeStamp());
                bookService.insertBook(bookQuery);
                query.setSkuId(bookQuery.getId());

            }
            int code=1;
            ServiceResult<Integer> integerServiceResult=bookService.insertSellBook(query);
            if(integerServiceResult.getSuccess() && integerServiceResult.getBody() > 0){
                code=0;
            }
            DataResult results= new DataResult(code, new Book());
            return results.toMap();

        }catch(Exception e){
            logger.error("BookManagerController.insertsellbook---------->",e);
            successMap.put("resultMassage", "信息异常，请稍后重试!");
            return successMap;
        }
    }

    //租借书籍上传
    //赠予书籍上传
    //竞拍书籍上传


}


