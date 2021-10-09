package emailapp;

import emailapp.model.User;

public interface UserService {
    User findByUserName(String name);
    void saveUser(User user);
}
