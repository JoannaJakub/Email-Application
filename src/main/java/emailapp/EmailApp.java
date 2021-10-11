package emailapp;

import emailapp.model.Email;
import emailapp.model.User;
import emailapp.repository.DepartmentRepository;
import emailapp.repository.EmailRepository;
import emailapp.service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;


@Controller
public class EmailApp {
    public final EmailRepository emailRepository;
    public final DepartmentRepository departmentRepository;
    public final RandomPasswordGenerator randomPasswordGenerator;
    private final UserService userService;

    public EmailApp(EmailRepository emailRepository, DepartmentRepository departmentRepository, RandomPasswordGenerator randomPasswordGenerator, UserService userService) {
        this.emailRepository = emailRepository;
        this.departmentRepository = departmentRepository;
        this.randomPasswordGenerator = randomPasswordGenerator;
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

    @RequestMapping("/landingPage")
    public String landingPage(Model model) {
        return "admin/landingPage";
    }

    @RequestMapping("/email")
    public String createMail(Model model) {
        model.addAttribute("user", new Email());
        model.addAttribute("department", departmentRepository.findAll());
        return "admin/email";
    }

    private String companyName() {
        return "AZCompany";
    }



    @PostMapping(value = "/emailSuccess")
    public String processRegister(@Valid Email email, BindingResult result, Model model) {
        email.setPassword(randomPasswordGenerator.generatePassword());
        String firstName = email.getFirstName().toLowerCase();
        String lastName = email.getLastName().toLowerCase();
        String department = email.getDepartment().getShortName().toLowerCase();
        String company = companyName().toLowerCase();
        email.setGeneratedEmail(firstName + "." + lastName + "@" + department + "." + company + ".com");
        emailRepository.save(email);
        model.addAttribute("userDetails", emailRepository.findTopByOrderByIdDesc());
        return "admin/emailSuccess";
    }

    @RequestMapping("/allUsers")
    public String allUsers(Model model) {
        model.addAttribute("users", emailRepository.findAll());
        System.out.println(emailRepository.findAll());
        return "admin/allUsers";
    }


}
