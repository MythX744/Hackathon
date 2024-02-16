package com.example.Project.Controller;

import com.example.Project.Model.User;
import com.example.Project.Service.ISchoolService;
import com.example.Project.Service.IUserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/School")
public class SchoolController {

    private ISchoolService schoolService;
    private IUserService userService;

    @Autowired
    public SchoolController(ISchoolService schoolService, IUserService userService) {
        this.schoolService = schoolService;
        this.userService = userService;
    }

    @PostMapping("/submit-testimony")
    public String submitTestimony(HttpSession session,
                                  @RequestParam("where") String where,
                                  @RequestParam("when") String when,
                                  @RequestParam("person") String person,
                                  @RequestParam("description") String description,
                                  Model model) {
        String[] strings = {where, when, person, description};
        String answers = String.join(";", strings);
        System.out.println(answers);
        session.setAttribute("answers", answers);
        model.addAttribute("submittedTestimony", true);

        return "thankYou";
    }

    @PostMapping("/School/submitSevereReport")
    public String submitSevereReport(HttpServletRequest request, Model model) {
        String choiceQ1 = request.getParameter("choiceQ1");
        String choiceQ2 = request.getParameter("choiceQ2");

        return null;
    }


}
