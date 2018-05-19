package sharebookmanager.controller;

import com.alibaba.fastjson.JSONObject;
import common.constant.ConstantsUtils;
import common.model.*;
import common.query.*;
import common.service.BookService;
import common.util.DateUtils;
import common.util.ListResult;
import common.util.ServiceResult;
import common.util.StringUtils;
import common.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import common.service.UserService;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletResponse;
import java.util.*;

@RestController("BookManagerController")
@RequestMapping("/book")
public class BookManagerController {
    private static  final Logger logger = Logger.getLogger(BookManagerController.class);

    @Autowired
    private BookService bookService;

    @Autowired
    private  UserService userService;

    /***
     *
     * @param response
     * @param strJson
     * @return
     */
    @RequestMapping(value = "/bookListData", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, ?> bookListData(HttpServletResponse response, @RequestBody String strJson) {


        logger.info("BookManagerController.bookListData---------->"+strJson);
        BookQuery query = JSONObject.parseObject(strJson,BookQuery.class);
        Map<String,Object> successMap = new HashMap<String,Object>();
        try{

            ServiceResult<Integer> countRes = bookService.queryBookCount(query);
            List<BookVo> list  = new ArrayList<BookVo>();
            long total = 0;
            if(countRes.getSuccess()  && countRes.getBody() > 0){
                total = countRes.getBody();
                query.setSortName("press_time");
                query.setSortOrder("desc");
                ServiceResult<List<BookVo>> result = bookService.queryBookList(query);
                if(result.getSuccess()){
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
    @RequestMapping(value = "/bookselling", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, ?> bookSellingData(HttpServletResponse response, @RequestBody String strJson) {
        logger.info("BookManagerController.bookSellingData---------->"+strJson);
        BookSellingQuery query = JSONObject.parseObject(strJson,BookSellingQuery.class);
        Map<String,Object> successMap = new HashMap<String,Object>();
        try{
            if(query.getSellerUser()!=null&&!query.getSellerUser().equals("")){
                ServiceResult<List<Integer>> serviceResult=userService.getIdByUserName(query.getSellerUser());
                if(serviceResult.getSuccess()&&serviceResult.getBody()!=null){
                    query.setSellerIds(serviceResult.getBody());
                }
            }
            ServiceResult<Integer> countRes = bookService.queryBookSellingCount(query);
            List<BookSellingVo> list  = new ArrayList<BookSellingVo>();
            long total = 0;
            if(countRes.getSuccess()  && countRes.getBody() > 0){
                total = countRes.getBody();
                query.setSortName("deal_time");
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
    @RequestMapping(value = "/recordselling", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, ?> recordsellingData(HttpServletResponse response, @RequestBody String strJson) {


        logger.info("BookManagerController.recordsellingData---------->"+strJson);
        RecordSellingQuery query = JSONObject.parseObject(strJson,RecordSellingQuery.class);
        Map<String,Object> successMap = new HashMap<String,Object>();
        try{
            if(query.getBuyerName()!=null&&!query.getBuyerName().equals("")){
                ServiceResult<List<Integer>> serviceResult=userService.getIdByUserName(query.getBuyerName());
                if(serviceResult.getSuccess()&&serviceResult.getBody()!=null){
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
            if(query.getSellerUser()!=null&&!query.getSellerUser().equals("")){
                ServiceResult<List<Integer>> serviceResult=userService.getIdByUserName(query.getSellerUser());
                if(serviceResult.getSuccess()&&serviceResult.getBody()!=null){
                    query.setSellerIds(serviceResult.getBody());
                }
            }
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
                if(serviceResult.getSuccess()&&serviceResult.getBody()!=null){
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
            if(query.getSellerUser()!=null&&!query.getSellerUser().equals("")){
                ServiceResult<List<Integer>> serviceResult=userService.getIdByUserName(query.getSellerUser());
                if(serviceResult.getSuccess()&&serviceResult.getBody()!=null){
                    query.setSellerIds(serviceResult.getBody());
                }
            }
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
                if(serviceResult.getSuccess()&&serviceResult.getBody()!=null){
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
            if(query.getSellerUser()!=null&&!query.getSellerUser().equals("")){
                ServiceResult<List<Integer>> serviceResult=userService.getIdByUserName(query.getSellerUser());
                if(serviceResult.getSuccess()&&serviceResult.getBody()!=null){
                    query.setSellerIds(serviceResult.getBody());
                }
            }
            query.setEndTime(DateUtils.getNowTimeStamp());
            ServiceResult<Integer> countRes = bookService.queryBookAuctionCount(query);
            List<BookAuctionVo> list  = new ArrayList<BookAuctionVo>();
            long total = 0;
            if(countRes.getSuccess()  && countRes.getBody() > 0){
                total = countRes.getBody();
                query.setSortName("end_time");
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
                if(serviceResult.getSuccess()&&serviceResult.getBody()!=null){
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
    /***
     *
     * @param response
     * @param strJson
     * @return
     */
    @RequestMapping(value = "/bookprofessionalList", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, ?> bookprofessionalList(HttpServletResponse response, @RequestBody String strJson) {


        logger.info("BookManagerController.bookprofessionalList---------->"+strJson);
        BookProfessionalListQuery query = JSONObject.parseObject(strJson,BookProfessionalListQuery.class);
        Map<String,Object> successMap = new HashMap<String,Object>();
        try{
            ServiceResult<Integer> countRes = bookService.getBookProfessionalListCount(query);
            List<BookProfessionalListVo> list  = new ArrayList<BookProfessionalListVo>();
            long total = 0;
            if(countRes.getSuccess()  && countRes.getBody() > 0){
                total = countRes.getBody();
                query.setSortName("grade");
                query.setSortOrder("asc");
                ServiceResult<List<BookProfessionalListVo>> result = bookService.getBookProfessionalList(query);
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
            logger.error("BookManagerController.bookprofessionalList---------->",e);
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
    @RequestMapping(value = "/auditBookSelling", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, ?> auditBookSelling(HttpServletResponse response, @RequestBody String strJson) {
        logger.info("BookManagerController.auditBookSelling---------->"+strJson);
        BookSellingQuery query = JSONObject.parseObject(strJson,BookSellingQuery.class);
        Map<String,Object> successMap = new HashMap<String,Object>();
        int id=1;
        try{
            List<Integer> ids=new ArrayList<>();
            ServiceResult<List<BookSelling>> serviceResult1=bookService.queryBookSellingByIds(query.getIds(),ConstantsUtils.BookAuditCode.AUDIT_NOT);
            if(serviceResult1.getSuccess()){
                if(serviceResult1.getBody()!=null){
                    for(BookSelling bookSelling:serviceResult1.getBody()){
                        ids.add(bookSelling.getId());
                    }
                }else{
                    successMap.put("resultMassage", "请刷新查看，书籍已被其他人审核");
                }
                ServiceResult<Integer> serviceResult = bookService.updateBookSellingStatus(ids,ConstantsUtils.BookAuditCode.AUDIT,id,DateUtils.getNowTimeStamp());
                if(serviceResult.getSuccess()  && serviceResult.getBody() ==1 ){
                    successMap.put("resultMassage", "ok");//"获取书籍信息异常，请稍后重试!");
                } else {
                    successMap.put("resultMassage", "审核失败");
                }
            }else{
                successMap.put("resultMassage", "审核失败");
            }
            return successMap;

        }catch(Exception e){
            logger.error("BookManagerController.auditBookSelling---------->",e);
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
    @RequestMapping(value = "/auditNotBookSelling", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, ?> auditNotBookSelling(HttpServletResponse response, @RequestBody String strJson) {
        logger.info("BookManagerController.auditNotBookSelling---------->"+strJson);
        BookSellingQuery query = JSONObject.parseObject(strJson,BookSellingQuery.class);
        Map<String,Object> successMap = new HashMap<String,Object>();
        int id=1;
        try{
            List<Integer> ids=new ArrayList<>();
            ServiceResult<List<BookSelling>> serviceResult1=bookService.queryBookSellingByIds(query.getIds(),ConstantsUtils.BookAuditCode.AUDIT_NOT);
            if(serviceResult1.getSuccess()){
                if(serviceResult1.getBody()!=null){
                    for(BookSelling bookSelling:serviceResult1.getBody()){
                        ids.add(bookSelling.getId());
                    }
                }else{
                    successMap.put("resultMassage", "请刷新查看，书籍已被其他人审核");
                }
                int userId=1;
                ServiceResult<Integer> serviceResult = bookService.updateBookSellingStatus(ids,ConstantsUtils.BookAuditCode.STOP,userId,DateUtils.getNowTimeStamp());
                if(serviceResult.getSuccess()  && serviceResult.getBody() ==1 ){
                    successMap.put("resultMassage", "ok");//"获取书籍信息异常，请稍后重试!");
                } else {
                    successMap.put("resultMassage", "审核失败");
                }
            }else{
                successMap.put("resultMassage", "审核失败");
            }
            return successMap;

        }catch(Exception e){
            logger.error("BookManagerController.auditNotBookSelling---------->",e);
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
    @RequestMapping(value = "/auditBookBorrow", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, ?> auditBookBorrow(HttpServletResponse response, @RequestBody String strJson) {
        logger.info("BookManagerController.auditBookBorrow---------->"+strJson);
        BookBorrowQuery query = JSONObject.parseObject(strJson,BookBorrowQuery.class);
        Map<String,Object> successMap = new HashMap<String,Object>();
        int id=1;//审核人
        try{
            ServiceResult<Integer> serviceResult = bookService.updateBookBorrowStatus(query.getIds(),ConstantsUtils.BookAuditCode.AUDIT,id,DateUtils.getNowTimeStamp());
            if(serviceResult.getSuccess()  && serviceResult.getBody() ==1 ){
                successMap.put("resultMassage", "ok");//"获取书籍信息异常，请稍后重试!");
            } else {
                successMap.put("resultMassage", "审核失败");
            }
            return successMap;
        }catch(Exception e){
            logger.error("BookManagerController.auditBookBorrow---------->",e);
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
    @RequestMapping(value = "/auditNotBookBorrow", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, ?> auditNotBookBorrow(HttpServletResponse response, @RequestBody String strJson) {
        logger.info("BookManagerController.auditNotBookSelling---------->"+strJson);
        BookBorrowQuery query = JSONObject.parseObject(strJson,BookBorrowQuery.class);
        Map<String,Object> successMap = new HashMap<String,Object>();
        int id=1;
        try{
            ServiceResult<Integer> serviceResult = bookService.updateBookSellingStatus(query.getIds(),ConstantsUtils.BookAuditCode.STOP,id,DateUtils.getNowTimeStamp());
            if(serviceResult.getSuccess()  && serviceResult.getBody() ==1 ){
                successMap.put("resultMassage", "ok");//"获取书籍信息异常，请稍后重试!");
            } else {
                successMap.put("resultMassage", "审核失败");
            }
            return successMap;
        }catch(Exception e){
            logger.error("BookManagerController.auditNotBookSelling---------->",e);
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
    @RequestMapping(value = "/auditBookGift", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, ?> auditBookGift(HttpServletResponse response, @RequestBody String strJson) {
        logger.info("BookManagerController.auditBookGift---------->"+strJson);
        BookGiftQuery query = JSONObject.parseObject(strJson,BookGiftQuery.class);
        Map<String,Object> successMap = new HashMap<String,Object>();
        int id=1;
        try{
                ServiceResult<Integer> serviceResult = bookService.updateBookGiftStatus(query.getIds(),ConstantsUtils.BookAuditCode.AUDIT,id,DateUtils.getNowTimeStamp());
                if(serviceResult.getSuccess()  && serviceResult.getBody() ==1 ){
                    successMap.put("resultMassage", "ok");//"获取书籍信息异常，请稍后重试!");
                } else {
                    successMap.put("resultMassage", "审核失败");
                 }
            return successMap;
        }catch(Exception e){
            logger.error("BookManagerController.auditBookGift---------->",e);
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
    @RequestMapping(value = "/auditNotBookGift", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, ?> auditNotBookGift(HttpServletResponse response, @RequestBody String strJson) {
        logger.info("BookManagerController.auditNotBookGift---------->"+strJson);
        BookGiftQuery query = JSONObject.parseObject(strJson,BookGiftQuery.class);
        Map<String,Object> successMap = new HashMap<String,Object>();
        int id=1;
        try{
            ServiceResult<Integer> serviceResult = bookService.updateBookGiftStatus(query.getIds(),ConstantsUtils.BookAuditCode.STOP,id,DateUtils.getNowTimeStamp());
            if(serviceResult.getSuccess()  && serviceResult.getBody() ==1 ){
                    successMap.put("resultMassage", "ok");//"获取书籍信息异常，请稍后重试!");
            } else {
                    successMap.put("resultMassage", "审核失败");
            }
            return successMap;

        }catch(Exception e){
            logger.error("BookManagerController.auditNotBookGift---------->",e);
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
    @RequestMapping(value = "/auditBookAuction", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, ?> auditBookAuction(HttpServletResponse response, @RequestBody String strJson) {
        logger.info("BookManagerController.auditBookGift---------->"+strJson);
        BookAuctionQuery query = JSONObject.parseObject(strJson,BookAuctionQuery.class);
        Map<String,Object> successMap = new HashMap<String,Object>();
        int id=1;
        try{
            ServiceResult<Integer> serviceResult = bookService.updateBooAuctionStatus(query.getIds(),ConstantsUtils.BookAuditCode.AUDIT,id,DateUtils.getNowTimeStamp());
            if(serviceResult.getSuccess()  && serviceResult.getBody() ==1 ){
                successMap.put("resultMassage", "ok");//"获取书籍信息异常，请稍后重试!");
            } else {
                successMap.put("resultMassage", "审核失败");
            }
            return successMap;
        }catch(Exception e){
            logger.error("BookManagerController.auditBookGift---------->",e);
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
    @RequestMapping(value = "/auditNotBookAuction", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, ?> auditNotBookAuction(HttpServletResponse response, @RequestBody String strJson) {
        logger.info("BookManagerController.auditNotBookAuction---------->"+strJson);
        BookAuctionQuery query = JSONObject.parseObject(strJson,BookAuctionQuery.class);
        Map<String,Object> successMap = new HashMap<String,Object>();
        int id=1;
        try{
            ServiceResult<Integer> serviceResult = bookService.updateBooAuctionStatus(query.getIds(),ConstantsUtils.BookAuditCode.STOP,id,DateUtils.getNowTimeStamp());
            if(serviceResult.getSuccess()  && serviceResult.getBody() ==1 ){
                successMap.put("resultMassage", "ok");//"获取书籍信息异常，请稍后重试!");
            } else {
                successMap.put("resultMassage", "审核失败");
            }
            return successMap;

        }catch(Exception e){
            logger.error("BookManagerController.auditNotBookAuction---------->",e);
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
    @RequestMapping(value = "/deleteBookList", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, ?> deleteBookList(HttpServletResponse response, @RequestBody String strJson) {
        logger.info("BookManagerController.deleteBookList---------->"+strJson);
        BookProfessionalListQuery query = JSONObject.parseObject(strJson,BookProfessionalListQuery.class);
        Map<String,Object> successMap = new HashMap<String,Object>();
        int id=1;
        try{
            /*操作人*/
            query.setcU(id);
            query.setcT(DateUtils.getNowTimeStamp());
            ServiceResult<Integer> serviceResult = bookService.deleteBookProfessionalList(query);
            if(serviceResult.getSuccess()  && serviceResult.getBody() ==1 ){
                successMap.put("resultMassage", "ok");//"获取书籍信息异常，请稍后重试!");
            } else {
                successMap.put("resultMassage", "删除失败");
            }
            return successMap;

        }catch(Exception e){
            logger.error("BookManagerController.deleteBookList---------->",e);
            successMap.put("resultMassage", "删除异常，请稍后重试!");
            return successMap;
        }
    }

    /***
     *
     * @param response
     * @param strJson
     * @return
     */
    @RequestMapping(value = "/bookgiftrec", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, ?> bookgiftrecData(HttpServletResponse response, @RequestBody String strJson) {


        logger.info("BookManagerController.bookgiftrecData---------->"+strJson);
        BookGiftRecQuery query = JSONObject.parseObject(strJson, BookGiftRecQuery.class);
        Map<String,Object> successMap = new HashMap<String,Object>();
        try{
            if(StringUtils.isNotEmpty(query.getGTime())){
                query.setGiftTime(DateUtils.getAppointedTimeIntValue(query.getGTime(), DateUtils.YMD));
            }else{

                query.setGiftTime(DateUtils.getTimesmorning(new Date()));
            }
            ServiceResult<Integer> countRes = bookService.queryBookGiftRecCount(query);
            List<BookGiftRecVo> list  = new ArrayList<>();
            long total = 0;
            if(countRes.getSuccess()  && countRes.getBody() > 0){
                total = countRes.getBody();
                query.setSortName("gift_time");
                query.setSortOrder("desc");
                ServiceResult<List<BookGiftRecVo>> result = bookService.queryBookGiftRecList(query);
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

}
