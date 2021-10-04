package emailapp;

import emailapp.model.Email;
import emailapp.repository.DepartmentRepository;
import emailapp.repository.EmailRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


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
      /*  model.addAllAttributes("user", new Email());
        model.addAllAttributes("department", departmentRepository.findAll());*/
        return "index";
    }
    @RequestMapping("/email")
    public String createMail(Model model) {
        model.addAllAttributes("user", new Email());
        model.addAllAttributes("department", departmentRepository.findAll());
        return "email";
    }

}
