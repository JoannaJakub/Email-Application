package emailapp.controller;

import emailapp.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
public class ContactController {

    @RequestMapping("/addContact")
    public String createUser(Model model) {
        model.addAttribute("conatct", new User());
        return "admin/user/addContact";
    }

}
