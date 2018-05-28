package common.mapper;

import common.model.PermissionsSet;

public interface PermissionsSetMapper {
    int deleteByPrimaryKey(Long id);

    int insert(PermissionsSet record);

    int insertSelective(PermissionsSet record);
}