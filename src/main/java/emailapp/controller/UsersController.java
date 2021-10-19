package emailapp.controller;

import emailapp.model.Email;
import emailapp.model.User;
import emailapp.repository.EmailRepository;
import emailapp.repository.RoleRepository;
import emailapp.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
@Controller
public class UsersController {
    public final UserRepository userRepository;
    public final EmailRepository emailRepository;
    public final RoleRepository roleRepository;

    public UsersController(UserRepository userRepository, EmailRepository emailRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.emailRepository = emailRepository;
        this.roleRepository = roleRepository;
    }

    @RequestMapping("/allUsers")
    public String allUsersAdmin(Model model) {
        model.addAttribute("allUsers1", userRepository.findAll());
        return "admin/user/allUsers";
    }

    @RequestMapping("/addUser")
    public String createUser(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("role", roleRepository.findAll());
        return "admin/user/addUser";
    }


    @PostMapping(value = "/addUserSuccess")
    public String addUserSuccess(@Valid User user, BindingResult result, Model model) {
        userRepository.save(user);
        return "admin/user/userSuccess";
    }

}
