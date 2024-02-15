package com.example.Project.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/navigation")
public class PageController {

    @RequestMapping("/home")
    public String LoadHome(Model model){
        return "home";
    }

    @RequestMapping("/contact")
    public String LoadContact(Model model){
        return "";
    }

    @RequestMapping("/specialists")
    public String LoadSpecialists(Model model){
        return "";
    }

    @RequestMapping("/faq")
    public String LoadFAQ(Model model){
        return "";
    }

    @RequestMapping("/User/loadProfile")
    public String LoadProfile(){
        return "profile";
    }
}
