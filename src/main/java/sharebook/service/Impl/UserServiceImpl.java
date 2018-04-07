package sharebook.service.Impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sharebook.mapper.UserMapper;
import sharebook.model.User;
import sharebook.service.UserService;

import javax.annotation.Resource;

/**
 * @author jinshuai
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl implements UserService{

   @Resource
    private UserMapper userMapper;

    public User queryByNamePwd(User user){
        int id=1;

        return userMapper.selectByPrimaryKey(id);
    }
}
