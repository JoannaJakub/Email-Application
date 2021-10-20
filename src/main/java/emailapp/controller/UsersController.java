package emailapp.controller;

import emailapp.model.User;
import emailapp.repository.EmailRepository;
import emailapp.repository.RoleRepository;
import emailapp.repository.UserRepository;
import emailapp.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
@Controller
public class UsersController {
    public final UserRepository userRepository;
    public final EmailRepository emailRepository;
    public final RoleRepository roleRepository;
    public final UserService userService;

    public UsersController(UserRepository userRepository, EmailRepository emailRepository, RoleRepository roleRepository, UserService userService) {
        this.userRepository = userRepository;
        this.emailRepository = emailRepository;
        this.roleRepository = roleRepository;
        this.userService = userService;
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
        if (result.hasErrors()) {
            model.addAttribute("role", roleRepository.findAll());
            return "admin/user/addUser";
        } else if (userService.findByUserName(user.getUsername().toLowerCase()) != null) {
            result.addError(new FieldError(user.toString(), "username", "Email is already taken"));
        } else {
            userService.saveUser(user);
            return "admin/user/userSuccess";
        }
        return "admin/user/addUser";
    }

    @RequestMapping("/usersConfirmDelete")
    public String userConfirmDelete() {
        return "admin/user/userConfirmDelete";
    }

    @GetMapping(value = {"/userDelete/{id}"})
    public String userDelete(@PathVariable long id) {
        userRepository.deleteById(id);
        return "redirect:/allUsers";


    }
}
