package common.service;


import common.mapper.PermissionsListManagerMapper;
import common.model.*;
import common.query.*;
import common.util.ServiceResult;
import common.vo.PermissionsSetVo;
import common.vo.StudenteacherVo;
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


 /*修改网站用户*/
   ServiceResult<Integer> updateUserManager(UserManagerQuery query);

   ServiceResult<Integer> insertUserManager(UserManagerQuery query);
    ServiceResult<List<ShareRole>> queryUserRole(ShareRoleQuery query);

    ServiceResult<Integer> insertPerrmissionSet(PermissionsSetQuery query);

    ServiceResult<Integer> deletePerrmissionSet(PermissionsSetQuery query);
    ServiceResult<Integer> insert(UserShareQuery query);

    /*根据id 查询网站管理员*/
    String getUserNameById(int id);

    /*根据id 查询用户姓名*/
    ServiceResult<UserShare> getUserShareNameById(int id);

    /*根据姓名查询用户id*/
    ServiceResult<List<Integer>> getIdByUserName(String userName);

    /*根据schoolCode查询认证信息*/

    ServiceResult<StudentTeacherList> getStudentTeacherList(Long schoolCode);

    /*每周六执行查询本周的异常用户存入异常用户表*/

    void insertAbnormal();
    /*查询异常用户*/
    ServiceResult<List<Abnormal>> getAbnormal();

    /*查询网站管理用户*/
    ServiceResult<UserManagerVo> queryUserShareManager(UserManagerQuery userManagerQuery);

     ServiceResult<Integer> queryUserShareManagerCount(UserManagerQuery userManagerQuery);
    /*查询网站管理用户列表*/
    ServiceResult<List<UserManagerVo>>  queryUserShareManagerLists(UserManagerQuery userManagerQuery);

    /*查看用户总数*/
    ServiceResult<Integer> queryCountUserShareManager(UserManagerQuery UserManagerQuery);

    /*修改用户角色*/
    ServiceResult<Boolean> updateRole(UserManagerQuery UserManagerQuery);

    ServiceResult<Integer> insertRole(ShareRoleQuery ShareRoleQuery);

 ServiceResult<Integer> insertPerrmission(PermissionsListManager query);


    /*查看用户总数*/
    ServiceResult<Integer> queryStudenteacherCount(StudentTeacherQuery query);

    /*查询网站管理用户列表*/
    ServiceResult<List<StudenteacherVo>>  queryStudenteacherList(StudentTeacherQuery query);
    /*查看当前用户是否有权限*/
    int  isTrue(String url,Integer roleId);

    /*获取角色拥有的权限Id*/
    List<Integer> getPermissionsSetIds(Integer roleId);

    StudenteacherVo getStudenteacherVo(StudenteacherVo studenteacherVo,StudentTeacherList studenteacher);

    /*网站后台用户注册*/
    ServiceResult<Integer>  signUserShareManager(UserManagerQuery query);
    /*网站后台用户登录*/
    ServiceResult<UserManagerVo>  getLoginUserShareManager(UserManagerQuery query);
    /*网站用户注册*/
    ServiceResult<Integer>  signUserShare(UserShareQuery query);
    /*网站用户登录*/
    ServiceResult<UserShareVo>  getLoginUserShare(UserShareQuery query);

    ServiceResult<Long>  getPhoneNumber(UserShareQuery query);

    /*查询权限*/
    ServiceResult<List<PermissionsListManager>>  getPermissionsListManagerList(PermissionsListManagerQuery query);

    /*修改权限的状态*/
    ServiceResult<Integer>  updatePermissionsListManagerStatus(PermissionsListManager query);


}
