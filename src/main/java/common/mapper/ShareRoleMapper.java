package common.mapper;

import common.model.ShareRole;
import org.apache.ibatis.annotations.Param;

public interface ShareRoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ShareRole record);

    int insertSelective(ShareRole record);

    ShareRole selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ShareRole record);

    int updateByPrimaryKey(ShareRole record);

    String getRoleById(@Param("id") int id);
}