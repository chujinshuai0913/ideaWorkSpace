package common.service;


import common.model.Abnormal;
import common.model.StudentTeacherList;
import common.model.UserShare;
import common.query.UserManagerQuery;
import common.query.UserShareQuery;
import common.util.ServiceResult;
import common.vo.UserManagerVo;
import common.vo.UserShareVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserService {
    /*查询网站用户*/
    ServiceResult<UserShareVo> queryUserShare(UserShareQuery userShareQuery);

    /*查询网站用户列表*/
    ServiceResult<List<UserShareVo>>  queryUserShareLists(UserShareQuery userShareQuery);
    /*查询网站用户列表*/
    ServiceResult<List<UserShareVo>>  queryUserShareByIds(UserShareQuery userShareQuery);

   /*查看用户总数*/
   ServiceResult<Integer> queryCountUserShare(UserShareQuery userShareQuery);

    /*修改网站用户*/
    ServiceResult<Integer> updateUserShare(UserShareQuery userShareQuery);

    ServiceResult<Integer> insert(UserShareQuery userShareQuery);

    /*根据id 查询网站管理员*/
    String getUserNameById(int id);

    /*根据id 查询用户姓名*/
    ServiceResult<UserShare> getUserShareNameById(int id);

    /*根据姓名查询用户id*/
    ServiceResult<List<Integer>> getIdByUserName(String userName);

    /*根据schoolCode查询认证信息*/

    ServiceResult<StudentTeacherList> getStudentTeacherList(int schoolCode);

    /*每周六执行查询本周的异常用户存入异常用户表*/

    void insertAbnormal();
    /*查询异常用户*/
    ServiceResult<List<Abnormal>> getAbnormal();

    /*查询网站管理用户*/
    ServiceResult<UserManagerVo> queryUserShareManager(UserManagerQuery userManagerQuery);

    /*查询网站管理用户列表*/
    ServiceResult<List<UserManagerVo>>  queryUserShareManagerLists(UserManagerQuery userManagerQuery);

    /*查看用户总数*/
    ServiceResult<Integer> queryCountUserShareManager(UserManagerQuery UserManagerQuery);

    /*修改用户角色*/
    ServiceResult<Boolean> updateRole(UserManagerQuery UserManagerQuery);

}
