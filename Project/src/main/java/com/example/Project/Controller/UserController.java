package com.example.Project.Controller;


import com.example.Project.Model.User;
import com.example.Project.Service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/User")
public class UserController {

    IUserService userService;

    @Autowired
    public UserController(IUserService userService) {
        this.userService = userService;
    }
    @GetMapping("/loadLogin")
    public String getLoginPage(Model leModel) {
        User theUser = new User();
        leModel.addAttribute("user", theUser);
        return "login";
    }
    @PostMapping("/login")
    public String login() {
        return "redirect:/User/loadProfile";
    }
    @GetMapping("/loadSignup")
    public String getSignUpPage(@ModelAttribute("user") User user){
        return "signup";
    }
    @PostMapping("/signup")
    public String saveUser(@ModelAttribute("user") User user, Model model){
        userService.save(user);
        return "redirect:/User/loadLogin";
    }
}
