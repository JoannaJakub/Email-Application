package emailapp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class EmailApp {
    @RequestMapping("/")
    @ResponseBody
    public String home() {
        return "hello world !!!";
    }
}
