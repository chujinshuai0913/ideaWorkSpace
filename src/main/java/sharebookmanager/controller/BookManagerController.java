package sharebookmanager.controller;

import com.alibaba.fastjson.JSONObject;
import common.constant.ConstantsUtils;
import common.model.*;
import common.query.*;
import common.service.BookService;
import common.service.ClassTypeService;
import common.util.DateUtils;
import common.util.ListResult;
import common.util.ServiceResult;
import common.util.StringUtils;
import common.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import common.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.*;

@RestController("BookManagerController")
@RequestMapping("/book")
public class BookManagerController {
    private static  final Logger logger = Logger.getLogger(BookManagerController.class);

    @Autowired
    private BookService bookService;

    @Autowired
    private  UserService userService;

    @Autowired
    private ClassTypeService classTypeService;



    @RequestMapping(value = "/bookList", method = RequestMethod.GET)
    public ModelAndView sharemanager() {
        logger.info("BookController.bookList------->");
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        HttpSession session = request.getSession();
        //用户
        UserManagerLogin userManagerLogin=(UserManagerLogin)session.getAttribute("userManagerLogin");
        String uri="";
        if(userManagerLogin==null){
            return new ModelAndView("redirect:/sso/sharemanager/gotologin.jsp");
        }
        String url=request.getServletPath();
        int count=userService.isTrue(url,userManagerLogin.getRoleId());
        if(count<1){
            return new ModelAndView("redirect:/sso/ssono/no_per.jsp");
        }
        return new ModelAndView("redirect:/sharebookmanager/jsp/book.jsp");

    }
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
            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
            HttpSession session = request.getSession();
            //用户
            UserManagerLogin userManagerLogin=(UserManagerLogin)session.getAttribute("userManagerLogin");
            if(userManagerLogin==null){
                successMap.put("resultMassage", "用户未登录!");
                return successMap;
            }
            int count=userService.isTrue(request.getServletPath(),userManagerLogin.getRoleId());
            if(count<1){
                successMap.put("resultMassage", "无权限!");
                return successMap;
            }
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

    @RequestMapping(value = "/books", method = RequestMethod.GET)
    public ModelAndView booksell() {
        logger.info("BookController.booksell------->");
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        HttpSession session = request.getSession();
        //用户
        UserManagerLogin userManagerLogin=(UserManagerLogin)session.getAttribute("userManagerLogin");
        String uri="";
        if(userManagerLogin==null){
            return new ModelAndView("redirect:/sso/sharemanager/gotologin.jsp");
        }
        String url=request.getServletPath();
        int count=userService.isTrue(url,userManagerLogin.getRoleId());
        if(count<1){
            return new ModelAndView("redirect:/sso/ssono/no_per.jsp");
        }
        return new ModelAndView("redirect:/sharebookmanager/jsp/bookselling.jsp");

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
            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
            HttpSession session = request.getSession();
            //用户
            UserManagerLogin userManagerLogin=(UserManagerLogin)session.getAttribute("userManagerLogin");
            if(userManagerLogin==null){
                successMap.put("resultMassage", "用户未登录!");
                return successMap;
            }
            int count=userService.isTrue(request.getServletPath(),userManagerLogin.getRoleId());
            if(count<1){
                successMap.put("resultMassage", "无权限!");
                return successMap;
            }
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
    @RequestMapping(value = "/bookb", method = RequestMethod.GET)
    public ModelAndView bookb() {
        logger.info("BookController.bookb------->");
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        HttpSession session = request.getSession();
        //用户
        UserManagerLogin userManagerLogin=(UserManagerLogin)session.getAttribute("userManagerLogin");
        String uri="";
        if(userManagerLogin==null){
            return new ModelAndView("redirect:/sso/sharemanager/gotologin.jsp");
        }
        String url=request.getServletPath();
        int count=userService.isTrue(url,userManagerLogin.getRoleId());
        if(count<1){
            return new ModelAndView("redirect:/sso/ssono/no_per.jsp");
        }
        return new ModelAndView("redirect:/sharebookmanager/jsp/bookborrow.jsp");

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
    @RequestMapping(value = "/bookg", method = RequestMethod.GET)
    public ModelAndView bookg() {
        logger.info("BookController.bookg------->");
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        HttpSession session = request.getSession();
        //用户
        UserManagerLogin userManagerLogin=(UserManagerLogin)session.getAttribute("userManagerLogin");
        String uri="";
        if(userManagerLogin==null){
            return new ModelAndView("redirect:/sso/sharemanager/gotologin.jsp");
        }
        String url=request.getServletPath();
        int count=userService.isTrue(url,userManagerLogin.getRoleId());
        if(count<1){
            return new ModelAndView("redirect:/sso/ssono/no_per.jsp");
        }
        return new ModelAndView("redirect:/sharebookmanager/jsp/bookgift.jsp");

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

    @RequestMapping(value = "/booka", method = RequestMethod.GET)
    public ModelAndView booka() {
        logger.info("BookController.booka------->");
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        HttpSession session = request.getSession();
        //用户
        UserManagerLogin userManagerLogin=(UserManagerLogin)session.getAttribute("userManagerLogin");
        String uri="";
        if(userManagerLogin==null){
            return new ModelAndView("redirect:/sso/sharemanager/gotologin.jsp");
        }
        String url=request.getServletPath();
        int count=userService.isTrue(url,userManagerLogin.getRoleId());
        if(count<1){
            return new ModelAndView("redirect:/sso/ssono/no_per.jsp");
        }
        return new ModelAndView("redirect:/sharebookmanager/jsp/bookauction.jsp");

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
    @RequestMapping(value = "/bookprofessionalList1", method = RequestMethod.GET)
    public ModelAndView bookprofessionalList1() {
        logger.info("BookController.bookprofessionalList1------->");
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        HttpSession session = request.getSession();
        //用户
        UserManagerLogin userManagerLogin=(UserManagerLogin)session.getAttribute("userManagerLogin");
        String uri="";
        if(userManagerLogin==null){
            return new ModelAndView("redirect:/sso/sharemanager/gotologin.jsp");
        }
        String url=request.getServletPath();
        int count=userService.isTrue(url,userManagerLogin.getRoleId());
        if(count<1){
            return new ModelAndView("redirect:/sso/ssono/no_per.jsp");
        }
        return new ModelAndView("redirect:/sharebookmanager/jsp/booklist.jsp");

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
        Map<Integer,Integer> bookMap=new HashMap<>();
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        HttpSession session = request.getSession();
        //用户
        UserManagerLogin userManagerLogin=(UserManagerLogin)session.getAttribute("userManagerLogin");
        try{
            List<Integer> ids=new ArrayList<>();
            ServiceResult<List<BookSelling>> serviceResult1=bookService.queryBookSellingByIds(query.getIds(),ConstantsUtils.BookAuditCode.AUDIT_NOT);
            if(serviceResult1.getSuccess()){
                if(serviceResult1.getBody()!=null){
                    int perNum=0;
                    for(BookSelling bookSelling:serviceResult1.getBody()){
                        ids.add(bookSelling.getId());
                        if(bookMap.get(bookSelling.getSkuId())!=null){
                             bookMap.put(bookSelling.getSkuId(),bookMap.get(bookSelling.getSkuId())+bookSelling.getUseableNum());
                        }else {
                             bookMap.put(bookSelling.getSkuId(),bookSelling.getUseableNum());
                        }

                    }
                }else{
                    successMap.put("resultMassage", "请刷新查看，书籍已被其他人审核");
                }
                ServiceResult<Integer> serviceResult = bookService.updateBookSellingStatus(ids,ConstantsUtils.BookAuditCode.AUDIT,userManagerLogin.getId(),DateUtils.getNowTimeStamp());
                if(serviceResult.getSuccess()  && serviceResult.getBody() ==1 ){
                    successMap.put("resultMassage", "ok");//"获取书籍信息异常，请稍后重试!");
                     BookQuery  bookQuery=new BookQuery();
                    for (Map.Entry<Integer, Integer> entry : bookMap.entrySet()) {
                        bookQuery.setId(entry.getKey());
                        bookQuery.setPreNum(entry.getValue());
                        bookService.upateBookUserNumAdd(bookQuery);
                    }
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
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        HttpSession session = request.getSession();
        //用户
        UserManagerLogin userManagerLogin=(UserManagerLogin)session.getAttribute("userManagerLogin");
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
                ServiceResult<Integer> serviceResult = bookService.updateBookSellingStatus(ids,ConstantsUtils.BookAuditCode.STOP,userManagerLogin.getId(),DateUtils.getNowTimeStamp());
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
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        HttpSession session = request.getSession();
        //用户
        UserManagerLogin userManagerLogin=(UserManagerLogin)session.getAttribute("userManagerLogin");
        try{
            ServiceResult<Integer> serviceResult = bookService.updateBookBorrowStatus(query.getIds(),ConstantsUtils.BookAuditCode.AUDIT,userManagerLogin.getId(),DateUtils.getNowTimeStamp());
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
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        HttpSession session = request.getSession();
        //用户
        UserManagerLogin userManagerLogin=(UserManagerLogin)session.getAttribute("userManagerLogin");
        try{
            ServiceResult<Integer> serviceResult = bookService.updateBookBorrowStatus(query.getIds(),ConstantsUtils.BookAuditCode.STOP,userManagerLogin.getId(),DateUtils.getNowTimeStamp());
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
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        HttpSession session = request.getSession();
        //用户
        UserManagerLogin userManagerLogin=(UserManagerLogin)session.getAttribute("userManagerLogin");
        try{
                ServiceResult<Integer> serviceResult = bookService.updateBookGiftStatus(query.getIds(),ConstantsUtils.BookAuditCode.AUDIT,userManagerLogin.getId(),DateUtils.getNowTimeStamp());
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
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        HttpSession session = request.getSession();
        //用户
        UserManagerLogin userManagerLogin=(UserManagerLogin)session.getAttribute("userManagerLogin");
        try{
            ServiceResult<Integer> serviceResult = bookService.updateBookGiftStatus(query.getIds(),ConstantsUtils.BookAuditCode.STOP,userManagerLogin.getId(),DateUtils.getNowTimeStamp());
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
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        HttpSession session = request.getSession();
        //用户
        UserManagerLogin userManagerLogin=(UserManagerLogin)session.getAttribute("userManagerLogin");
        try{
            ServiceResult<Integer> serviceResult = bookService.updateBooAuctionStatus(query.getIds(),ConstantsUtils.BookAuditCode.AUDIT,userManagerLogin.getId(),DateUtils.getNowTimeStamp());
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
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        HttpSession session = request.getSession();
        //用户
        UserManagerLogin userManagerLogin=(UserManagerLogin)session.getAttribute("userManagerLogin");
        try{
            ServiceResult<Integer> serviceResult = bookService.updateBooAuctionStatus(query.getIds(),ConstantsUtils.BookAuditCode.STOP,userManagerLogin.getId(),DateUtils.getNowTimeStamp());
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
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        HttpSession session = request.getSession();
        UserManagerLogin userManagerLogin=(UserManagerLogin)session.getAttribute("userManagerLogin");
        try{
            /*操作人*/
            query.setcU(userManagerLogin.getId());
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
    @RequestMapping(value = "/bookrec", method = RequestMethod.GET)
    public ModelAndView bookrec() {
        logger.info("BookController.booka------->");
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        HttpSession session = request.getSession();
        //用户
        UserManagerLogin userManagerLogin=(UserManagerLogin)session.getAttribute("userManagerLogin");
        String uri="";
        if(userManagerLogin==null){
            return new ModelAndView("redirect:/sso/sharemanager/gotologin.jsp");
        }
        String url=request.getServletPath();
        int count=userService.isTrue(url,userManagerLogin.getRoleId());
        if(count<1){
            return new ModelAndView("redirect:/sso/ssono/no_per.jsp");
        }
        return new ModelAndView("redirect:/sharebookmanager/jsp/bookgiftrec.jsp");

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


        logger.info("BookController.bookgiftrecData---------->"+strJson);
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
    @RequestMapping(value = "/resolveBook", method = RequestMethod.POST)
    @ResponseBody
    public Map<String,?> resolveBook(HttpServletResponse respone,@RequestBody String strJson){
        logger.info("BookController.resolveBook---------->"+strJson);
        BookGiftRecQuery query = JSONObject.parseObject(strJson,BookGiftRecQuery.class);
        Map<String,Object> succMap = new HashMap<String,Object>();
        try{
               HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
               HttpSession session = request.getSession();
              //用户
                UserManagerLogin userManagerLogin=(UserManagerLogin)session.getAttribute("userManagerLogin");
                BookGiftRecVo bookGiftRecVo=new BookGiftRecVo();
                ServiceResult<BookGiftRecVo> recVoServiceResult=bookService.queryBookGiftRecById(query);
                if(recVoServiceResult.getSuccess()&&recVoServiceResult.getBody()!=null){
                    bookGiftRecVo=recVoServiceResult.getBody();
                }
                if(bookGiftRecVo.getSuccess()!=null){
                    query.setSuccess(query.getSuccess()+bookGiftRecVo.getSuccess());

                }else {
                    query.setSuccess(query.getSuccess());
                }
                if(query.getRemark()!=null&&query.getRemark().equals("")){
                    if(bookGiftRecVo.getRemark()!=null&&!bookGiftRecVo.getRemark().equals("")){
                        query.setRemark(query.getRemark()+"/"+bookGiftRecVo.getRemark());
                    }else{
                        query.setRemark(query.getRemark());
                    }

                }
                query.setCt(DateUtils.getNowTimeStamp());
                query.setCu(userManagerLogin.getId());
                ServiceResult<Integer> result2 =bookService.updateBookGiftRecById(query);
                succMap.put("resultMassage", result2.getSuccess()?"ok":result2.getMessage());
                 return succMap;
        }catch(Exception e){
            logger.error("处理失败", e);
            succMap.put("resultMassage", "处理失败");
            return succMap;
        }
    }
    @RequestMapping(value = "/bookclass12", method = RequestMethod.GET)
    public ModelAndView bookclass12() {
        logger.info("BookController.bookclass12------->");
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        HttpSession session = request.getSession();
        //用户
        UserManagerLogin userManagerLogin=(UserManagerLogin)session.getAttribute("userManagerLogin");
        String uri="";
        if(userManagerLogin==null){
            return new ModelAndView("redirect:/sso/sharemanager/gotologin.jsp");
        }
        String url=request.getServletPath();
        int count=userService.isTrue(url,userManagerLogin.getRoleId());
        if(count<1){
            return new ModelAndView("redirect:/sso/ssono/no_per.jsp");
        }
        return new ModelAndView("redirect:/sharebookmanager/jsp/bookclass.jsp");

    }
    /***
     *
     * @param response
     * @param strJson
     * @return
     */
    @RequestMapping(value = "/bookclass1", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, ?> bookclass1Data(HttpServletResponse response, @RequestBody String strJson) {


        logger.info("BookManagerController.bookclass1Data---------->"+strJson);
        TypeBook1Query query = JSONObject.parseObject(strJson, TypeBook1Query.class);
        Map<String,Object> successMap = new HashMap<String,Object>();
        try{

            ServiceResult<Integer> countRes = new ServiceResult<>(classTypeService.getTypeBook1ListCount(query));
            List<TypeBook1Vo> list  = new ArrayList<>();
            long total = 0;
            if(countRes.getSuccess()  && countRes.getBody() > 0){
                total = countRes.getBody();
                query.setSortName("c_t");
                query.setSortOrder("desc");
                ServiceResult<List<TypeBook1Vo>> result = classTypeService.getTypeBook1Lists(query);
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
    @RequestMapping(value = "/insertclass1", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, ?> insertclass1Data(HttpServletResponse response, @RequestBody String strJson) {


        logger.info("BookManagerController.insertclass1Data---------->"+strJson);
        TypeBook1Query query = JSONObject.parseObject(strJson, TypeBook1Query.class);
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        HttpSession session = request.getSession();
        UserManagerLogin userManagerLogin=(UserManagerLogin)session.getAttribute("userManagerLogin");
        Map<String,Object> successMap = new HashMap<String,Object>();
        try{
            query.setcU(userManagerLogin.getId());
            query.setcT(DateUtils.getNowTimeStamp());
            query.setStatus(2);
            if(StringUtils.isEmpty(query.getClassName1())) {
                successMap.put("resultMassage", "分类名称不能为空！");
                return successMap;
            }
            ServiceResult<Integer> serviceResult = new ServiceResult<>(classTypeService.queryTypeBook1ByName(query));
            if(serviceResult.getSuccess()&& serviceResult.getBody()>0){
                successMap.put("resultMassage", "该分类已存在！");
            }else{
                ServiceResult<Integer> result = new ServiceResult<>(classTypeService.insertTypeBook1(query));
                if(result.getSuccess()&& result.getBody()==1){
                    successMap.put("resultMassage", "ok");
                }else{
                    successMap.put("resultMassage", "新建失败");
                }
            }
            return successMap;

        }catch(Exception e){
            logger.error("BookManagerController.insertclass1Data---------->",e);
            successMap.put("resultMassage", "新建失败!");
            return successMap;
        }
    }
    /***
     *
     * @param response
     * @param strJson
     * @return
     */
    @RequestMapping(value = "/insertclass2", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, ?> insertclass2Data(HttpServletResponse response, @RequestBody String strJson) {


        logger.info("BookManagerController.insertclass2Data---------->"+strJson);
        TypeBook2Query query = JSONObject.parseObject(strJson, TypeBook2Query.class);
        Map<String,Object> successMap = new HashMap<String,Object>();
        try{
            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
            HttpSession session = request.getSession();
            UserManagerLogin userManagerLogin=(UserManagerLogin)session.getAttribute("userManagerLogin");
            query.setcU(userManagerLogin.getId());
            query.setcT(DateUtils.getNowTimeStamp());
            query.setStatus(2);
            if(StringUtils.isEmpty(query.getClassName2())) {
                successMap.put("resultMassage", "分类名称不能为空！");
                return successMap;
            }
            ServiceResult<Integer> serviceResult = new ServiceResult<>(classTypeService.queryTypeBook2ByName(query));
            if(serviceResult.getSuccess()&& serviceResult.getBody()>0){
                successMap.put("resultMassage", "该分类已存在！");
            }else{
                ServiceResult<Integer> result = new ServiceResult<>(classTypeService.insertTypeBook2(query));
                if(result.getSuccess()&& result.getBody()==1){
                    successMap.put("resultMassage", "ok");
                }else{
                    successMap.put("resultMassage", "新建失败");
                }
            }
            return successMap;

        }catch(Exception e){
            logger.error("BookManagerController.insertclass2Data---------->",e);
            successMap.put("resultMassage", "新建失败!");
            return successMap;
        }
    }
    /***
     *
     * @param response
     * @param strJson
     * @return
     */
    @RequestMapping(value = "/bookclass2", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, ?> bookclass2Data(HttpServletResponse response, @RequestBody String strJson) {


        logger.info("BookManagerController.bookclass2Data---------->"+strJson);
        TypeBook2Query query = JSONObject.parseObject(strJson, TypeBook2Query.class);
        Map<String,Object> successMap = new HashMap<String,Object>();
        try{
            ServiceResult<Integer> countRes = new ServiceResult<>(classTypeService.getTypeBook2ListCount(query));
            List<TypeBook2Vo> list  = new ArrayList<>();
            long total = 0;
            if(countRes.getSuccess()  && countRes.getBody() > 0){
                total = countRes.getBody();
                query.setSortName("c_t");
                query.setSortOrder("desc");
                ServiceResult<List<TypeBook2Vo>> result = classTypeService.getTypeBook2Lists(query);
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
    @RequestMapping(value = "/auditClass1", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, ?> auditClass1(HttpServletResponse response, @RequestBody String strJson) {
        logger.info("BookManagerController.auditClass1---------->"+strJson);
        TypeBook1Query query = JSONObject.parseObject(strJson,TypeBook1Query.class);
        Map<String,Object> successMap = new HashMap<String,Object>();
        int cU=1;
        try{
            ServiceResult<Integer> serviceResult = classTypeService.updateBookClass1Status(query.getIds(),1,cU,DateUtils.getNowTimeStamp());
            if(serviceResult.getSuccess()  && serviceResult.getBody() ==1 ){
                successMap.put("resultMassage", "ok");//"获取书籍信息异常，请稍后重试!");
            } else {
                successMap.put("resultMassage", "启用失败");
            }
            return successMap;

        }catch(Exception e){
            logger.error("BookManagerController.auditClass1---------->",e);
            successMap.put("resultMassage", "启用失败，请稍后重试!");
            return successMap;
        }
    }
    /***
     *
     * @param response
     * @param strJson
     * @return
     */
    @RequestMapping(value = "/auditClass2", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, ?> auditClass2(HttpServletResponse response, @RequestBody String strJson) {
        logger.info("BookManagerController.auditClass2---------->"+strJson);
        TypeBook2Query query = JSONObject.parseObject(strJson,TypeBook2Query.class);
        Map<String,Object> successMap = new HashMap<String,Object>();
        int cU=1;
        try{
            ServiceResult<Integer> serviceResult = classTypeService.updateBookClass2Status(query.getIds(),1,cU,DateUtils.getNowTimeStamp());
            if(serviceResult.getSuccess()  && serviceResult.getBody() ==1 ){
                successMap.put("resultMassage", "ok");//"获取书籍信息异常，请稍后重试!");
            } else {
                successMap.put("resultMassage", "启用失败");
            }
            return successMap;

        }catch(Exception e){
            logger.error("BookManagerController2---------->",e);
            successMap.put("resultMassage", "启用失败，请稍后重试!");
            return successMap;
        }
    }
    /***
     *
     * @param response
     * @param strJson
     * @return
     */
    @RequestMapping(value = "/auditNotClass2", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, ?> auditNotClass2(HttpServletResponse response, @RequestBody String strJson) {
        logger.info("BookManagerController.auditNotClass2---------->"+strJson);
        TypeBook2Query query = JSONObject.parseObject(strJson,TypeBook2Query.class);
        Map<String,Object> successMap = new HashMap<String,Object>();
        int cU=1;
        try{
            ServiceResult<Integer> serviceResult = classTypeService.updateBookClass2Status(query.getIds(),2,cU,DateUtils.getNowTimeStamp());
            if(serviceResult.getSuccess()  && serviceResult.getBody() ==1 ){
                successMap.put("resultMassage", "ok");//"获取书籍信息异常，请稍后重试!");
            } else {
                successMap.put("resultMassage", "禁用失败");
            }
            return successMap;

        }catch(Exception e){
            logger.error("BookManagerController2---------->",e);
            successMap.put("resultMassage", "禁用失败，请稍后重试!");
            return successMap;
        }
    }

    /***
     *
     * @param response
     * @param strJson
     * @return
     */
    @RequestMapping(value = "/auditNotClass1", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, ?> auditNotClass1(HttpServletResponse response, @RequestBody String strJson) {
        logger.info("BookManagerController.auditNotClass1---------->"+strJson);
        TypeBook1Query query = JSONObject.parseObject(strJson,TypeBook1Query.class);
        Map<String,Object> successMap = new HashMap<String,Object>();
        int cU=1;
        try{
            ServiceResult<Integer> serviceResult = classTypeService.updateBookClass1Status(query.getIds(),2,cU,DateUtils.getNowTimeStamp());
            if(serviceResult.getSuccess()  && serviceResult.getBody() ==1 ){
                successMap.put("resultMassage", "ok");//"获取书籍信息异常，请稍后重试!");
            } else {
                successMap.put("resultMassage", "禁用失败");
            }
            return successMap;

        }catch(Exception e){
            logger.error("BookManagerController1---------->",e);
            successMap.put("resultMassage", "禁用失败，请稍后重试!");
            return successMap;
        }
    }
    @RequestMapping(value = "/bookpro12", method = RequestMethod.GET)
    public ModelAndView bookpro12() {
        logger.info("BookController.bookpro12------->");
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        HttpSession session = request.getSession();
        //用户
        UserManagerLogin userManagerLogin=(UserManagerLogin)session.getAttribute("userManagerLogin");
        String uri="";
        if(userManagerLogin==null){
            return new ModelAndView("redirect:/sso/sharemanager/gotologin.jsp");
        }
        String url=request.getServletPath();
        int count=userService.isTrue(url,userManagerLogin.getRoleId());
        if(count<1){
            return new ModelAndView("redirect:/sso/ssono/no_per.jsp");
        }
        return new ModelAndView("redirect:/sharebookmanager/jsp/professionalclass.jsp");

    }
    /***
     *
     * @param response
     * @param strJson
     * @return
     */
    @RequestMapping(value = "/bookpro1", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, ?> proclass1Data(HttpServletResponse response, @RequestBody String strJson) {


        logger.info("BookManagerController.proclass1Data---------->"+strJson);
        TypeProfessional1Query query = JSONObject.parseObject(strJson, TypeProfessional1Query.class);
        Map<String,Object> successMap = new HashMap<String,Object>();
        try{

            ServiceResult<Integer> countRes = new ServiceResult<>(classTypeService.getTypeProfessional1ListCount(query));
            List<TypeProfessional1Vo> list  = new ArrayList<>();
            long total = 0;
            if(countRes.getSuccess()  && countRes.getBody() > 0){
                total = countRes.getBody();
                query.setSortName("c_t");
                query.setSortOrder("desc");
                ServiceResult<List<TypeProfessional1Vo>> result = classTypeService.getTypeProfessional1Lists(query);
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
    @RequestMapping(value = "/insertpro1", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, ?> insertpro1Data(HttpServletResponse response, @RequestBody String strJson) {


        logger.info("BookManagerController.insertpro1Data---------->"+strJson);
        TypeProfessional1Query query = JSONObject.parseObject(strJson, TypeProfessional1Query.class);
        Map<String,Object> successMap = new HashMap<String,Object>();
        try{
            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
            HttpSession session = request.getSession();
            UserManagerLogin userManagerLogin=(UserManagerLogin)session.getAttribute("userManagerLogin");
            query.setcU(userManagerLogin.getId());
            query.setcT(DateUtils.getNowTimeStamp());
            query.setStatus(2);
            if(StringUtils.isEmpty(query.getClassName1())) {
                successMap.put("resultMassage", "分类名称不能为空！");
                return successMap;
            }
            ServiceResult<Integer> serviceResult = new ServiceResult<>(classTypeService.queryTypeProfessional1ByName(query));
            if(serviceResult.getSuccess()&& serviceResult.getBody()>0){
                successMap.put("resultMassage", "该分类已存在！");
            }else{
                ServiceResult<Integer> result = new ServiceResult<>(classTypeService.insertTypeProfessional1(query));
                if(result.getSuccess()&& result.getBody()==1){
                    successMap.put("resultMassage", "ok");
                }else{
                    successMap.put("resultMassage", "新建失败");
                }
            }
            return successMap;

        }catch(Exception e){
            logger.error("BookManagerController.insertclass1Data---------->",e);
            successMap.put("resultMassage", "新建失败!");
            return successMap;
        }
    }
    /***
     *
     * @param response
     * @param strJson
     * @return
     */
    @RequestMapping(value = "/insertpro2", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, ?> insertpro2Data(HttpServletResponse response, @RequestBody String strJson) {


        logger.info("BookManagerController.insertpro2Data---------->"+strJson);
        TypeProfessional2Query query = JSONObject.parseObject(strJson, TypeProfessional2Query.class);
        Map<String,Object> successMap = new HashMap<String,Object>();
        try{
            query.setcU(1);
            query.setcT(DateUtils.getNowTimeStamp());
            query.setStatus(2);
            if(StringUtils.isEmpty(query.getClassName2())) {
                successMap.put("resultMassage", "分类名称不能为空！");
                return successMap;
            }
            ServiceResult<Integer> serviceResult = new ServiceResult<>(classTypeService.queryTypeProfessional2ByName(query));
            if(serviceResult.getSuccess()&& serviceResult.getBody()>0){
                successMap.put("resultMassage", "该分类已存在！");
            }else{
                ServiceResult<Integer> result = new ServiceResult<>(classTypeService.insertTypeProfessional2(query));
                if(result.getSuccess()&& result.getBody()==1){
                    successMap.put("resultMassage", "ok");
                }else{
                    successMap.put("resultMassage", "新建失败");
                }
            }
            return successMap;

        }catch(Exception e){
            logger.error("BookManagerController.insertclass2Data---------->",e);
            successMap.put("resultMassage", "新建失败!");
            return successMap;
        }
    }
    /***
     *
     * @param response
     * @param strJson
     * @return
     */
    @RequestMapping(value = "/bookpro2", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, ?> bookpro2Data(HttpServletResponse response, @RequestBody String strJson) {


        logger.info("BookManagerController.bookclass2Data---------->"+strJson);
        TypeProfessional2Query query = JSONObject.parseObject(strJson, TypeProfessional2Query.class);
        Map<String,Object> successMap = new HashMap<String,Object>();
        try{
            ServiceResult<Integer> countRes = new ServiceResult<>(classTypeService.getTypeProfessional2ListCount(query));
            List<TypeProfessional2Vo> list  = new ArrayList<>();
            long total = 0;
            if(countRes.getSuccess()  && countRes.getBody() > 0){
                total = countRes.getBody();
                query.setSortName("c_t");
                query.setSortOrder("desc");
                ServiceResult<List<TypeProfessional2Vo>> result = classTypeService.getTypeProfessional2Lists(query);
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
    @RequestMapping(value = "/auditpro1", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, ?> auditpro1(HttpServletResponse response, @RequestBody String strJson) {
        logger.info("BookManagerController.auditClass1---------->"+strJson);
        TypeProfessional1Query query = JSONObject.parseObject(strJson,TypeProfessional1Query.class);
        Map<String,Object> successMap = new HashMap<String,Object>();
        int cU=1;
        try{
            ServiceResult<Integer> serviceResult = classTypeService.updateTypeProfessional1Status(query.getIds(),1,cU,DateUtils.getNowTimeStamp());
            if(serviceResult.getSuccess()  && serviceResult.getBody() ==1 ){
                successMap.put("resultMassage", "ok");//"获取书籍信息异常，请稍后重试!");
            } else {
                successMap.put("resultMassage", "启用失败");
            }
            return successMap;

        }catch(Exception e){
            logger.error("BookManagerController.auditClass1---------->",e);
            successMap.put("resultMassage", "启用失败，请稍后重试!");
            return successMap;
        }
    }
    /***
     *
     * @param response
     * @param strJson
     * @return
     */
    @RequestMapping(value = "/auditpro2", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, ?> auditpro2(HttpServletResponse response, @RequestBody String strJson) {
        logger.info("BookManagerController.auditClass2---------->"+strJson);
        TypeProfessional2Query query = JSONObject.parseObject(strJson,TypeProfessional2Query.class);
        Map<String,Object> successMap = new HashMap<String,Object>();
        int cU=1;
        try{
            ServiceResult<Integer> serviceResult = classTypeService.updateTypeProfessional2Status(query.getIds(),1,cU,DateUtils.getNowTimeStamp());
            if(serviceResult.getSuccess()  && serviceResult.getBody() ==1 ){
                successMap.put("resultMassage", "ok");//"获取书籍信息异常，请稍后重试!");
            } else {
                successMap.put("resultMassage", "启用失败");
            }
            return successMap;

        }catch(Exception e){
            logger.error("BookManagerController2---------->",e);
            successMap.put("resultMassage", "启用失败，请稍后重试!");
            return successMap;
        }
    }
    /***
     *
     * @param response
     * @param strJson
     * @return
     */
    @RequestMapping(value = "/auditNotpro2", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, ?> auditNotpro2(HttpServletResponse response, @RequestBody String strJson) {
        logger.info("BookManagerController.auditNotClass2---------->"+strJson);
        TypeProfessional2Query query = JSONObject.parseObject(strJson,TypeProfessional2Query.class);
        Map<String,Object> successMap = new HashMap<String,Object>();
        int cU=1;
        try{
            ServiceResult<Integer> serviceResult = classTypeService.updateTypeProfessional2Status(query.getIds(),2,cU,DateUtils.getNowTimeStamp());
            if(serviceResult.getSuccess()  && serviceResult.getBody() ==1 ){
                successMap.put("resultMassage", "ok");//"获取书籍信息异常，请稍后重试!");
            } else {
                successMap.put("resultMassage", "禁用失败");
            }
            return successMap;

        }catch(Exception e){
            logger.error("BookManagerController2---------->",e);
            successMap.put("resultMassage", "禁用失败，请稍后重试!");
            return successMap;
        }
    }

    /***
     *
     * @param response
     * @param strJson
     * @return
     */
    @RequestMapping(value = "/auditNotpro1", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, ?> auditNotpro1(HttpServletResponse response, @RequestBody String strJson) {
        logger.info("BookManagerController.auditNotClass1---------->"+strJson);
        TypeProfessional1Query query = JSONObject.parseObject(strJson,TypeProfessional1Query.class);
        Map<String,Object> successMap = new HashMap<String,Object>();
        int cU=1;
        try{
            ServiceResult<Integer> serviceResult = classTypeService.updateTypeProfessional1Status(query.getIds(),2,cU,DateUtils.getNowTimeStamp());
            if(serviceResult.getSuccess()  && serviceResult.getBody() ==1 ){
                successMap.put("resultMassage", "ok");//"获取书籍信息异常，请稍后重试!");
            } else {
                successMap.put("resultMassage", "禁用失败");
            }
            return successMap;

        }catch(Exception e){
            logger.error("BookManagerController1---------->",e);
            successMap.put("resultMassage", "禁用失败，请稍后重试!");
            return successMap;
        }
    }
}
