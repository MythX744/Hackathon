package com.example.Project.Controller;

import com.example.Project.Model.User;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.Project.Service.impl.UserService;


@Controller
@RequestMapping("/User")
public class UserController {
    private final UserService userService;
    @Autowired
    public UserController(UserService userService){
        this.userService = userService;

    }

    @GetMapping("/loadSignup")
    public String showSignUpForm(Model model){
        model.addAttribute("user", new User());

        return "signup";
    }

    @PostMapping("/signup")
    public String signUp(@ModelAttribute("user") @Valid User myUser, BindingResult bindingResult){
        if (userService.findByEmail(myUser.getEmail())!=null) {
            bindingResult.rejectValue("email", "error.user", "Email already has an account. Did you forget your password?");
            return "signup";
        }
        userService.save(myUser);
        return "login";
    }

    @GetMapping("/loadLogin")
    public String showLoginForm(Model model) {
        model.addAttribute("user", new User());
        return "login";
    }
    @PostMapping("/login")
    public String login(@ModelAttribute("user") @Valid User myUser, BindingResult bindingResult, HttpSession session){
        User authdUser = userService.login(myUser.getEmail(), myUser.getPassword());
        if (authdUser != null){
            session.setAttribute("loggedInUser", authdUser);
            userService.updateActionTimeByUser(authdUser);
            return "redirect:/index";
        }else {
            bindingResult.rejectValue("password", "error.user", "Invalid username or password");
            return "login";
        }
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "index";
    }

}
