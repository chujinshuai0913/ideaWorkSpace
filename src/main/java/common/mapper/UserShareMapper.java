package common.mapper;

import common.model.UserShare;
import common.query.UserShareQuery;
import common.vo.UserShareVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserShareMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserShareQuery record);

    int insertSelective(UserShare record);

    UserShare selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserShare record);

    int updateByPrimaryKey(UserShare record);

    /*查询网站用户*/
    UserShare queryUserShare(UserShareQuery userShareQuery);

    /*查询网站用户列表*/
    List<UserShare> queryUserShareLists(UserShareQuery userShareQuery);

    /*查询网站用户列表*/
    List<UserShare> queryUserShareListsByIds(UserShareQuery userShareQuery);

    /*查看用户总数*/
    int queryCountUserShare(UserShareQuery userShareQuery);

    /*根据姓名查询用户id*/
    List<Integer> getIdByUserName(@Param("userName") String userName);

    /*根据id 查询用户姓名*/
    UserShare getUserShareNameById(@Param("id") int id);
    /*修改网站用户*/
    int updateUserShare(UserShareQuery userShareQuery);

}