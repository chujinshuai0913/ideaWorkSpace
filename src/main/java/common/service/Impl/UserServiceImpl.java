package common.service.Impl;

import com.alibaba.fastjson.JSONObject;
import common.constant.ConstantsUtils;
import common.constant.UserShareCodeEum;
import common.constant.UserStatusEnum;
import common.mapper.*;
import common.model.*;
import common.query.*;
import common.util.DateUtils;
import common.util.ServiceResult;
import common.vo.PermissionsSetVo;
import common.vo.StudenteacherVo;
import common.vo.UserManagerVo;
import common.vo.UserShareVo;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import common.service.UserService;

import javax.mail.Flags;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * @author jinshuai
 */
@Service
public class UserServiceImpl implements UserService{

    private static final Logger logger = Logger.getLogger(UserServiceImpl.class);

    @Autowired
    private UserShareMapper userShareMapper;

    @Autowired
    private UserManagerMapper userManagerMapper;
    @Autowired
    private StudentTeacherListMapper studentTeacherListMapper;
    @Autowired
    private RecordSellingMapper recordSellingMapper;
    @Autowired
    private AbnormalMapper abnormalMapper;
    @Autowired
    private  ShareRoleMapper shareRoleMapper;

    @Autowired
    private  PermissionsListManagerMapper permissionsListManagerMapper;

    @Autowired
    private PermissionsSetMapper permissionsSetMapper;

    @Override
    public ServiceResult<UserShareVo> queryUserShare(UserShareQuery userShareQuery) {
        try {
            UserShareVo userShareVo=new UserShareVo();
            UserShare userShare=new UserShare();

            ServiceResult<UserShare> result = new ServiceResult<>(userShareMapper.queryUserShare(userShareQuery));
            if (result.getSuccess()&&result.getBody()!=null) {
                userShare=result.getBody();
                userShareVo= JSONObject.parseObject(JSONObject.toJSONString(userShare),UserShareVo.class);
                userShareVo.setcName("");
                userShareVo.seteUser("");
                userShareVo.setpUser("");
                if(ConstantsUtils.UserShareCode.STATUS==userShare.getStatus()){
                    userShareVo.setStatusName(UserShareCodeEum.STAUS.getName());
                }else {
                    userShareVo.setStatusName(UserShareCodeEum.STATUS_NOT.getName());
                }
                if (userShare.getRegisteredTime()!=null&&userShare.getRegisteredTime() > 0) {
                    userShareVo.setrTime(DateUtils.getDateStringByTimeStamp(userShare.getRegisteredTime(), DateUtils.YMDHMS));
                }
                if (userShare.getcT()!=null&&userShare.getcT() > 0) {
                    userShareVo.setcTime(DateUtils.getDateStringByTimeStamp(userShare.getcT(), DateUtils.YMDHMS));
                }
                if (userShare.getBanTime()!=null&&userShare.getBanTime() > 0) {
                    userShareVo.setbTime(DateUtils.getDateStringByTimeStamp(userShare.getBanTime(), DateUtils.YMDHMS));
                    userShareVo.setStime(DateUtils.getDateStringByTimeStamp(userShare.getBanTime() + userShareVo.getBanLongtime(), DateUtils.YMDHMS));
                }
                if (userShare.getLoginTime()!=null&&userShare.getLoginTime() > 0) {
                    userShareVo.setlTime(DateUtils.getDateStringByTimeStamp(userShare.getLoginTime(), DateUtils.YMDHMS));
                }
                if (userShare.getDeleteTime()!=null&&userShare.getDeleteTime() > 0) {
                    userShareVo.setdTime(DateUtils.getDateStringByTimeStamp(userShare.getDeleteTime(), DateUtils.YMDHMS));
                }
                if (userShare.getPrintTime()!=null&&userShare.getPrintTime() > 0) {
                    userShareVo.setpTime(DateUtils.getDateStringByTimeStamp(userShare.getPrintTime(), DateUtils.YMDHMS));
                }
                if (userShare.getExportTime()!=null&&userShare.getExportTime() > 0) {
                    userShareVo.seteTime(DateUtils.getDateStringByTimeStamp(userShare.getExportTime(), DateUtils.YMDHMS));
                }
                if (userShare.getcU()!=null)
                {
                    userShareVo.setcName(userManagerMapper.getUserNameById(userShare.getcU()));
                }
                if (userShare.getPrintUser()!=null)
                {
                    userShareVo.setpUser(userManagerMapper.getUserNameById(userShare.getPrintUser()));
                }
                if (userShare.getExportUser()!=null)
                {
                    userShareVo.seteUser(userManagerMapper.getUserNameById(userShare.getExportUser()));
                }
            }
                return new ServiceResult<>(userShareVo);

        }catch (Exception e){
            logger.error(e.getMessage(),e);
            return new ServiceResult<>(11,e.getMessage());

        }

    }

    @Override
    public  ServiceResult<List<UserShareVo>> queryUserShareLists(UserShareQuery userShareQuery) {
        try {
            List<UserShare> userShareList=new ArrayList<>();
            List<UserShareVo> userShareVoList=new ArrayList<>();
            ServiceResult< List<UserShare>> result = new ServiceResult<>(userShareMapper.queryUserShareLists(userShareQuery));

            if (result.getSuccess()&&result.getBody()!=null) {
                userShareList=result.getBody();
                for ( UserShare userShare:userShareList ) {
                    UserShareVo userShareVo= JSONObject.parseObject(JSONObject.toJSONString(userShare),UserShareVo.class);
                    userShareVo.setcName("");
                    userShareVo.seteUser("");
                    userShareVo.setpUser("");
                    userShareVo.setStatusName(UserStatusEnum.getNameMap().get(userShare.getStatus()));
                    if (userShare.getRegisteredTime()!=null&&userShare.getRegisteredTime() > 0) {
                        userShareVo.setrTime(DateUtils.getDateStringByTimeStamp(userShare.getRegisteredTime(), DateUtils.YMDHMS));
                    }
                    if (userShare.getcT()!=null&&userShare.getcT() > 0) {
                        userShareVo.setcTime(DateUtils.getDateStringByTimeStamp(userShare.getcT(), DateUtils.YMDHMS));
                    }
                    if (userShare.getBanTime()!=null&&userShare.getBanTime() > 0) {
                        userShareVo.setbTime(DateUtils.getDateStringByTimeStamp(userShare.getBanTime(), DateUtils.YMDHMS));
                       /* userShareVo.setStime(DateUtils.getDateStringByTimeStamp(userShare.getBanTime() - userShareVo.getBanLongtime(), DateUtils.YMDHMS));*/
                    }
                    if (userShare.getLoginTime()!=null&&userShare.getLoginTime() > 0) {
                        userShareVo.setlTime(DateUtils.getDateStringByTimeStamp(userShare.getLoginTime(), DateUtils.YMDHMS));
                    }
                    if (userShare.getDeleteTime()!=null&&userShare.getDeleteTime() > 0) {
                        userShareVo.setdTime(DateUtils.getDateStringByTimeStamp(userShare.getDeleteTime(), DateUtils.YMDHMS));
                    }
                    if (userShare.getPrintTime()!=null&&userShare.getPrintTime() > 0) {
                        userShareVo.setpTime(DateUtils.getDateStringByTimeStamp(userShare.getPrintTime(), DateUtils.YMDHMS));
                    }
                    if (userShare.getExportTime()!=null&&userShare.getExportTime() > 0) {
                        userShareVo.seteTime(DateUtils.getDateStringByTimeStamp(userShare.getExportTime(), DateUtils.YMDHMS));
                    }
                    if (userShare.getcU()!=null)
                    {
                        userShareVo.setcName(userManagerMapper.getUserNameById(userShare.getcU()));
                    }
                    if (userShare.getPrintUser()!=null)
                    {
                        userShareVo.setpUser(userManagerMapper.getUserNameById(userShare.getPrintUser()));
                    }
                    if (userShare.getExportUser()!=null)
                    {
                        userShareVo.seteUser(userManagerMapper.getUserNameById(userShare.getExportUser()));
                    }
                    userShareVoList.add(userShareVo);
                }
            }
            return new ServiceResult<>(userShareVoList);

        }catch (Exception e){
            logger.error(e.getMessage(),e);
            return new ServiceResult<>(11,e.getMessage());

        }

    }


    @Override
    public ServiceResult<List<UserShareVo>> queryUserShareByIds(UserShareQuery userShareQuery) {
        try {
        List<UserShare> userShareList=new ArrayList<>();
        List<UserShareVo> userShareVoList=new ArrayList<>();
        ServiceResult< List<UserShare>> result = new ServiceResult<>(userShareMapper.queryUserShareListsByIds(userShareQuery));

        if (result.getSuccess()&&result.getBody()!=null) {
            userShareList=result.getBody();
            for ( UserShare userShare:userShareList ) {
                UserShareVo userShareVo= JSONObject.parseObject(JSONObject.toJSONString(userShare),UserShareVo.class);
                userShareVo.setcName("");
                userShareVo.seteUser("");
                userShareVo.setpUser("");
                if(ConstantsUtils.UserShareCode.STATUS==userShare.getStatus()){
                    userShareVo.setStatusName(UserShareCodeEum.STAUS.getName());
                }else {
                    userShareVo.setStatusName(UserShareCodeEum.STATUS_NOT.getName());
                }
                if (userShare.getRegisteredTime()!=null&&userShare.getRegisteredTime() > 0) {
                    userShareVo.setrTime(DateUtils.getDateStringByTimeStamp(userShare.getRegisteredTime(), DateUtils.YMDHMS));
                }
                if (userShare.getcT()!=null&&userShare.getcT() > 0) {
                    userShareVo.setcTime(DateUtils.getDateStringByTimeStamp(userShare.getcT(), DateUtils.YMDHMS));
                }
                if (userShare.getBanTime()!=null&&userShare.getBanTime() > 0) {
                    userShareVo.setbTime(DateUtils.getDateStringByTimeStamp(userShare.getBanTime(), DateUtils.YMDHMS));
                    userShareVo.setStime(DateUtils.getDateStringByTimeStamp(userShare.getBanTime() - userShareVo.getBanLongtime(), DateUtils.YMDHMS));
                }
                if (userShare.getLoginTime()!=null&&userShare.getLoginTime() > 0) {
                    userShareVo.setlTime(DateUtils.getDateStringByTimeStamp(userShare.getLoginTime(), DateUtils.YMDHMS));
                }
                if (userShare.getDeleteTime()!=null&&userShare.getDeleteTime() > 0) {
                    userShareVo.setdTime(DateUtils.getDateStringByTimeStamp(userShare.getDeleteTime(), DateUtils.YMDHMS));
                }
                if (userShare.getPrintTime()!=null&&userShare.getPrintTime() > 0) {
                    userShareVo.setpTime(DateUtils.getDateStringByTimeStamp(userShare.getPrintTime(), DateUtils.YMDHMS));
                }
                if (userShare.getExportTime()!=null&&userShare.getExportTime() > 0) {
                    userShareVo.seteTime(DateUtils.getDateStringByTimeStamp(userShare.getExportTime(), DateUtils.YMDHMS));
                }
                if (userShare.getcU()!=null)
                {
                    userShareVo.setcName(userManagerMapper.getUserNameById(userShare.getcU()));
                }
                if (userShare.getPrintUser()!=null)
                {
                    userShareVo.setpUser(userManagerMapper.getUserNameById(userShare.getPrintUser()));
                }
                if (userShare.getExportUser()!=null)
                {
                    userShareVo.seteUser(userManagerMapper.getUserNameById(userShare.getExportUser()));
                }
                userShareVoList.add(userShareVo);
            }
        }
        return new ServiceResult<>(userShareVoList);

    }catch (Exception e){
        logger.error(e.getMessage(),e);
        return new ServiceResult<>(11,e.getMessage());

    }
}
    @Override
    public ServiceResult<Integer> queryCountUserShare(UserShareQuery userShareQuery) {
        return new ServiceResult<>(userShareMapper.queryCountUserShare(userShareQuery));
    }

    @Override
    public ServiceResult<Integer> updateUserShare(UserShareQuery userShareQuery) {
        return new ServiceResult<>(userShareMapper.updateByPrimaryKeySelective(userShareQuery));
    }
    @Override
    public ServiceResult<Integer> updateUserShareStaus(UserShareQuery userShareQuery) {
        return new ServiceResult<>(userShareMapper.updateUserShareStaus(userShareQuery));
    }

    @Override
    public ServiceResult<Integer> updateUserManager(UserManagerQuery query) {
        return new ServiceResult<>(userManagerMapper.updateByPrimaryKeySelective(query));
    }

    @Override
    public ServiceResult<Integer> insertUserManager(UserManagerQuery query) {
        return new ServiceResult<>(userManagerMapper.insert(query));
    }

    @Override
    public ServiceResult<List<ShareRole>> queryUserRole(ShareRoleQuery query) {
        return new ServiceResult<>(shareRoleMapper.getUserRoleList(query));
    }
    @Override
    public  ServiceResult<Integer> queryUserRoleCount(ShareRoleQuery query) {
        return new ServiceResult<>(shareRoleMapper.queryUserRoleCount(query));
    }

    @Override
    public ServiceResult<Integer> insertPerrmissionSet(PermissionsSetQuery query) {
        try {
            int flag=1;
            for(int id:query.getIds()){
                query.setPermissionsId(id);
                query.setStatus(1);
                permissionsSetMapper.insert(query);
            }
            return new ServiceResult<>(flag);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            return new ServiceResult<>(11,e.getMessage());
        }


    }

    @Override
    public ServiceResult<Integer> deletePerrmissionSet(PermissionsSetQuery query) {
        try {
            int flag=1;
            for(int id:query.getIds()){
                permissionsSetMapper.deleteByPermissionsId(id);
            }
            return new ServiceResult<>(flag);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            return new ServiceResult<>(11,e.getMessage());
        }

    }

    @Override
    public ServiceResult<Integer> insert(UserShareQuery query) {
        return new ServiceResult<>(userShareMapper.insert(query));
    }

    @Override
    public String getUserNameById(int id) {
        return userManagerMapper.getUserNameById(id);
    }

    @Override
    public  ServiceResult<UserShare> getUserShareNameById(int id) {
        return new ServiceResult<>(userShareMapper.getUserShareNameById(id));
    }

    @Override
    public ServiceResult<List<Integer>> getIdByUserName(String userName) {
        return new ServiceResult<>(userShareMapper.getIdByUserName(userName));
    }

    @Override
    public  ServiceResult<StudentTeacherList>  getStudentTeacherList(Long schoolCode) {
        return new ServiceResult<>(studentTeacherListMapper.getStudentTeacherList(schoolCode));
    }
    @Override
    public  ServiceResult<Integer> updateStudentTeacherList(Long schoolCode){
        return new ServiceResult<>(studentTeacherListMapper.updateStudentTeacherList(schoolCode,DateUtils.getNowTimeStamp()));
    }

    @Override
    public void insertAbnormal() {
        Integer endTime=DateUtils.getTodayUnixTimeStamp();
        Integer starTime=endTime-86400 *6;
        int count=0;
        RecordSellingQuery query=new RecordSellingQuery();
           query.setScompleteTime(starTime);
           query.setEcompleteTime(endTime);
           query.setNum(100);
           List<RecordSelling> recordSellingList =recordSellingMapper.getRecordsellingBuyer(query);
        for (RecordSelling recordSelling:recordSellingList) {
            Abnormal abnormal =new Abnormal();
            abnormal.setUserId(recordSelling.getBuyer());
            abnormal.setNum(recordSelling.getTotal());
            abnormalMapper.insertSelective(abnormal);
        }
    }

    @Override
    public ServiceResult<List<Abnormal>> getAbnormal() {
        return new ServiceResult<>(abnormalMapper.getAbnormal());
    }

    @Override
    public ServiceResult<UserManagerVo> queryUserShareManager(UserManagerQuery userManagerQuery) {
       try {
            UserManager userManager=new UserManager();
           UserManagerVo userManagerVo=new UserManagerVo();
            userManager=userManagerMapper.queryUserShareManager(userManagerQuery);
            if(userManager!=null){
                userManagerVo= JSONObject.parseObject(JSONObject.toJSONString(userManager),UserManagerVo.class);
            }
           return new ServiceResult<>(userManagerVo);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            return new ServiceResult<>(11,e.getMessage());
        }
    }
    @Override
    public ServiceResult<Integer> queryUserShareManagerCount(UserManagerQuery userManagerQuery) {
        try {
            return new ServiceResult<>(userManagerMapper.queryUserShareManagerCount(userManagerQuery));
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            return new ServiceResult<>(11,e.getMessage());
        }
    }
    @Override
    public ServiceResult<List<UserManagerVo>> queryUserShareManagerLists(UserManagerQuery userManagerQuery) {
        try {
            List<UserManager> userManagerList=new ArrayList<>();
            List<UserManagerVo> userManagerVoList=new ArrayList<>();
            ServiceResult<List<UserManager>> result = new ServiceResult<>(userManagerMapper.queryUserShareManagerLists(userManagerQuery));

            if (result.getSuccess()&&result.getBody()!=null) {
                userManagerList=result.getBody();
                for ( UserManager userManager:userManagerList ) {
                    UserManagerVo userManagerVo= JSONObject.parseObject(JSONObject.toJSONString(userManager),UserManagerVo.class);
                    if (userManager.getLoginTime()!=null&&userManager.getLoginTime() > 0) {
                        userManagerVo.setlTime(DateUtils.getDateStringByTimeStamp(userManager.getLoginTime(), DateUtils.YMDHMS));
                    }
                    if (userManager.getSignTime()!=null&&userManager.getSignTime() > 0) {
                        userManagerVo.setsTime(DateUtils.getDateStringByTimeStamp(userManager.getSignTime(), DateUtils.YMDHMS));
                    }
                    if (userManager.getDeleteTime()!=null&&userManager.getDeleteTime() > 0) {
                        userManagerVo.setdTime(DateUtils.getDateStringByTimeStamp(userManager.getDeleteTime(), DateUtils.YMDHMS));
                    }
                    if(userManager.getRoleId()!=null&&userManager.getRoleId()>0){
                          userManagerVo.setRole(shareRoleMapper.getRoleById(userManager.getRoleId()));
                    }
                    userManagerVoList.add(userManagerVo);
                }
            }
            return new ServiceResult<>(userManagerVoList);

        }catch (Exception e){
            logger.error(e.getMessage(),e);
            return new ServiceResult<>(11,e.getMessage());

        }
    }

    @Override
    public ServiceResult<Integer> queryCountUserShareManager(UserManagerQuery userManagerQuery) {
        return new ServiceResult<>(userManagerMapper.queryCountUserShareManager(userManagerQuery));
    }

    @Override
    public ServiceResult<Boolean> updateRole(UserManagerQuery userManagerQuery) {
        return  new ServiceResult<>(userManagerMapper.updateRole(userManagerQuery));
    }

    @Override
    public ServiceResult<Integer> insertRole(ShareRoleQuery query) {
        return new ServiceResult<>(shareRoleMapper.insert(query));
    }
    @Override
    public  ServiceResult<Integer> insertPerrmission(PermissionsListManager query){
        return new ServiceResult<>(permissionsListManagerMapper.insert(query));
    }

    @Override
    public ServiceResult<Integer> queryStudenteacherCount(StudentTeacherQuery query) {
        return  new ServiceResult<>(studentTeacherListMapper.getStudentTeacherListCount(query));
    }

    @Override
    public ServiceResult<List<StudenteacherVo>> queryStudenteacherList(StudentTeacherQuery query) {
        try {
            List<StudenteacherVo> studenteacherVos=new ArrayList<>();
            ServiceResult<List<StudentTeacherList>> serviceResult=new ServiceResult<>(studentTeacherListMapper.getStudentTeacherLists(query));
            if (serviceResult.getSuccess()&&serviceResult.getBody()!=null){
                for (StudentTeacherList studentTeacherList:serviceResult.getBody()) {
                    StudenteacherVo studenteacherVo= new StudenteacherVo();
                    studenteacherVos.add(this.getStudenteacherVo(studenteacherVo,studentTeacherList));
                }
            }
            return new ServiceResult<>(studenteacherVos) ;
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            return new ServiceResult<>(11,e.getMessage());
        }
    }

    @Override
    public int isTrue(String url, Integer roleId) {
        try {
            int flag=0;
            //根据roleId 查 setId
            List<Integer> permissionsIds=permissionsSetMapper.getPermissionsSetIds(roleId);
            if(permissionsIds.size()>0){
                PermissionsListManager permissionsListManager=permissionsListManagerMapper.getTrueOrFalse(permissionsIds,url);
                if(permissionsListManager!=null&&permissionsListManager.getId()>0){
                    flag=1;
                }
            }
            return  flag;
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            return 0;
        }
    }
    @Override
    public List<Integer> getPermissionsSetIds(Integer roleId) {
           return permissionsSetMapper.getPermissionsSetIds(roleId);
    }
    @Override
    public StudenteacherVo getStudenteacherVo(StudenteacherVo studenteacherVo, StudentTeacherList studenteacher) {
        try{
            studenteacherVo = JSONObject.parseObject(JSONObject.toJSONString(studenteacher),StudenteacherVo.class);
            studenteacherVo.setStrT("");

            if(studenteacher.getTime()!=null&&studenteacher.getTime()>0)
            {
                studenteacherVo.setStrT(DateUtils.getDateStringByTimeStamp(studenteacher.getTime(),DateUtils.YMD));
            }
            return studenteacherVo;
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            return new StudenteacherVo();
        }
    }

    @Override
    public ServiceResult<Integer> signUserShareManager(UserManagerQuery query) {
        return null;
    }

    @Override
    public ServiceResult<UserManagerVo> getLoginUserShareManager(UserManagerQuery query) {
        try {
            UserManagerVo userManagerVo=new UserManagerVo();
            ServiceResult<UserManager> result = new ServiceResult<>(userManagerMapper.loginUserManager(query));
            if (result.getSuccess()&&result.getBody()!=null) {
                UserManager userManager = result.getBody();
                userManagerVo = JSONObject.parseObject(JSONObject.toJSONString(userManager), UserManagerVo.class);
                if(userManager.getLoginTime()!=null&&userManager.getLoginTime()>0){
                    userManagerVo.setlTime(DateUtils.getDateStringByTimeStamp(userManager.getLoginTime(),DateUtils.YMDHMS));
                }
                if(userManager.getRoleId()!=null&&userManager.getRoleId()>0){
                    userManagerVo.setRole(shareRoleMapper.getRoleById(userManager.getRoleId()));
                }
            }
            return new ServiceResult<>(userManagerVo);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            return new ServiceResult<>(11,e.getMessage());
        }
    }

    @Override
    public ServiceResult<Integer> signUserShare(UserShareQuery query) {
        return null;
    }

    @Override
    public ServiceResult<UserShareVo> getLoginUserShare(UserShareQuery query) {
        try {
            UserShareVo userShareVo=new UserShareVo();
            ServiceResult<UserShare> result = new ServiceResult<>(userShareMapper.loginUserShare(query));
            if (result.getSuccess()&&result.getBody()!=null) {
                UserShare userShare = result.getBody();
                userShareVo = JSONObject.parseObject(JSONObject.toJSONString(userShare), UserShareVo.class);
                if(userShare.getSchoolCode()!=null&&userShare.getSchoolCode()>0){
                   StudentTeacherList studentTeacherList=  studentTeacherListMapper.selectBySchoolCode(userShare.getSchoolCode());
                   userShareVo.setProfessionalName1(studentTeacherList.getProfessional1Name());
                   userShareVo.setProfessionalName2(studentTeacherList.getProfessional2Name());
                   int grade=Integer.parseInt(studentTeacherList.getGrade());
                   userShareVo.setGarde(grade);
                   userShareVo.setRealName(studentTeacherList.getStName());
                }
            }
            return new ServiceResult<>(userShareVo);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            return new ServiceResult<>(11,e.getMessage());
        }
    }

    @Override
    public ServiceResult<Long> getPhoneNumber(UserShareQuery query) {
        return new ServiceResult<>(userShareMapper.queryPhoneNumber(query.getPhoneNumber()));
    }

    @Override
    public ServiceResult<List<PermissionsListManager>> getPermissionsListManagerList(PermissionsListManagerQuery query) {
        try {
            return new ServiceResult<>(permissionsListManagerMapper.getPermissionsListManagerList(query)) ;
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            return new ServiceResult<>(11,e.getMessage());
        }
    }

    @Override
    public     ServiceResult<Integer>  getPermissionsListManagerListCount(PermissionsListManagerQuery query) {
        try {
            return new ServiceResult<>(permissionsListManagerMapper.getPermissionsListManagerListCount(query)) ;
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            return new ServiceResult<>(11,e.getMessage());
        }
    }
    @Override
    public ServiceResult<List<PermissionsListManager>> getNotPermissionsListManagerList(PermissionsListManagerQuery query) {
        try {
            return new ServiceResult<>(permissionsListManagerMapper.getNotPermissionsListManagerList(query)) ;
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            return new ServiceResult<>(11,e.getMessage());
        }
    }

    @Override
    public     ServiceResult<Integer>  getNotPermissionsListManagerListCount(PermissionsListManagerQuery query) {
        try {
            return new ServiceResult<>(permissionsListManagerMapper.getNotPermissionsListManagerListCount(query)) ;
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            return new ServiceResult<>(11,e.getMessage());
        }
    }
    @Override
    public ServiceResult<Integer> updatePermissionsListManagerStatus(PermissionsListManager query) {
        return new ServiceResult<>(permissionsListManagerMapper.updatePermissionsListManagerStatus(query));
    }

    public PermissionsSetVo getPermissionsSetVo(PermissionsSetVo permissionsSetVo,PermissionsSet permissionsSet){
        try{
            permissionsSetVo = JSONObject.parseObject(JSONObject.toJSONString(permissionsSet),PermissionsSetVo.class);
            if(permissionsSet.getPermissionsId()!=null&&permissionsSet.getPermissionsId()>0)
            {
                PermissionsListManager permissionsListManager=permissionsListManagerMapper.selectByPrimaryKey(permissionsSet.getPermissionsId());
                if(permissionsListManager!=null&&permissionsListManager.getId()>0){
                        permissionsSetVo.setUrl(permissionsListManager.getUrl());
                    permissionsSetVo.setUrlName(permissionsListManager.getUrlName());
                    permissionsSetVo.setStatus(permissionsListManager.getStatus());
                }
            }
            return permissionsSetVo;
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            return new PermissionsSetVo();
        }
    }
}
