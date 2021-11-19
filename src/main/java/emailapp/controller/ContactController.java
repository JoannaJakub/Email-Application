package emailapp.controller;

import emailapp.model.Contact;
import emailapp.repository.ContactRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.Optional;


@Controller
public class ContactController {
    public final ContactRepository contactRepository;

    public ContactController(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }


    @RequestMapping("/sendMessage")
    public String createMessage(Model model) {
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
        return "redirect:/allMessages";


    }
    @RequestMapping("/messageConfirmDelete")
    public String messageConfirmDelete() {
        return "admin/contact/messageConfirmDelete";
    }

    @RequestMapping("/allMessages")
    public String allMessage(Model model) {
        model.addAttribute("message", contactRepository.findAll());
        return "admin/contact/allMessages";
    }

    @GetMapping(value = {"/messageEdit/{id}"})
    public String messageEditForm(@PathVariable long id, Model model) {
        model.addAttribute("messageEdit", contactRepository.findById(id));
        return "admin/contact/messageEdit";
    }

    @PostMapping(value = {"messageEdit/{id}"})
    public String messageEditSave(@Valid Contact contact) {
        contactRepository.save(contact);
        return "redirect:/messageEditSuccess/{id}";
    }

    @RequestMapping("/messageEditSuccess/{id}")
    public String messageEditSuccess(@PathVariable long id, Model model) {
        Optional<Contact> contact = contactRepository.findById(id);
        model.addAttribute("messageEditSuccess", contact);
        return "admin/contact/messageEditSuccess";
    }
}
