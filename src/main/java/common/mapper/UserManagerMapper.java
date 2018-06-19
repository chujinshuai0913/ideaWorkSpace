package common.mapper;

import common.model.UserManager;
import common.query.UserManagerQuery;
import common.util.ServiceResult;
import common.vo.UserManagerVo;
import common.vo.UserShareVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserManagerMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserManagerQuery record);

    int insertSelective(UserManager record);

    UserManager selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserManagerQuery record);

    int updateByPrimaryKey(UserManager record);

    String getUserNameById(@Param("id") int id);

    /*查询网站管理用户*/
    UserManager queryUserShareManager(UserManagerQuery userManagerQuery);
    int  queryUserShareManagerCount(UserManagerQuery userManagerQuery);
    UserManager loginUserManager(UserManagerQuery userManagerQuery);

    /*查询网站管理用户列表*/
    List<UserManager>  queryUserShareManagerLists(UserManagerQuery userManagerQuery);

    /*查询网站管理用户列表*/
    UserManager queryUserShareManagerById(@Param("id") int id);



    /*查看用户总数*/
    int queryCountUserShareManager(UserManagerQuery UserManagerQuery);

    /*修改用户角色*/
   Boolean updateRole(UserManagerQuery UserManagerQuery);
}