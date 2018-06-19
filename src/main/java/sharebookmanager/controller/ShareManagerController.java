/**
 * Copyright (C), 2018-2018
 * FileName: ShareManagerController
 * Author:   jinshuai
 * Date:     2018/5/21 10:49
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package sharebookmanager.controller;

import com.alibaba.fastjson.JSONObject;
import common.model.ShareActivity;
import common.model.UserManagerLogin;
import common.query.ShareActivityQuery;
import common.query.ShareAnnouncementQuery;
import common.service.ShareManagerService;
import common.service.UserService;
import common.util.DateUtils;
import common.util.ListResult;
import common.util.ServiceResult;
import common.util.StringUtils;
import common.vo.ShareActivityVo;
import common.vo.ShareAnnouncementVo;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.*;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author jinshuai
 * @create 2018/5/21
 * @since 1.0.0
 */
@RestController("ShareManagerController")
@RequestMapping("/share")
public class ShareManagerController {

    private static  final Logger logger = Logger.getLogger(ShareManagerController.class);

    @Autowired
    private ShareManagerService shareManagerService;

    @Autowired
    private UserService userService;



    @RequestMapping(value = "/shareactivitylist1", method = RequestMethod.GET)
    public ModelAndView shareactivitylist1() {
        logger.info("BookController.shareactivitylist1------->");
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
        return new ModelAndView("redirect:/sharebookmanager/jsp/shareactivity.jsp");

    }
    /***
     *
     * @param response
     * @param strJson
     * @return
     */
    @RequestMapping(value = "/shareactivitylist", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, ?> shareactivitlistData(HttpServletResponse response, @RequestBody String strJson) {


        logger.info("ShareManagerController.shareactivitlistData---------->"+strJson);
        ShareActivityQuery query = JSONObject.parseObject(strJson,ShareActivityQuery.class);
        Map<String,Object> successMap = new HashMap<String,Object>();
        try{
            if(StringUtils.isNotEmpty(query.getStartTime())){
                query.setsTime(DateUtils.getAppointedTimeIntValue(query.getStartTime(), DateUtils.YMD));
            }
            if(StringUtils.isNotEmpty(query.getFinshTime())){
                query.setfTime(DateUtils.getAppointedTimeIntValue(query.getFinshTime()+" 23:59:59", DateUtils.YMDHMS));
            }
            ServiceResult<Integer> countRes = shareManagerService.getShareActivityCount(query);
            List<ShareActivityVo> list  = new ArrayList<ShareActivityVo>();
            long total = 0;
            if(countRes.getSuccess()  && countRes.getBody() > 0){
                total = countRes.getBody();
                query.setSortName("activity_time");
                query.setSortOrder("desc");
                ServiceResult<List<ShareActivityVo>> result = shareManagerService.getShareActivityVoList(query);
                if(result.getSuccess()){
                    list = result.getBody();
                }else{
                    successMap.put("resultMassage", result.getMessage());
                    return successMap;
                }
            }
            ListResult results= new ListResult(0, total, query.getPageSize(), query.getPageNumber(), list);
            return results.toMap();

        }catch(Exception e){
            logger.error("ShareManagerController.shareactivitlistData---------->",e);
            successMap.put("resultMassage", "获取活动信息失败，请稍后重试!");
            return successMap;
        }
    }
    @RequestMapping(value = "/shareannouncementlist1", method = RequestMethod.GET)
    public ModelAndView shareannouncementlist1() {
        logger.info("BookController.shareannouncementlist1------->");
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        HttpSession session = request.getSession();
        //用户
        UserManagerLogin userManagerLogin = (UserManagerLogin) session.getAttribute("userManagerLogin");
        String uri = "";
        if (userManagerLogin == null) {
            return new ModelAndView(request.getContextPath() + "/sso/sharemanager/login.jsp");
        }
        String url = request.getServletPath();
        int count = userService.isTrue(url, userManagerLogin.getRoleId());
        if (count < 1) {
            return new ModelAndView("redirect:/sso/ssono/no_per.jsp");
        }
        return new ModelAndView("redirect:/sharebookmanager/jsp/shareannouncement.jsp");
    }

    /***
     *
     * @param response
     * @param strJson
     * @return
     */
    @RequestMapping(value = "/shareannouncementlist", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, ?> shareannouncementData(HttpServletResponse response, @RequestBody String strJson) {
        logger.info("ShareManagerController.shareannouncementData---------->"+strJson);
        ShareAnnouncementQuery query = JSONObject.parseObject(strJson,ShareAnnouncementQuery.class);
        Map<String,Object> successMap = new HashMap<String,Object>();
        try{


            List<ShareAnnouncementVo> list  = new ArrayList<ShareAnnouncementVo>();
            long total = 0;
            if(StringUtils.isNotEmpty(query.getStartTime())){
                query.setsTime(DateUtils.getAppointedTimeIntValue(query.getStartTime(), DateUtils.YMD));
            }
            if(StringUtils.isNotEmpty(query.getFinshTime())){
                query.setfTime(DateUtils.getAppointedTimeIntValue(query.getFinshTime()+" 23:59:59", DateUtils.YMDHMS));
            }
            ServiceResult<Integer> countRes = shareManagerService.getShareAnnouncementCount(query);
            if(countRes.getSuccess()  && countRes.getBody() > 0){
                total = countRes.getBody();
                query.setSortName("upload_time");
                query.setSortOrder("desc");
                ServiceResult<List<ShareAnnouncementVo>> result = shareManagerService.getShareAnnouncementVoList(query);
                if(result.getSuccess()){
                    list = result.getBody();
                }else{
                    successMap.put("resultMassage", result.getMessage());
                    return successMap;
                }
            }
            ListResult results= new ListResult(0, total, query.getPageSize(), query.getPageNumber(), list);
            return results.toMap();

        }catch(Exception e){
            logger.error("ShareManagerController.shareannouncementData---------->",e);
            successMap.put("resultMassage", "获取公告信息失败，请稍后重试!");
            return successMap;
        }
    }
    /***
     *
     * @param response
     * @param strJson
     * @return
     */
    @RequestMapping(value = "/insertactivity", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, ?> insertactivity(HttpServletResponse response, @RequestBody String strJson) {


        logger.info("ShareManagerController.insertactivity---------->"+strJson);
        ShareActivityQuery query = JSONObject.parseObject(strJson, ShareActivityQuery.class);
        Map<String,Object> successMap = new HashMap<String,Object>();
        try{
            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
            HttpSession session = request.getSession();
            UserManagerLogin userManagerLogin=(UserManagerLogin)session.getAttribute("userManagerLogin");
            query.setCu(userManagerLogin.getId());
            query.setCt(DateUtils.getNowTimeStamp());
            query.setIsDelete(2);
            if(StringUtils.isEmpty(query.getStartTime())) {
                successMap.put("resultMassage", "活动时间不能为空！");
                return successMap;
            }
            if(StringUtils.isEmpty(query.getName())) {
                successMap.put("resultMassage", "活动名称不能为空！");
                return successMap;
            }
            if(StringUtils.isEmpty(query.getActivityRoom())) {
                successMap.put("resultMassage", "活动地点不能为空！");
                return successMap;
            }
            if(StringUtils.isEmpty(query.getRemark())) {
                successMap.put("resultMassage", "活动内容不能为空！");
                return successMap;
            }
            //时间转化 判断
            if(StringUtils.isNotEmpty(query.getStartTime())){
                query.setActivityTime(DateUtils.getAppointedTimeIntValue(query.getStartTime(), DateUtils.YMD));
            }
            if(query.getActivityTime()<DateUtils.getNowTimeStamp()){
                successMap.put("resultMassage", "活动时间必须晚于当前时间！");
                return successMap;
            }
            query.setId(DateUtils.getNowTimeStamp()+this.generateRandomNumber(3));
            ServiceResult<Integer> integerServiceResult=shareManagerService.getShareActivityByActivityRoom(query.getActivityRoom(),query.getActivityTime());
            if(integerServiceResult.getSuccess()&&integerServiceResult.getBody()>0){
                successMap.put("resultMassage", "该活动时间该地点占用！");
                return successMap;
            }
            ServiceResult<Integer> result = shareManagerService.insertShareActivity(query);
                if(result.getSuccess()&& result.getBody()==1){
                    successMap.put("resultMassage", "ok");
                }else{
                    successMap.put("resultMassage", "新建失败");
                }
            return successMap;

        }catch(Exception e){
            logger.error("BookManagerController.insertannouncement---------->",e);
            successMap.put("resultMassage", "新建失败!");
            return successMap;
        }
    }
    //获取随机数
    protected int generateRandomNumber(int n){
        return (int)(Math.random()*9*Math.pow(10,n-1)) + (int)Math.pow(10,n-1);
    }
    /***
     *
     * @param response
     * @param strJson
     * @return
     */
    @RequestMapping(value = "/insertannouncement", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, ?> insertannouncement(HttpServletResponse response, @RequestBody String strJson) {


        logger.info("ShareManagerController.insertannouncement---------->"+strJson);
        ShareAnnouncementQuery query = JSONObject.parseObject(strJson, ShareAnnouncementQuery.class);
        Map<String,Object> successMap = new HashMap<String,Object>();
        try{
            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
            HttpSession session = request.getSession();
            UserManagerLogin userManagerLogin=(UserManagerLogin)session.getAttribute("userManagerLogin");
            query.setCu(userManagerLogin.getId());
            query.setCt(DateUtils.getNowTimeStamp());
            query.setIsDelete(2);
            query.setStatus(2);
            if(StringUtils.isEmpty(query.getStartTime())) {
                successMap.put("resultMassage", "预定上传时间不能为空！");
                return successMap;
            }
            if(StringUtils.isEmpty(query.getFinshTime())) {
                successMap.put("resultMassage", "预定结束时间不能为空！");
                return successMap;
            }
            if(query.getActivityId()<=0){
                successMap.put("resultMassage", "编号不能为空！");
                return successMap;
            }
            if(query.getActivityId()>0){
                ServiceResult<ShareActivity> shareActivityServiceResult = shareManagerService.selectByPrimaryKey(query.getActivityId());
                if(shareActivityServiceResult.getSuccess()&&shareActivityServiceResult.getBody()==null){
                    successMap.put("resultMassage", "不存在该编号下的活动，请验证！");
                    return successMap;
                }
            }
            //时间转化 判断
            if(StringUtils.isNotEmpty(query.getStartTime())){
                query.setUploadTime(DateUtils.getAppointedTimeIntValue(query.getStartTime(), DateUtils.YMD));

            }else{
                query.setUploadTime(DateUtils.getTimesmorning(new Date()));
            }
            if(StringUtils.isNotEmpty(query.getFinshTime())){
                query.setEndTime(DateUtils.getAppointedTimeIntValue(query.getFinshTime()+" 23:59:59", DateUtils.YMDHMS));
            }else{
                query.setEndTime(DateUtils.getTimesnight(new Date()));
            }
            if(query.getUploadTime()<DateUtils.getNowTimeStamp()){
                successMap.put("resultMassage", "预定上传时间必须晚于当前时间！");
                return successMap;
            }
            if(query.getUploadTime()>=query.getEndTime()){
                successMap.put("resultMassage", "预定结束时间必须晚于预定开始时间！");
                return successMap;
            }
            ServiceResult<Integer> integerServiceResult=shareManagerService.getShareAnnouncementBySrc(query.getSrc());
            if(integerServiceResult.getSuccess()&&integerServiceResult.getBody()>0){
                successMap.put("resultMassage", "该信息公告已存在");
                return successMap;
            }
            ServiceResult<Integer> result = shareManagerService.insertShareAnnouncement(query);
            if(result.getSuccess()&& result.getBody()==1){
                successMap.put("resultMassage", "ok");
            }else{
                successMap.put("resultMassage", "新建失败");
            }
            return successMap;

        }catch(Exception e){
            logger.error("BookManagerController.insertannouncement---------->",e);
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
    @RequestMapping(value = "/auditactivity", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, ?> auditactivity(HttpServletResponse response, @RequestBody String strJson) {
        logger.info("ShareManagerController.auditactivity---------->"+strJson);
        ShareActivityQuery query = JSONObject.parseObject(strJson,ShareActivityQuery.class);
        Map<String,Object> successMap = new HashMap<String,Object>();
        int cU=1;
        try{
            ServiceResult<Integer> serviceResult = shareManagerService.updateShareActivityStatus(query.getIds(),2,cU,DateUtils.getNowTimeStamp());
            if(serviceResult.getSuccess()  && serviceResult.getBody() ==1 ){
                successMap.put("resultMassage", "ok");//"获取书籍信息异常，请稍后重试!");
            } else {
                successMap.put("resultMassage", "恢复失败");
            }
            return successMap;

        }catch(Exception e){
            logger.error("BookManagerController.auditClass1---------->",e);
            successMap.put("resultMassage", "恢复失败，请稍后重试!");
            return successMap;
        }
    }
    /***
     *
     * @param response
     * @param strJson
     * @return
     */
    @RequestMapping(value = "/auditannouncement", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, ?> auditClass2(HttpServletResponse response, @RequestBody String strJson) {
        logger.info("ShareManagerController.auditClass2---------->"+strJson);
        ShareAnnouncementQuery query = JSONObject.parseObject(strJson,ShareAnnouncementQuery.class);
        Map<String,Object> successMap = new HashMap<String,Object>();
        int cU=1;
        try{
            ServiceResult<Integer> serviceResult = shareManagerService.updateShareAnnouncementStatus(query.getIds(),2,cU,DateUtils.getNowTimeStamp());
            if(serviceResult.getSuccess()  && serviceResult.getBody() ==1 ){
                successMap.put("resultMassage", "ok");//"获取书籍信息异常，请稍后重试!");
            } else {
                successMap.put("resultMassage", "恢复失败");
            }
            return successMap;

        }catch(Exception e){
            logger.error("BookManagerController2---------->",e);
            successMap.put("resultMassage", "恢复失败，请稍后重试!");
            return successMap;
        }
    }
    /***
     *
     * @param response
     * @param strJson
     * @return
     */
    @RequestMapping(value = "/auditNotactivity", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, ?> auditNotactivity(HttpServletResponse response, @RequestBody String strJson) {
        logger.info("BookManagerController.auditNotactivity---------->"+strJson);
        ShareActivityQuery query = JSONObject.parseObject(strJson,ShareActivityQuery.class);
        Map<String,Object> successMap = new HashMap<String,Object>();
        int cU=1;
        try{
            ServiceResult<Integer> serviceResult = shareManagerService.updateShareActivityStatus(query.getIds(),1,cU,DateUtils.getNowTimeStamp());
            if(serviceResult.getSuccess()  && serviceResult.getBody() ==1 ){
                successMap.put("resultMassage", "ok");//"获取书籍信息异常，请稍后重试!");
            } else {
                successMap.put("resultMassage", "删除失败");
            }
            return successMap;

        }catch(Exception e){
            logger.error("BookManagerController2---------->",e);
            successMap.put("resultMassage", "删除失败，请稍后重试!");
            return successMap;
        }
    }
    /***
     *
     * @param response
     * @param strJson
     * @return
     */
    @RequestMapping(value = "/auditNotannouncement", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, ?> auditNotClass2(HttpServletResponse response, @RequestBody String strJson) {
        logger.info("BookManagerController.auditNotClass2---------->"+strJson);
        ShareAnnouncementQuery query = JSONObject.parseObject(strJson,ShareAnnouncementQuery.class);
        Map<String,Object> successMap = new HashMap<String,Object>();
        int cU=1;
        try{
            ServiceResult<Integer> serviceResult = shareManagerService.updateShareAnnouncementStatus(query.getIds(),1,cU,DateUtils.getNowTimeStamp());
            if(serviceResult.getSuccess()  && serviceResult.getBody() ==1 ){
                successMap.put("resultMassage", "ok");//"获取书籍信息异常，请稍后重试!");
            } else {
                successMap.put("resultMassage", "删除失败");
            }
            return successMap;

        }catch(Exception e){
            logger.error("BookManagerController2---------->",e);
            successMap.put("resultMassage", "删除失败，请稍后重试!");
            return successMap;
        }
    }

}
