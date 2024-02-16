package com.example.Project.Controller;

import com.example.Project.Model.ResponseForm;
import com.example.Project.Model.School;
import com.example.Project.Model.User;
import com.example.Project.Service.ISchoolService;
import com.example.Project.Service.IUserService;
import com.example.Project.Service.impl.SchoolService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import jakarta.websocket.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import com.example.Project.Service.impl.UserService;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Set;


@Controller
@RequestMapping("/User")
public class UserController {
    private IUserService userService;
    private ISchoolService schoolService;
    @Autowired
    public UserController(UserService userService, SchoolService schoolService){
        this.userService = userService;
        this.schoolService = schoolService;
    }

    @GetMapping("/loadProfile")
    public String showProfile(Model model, HttpSession session) {
        User user = (User) session.getAttribute("user");
        Set<ResponseForm> responses = user.getResponseForms();
        model.addAttribute("responses", responses);
        model.addAttribute("user", user);
        return "profile";
    }


    @PostMapping("/profile")
    public User updateUser(@ModelAttribute("user") User user, Model model) {
        userService.update(user);
        return user;
    }

    @GetMapping("/loadLogin")
    public String getLoginPage(Model leModel) {
        User theUser = new User();
        leModel.addAttribute("user", theUser);
        return "login";
    }

    @PostMapping("/login")
    public String login(HttpSession session, User user) {
        String email = user.getEmail();
        String password = user.getPassword();
        if ((user = userService.validateUser(email, password)) != null) {
            session.setAttribute("user", user); // Trigger rating updates for all recipes
            return "redirect:/navigation/home";
        } else {
            System.out.println("Invalid credentials");
            return "redirect:/User/loadLogin";
        }
    }


    @GetMapping("/login/guest")
    public String signInAsGuest(HttpSession session) {
        User guestUser = new User();
        guestUser.setFullname("guest");
        session.setAttribute("user", guestUser);
        return "redirect:/navigation/home";
    }

    @GetMapping("/loadSignup")
    public String getRegPage(@ModelAttribute("user") User user){
        return "signup";
    }
    @PostMapping("/signup")
    public String saveUser(@ModelAttribute("user") User user, BindingResult result, Model model, @RequestParam("school") String schoolName){

        Long schoolId = schoolService.findIdByName(schoolName); // Attempt to find the school ID by name
        School school;

        if (schoolId == null) {
            // If no existing school found, create a new one
            school = new School();
            school.setName(schoolName);
            school = schoolService.save(school); // Save the new school and reuse it to get a managed entity with an ID
        } else {
            school = schoolService.findById(schoolId); // If found, fetch the full School entity
        }

        if (school != null) {
            user.setSchool(school); // Associate the school with the user
            userService.save(user); // Save the user
            System.out.println("User saved with school: " + school.getName());
        } else {
            System.out.println("Failed to associate school with user.");
            // Handle the error appropriately, maybe redirect to an error page or show an error message
            return "signup";
        }

        return "redirect:/User/loadLogin";
    }

    @GetMapping("/report")
    public String processLink(HttpSession session, Model model) {
        User user = (User) session.getAttribute("user"); // Directly retrieve the user object from the session
        if (user == null) {
            return "redirect:/User/loadLogin"; // Redirect if no user is found in the session
        }
        else {
            LocalDate dob = user.getDateOfBirth();
            int age = 0;
            if (dob != null) {
                LocalDate currentDate = LocalDate.now();
                age = Period.between(dob, currentDate).getYears();
                System.out.println("Age: " + age);
            }
                if (age < 12) {
                    return "redirect:/navigation/loadResponseFormChild";
                } else {
                    return "redirect:/navigation/loadResponseForm";
                }
        }
    }

    @GetMapping("/check-guest")
    @ResponseBody
    public String checkGuest(HttpSession session) {
        User user = (User) session.getAttribute("user");
        if ("guest".equals(user.getFullname())) {
            return "true";
        } else {
            return "false";
        }
    }

    @PostMapping("/age-filter")
    public String submitAge(@RequestParam("age") String age, HttpSession session) {
        if (age.equals("under12")) {
            return "redirect:/navigation/loadResponseFormChild";
        } else {
            return "redirect:/navigation/loadResponseForm";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/User/loadLogin";
    }

}
