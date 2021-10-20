package emailapp.controller;

import emailapp.model.User;
import emailapp.service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collection;


@Controller
public class EmailApp {
    private final UserService userService;

    public EmailApp( UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String login() {
        return "main/login";
    }

    @GetMapping("/create-user")
    @ResponseBody
    public String createUser() {
        User user = new User();
        user.setUsername("admin");
        user.setPassword("admin");
        user.setFirstName("admin");
        user.setLastName("admin");
        userService.saveUser(user);
        return "admin";
    }

    @GetMapping(value="/logout")
    public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/?logout";
    }

    @RequestMapping("/default")
    public String defaultAfterLogin() {
        Collection<? extends GrantedAuthority> authorities;
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        authorities = auth.getAuthorities();
        String myRole = authorities.toArray()[0].toString();
        String admin = "ADMIN";
        if (myRole.equals(admin)) {
            return "redirect:/adminLandingPage";
        }
        return "redirect:/landingPage";
    }

    @GetMapping("/adminLandingPage")
    public String adminLandingPage() {
        return "admin/adminLandingPage";
    }

}
