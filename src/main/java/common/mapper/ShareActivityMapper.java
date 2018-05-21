package common.mapper;

import common.model.ShareActivity;
import common.query.ShareActivityQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ShareActivityMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ShareActivityQuery record);

    int insertSelective(ShareActivity record);

    ShareActivity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ShareActivity record);

    int updateByPrimaryKey(ShareActivity record);

    List<ShareActivity> getShareActivityList(ShareActivityQuery query);

    int getShareActivityCount(ShareActivityQuery query);

    int updateShareActivityStatus(@Param("id") int id, @Param("isDelete")  int isDelete, @Param("cU") int cU, @Param("cTime") int cTime);

    int getShareActivityByActivityRoom(@Param("activityRoom") String activityRoom, @Param("activityTime") Integer activityTime);


}