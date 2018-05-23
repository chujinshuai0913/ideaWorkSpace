/**
 * Copyright (C), 2018-2018
 * FileName: ShareManagerServiceImpl
 * Author:   jinshuai
 * Date:     2018/5/21 10:51
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package common.service.Impl;

import com.alibaba.fastjson.JSONObject;
import common.mapper.ShareActivityMapper;
import common.mapper.ShareAnnouncementMapper;
import common.mapper.UserManagerMapper;
import common.model.ShareActivity;
import common.model.ShareAnnouncement;
import common.model.TypeProfessional1;
import common.model.UserManager;
import common.query.ShareActivityQuery;
import common.query.ShareAnnouncementQuery;
import common.service.ShareManagerService;
import common.util.DateUtils;
import common.util.ServiceResult;
import common.vo.ShareActivityVo;
import common.vo.ShareAnnouncementVo;
import common.vo.TypeProfessional1Vo;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author jinshuai
 * @create 2018/5/21
 * @since 1.0.0
 */

@Service
public class ShareManagerServiceImpl implements ShareManagerService {

    private static final Logger logger = Logger.getLogger(ShareManagerServiceImpl.class);

      @Autowired
      private ShareAnnouncementMapper shareAnnouncementMapper;
      @Autowired
      private ShareActivityMapper shareActivityMapper;
       @Autowired
       private UserManagerMapper userManagerMapper;

    @Override
    public ServiceResult<Integer> insertShareActivity(ShareActivityQuery record) {
        return new ServiceResult<>(shareActivityMapper.insert(record));
    }
    @Override
    public ServiceResult<ShareActivity> selectByPrimaryKey(Integer id) {
        return  new ServiceResult<>(shareActivityMapper.selectByPrimaryKey(id));
    }

    @Override
    public ServiceResult<List<ShareActivityVo>> getShareActivityVoList(ShareActivityQuery query) {
        try {
            List<ShareActivityVo> shareActivityVos=new ArrayList<>();

            ServiceResult<List<ShareActivity>> serviceResult=new ServiceResult<>(shareActivityMapper.getShareActivityList(query));
            if (serviceResult.getSuccess()&&serviceResult.getBody()!=null){
                for (ShareActivity shareActivity:serviceResult.getBody()) {
                    ShareActivityVo shareActivityVo= new ShareActivityVo();
                    shareActivityVos.add(this.getShareActivityVo(shareActivityVo,shareActivity));
                }
            }
            return new ServiceResult<>(shareActivityVos) ;
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            return new ServiceResult<>(11,e.getMessage());
        }
    }

    @Override
    public ServiceResult<List<ShareAnnouncement>> getShareAnnouncementImgList(ShareAnnouncementQuery query) {
        try {
            return  new ServiceResult<>(shareAnnouncementMapper.getShareAnnouncementImgList(query));
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            return new ServiceResult<>(11,e.getMessage());
        }
    }

    @Override
    public ServiceResult<List<Integer>> getShareAnnouncementImgCount(ShareAnnouncementQuery query) {
        return new ServiceResult<>(shareAnnouncementMapper.getShareAnnouncementImgCount(query));
    }

    private ShareActivityVo getShareActivityVo(ShareActivityVo shareActivityVo, ShareActivity shareActivity){
        try {
            shareActivityVo = JSONObject.parseObject(JSONObject.toJSONString(shareActivity),ShareActivityVo.class);
            shareActivityVo.setcUser("");
            shareActivityVo.setcTime("");
            if(shareActivity.getCt()!=null&&shareActivity.getCt()>0)
            {
                shareActivityVo.setcTime(DateUtils.getDateStringByTimeStamp(shareActivity.getCt(),DateUtils.YMDHMS));
            }
            if(shareActivity.getActivityTime()!=null&&shareActivity.getActivityTime()>0)
            {
                shareActivityVo.setaTime(DateUtils.getDateStringByTimeStamp(shareActivity.getActivityTime(),DateUtils.YMD));
            }
            if (shareActivity.getCu()!=null&&shareActivity.getCu()>0){
                ServiceResult<UserManager> result=new ServiceResult<>(userManagerMapper.queryUserShareManagerById(shareActivity.getCu()));
                if(result.getSuccess()&&result.getBody()!=null){
                    shareActivityVo.setcUser(result.getBody().getUsername());
                }
            }
            return shareActivityVo;
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            return new ShareActivityVo();
        }
    }
    private ShareAnnouncementVo getShareAnnouncementVo(ShareAnnouncementVo shareAnnouncementVo, ShareAnnouncement shareAnnouncement){
        try {
            shareAnnouncementVo = JSONObject.parseObject(JSONObject.toJSONString(shareAnnouncement),ShareAnnouncementVo.class);
            shareAnnouncementVo.setcUser("");
            shareAnnouncementVo.setcTime("");
            shareAnnouncementVo.setuTime("");
            if(shareAnnouncement.getCt()!=null&&shareAnnouncement.getCt()>0)
            {
                shareAnnouncementVo.setcTime(DateUtils.getDateStringByTimeStamp(shareAnnouncement.getCt(),DateUtils.YMDHMS));
            }
            if(shareAnnouncement.getUploadTime()!=null&&shareAnnouncement.getUploadTime()>0)
            {
                shareAnnouncementVo.setuTime(DateUtils.getDateStringByTimeStamp(shareAnnouncement.getUploadTime(),DateUtils.YMDHMS));
            }
            if(shareAnnouncement.getEndTime()!=null&&shareAnnouncement.getEndTime()>0)
            {
                shareAnnouncementVo.seteTime(DateUtils.getDateStringByTimeStamp(shareAnnouncement.getEndTime(),DateUtils.YMDHMS));
            }
            if (shareAnnouncement.getCu()!=null&&shareAnnouncement.getCu()>0){
                ServiceResult<UserManager> result=new ServiceResult<>(userManagerMapper.queryUserShareManagerById(shareAnnouncement.getCu()));
                if(result.getSuccess()&&result.getBody()!=null){
                    shareAnnouncementVo.setcUser(result.getBody().getUsername());
                }
            }
            if (shareAnnouncement.getActivityId()!=null&&shareAnnouncement.getActivityId()>0){
                ServiceResult<ShareActivity> result=new ServiceResult<>(shareActivityMapper.selectByPrimaryKey(shareAnnouncement.getActivityId()));
                if(result.getSuccess()&&result.getBody()!=null){
                    shareAnnouncementVo.setName(result.getBody().getName());
                }
            }
            return shareAnnouncementVo;
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            return new ShareAnnouncementVo();
        }
    }

    @Override
    public ServiceResult<Integer> getShareActivityCount(ShareActivityQuery query) {
        return  new ServiceResult<>(shareActivityMapper.getShareActivityCount(query));
    }

    @Override
    public ServiceResult<Integer> updateShareActivityStatus(List<Integer> ids, int isDelete, int cU, int cTime) {
        int count = 0;
        ServiceResult<Integer> serviceResult = new ServiceResult();
        serviceResult.setBody(0);
        for (Integer id : ids) {
            count = count + shareActivityMapper.updateShareActivityStatus(id, isDelete,cU,cTime);
        }
        if (count == ids.size()) {
            serviceResult.setBody(1);
        }

        return serviceResult;
    }

    @Override
    public ServiceResult<Integer> insertShareAnnouncement(ShareAnnouncementQuery record) {
       return new ServiceResult<>(shareAnnouncementMapper.insert(record));
    }

    @Override
    public ServiceResult<ShareAnnouncement> selectShareAnnouncementByPrimaryKey(Integer id) {
        return new ServiceResult<>(shareAnnouncementMapper.selectByPrimaryKey(id));
    }

    @Override
    public ServiceResult<List<ShareAnnouncementVo>> getShareAnnouncementVoList(ShareAnnouncementQuery query) {
        try {
            List<ShareAnnouncementVo> shareAnnouncementVos=new ArrayList<>();

            ServiceResult<List<ShareAnnouncement>> serviceResult=new ServiceResult<>(shareAnnouncementMapper.getShareAnnouncementList(query));
            if (serviceResult.getSuccess()&&serviceResult.getBody()!=null){
                for (ShareAnnouncement shareAnnouncement:serviceResult.getBody()) {
                    ShareAnnouncementVo shareAnnouncementVo= new ShareAnnouncementVo();
                    shareAnnouncementVos.add(this.getShareAnnouncementVo(shareAnnouncementVo,shareAnnouncement));
                }
            }
            return new ServiceResult<>(shareAnnouncementVos) ;
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            return new ServiceResult<>(11,e.getMessage());
        }
    }

    @Override
    public ServiceResult<Integer> getShareAnnouncementCount(ShareAnnouncementQuery query) {
        return  new ServiceResult<>(shareAnnouncementMapper.getShareAnnouncementCount(query));
    }

    @Override
    public ServiceResult<Integer> updateShareAnnouncementStatus(List<Integer> ids, int isDelete, int cU, int cTime) {
        int count = 0;
        ServiceResult<Integer> serviceResult = new ServiceResult();
        serviceResult.setBody(0);
        for (Integer id : ids) {
            count = count + shareAnnouncementMapper.updateShareAnnouncementStatus(id, isDelete,cU,cTime);
        }
        if (count == ids.size()) {
            serviceResult.setBody(1);
        }

        return serviceResult;
    }

    @Override
    public ServiceResult<Integer> getShareAnnouncementBySrc(String src) {
        return new ServiceResult<>( shareAnnouncementMapper.getShareAnnouncementBySrc(src));
    }


    @Override
    public ServiceResult<Integer> getShareActivityByActivityRoom(String activityRoom,Integer activityTime) {
        return new ServiceResult<>(shareActivityMapper.getShareActivityByActivityRoom(activityRoom,activityTime));
    }
}
