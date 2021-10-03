package emailapp;

import emailapp.model.Email;
import emailapp.repository.DepartmentRepository;
import emailapp.repository.EmailRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class EmailApp {
    public final EmailRepository emailRepository;
    public final DepartmentRepository departmentRepository;

    public EmailApp(EmailRepository emailRepository, DepartmentRepository departmentRepository) {
        this.emailRepository = emailRepository;
        this.departmentRepository = departmentRepository;
    }

    @RequestMapping("/")
    @ResponseBody
    public String createMail(Model model) {
      /*  model.addAllAttributes("user", new Email());
        model.addAllAttributes("department", departmentRepository.findAll());*/
        return "email";
    }

}
