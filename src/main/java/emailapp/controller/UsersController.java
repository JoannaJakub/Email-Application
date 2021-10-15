package emailapp.controller;

import emailapp.repository.UserRepository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

public class UsersController {
    public final UserRepository userRepository;

    public UsersController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @RequestMapping("/users")
    public String allUsers(Model model) {
        model.addAttribute("allUsers", userRepository.findAll());
        return "admin/users/users";
    }
}
