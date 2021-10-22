package emailapp.service;

import emailapp.model.User;

public interface UserService {
    User findByUserName(String name);
    void saveUser(User user);
    User findLastUserById(Long Id);
}
