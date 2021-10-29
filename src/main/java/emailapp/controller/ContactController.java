package emailapp.controller;

import emailapp.model.User;
import emailapp.service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collection;


@Controller
public class ContactController {
    private final UserService userService;

    public ContactController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/addContact")
    public String createUser(Model model) {
        model.addAttribute("conatct", new User());
        return "admin/user/addContact";
    }

}
