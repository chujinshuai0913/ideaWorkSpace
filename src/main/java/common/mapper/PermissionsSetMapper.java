package common.mapper;

import common.model.PermissionsSet;
import common.query.PermissionsSetQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PermissionsSetMapper {
    int deleteByPrimaryKey(Long id);

    int deleteByPermissionsId(@Param("permissionsId") int permissionsId);
    int insert(PermissionsSetQuery record);

    int insertSelective(PermissionsSet record);

    PermissionsSet selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PermissionsSet record);

    int updateByPrimaryKey(PermissionsSet record);

    List<PermissionsSet> getPermissionsSetList(PermissionsSetQuery query);

  List<Integer> getPermissionsSetIds(@Param("roleId") int roleId);

}