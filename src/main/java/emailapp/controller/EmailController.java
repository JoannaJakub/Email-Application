package emailapp.controller;

import emailapp.RandomPasswordGenerator;
import emailapp.model.Email;
import emailapp.repository.DepartmentRepository;
import emailapp.repository.EmailRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
public class EmailController {
    public final EmailRepository emailRepository;
    public final DepartmentRepository departmentRepository;
    public final RandomPasswordGenerator randomPasswordGenerator;

    public EmailController(EmailRepository emailRepository, DepartmentRepository departmentRepository, RandomPasswordGenerator randomPasswordGenerator) {
        this.emailRepository = emailRepository;
        this.departmentRepository = departmentRepository;
        this.randomPasswordGenerator = randomPasswordGenerator;
    }

    @RequestMapping("/email")
    public String createMail(Model model) {
        model.addAttribute("addThisEmail", new Email());
        model.addAttribute("department", departmentRepository.findAll());
        return "admin/email/email";
    }

    private String companyName() {
        return "AZCompany";
    }

    private Email returnEmail(@Valid Email email) {
        String firstName = email.getFirstName().toLowerCase();
        String lastName = email.getLastName().toLowerCase();
        String department = email.getDepartment().getShortName().toLowerCase();
        String company = companyName().toLowerCase();
        email.setGeneratedEmail(firstName + "." + lastName + "@" + department + "." + company + ".com");
        return email;
    }

    @PostMapping(value = "/emailSuccess")
    public String processRegister(@Valid Email email, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "admin/email/email";
        }
        email.setPassword(randomPasswordGenerator.generatePassword());
        returnEmail(email);
        emailRepository.save(email);
        model.addAttribute("userDetails", emailRepository.findTopByOrderByIdDesc());
        return "admin/email/emailSuccess";

    }

    @RequestMapping("/allEmails")
    public String allUsers(Model model, @Param("keyword") String keyword) {
        List<Email> listEmail = listAll(keyword);
        model.addAttribute("keyword", keyword);
        model.addAttribute("users", listEmail);
        return "admin/email/allEmails";
    }

    @RequestMapping("/emailConfirmDelete")
    public String emailConfirmDelete() {
        return "admin/email/emailConfirmDelete";
    }

    @GetMapping(value = {"/emailDelete/{id}"})
    public String emailDelete(@PathVariable long id) {
        emailRepository.deleteById(id);
        return "redirect:/allEmails";
    }

    @GetMapping(value = {"/emailEdit/{id}"})
    public String emilEditForm(@PathVariable long id, Model model) {
        model.addAttribute("userEdit", emailRepository.findById(id));
        model.addAttribute("department", departmentRepository.findAll());

        return "admin/email/emailEdit";
    }

    @PostMapping(value = {"emailEdit/{id}"})
    public String emilEditSave(@Valid Email email) {
        emailRepository.save(email);
        return "redirect:/emailConfirmEditing/{id}";
    }

    @RequestMapping("/emailConfirmEditing/{id}")
    public String emailConfirmEditing(@PathVariable long id, Model model) {
        Optional<Email> email = emailRepository.findById(id);
        if (email.isPresent()) {
            model.addAttribute("emailConfirmEdit", email.get());
        } else {
            return "admin/email/adminError";
        }
        return "admin/email/emailConfirmEdit";
    }

    @GetMapping(value = {"/generateNewPassword/{id}"})
    public String generateNewPasswordForm(@PathVariable long id, Model model) {
        model.addAttribute("generateNewPassword", emailRepository.findById(id));
        return "admin/email/generateNewPassword";
    }

    @PostMapping(value = {"generateNewPassword/{id}"})
    public String generateNewPasswordSave(@Valid Email email) {
        email.setPassword(randomPasswordGenerator.generatePassword());
        emailRepository.save(email);
        return "redirect:/generateNewPasswordConfirm/{id}";
    }

    @RequestMapping("/generateNewPasswordConfirm/{id}")
    public String generateNewPasswordConfirm(@PathVariable long id, Model model) {
        Optional<Email> email = emailRepository.findById(id);
        if (email.isPresent()) {
            model.addAttribute("newPassword", email.get());
        } else {
            return "admin/email/adminError";
        }
        return "admin/email/generateNewPasswordConfirm";
    }

    public List<Email> listAll(String keyword) {
        if (keyword != null) {
            return emailRepository.search(keyword);
        }
        return emailRepository.findAll();
    }
}
