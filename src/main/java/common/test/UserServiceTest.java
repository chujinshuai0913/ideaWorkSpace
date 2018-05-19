/**
 * Copyright (C), 2018-2018
 * FileName: UserServiceTest
 * Author:   jinshuai
 * Date:     2018/4/8 23:04
 * Description: UserService测试
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package common.test;
import common.query.UserShareQuery;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import common.service.UserService;

/**
 * 〈一句话功能简述〉<br> 
 * 〈UserService测试〉
 *
 * @author jinshuai
 * @create 2018/4/8
 * @since 1.0.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
public class UserServiceTest {

    @Autowired
    private UserService userService;
    @Test
    public void queryUserShareTest(){
        UserShareQuery userShareQuery=new UserShareQuery();
        userShareQuery.setStatus(0);
        System.out.println(userService.queryUserShareLists(userShareQuery));
    }
    @Test
    public void insertUserTest(){

    }
}
