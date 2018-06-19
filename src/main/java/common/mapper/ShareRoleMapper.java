package common.mapper;

import common.model.ShareRole;
import common.query.ShareRoleQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ShareRoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ShareRoleQuery record);

    int insertSelective(ShareRole record);

    ShareRole selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ShareRole record);

    int updateByPrimaryKey(ShareRole record);

    String getRoleById(@Param("id") int id);

    int getRolePermissionsId(@Param("id") int id);

    List<ShareRole> getUserRoleList(ShareRoleQuery query);

}