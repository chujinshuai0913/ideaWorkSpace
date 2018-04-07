package sharebook.service;

import sharebook.model.User;

public interface UserService {
    User queryByNamePwd(User user);

}
