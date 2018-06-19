/**
 * Copyright (C), 2018-2018
 * FileName: ShareManagerService
 * Author:   jinshuai
 * Date:     2018/5/21 10:50
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package common.service;

import common.model.ShareActivity;
import common.model.ShareAnnouncement;
import common.query.ShareActivityQuery;
import common.query.ShareAnnouncementQuery;
import common.util.ServiceResult;
import common.vo.ShareActivityVo;
import common.vo.ShareAnnouncementVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author jinshuai
 * @create 2018/5/21
 * @since 1.0.0
 */
public interface ShareManagerService {

    ServiceResult<Integer> insertShareActivity(ShareActivityQuery record);

    ServiceResult<ShareActivity> selectByPrimaryKey(Integer id);

    ServiceResult<List<ShareActivityVo>> getShareActivityVoList(ShareActivityQuery query);

    ServiceResult<List<ShareAnnouncement>> getShareAnnouncementImgList(ShareAnnouncementQuery query);

    ServiceResult<List<Integer>> getShareAnnouncementImgCount(ShareAnnouncementQuery query);
    ServiceResult<Integer> getShareActivityCount(ShareActivityQuery query);

    ServiceResult<Integer> updateShareActivityStatus( List<Integer> ids, int isDelete,int cU,int cTime);

    ServiceResult<Integer> insertShareAnnouncement(ShareAnnouncementQuery record);

    ServiceResult<ShareAnnouncement> selectShareAnnouncementByPrimaryKey(Integer id);

    ServiceResult<List<ShareAnnouncementVo>> getShareAnnouncementVoList(ShareAnnouncementQuery query);

    ServiceResult<Integer> getShareAnnouncementCount(ShareAnnouncementQuery query);

    ServiceResult<Integer> updateShareAnnouncementStatus(List<Integer> ids, int isDelete,int cU,int cTime);

    ServiceResult<Integer> getShareAnnouncementBySrc(String src);
    ServiceResult<Integer> getShareActivityByActivityRoom(String activityRoom,Integer activityTime);


}
