package emailapp.controller;

import emailapp.model.Contact;
import emailapp.repository.ContactRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;


@Controller
public class ContactController {
    public final ContactRepository contactRepository;

    public ContactController(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }


    @RequestMapping("/sendMessage")
    public String createUser(Model model) {
        model.addAttribute("sendMessage", new Contact());
        return "admin/contact/createMessage";
    }
    @PostMapping(value = "/sendSuccess")
    public String sendSuccess(@Valid Contact contact) {
        contactRepository.save(contact);
        return "admin/contact/sendSuccess";
    }


    @GetMapping(value = {"/messageDelete/{id}"})
    public String messageDelete(@PathVariable long id) {
        contactRepository.deleteById(id);
        return "redirect:/allUsers";


    }
    @RequestMapping("/messageConfirmDelete")
    public String messagerConfirmDelete() {
        return "admin/contact/messageConfirmDelete";
    }

}
