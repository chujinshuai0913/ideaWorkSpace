/**
 * Copyright (C), 2018-2018
 * FileName: UserShareLoginController
 * Author:   jinshuai
 * Date:     2018/6/12 10:31
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package sso.controller;

import com.alibaba.fastjson.JSONObject;
import common.constant.ConstantsUtils;
import common.model.*;
import common.query.UserShareQuery;
import common.service.UserService;
import common.util.DateUtils;
import common.util.ServiceResult;
import common.vo.UserShareVo;
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
 * @create 2018/6/12
 * @since 1.0.0
 */
@RestController("UserShareLoginController")
@RequestMapping("/login")
public class UserShareLoginController {

    private static  final Logger logger = Logger.getLogger(UserShareLoginController.class);
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/userlogin", method = RequestMethod.POST)
        public Map<String, ?> userlogin(HttpServletResponse response, @RequestBody String strJson) {
        logger.info("UserShareLoginController.userlogin------->");
        UserShareQuery query = JSONObject.parseObject(strJson.trim(),UserShareQuery.class);
        Map<String,Object> successMap = new HashMap<String,Object>();
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        HttpSession session = request.getSession();
        UserLogin userLogin=new UserLogin();
        int flag=0;
        ServiceResult<UserShareVo> result=userService.getLoginUserShare(query);
        if(result.getSuccess()&&result.getBody().getId()!=null){
            UserShareVo userShareVo=result.getBody();
            if(userShareVo.getPhoneNumber().longValue()==query.getPhoneNumber().longValue()){
                UserShareQuery query1=new UserShareQuery();
                query1.setLoginTime(DateUtils.getNowTimeStamp());
                query1.setId(userShareVo.getId());
                userService.updateUserShare(query1);
                userLogin.setUserId(userShareVo.getId());
                userLogin.setRealUserName(userShareVo.getRealName());
                userLogin.setUserName(userShareVo.getUserName());
                userLogin.setProfessionalName1(userShareVo.getProfessionalName1());
                userLogin.setProfessionalName2(userShareVo.getProfessionalName2());
                userLogin.setGrade(userShareVo.getGarde());
                userLogin.setIntegral(userShareVo.getIntegral());
                userLogin.setPassword(userShareVo.getPassword());
                userLogin.setPhoneNumber(userShareVo.getPhoneNumber());
                userLogin.setStatus(userShareVo.getStatus());
                userLogin.setStudentCode(userShareVo.getSchoolCode());
               //把用户数据保存在session域对象中
                session.setAttribute("userLogin", userLogin);
                flag=1;
            }
        }
        successMap.put("resultMassage", flag);
        return successMap;
    }
   //验证手机号是否已经存在
    @RequestMapping(value = "/userphone", method = RequestMethod.POST)
    public Map<String, ?> userphone(HttpServletResponse response, @RequestBody String strJson) {
        logger.info("UserShareLoginController.userphone------->");
        UserShareQuery query = JSONObject.parseObject(strJson.trim(),UserShareQuery.class);
        Map<String,Object> successMap = new HashMap<String,Object>();
        int flag=0;
        ServiceResult<Long> longServiceResult =userService.getPhoneNumber(query);
        if(longServiceResult.getSuccess()&&longServiceResult.getBody()!=null&&longServiceResult.getBody().longValue()==query.getPhoneNumber().longValue()){
            flag=1;
        }
        successMap.put("resultMassage", flag);
        return successMap;
    }
    @RequestMapping(value = "/usersign", method = RequestMethod.POST)
    public Map<String, ?> usersign(HttpServletResponse response, @RequestBody String strJson) {
        logger.info("UserShareLoginController.usersign------->");
        UserShareQuery query = JSONObject.parseObject(strJson.trim(),UserShareQuery.class);
        Map<String,Object> successMap = new HashMap<String,Object>();
        int flag=0;
        query.setStatus(ConstantsUtils.UserShareCode.STATUS);
        query.setRegisteredTime(DateUtils.getNowTimeStamp());
        query.setIntegral(100);
        ServiceResult<Integer> result=userService.insert(query);
        if(result.getSuccess()&&result.getBody()>0){
           flag=1;
        }
        successMap.put("resultMassage", flag);
        return successMap;
    }
    @RequestMapping(value = "/loginout", method = RequestMethod.GET)
    public ModelAndView loginout() {
        logger.info("UserManagerLoginController.loginout------->");
        ModelAndView mv = new ModelAndView();
        Map<String,Object> successMap = new HashMap<String,Object>();
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        HttpSession session = request.getSession();
        session.removeAttribute("userLogin");
        mv.setViewName("/sharebook/jsp/shareindex");
        return mv;
    }
    @RequestMapping(value = "/mybookshare", method = RequestMethod.GET)
    public ModelAndView sharemanager() {
        logger.info("UserShareLoginController.mybookshare------->");
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        HttpSession session = request.getSession();
        //用户
        UserLogin userLogin=(UserLogin)session.getAttribute("userLogin");
        if(userLogin==null){
            return new ModelAndView("redirect:/sso/sharebook/login.jsp");
        }else {
            return new ModelAndView("redirect:/sharebook/jsp/mybookshare.jsp");
        }
    }

    @RequestMapping(value = "/updatepass", method = RequestMethod.GET)
    public ModelAndView updatepass() {
        logger.info("UserShareLoginController.mybookshare------->");
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        HttpSession session = request.getSession();
        //用户
        UserLogin userLogin=(UserLogin)session.getAttribute("userLogin");
        if(userLogin==null){
            return new ModelAndView("redirect:/sso/sharebook/login.jsp");
        }else {
            return new ModelAndView("redirect:/sso/sharebook/updatepassword.jsp");
        }
    }
    /*修改密码*/
    @RequestMapping(value = "/updatesharepassword", method = RequestMethod.POST)
    @ResponseBody
    public Map<String,?> updatemanagerpassword(HttpServletResponse respone,@RequestBody String strJson){
        logger.info("UserController.updatemanagerpassword---------->"+strJson);
        UserShareQuery query = JSONObject.parseObject(strJson,UserShareQuery.class);
        UserShareQuery query1 =new UserShareQuery();
        Map<String,Object> succMap = new HashMap<String,Object>();
        try{
            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
            HttpSession session = request.getSession();
            UserLogin userLogin=(UserLogin)session.getAttribute("userManagerLogin");
            if(userLogin==null){
                succMap.put("resultMassage", "您还没登陆呢");
                return succMap;
            }
            if(query.getPassword()==null||query.getPassword().equals("")){
                succMap.put("resultMassage", "原密码不能为空");
                return succMap;
            }else {
                if(query.getPassword().equals(query.getNewpassword())){
                    succMap.put("resultMassage", "原密码与新密码不能相同！");
                    return succMap;
                }else if(userLogin.getPassword().equals(query.getPassword())){
                    query1.setPassword(query.getNewpassword());
                }else{
                    succMap.put("resultMassage", "原密码不正确");
                    return succMap;
                }
            }
            query1.setId(userLogin.getUserId());
            ServiceResult<Integer> result =userService.updateUserShare(query1);
            succMap.put("resultMassage", result.getSuccess()?"ok":result.getMessage());
            return succMap;
        }catch(Exception e){
            logger.error("修改失败", e);
            succMap.put("resultMassage", "修改失败");
            return succMap;
        }
    }
    /*认证*/
    @RequestMapping(value = "/sureSchooclCode", method = RequestMethod.POST)
    @ResponseBody
    public Map<String,?> sureSchooclCode(HttpServletResponse respone,@RequestBody String strJson){
        logger.info("UserController.sureSchooclCode---------->"+strJson);
        UserShareQuery query = JSONObject.parseObject(strJson,UserShareQuery.class);
        UserShareQuery query1 =new UserShareQuery();
        Map<String,Object> succMap = new HashMap<String,Object>();
        try{
            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
            HttpSession session = request.getSession();
            UserLogin userLogin=(UserLogin)session.getAttribute("userLogin");
            if(userLogin==null){
                succMap.put("resultMassage", "您还没登陆呢");
                return succMap;
            }
            if(query.getRealName() == null||query.getRealName().equals("")){
                succMap.put("resultMassage", "姓名不能为空");
                return succMap;
            }
            if(query.getSchoolCode() == null){
                succMap.put("resultMassage", "学号不能为空");
                return succMap;
            }else {
                query1.setSchoolCode(query.getSchoolCode());
                ServiceResult<Integer> result=userService.queryCountUserShare(query1);
                if(result.getSuccess()&&result.getBody()!=null&&result.getBody()>0){
                    succMap.put("resultMassage", "学号已经认证了");
                    return succMap;
                }else{
                    ServiceResult<StudentTeacherList> result1=userService.getStudentTeacherList(query.getSchoolCode());
                    if(result1.getSuccess()&&result1.getBody()!=null){
                        StudentTeacherList studentTeacherList=result1.getBody();
                        if(!studentTeacherList.getStName().equals(query.getRealName())){
                            succMap.put("resultMassage", "请输入用户的真实姓名！");
                            return succMap;
                        }
                    }else{
                        succMap.put("resultMassage", "请查看学号是否正确！！");
                        return succMap;
                    }
                }
            }
            query1.setId(userLogin.getUserId());
            ServiceResult<Integer> result =userService.updateUserShare(query1);
            ServiceResult<Integer> result1 =userService.updateStudentTeacherList(query.getSchoolCode());
            succMap.put("resultMassage", result.getSuccess()?"ok":result.getMessage());
            return succMap;
        }catch(Exception e){
            logger.error("认证成功", e);
            succMap.put("resultMassage", "认证失败");
            return succMap;
        }
    }

}
