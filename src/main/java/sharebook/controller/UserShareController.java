/**
 * Copyright (C), 2018-2018
 * FileName: UserShareController
 * Author:   jinshuai
 * Date:     2018/4/12 23:25
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package sharebook.controller;

import com.alibaba.fastjson.JSONObject;
import common.constant.ConstantsUtils;
import common.model.Abnormal;
import common.model.StudentTeacherList;
import common.query.StudentTeacherQuery;
import common.query.UserShareQuery;
import common.service.UserService;
import common.util.DateUtils;
import common.util.ListResult;
import common.util.ServiceResult;
import common.util.StringUtils;
import common.vo.UserShareVo;
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

@RestController("UserShareController")
@RequestMapping("/usershare")
public class UserShareController{

        private static  final Logger logger = Logger.getLogger(sharebook.controller.UserShareController.class);
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


        logger.info("UserShareController.userlistData---------->"+strJson);
        UserShareQuery query = JSONObject.parseObject(strJson,UserShareQuery.class);
        Map<String,Object> successMap = new HashMap<String,Object>();
        try{
            if(StringUtils.isNotEmpty(query.getStartSignDate())){
                query.setsSignDate(DateUtils.getAppointedTimeIntValue(query.getStartSignDate(), DateUtils.YMD));
            }else{
                query.setsSignDate(DateUtils.getTimesmorning(new Date()));
            }
            if(StringUtils.isNotEmpty(query.getEndSignDate())){
                query.seteSignDate(DateUtils.getAppointedTimeIntValue(query.getEndSignDate()+" 23:59:59", DateUtils.YMDHMS));
            }else{
                query.seteSignDate(DateUtils.getTimesnight(new Date()));
            }
            ServiceResult<Integer> countRes = userService.queryCountUserShare(query);
            List<UserShareVo> list  = new ArrayList<UserShareVo>();
            long total = 0;
            if(countRes.getSuccess()  && countRes.getBody() > 0){
                total = countRes.getBody();
                query.setSortName("login_time");
                ServiceResult<List<UserShareVo>> result = userService.queryUserShareLists(query);
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
            logger.error("UserShareController.userlistData---------->",e);
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
    @RequestMapping(value = "/userlistDetail", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, ?> listDetail(HttpServletResponse response, @RequestBody String strJson) {


        logger.info("UserShareController.userlistData---------->"+strJson);
        StudentTeacherQuery query = JSONObject.parseObject(strJson,StudentTeacherQuery.class);
        Map<String,Object> successMap = new HashMap<String,Object>();
        try{
               StudentTeacherList studentTeacherList=new StudentTeacherList();
                List<StudentTeacherList> lists=new ArrayList<>();
            ServiceResult<StudentTeacherList> result=new ServiceResult<>();
                Integer schoolCode=query.getSchoolCode();
                Integer workId=query.getWorkId();
                if(schoolCode!=null&&schoolCode>0){
                    result = userService.getStudentTeacherList(schoolCode);
                }
                if(workId!=null&&workId>0){
                    result = userService.getStudentTeacherList(workId);
                }
                if(result.getSuccess()){
                    studentTeacherList = result.getBody();
                    lists.add(studentTeacherList);
                }else{
                    successMap.put("resultMassage", result.getMessage());//"获取信息异常，请稍后重试!");
                    return successMap;
                }
            ListResult results= new ListResult(0, 1, query.getPageSize(), query.getPageNumber(), lists);
            return results.toMap();

        }catch(Exception e){
            logger.error("UserShareController.userlistData---------->",e);
            successMap.put("resultMassage", "获取信息异常，请稍后重试!");
            return successMap;
        }
    }
    @RequestMapping(value = "/abnormaluser", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, ?> abnormallistData(HttpServletResponse response, @RequestBody String strJson) {


        logger.info("UserShareController.abnormallistData---------->"+strJson);
        UserShareQuery query = JSONObject.parseObject(strJson,UserShareQuery.class);
        Map<String,Object> successMap = new HashMap<String,Object>();
        try{
            List<Integer> userIds=new ArrayList<>();
            query.setSortName("login_time");
            query.setStatus(ConstantsUtils.UserShareCode.STATUS);
            Map<Integer,UserShareVo> map=new HashMap<>();
            /*上周异常用户*/
            List<UserShareVo> list  = new ArrayList<UserShareVo>();
            List<Abnormal> abnormalList=new ArrayList<>();
            ServiceResult<List<Abnormal>> result=userService.getAbnormal();
            if(result.getSuccess()&&result.getBody()!=null){
                abnormalList=result.getBody();
                for ( Abnormal abnormal:abnormalList) {
                   userIds.add(abnormal.getUserId());
                }
                query.setIds(userIds);
                ServiceResult<List<UserShareVo>> serviceResult = userService.queryUserShareByIds(query);
                if(serviceResult.getSuccess()){
                    list = serviceResult.getBody();
                    for (UserShareVo userShareVo : list) {
                        for ( Abnormal abnormal:abnormalList) {
                            if (abnormal.getUserId()==userShareVo.getId()){
                                userShareVo.setNum(abnormal.getNum());
                            }
                        }
                    }
                }else{
                    successMap.put("resultMassage", result.getMessage());//"获取信息异常，请稍后重试!");
                    return successMap;
                }
            }
            int total=list.size();
            ListResult results= new ListResult(0, total, query.getPageSize(), query.getPageNumber(), list);
            return results.toMap();

        }catch(Exception e){
            logger.error("UserShareController.abnormallistData---------->",e);
            successMap.put("resultMassage", "获取信息异常，请稍后重试!");
            return successMap;
        }
    }
}
