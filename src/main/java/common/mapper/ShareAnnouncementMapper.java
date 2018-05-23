package common.mapper;

import common.model.ShareAnnouncement;
import common.query.ShareAnnouncementQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ShareAnnouncementMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ShareAnnouncementQuery record);

    int insertSelective(ShareAnnouncement record);

    ShareAnnouncement selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ShareAnnouncement record);

    int updateByPrimaryKey(ShareAnnouncement record);

    List<ShareAnnouncement> getShareAnnouncementList(ShareAnnouncementQuery query);

    int getShareAnnouncementCount(ShareAnnouncementQuery query);


    int updateShareAnnouncementStatus(@Param("id") int id, @Param("isDelete")  int isDelete, @Param("cU") int cU, @Param("cTime") int cTime);

    int getShareAnnouncementBySrc( @Param("src") String src);

    List<ShareAnnouncement> getShareAnnouncementImgList(ShareAnnouncementQuery query);

    List<Integer> getShareAnnouncementImgCount(ShareAnnouncementQuery query);


}