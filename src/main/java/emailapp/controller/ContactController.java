package emailapp.controller;

import emailapp.model.Contact;
import emailapp.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
public class ContactController {

    @RequestMapping("/sendMessage")
    public String createUser(Model model) {
        model.addAttribute("sendSuccess", new Contact());
        return "admin/user/contact/createMessage";
    }

}
