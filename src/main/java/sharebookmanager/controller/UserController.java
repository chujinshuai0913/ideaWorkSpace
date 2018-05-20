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
import common.query.BookGiftRecQuery;
import common.query.StudentTeacherQuery;
import common.query.UserManagerQuery;
import common.service.UserService;
import common.util.DateUtils;
import common.util.ListResult;
import common.util.ServiceResult;
import common.util.StringUtils;
import common.vo.BookGiftRecVo;
import common.vo.StudenteacherVo;
import common.vo.UserManagerVo;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
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
                        if(StringUtils.isNotEmpty(query.getStrTime())){
                                query.setTime(DateUtils.getAppointedTimeIntValue(query.getStrTime(), DateUtils.YMD));
                        }else{
                                query.setTime(DateUtils.getTimesmorning(new Date()));
                        }
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


}
