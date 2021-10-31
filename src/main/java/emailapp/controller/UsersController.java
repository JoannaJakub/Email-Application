package emailapp.controller;

import emailapp.RandomPasswordGenerator;
import emailapp.model.Role;
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
import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;

@Controller
public class UsersController {
    public final UserRepository userRepository;
    public final EmailRepository emailRepository;
    public final RoleRepository roleRepository;
    public final UserService userService;
    public final RandomPasswordGenerator randomPasswordGenerator;


    public UsersController(UserRepository userRepository, EmailRepository emailRepository, RoleRepository roleRepository, UserService userService, RandomPasswordGenerator randomPasswordGenerator) {
        this.userRepository = userRepository;
        this.emailRepository = emailRepository;
        this.roleRepository = roleRepository;
        this.userService = userService;
        this.randomPasswordGenerator = randomPasswordGenerator;
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
        user.setPassword(randomPasswordGenerator.generatePassword());
        if (result.hasErrors()) {
            return "admin/user/addUser";
        } else if (userService.findByUserName(user.getUsername().toLowerCase()) != null) {
            result.addError(new FieldError(user.toString(), "username", "Username is already taken"));
        } else if (user.getRole().equals("ADMIN")) {
            Role userRole = roleRepository.findByName("ADMIN");
            user.setRole(new HashSet<Role>(Arrays.asList(userRole)));
        } else {
            userService.saveUser(user);
            model.addAttribute("userDetails", userService.findLastUserById(user.getId()));
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

    @GetMapping(value = {"/userEdit/{id}"})
    public String userEditForm(@PathVariable long id, Model model) {
        model.addAttribute("edit", userRepository.findById(id));
        model.addAttribute("role", roleRepository.findAll());

        return "admin/user/userEdit";
    }

    @PostMapping(value = {"userEdit/{id}"})
    public String userEditSave(@Valid User user) {
        userService.saveUser(user);
        return "redirect:/userConfirmEditing/{id}";
    }

    @RequestMapping("/userConfirmEditing/{id}")
    public String userConfirmEditing(@PathVariable long id, Model model) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            model.addAttribute("userConfirmEdit", user.get());
        } else {
            return "admin/user/adminError";
        }
        return "admin/user/userConfirmEdit";

    }

   @GetMapping(value = {"/userGenerateNewPassword/{id}"})
    public String userGenerateNewPasswordEditForm(@PathVariable long id, Model model) {
        model.addAttribute("newPas", userRepository.findById(id));
        return "admin/user/userGenerateNewPassword";
    }

    @PostMapping(value = {"userGenerateNewPassword/{id}"})
    public String userGenerateNewPasswordSave(@Valid User user) {
        userService.saveUser(user);
        return "redirect:/userGenerateNewPasswordConfirm/{id}";
    }
    @RequestMapping("/userGenerateNewPasswordConfirm/{id}")
    public String userGenerateNewPasswordConfirm(@PathVariable long id, Model model) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            model.addAttribute("newPassword", user.get());
        } else {
            return "admin/user/adminError";
        }
        return "admin/user/userGenerateNewPasswordConfirm";
    }
}
