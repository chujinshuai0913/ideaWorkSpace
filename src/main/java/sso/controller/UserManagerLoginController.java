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
import common.model.PermissionsListManager;
import common.model.UserLogin;
import common.model.UserManagerLogin;
import common.query.UserManagerQuery;
import common.query.UserShareQuery;
import common.service.UserService;
import common.util.DateUtils;
import common.util.ServiceResult;
import common.vo.UserManagerVo;
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
@RestController("UserManagerLoginController")
@RequestMapping("/loginmanager")
public class UserManagerLoginController {
    private static  final Logger logger = Logger.getLogger(UserShareLoginController.class);
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/userlogin", method = RequestMethod.POST)
    public Map<String, ?> userlogin(HttpServletResponse response, @RequestBody String strJson) {
        logger.info("UserManagerLoginController.userlogin------->");
        UserManagerQuery query = JSONObject.parseObject(strJson.trim(),UserManagerQuery.class);
        Map<String,Object> successMap = new HashMap<String,Object>();
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        HttpSession session = request.getSession();
        UserManagerLogin userManagerLogin=new UserManagerLogin();
        int flag=0;
        ServiceResult<UserManagerVo> result=userService.getLoginUserShareManager(query);
        if(result.getSuccess()&&result.getBody().getId()!=null){
            UserManagerVo userManagerVo=result.getBody();
            if(userManagerVo.getPhoneNumber().longValue()==query.getPhoneNumber().longValue()){
                UserManagerQuery query1=new UserManagerQuery();
                query1.setLoginTime(DateUtils.getNowTimeStamp());
                query1.setId(userManagerVo.getId());
                userService.updateUserManager(query1);
                userManagerLogin.setId(userManagerVo.getId());
                userManagerLogin.setUsername(userManagerVo.getUsername());
                userManagerLogin.setLoginTime(userManagerVo.getlTime());
                userManagerLogin.setWorkId(userManagerVo.getWorkId());
                userManagerLogin.setPassword(userManagerVo.getPassword());
                userManagerLogin.setPhoneNumber(userManagerVo.getPhoneNumber());
                userManagerLogin.setRoleId(userManagerVo.getRoleId());
                userManagerLogin.setRole(userManagerVo.getRole());
                //把用户数据保存在session域对象中
                session.setAttribute("userManagerLogin", userManagerLogin);
                flag=1;
            }
        }
        successMap.put("resultMassage", flag);
        return successMap;
    }











    //验证手机号是否已经存在
    @RequestMapping(value = "/userphone", method = RequestMethod.POST)
    public Map<String, ?> userphone(HttpServletResponse response, @RequestBody String strJson) {
        logger.info("UserManagerLoginController.userphone------->");
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
        logger.info("UserManagerLoginController.usersign------->");
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
        session.removeAttribute("userManagerLogin");
        mv.setViewName("sso/sharemanager/login");
        return mv;
    }

    /*修改密码*/
    @RequestMapping(value = "/updatemanagerpassword", method = RequestMethod.POST)
    @ResponseBody
    public Map<String,?> updatemanagerpassword(HttpServletResponse respone,@RequestBody String strJson){
        logger.info("UserController.updatemanagerpassword---------->"+strJson);
        UserManagerQuery query = JSONObject.parseObject(strJson,UserManagerQuery.class);
        UserManagerQuery query1 =new UserManagerQuery();
        Map<String,Object> succMap = new HashMap<String,Object>();
        try{
            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
            HttpSession session = request.getSession();
            UserManagerLogin userManagerLogin=(UserManagerLogin)session.getAttribute("userManagerLogin");
            if(userManagerLogin==null){
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
                     }else if(userManagerLogin.getPassword().equals(query.getPassword())){
                         query1.setPassword(query.getNewpassword());
                     }else{
                         succMap.put("resultMassage", "原密码不正确");
                         return succMap;
                     }
            }
            query1.setId(userManagerLogin.getId());
            ServiceResult<Integer> result =userService.updateUserManager(query1);
            succMap.put("resultMassage", result.getSuccess()?"ok":result.getMessage());
            return succMap;
        }catch(Exception e){
            logger.error("修改失败", e);
            succMap.put("resultMassage", "修改失败");
            return succMap;
        }
    }
}
