package common.service.Impl;

import com.alibaba.fastjson.JSONObject;
import common.constant.ConstantsUtils;
import common.constant.UserShareCodeEum;
import common.mapper.*;
import common.model.*;
import common.query.RecordSellingQuery;
import common.query.UserManagerQuery;
import common.query.UserShareQuery;
import common.util.DateUtils;
import common.util.ServiceResult;
import common.vo.UserManagerVo;
import common.vo.UserShareVo;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import common.service.UserService;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * @author jinshuai
 */
@Service
@Transactional(rollbackFor = Exception.class)
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
        return new ServiceResult<>(userShareMapper.updateUserShare(userShareQuery));
    }

    @Override
    public ServiceResult<Integer> insert(UserShareQuery userShareQuery) {
        return new ServiceResult<>(userShareMapper.insert(userShareQuery));
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
    public  ServiceResult<StudentTeacherList>  getStudentTeacherList(int schoolCode) {
        return new ServiceResult<>(studentTeacherListMapper.getStudentTeacherList(schoolCode));
    }

    @Override
    public void insertAbnormal() {
        List<Abnormal> abnormalList=new ArrayList<>();
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
            abnormalList.add(abnormal);
        }
        if(count==0){
          count = abnormalMapper.batchInsertAbnormal(abnormalList);
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
           return new ServiceResult<>(userManagerVo);
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

}
