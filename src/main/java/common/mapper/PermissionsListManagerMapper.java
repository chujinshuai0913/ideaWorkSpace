package common.mapper;

import common.model.PermissionsListManager;
import common.query.PermissionsListManagerQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PermissionsListManagerMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PermissionsListManager record);

    int insertSelective(PermissionsListManager record);

    PermissionsListManager selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PermissionsListManager record);

    int updateByPrimaryKey(PermissionsListManager record);

    PermissionsListManager getTrueOrFalse(@Param("Ids") List<Integer> Ids,@Param("url") String url);

    int updatePermissionsListManagerStatus(PermissionsListManager query);

    List<PermissionsListManager> getPermissionsListManagerList(PermissionsListManagerQuery query);


}