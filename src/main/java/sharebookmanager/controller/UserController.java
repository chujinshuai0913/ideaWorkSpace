/**
 * Copyright (C), 2018-2018
 * FileName: UserController
 * Author:   jinshuai
 * Date:     2018/4/12 23:27
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package sharebookmanager.controller;

import com.alibaba.fastjson.JSONObject;
import common.constant.ConstantsUtils;
import common.model.*;
import common.query.*;
import common.service.BookService;
import common.service.UserService;
import common.util.DateUtils;
import common.util.ListResult;
import common.util.ServiceResult;
import common.util.StringUtils;
import common.vo.*;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.InputStream;
import java.util.*;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author jinshuai
 * @create 2018/4/12
 * @since 1.0.0
 */

@RestController("UserController")
@RequestMapping("/usersharemanager")
public class UserController {


        private static  final Logger logger = Logger.getLogger(UserController.class);
        @Autowired
        private UserService userService;
       @Autowired
       private BookService bookService;

        @RequestMapping(value = "/usermanager1", method = RequestMethod.GET)
        public ModelAndView userlistData1() {
                logger.info("UserController.userlistData1------->");
                HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
                HttpSession session = request.getSession();
                //用户
                UserManagerLogin userManagerLogin = (UserManagerLogin) session.getAttribute("userManagerLogin");
                String uri = "";
                if (userManagerLogin == null) {
                    return new ModelAndView("redirect:/sso/sharemanager/gotologin.jsp");
                }
                String url = request.getServletPath();
                int count = userService.isTrue(url, userManagerLogin.getRoleId());
                if (count < 1) {
                        return new ModelAndView("redirect:/sso/ssono/no_per.jsp");
                }
                return new ModelAndView("redirect:/sharebookmanager/jsp/usermanager.jsp");
        }
        /***
         *
         * @param response
         * @param strJson
         * @return
         */
        @RequestMapping(value = "/userlistData", method = RequestMethod.POST)
        @ResponseBody
        public Map<String, ?> listData(HttpServletResponse response, @RequestBody String strJson) {


                logger.info("UserController.userlistData---------->"+strJson);
                UserManagerQuery query = JSONObject.parseObject(strJson,UserManagerQuery.class);
                Map<String,Object> successMap = new HashMap<String,Object>();
                try{

                        ServiceResult<Integer> countRes = userService.queryCountUserShareManager(query);
                        List<UserManagerVo> list  = new ArrayList<UserManagerVo>();
                        long total = 0;
                        if(countRes.getSuccess()  && countRes.getBody() > 0){
                                total = countRes.getBody();
                                query.setSortName("login_time");
                                ServiceResult<List<UserManagerVo>> result = userService.queryUserShareManagerLists(query);
                                if(result.getSuccess()){
                                        list = result.getBody();
                                }else{
                                        successMap.put("resultMassage", result.getMessage());//"获取信息异常，请稍后重试!");
                                        return successMap;
                                }
                        }
                        ListResult results= new ListResult(0, total, query.getPageSize(), query.getPageNumber(), list);
                        return results.toMap();

                }catch(Exception e){
                        logger.error("UserController.userlistData---------->",e);
                        successMap.put("resultMassage", "获取信息异常，请稍后重试!");
                        return successMap;
                }
        }
        /***
         *
         * @param response
         * @param strJson
         * @return
         */
        @RequestMapping(value = "/userRolelistData", method = RequestMethod.POST)
        @ResponseBody
        public Map<String, ?> listRoleData(HttpServletResponse response, @RequestBody String strJson) {


                logger.info("UserController.userlistData---------->"+strJson);
                UserManagerQuery query = JSONObject.parseObject(strJson,UserManagerQuery.class);
                Map<String,Object> successMap = new HashMap<String,Object>();
                try{
                        ServiceResult<Integer> countRes = userService.queryCountUserShareManager(query);
                        List<UserManagerVo> list  = new ArrayList<UserManagerVo>();
                        long total = 0;
                        if(countRes.getSuccess()  && countRes.getBody() > 0){
                                total = countRes.getBody();
                                query.setSortName("login_time");
                                ServiceResult<List<UserManagerVo>> result = userService.queryUserShareManagerLists(query);
                                if(result.getSuccess()){
                                        list = result.getBody();
                                }else{
                                        successMap.put("resultMassage", result.getMessage());//"获取信息异常，请稍后重试!");
                                        return successMap;
                                }
                        }
                        ListResult results= new ListResult(0, total, query.getPageSize(), query.getPageNumber(), list);
                        return results.toMap();

                }catch(Exception e){
                        logger.error("UserController.userlistData---------->",e);
                        successMap.put("resultMassage", "获取信息异常，请稍后重试!");
                        return successMap;
                }
        }


        @RequestMapping(value = "/sharerole1", method = RequestMethod.GET)
        public ModelAndView sharerole1() {
                logger.info("UserController.sharerole1------->");
                HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
                HttpSession session = request.getSession();
                //用户
                UserManagerLogin userManagerLogin = (UserManagerLogin) session.getAttribute("userManagerLogin");
                String uri = "";
               if (userManagerLogin == null) {
                   return new ModelAndView("redirect:/sso/sharemanager/gotologin.jsp");
                }
                String url = request.getServletPath();
                int count = userService.isTrue(url, userManagerLogin.getRoleId());
                if (count < 1) {
                        return new ModelAndView("redirect:/sso/ssono/no_per.jsp");
                }
                return new ModelAndView("redirect:/sharebookmanager/jsp/sharerole.jsp");
        }
        /***
         *
         * @param response
         * @param strJson
         * @return
         */
        @RequestMapping(value = "/rolelistData", method = RequestMethod.POST)
        @ResponseBody
        public Map<String, ?> rolelistData(HttpServletResponse response, @RequestBody String strJson) {
                logger.info("UserController.rolelistData---------->"+strJson);
                ShareRoleQuery query = JSONObject.parseObject(strJson,ShareRoleQuery.class);
                Map<String,Object> successMap = new HashMap<String,Object>();
                ShareRole shareRole=new ShareRole();
                try{
                        List<ShareRole> list=new ArrayList<>();
                        ServiceResult<Integer> serviceResult =userService.queryUserRoleCount(query);
                    int total=0;
                    if(serviceResult.getSuccess()&&serviceResult.getBody()>0){
                        total=serviceResult.getBody();
                    }
                        ServiceResult<List<ShareRole>> result = userService.queryUserRole(query);
                       if(result.getSuccess()&&result.getBody()!=null){
                               list=result.getBody();
                       }
                        ListResult results= new ListResult(0, total, query.getPageSize(), query.getPageNumber(), list);
                        return results.toMap();

                }catch(Exception e){
                        logger.error("UserController.rolelistData---------->",e);
                        successMap.put("resultMassage", "获取信息异常，请稍后重试!");
                        return successMap;
                }
        }
        @RequestMapping(value = "/updaterole", method = RequestMethod.POST)
        @ResponseBody
        public Map<String,?> updateRole(HttpServletResponse respone,@RequestBody String strJson){
                logger.info("UserController.userlistData---------->"+strJson);
                UserManagerQuery query = JSONObject.parseObject(strJson,UserManagerQuery.class);
                Map<String,Object> succMap = new HashMap<String,Object>();

                if(query.getId() == null){
                        succMap.put("resultMassage", "用户Id不能为空");
                        return succMap;
                }
                if(query.getRoleId() == null){
                        succMap.put("resultMassage", "角色不能为空");
                        return succMap;
                }

                try{
                        ServiceResult<Boolean> result =userService.updateRole(query);
                        succMap.put("resultMassage", result.getSuccess()?"ok":result.getMessage());
                        return succMap;
                }catch(Exception e){
                        logger.error("角色修改失败", e);
                        succMap.put("resultMassage", "角色修改失败");
                        return succMap;
                }
        }
        @RequestMapping(value = "/insertrole", method = RequestMethod.POST)
        @ResponseBody
        public Map<String,?> insertrole(HttpServletResponse respone,@RequestBody String strJson){
                logger.info("UserController.insertrole---------->"+strJson);
                ShareRoleQuery query = JSONObject.parseObject(strJson,ShareRoleQuery.class);
                Map<String,Object> succMap = new HashMap<String,Object>();
                if(query.getRole() == null){
                        succMap.put("resultMassage", "角色不能为空");
                        return succMap;
                }
                try{
                        ServiceResult<Integer> result =userService.insertRole(query);
                        succMap.put("resultMassage", result.getSuccess()?"ok":result.getMessage());
                        return succMap;
                }catch(Exception e){
                        logger.error("插入失败", e);
                        succMap.put("resultMassage", "插入失败");
                        return succMap;
                }
        }
        @RequestMapping(value = "/studenteacher", method = RequestMethod.GET)
        public ModelAndView studenteacher() {
                logger.info("BookController.studenteacher------->");
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
                return new ModelAndView("redirect:/sharebookmanager/jsp/studenteacher.jsp");

        }
        /***
         *
         * @param response
         * @param strJson
         * @return
         */
        @RequestMapping(value = "/studenteacherlist", method = RequestMethod.POST)
        @ResponseBody
        public Map<String, ?> studenteacherlistData(HttpServletResponse response, @RequestBody String strJson) {


                logger.info("BookManagerController.studenteacherlistData---------->"+strJson);
                StudentTeacherQuery query = JSONObject.parseObject(strJson, StudentTeacherQuery.class);
                Map<String,Object> successMap = new HashMap<String,Object>();
                try{
                        ServiceResult<Integer> countRes = userService.queryStudenteacherCount(query);
                        List<StudenteacherVo> list  = new ArrayList<>();
                        long total = 0;
                        if(countRes.getSuccess()  && countRes.getBody() > 0){
                                total = countRes.getBody();
                                query.setSortName("time");
                                query.setSortOrder("desc");
                                ServiceResult<List<StudenteacherVo>> result = userService.queryStudenteacherList(query);
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
         //查询分组
        //新建分组
        //分组内添加权限
        //将分组授予角色

        @RequestMapping(value = "/permissionsset", method = RequestMethod.GET)
        public ModelAndView permissionsset() {
                logger.info("UserController.permissionsset------->");
                HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
                HttpSession session = request.getSession();
                //用户
                UserManagerLogin userManagerLogin = (UserManagerLogin) session.getAttribute("userManagerLogin");
                String uri = "";
               if (userManagerLogin == null) {
                   return new ModelAndView("redirect:/sso/sharemanager/gotologin.jsp");
                }
                String url = request.getServletPath();
                int count = userService.isTrue(url, userManagerLogin.getRoleId());
                if (count < 1) {
                        return new ModelAndView("redirect:/sso/ssono/no_per.jsp");
                }
                return new ModelAndView("redirect:/sharebookmanager/jsp/permissionslistmanager.jsp");
        }
        @RequestMapping(value = "/getgroupname", method = RequestMethod.POST)
        @ResponseBody
        public Map<String,?> getgroupname(HttpServletResponse respone,@RequestBody String strJson){
                logger.info("UserController.getgroupname---------->"+strJson);
                PermissionsListManagerQuery  query = JSONObject.parseObject(strJson,PermissionsListManagerQuery.class);
                Map<String,Object> succMap = new HashMap<String,Object>();
                List<PermissionsListManager> list  = new ArrayList<>();
                try{
                    ServiceResult<Integer> serviceResult =userService.getPermissionsListManagerListCount(query);
                    int total=0;
                    if(serviceResult.getSuccess()&&serviceResult.getBody()>0){
                        total=serviceResult.getBody();
                    }
                        ServiceResult<List<PermissionsListManager>> result =userService.getPermissionsListManagerList(query);
                        if(result.getSuccess()  && result.getBody() !=null){
                                list = result.getBody();

                        }else {
                                succMap.put("resultMassage", result.getMessage());//"获取书籍信息异常，请稍后重试!");
                                return succMap;
                        }
                        ListResult results= new ListResult(0, total, query.getPageSize(), query.getPageNumber(), list);
                        return results.toMap();
                }catch(Exception e){
                        logger.error("查询失败", e);
                        succMap.put("resultMassage", "查询失败");
                        return succMap;
                }
        }
        @RequestMapping(value = "/updateperstatus", method = RequestMethod.POST)
        @ResponseBody
        public Map<String,?> updateperstatus(HttpServletResponse respone,@RequestBody String strJson){
                logger.info("UserController.updateperstatus---------->"+strJson);
                PermissionsListManager query = JSONObject.parseObject(strJson,PermissionsListManager.class);
                Map<String,Object> succMap = new HashMap<String,Object>();
                try{
                        if(query.getStatus()==1){
                                query.setStatus(2);
                        }else if(query.getStatus()==2) {
                                query.setStatus(1);
                        }
                        ServiceResult<Integer> result =userService.updatePermissionsListManagerStatus(query);
                        succMap.put("resultMassage", result.getSuccess()?"ok":result.getMessage());
                        return succMap;
                }catch(Exception e){
                                logger.error("修改失败", e);
                                succMap.put("resultMassage", "修改失败");
                                return succMap;
                        }
        }

        @RequestMapping(value = "/insertpermission", method = RequestMethod.POST)
        @ResponseBody
        public Map<String,?> insertpermission(HttpServletResponse respone,@RequestBody String strJson){
                logger.info("UserController.insertrole---------->"+strJson);
                PermissionsListManager query = JSONObject.parseObject(strJson,PermissionsListManager.class);
                Map<String,Object> succMap = new HashMap<String,Object>();
                if(query.getUrl() == null){
                        succMap.put("resultMassage", "url不能为空");
                        return succMap;
                }
                if(query.getUrlName() == null){
                        succMap.put("resultMassage", "名称不能为空");
                        return succMap;
                }
                query.setStatus(2);
                try{
                        ServiceResult<Integer> result =userService.insertPerrmission(query);
                        succMap.put("resultMassage", result.getSuccess()?"ok":result.getMessage());
                        return succMap;
                }catch(Exception e){
                        logger.error("插入失败", e);
                        succMap.put("resultMassage", "插入失败");
                        return succMap;
                }
        }
        @RequestMapping(value = "/getpermissionurlno", method = RequestMethod.POST)
        @ResponseBody
        public Map<String,?> getpermissionurlno(HttpServletResponse respone,@RequestBody String strJson){
                logger.info("UserController.getpermissionurlno---------->"+strJson);
                PermissionsSetQuery  query = JSONObject.parseObject(strJson,PermissionsSetQuery.class);
                Map<String,Object> succMap = new HashMap<String,Object>();
                List<PermissionsListManager> list  = new ArrayList<>();
                List<PermissionsSet> listSet  = new ArrayList<>();
                List<Integer> persmissionIds=new ArrayList<>();
                try{
                    persmissionIds =userService.getPermissionsSetIds(query.getRoleId());
                    PermissionsListManagerQuery query1=new PermissionsListManagerQuery();
                    query1.setStatus(1);
                    query1.setPageNumber(query.getPageNumber());
                    query1.setPageSize(query.getPageSize());
                    query1.setSortName(query.getSortName());
                    query1.setSortOrder(query.getSortOrder());
                    query1.setIds(persmissionIds);
                    ServiceResult<Integer> serviceResult =userService.getNotPermissionsListManagerListCount(query1);
                    int total=0;
                    if(serviceResult.getSuccess()&&serviceResult.getBody()>0){
                        total=serviceResult.getBody();
                    }
                        ServiceResult<List<PermissionsListManager>> result =userService.getNotPermissionsListManagerList(query1);
                        if(result.getSuccess()  && result.getBody() !=null){
                                list = result.getBody();
                        }else {
                                succMap.put("resultMassage", result.getMessage());//"获取书籍信息异常，请稍后重试!");
                                return succMap;
                        }
                        ListResult results= new ListResult(0, total, query.getPageSize(), query.getPageNumber(), list);
                        return results.toMap();
                }catch(Exception e){
                        logger.error("查询失败", e);
                        succMap.put("resultMassage", "查询失败");
                        return succMap;
                }
        }
    @RequestMapping(value = "/getpermissionurl", method = RequestMethod.POST)
    @ResponseBody
    public Map<String,?> getpermissionurl(HttpServletResponse respone,@RequestBody String strJson){
        logger.info("UserController.getpermissionurl---------->"+strJson);
        PermissionsSetQuery  query = JSONObject.parseObject(strJson,PermissionsSetQuery.class);
        Map<String,Object> succMap = new HashMap<String,Object>();
        List<PermissionsListManager> list  = new ArrayList<>();
        List<PermissionsSet> listSet  = new ArrayList<>();
        List<Integer> persmissionIds=new ArrayList<>();
        try{
            PermissionsListManagerQuery query1=new PermissionsListManagerQuery();
            persmissionIds =userService.getPermissionsSetIds(query.getRoleId());
            query1.setStatus(1);
            query1.setPageNumber(query.getPageNumber());
            query1.setPageSize(query.getPageSize());
            query1.setSortName(query.getSortName());
            query1.setSortOrder(query.getSortOrder());
            query1.setIds(persmissionIds);
            ServiceResult<Integer> serviceResult =userService.getPermissionsListManagerListCount(query1);
            int total=0;
            if(serviceResult.getSuccess()&&serviceResult.getBody()>0){
                total=serviceResult.getBody();

            ServiceResult<List<PermissionsListManager>> result =userService.getPermissionsListManagerList(query1);
            if(result.getSuccess()&& result.getBody() !=null){
                   list=result.getBody();
            }else {
                succMap.put("resultMassage", result.getMessage());//"获取书籍信息异常，请稍后重试!");
                return succMap;
            }
            }
            ListResult results= new ListResult(0, total, query.getPageSize(), query.getPageNumber(), list);
            return results.toMap();
        }catch(Exception e){
            logger.error("查询失败", e);
            succMap.put("resultMassage", "查询失败");
            return succMap;
        }
    }
    //解除权限
    @RequestMapping(value = "/deleteperset", method = RequestMethod.POST)
    @ResponseBody
    public Map<String,?> deleteperset(HttpServletResponse respone,@RequestBody String strJson){
        logger.info("UserController.deleteperset---------->"+strJson);
        PermissionsSetQuery query = JSONObject.parseObject(strJson,PermissionsSetQuery.class);
        Map<String,Object> succMap = new HashMap<String,Object>();
        if(query.getRoleId() == null){
            succMap.put("resultMassage", "解除失败请刷新");
            return succMap;
        }
        try{
            ServiceResult<Integer> result =userService.deletePerrmissionSet(query);
            succMap.put("resultMassage", result.getSuccess()?"ok":result.getMessage());
            return succMap;
        }catch(Exception e){
            logger.error("解除失败", e);
            succMap.put("resultMassage", "解除失败");
            return succMap;
        }
    }
   //添加新权限
    @RequestMapping(value = "/insertperset", method = RequestMethod.POST)
    @ResponseBody
    public Map<String,?> insertperset(HttpServletResponse respone,@RequestBody String strJson){
        logger.info("UserController.insertperset---------->"+strJson);
        PermissionsSetQuery query = JSONObject.parseObject(strJson,PermissionsSetQuery.class);
        Map<String,Object> succMap = new HashMap<String,Object>();
        if(query.getRoleId() == null){
            succMap.put("resultMassage", "插入失败请刷新");
            return succMap;
        }
        try{
            ServiceResult<Integer> result =userService.insertPerrmissionSet(query);
            succMap.put("resultMassage", result.getSuccess()?"ok":result.getMessage());
            return succMap;
        }catch(Exception e){
            logger.error("插入失败", e);
            succMap.put("resultMassage", "插入失败");
            return succMap;
        }
    }
    //注册新用户
    @RequestMapping(value = "/insertusermanager", method = RequestMethod.POST)
    @ResponseBody
    public Map<String,?> insertusermanager(HttpServletResponse respone,@RequestBody String strJson){
        logger.info("UserController.insertusermanager---------->"+strJson);
        UserManagerQuery query = JSONObject.parseObject(strJson,UserManagerQuery.class);
        UserManagerQuery query1=new UserManagerQuery();
        UserManagerQuery query2=new UserManagerQuery();
        UserManagerQuery query3=new UserManagerQuery();
        Map<String,Object> succMap = new HashMap<String,Object>();
        if(query.getUsername() == null){
            succMap.put("resultMassage", "用户名不能为空");
            return succMap;
        }else {
            query2.setUsername(query.getUsername());
            ServiceResult<Integer> result=userService.queryUserShareManagerCount(query2);
            if(result.getSuccess()&&result.getBody()!=null&&result.getBody()>0){
                succMap.put("resultMassage", "用户名已经存在了");
                return succMap;
            }
        }
        if(query.getPhoneNumber() == null){
            succMap.put("resultMassage", "手机号不能为空");
            return succMap;
        }else {
            query1.setPhoneNumber(query.getPhoneNumber());
            ServiceResult<Integer> result=userService.queryUserShareManagerCount(query1);
             if(result.getSuccess()&&result.getBody()!=null&&result.getBody()>0){
                         succMap.put("resultMassage", "手机号已经存在了");
                         return succMap;
             }
        }

        if(query.getWorkId() == null){
            succMap.put("resultMassage", "学号不能为空");
            return succMap;
        }else {
            query3.setWorkId(query.getWorkId());
            ServiceResult<Integer> result=userService.queryUserShareManagerCount(query3);
            if(result.getSuccess()&&result.getBody()!=null&&result.getBody()>0){
                succMap.put("resultMassage", "学号已经认证了");
                return succMap;
            }else{
                ServiceResult<StudentTeacherList> result1=userService.getStudentTeacherList(query.getWorkId());
                if(result1.getSuccess()&&result1.getBody()!=null){
                    StudentTeacherList studentTeacherList=result1.getBody();
                    if(!studentTeacherList.getStName().equals(query.getUsername())){
                        succMap.put("resultMassage", "请输入用户的真实姓名！");
                        return succMap;
                    }
                }else{
                    succMap.put("resultMassage", "请查看学号是否正确！！");
                    return succMap;
                }
            }
        }
        query.setSignTime(DateUtils.getNowTimeStamp());
        query.setPassword(1234567);
        query.setRoleId(3);
        try{
            ServiceResult<Integer> result1 =userService.insertUserManager(query);
            succMap.put("resultMassage", result1.getSuccess()?"ok":result1.getMessage());
            return succMap;
        }catch(Exception e){
            logger.error("插入失败", e);
            succMap.put("resultMassage", "插入失败");
            return succMap;
        }
    }
    /*导入学生教师信息*/
    @RequestMapping(value = "/importStudent", method = RequestMethod.POST)
    @ResponseBody
    public  Map<String,?> importStudent( HttpServletRequest request){
        Map<String,Object> succMap = new HashMap<String,Object>();
        try{
            //获取上传的文件
            MultipartHttpServletRequest multipart = (MultipartHttpServletRequest) request;
            MultipartFile file = multipart.getFile("upfile");
            InputStream in = file.getInputStream();
            //数据导入
            bookService.importExcelInfo(in,file);
            in.close();
            succMap.put("resultMassage", "导入成功");
            return succMap;
        }catch(Exception e){
            logger.error("导入失败", e);
            succMap.put("resultMassage", "导入失败");
            return succMap;
        }
    }
    /*倒入书单*/
    @RequestMapping(value = "/importBookList", method = RequestMethod.POST)
    @ResponseBody
    public  Map<String,?> importBookList( HttpServletRequest request){
        Map<String,Object> succMap = new HashMap<String,Object>();
        try{
            //获取上传的文件
            MultipartHttpServletRequest multipart = (MultipartHttpServletRequest) request;
            MultipartFile file = multipart.getFile("upfile");
            InputStream in = file.getInputStream();
            //数据导入
            bookService.importBookListExcelInfo(in,file);
            in.close();
            succMap.put("resultMassage", "导入成功");
            return succMap;
        }catch(Exception e){
            logger.error("导入失败", e);
            succMap.put("resultMassage", "导入失败");
            return succMap;
        }
    }
}
