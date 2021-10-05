package emailapp;

import emailapp.model.Email;
import emailapp.repository.DepartmentRepository;
import emailapp.repository.EmailRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;


@Controller
public class EmailApp {
    public final EmailRepository emailRepository;
    public final DepartmentRepository departmentRepository;

    public EmailApp(EmailRepository emailRepository, DepartmentRepository departmentRepository) {
        this.emailRepository = emailRepository;
        this.departmentRepository = departmentRepository;
    }

    @RequestMapping("/")
    public String landingPage(Model model) {
        return "index";
    }

    @RequestMapping("/email")
    public String createMail(Model model) {
        model.addAttribute("user", new Email());
        model.addAttribute("department", departmentRepository.findAll());
        return "email";
    }

    @PostMapping(value = "/emailSuccess")
    public String processRegister(@Valid Email email, BindingResult result) {
        if (result.hasErrors()) {
            return "email";
        } else {
            emailRepository.save(email);
        }
        return "emailSuccess";
    }
}
