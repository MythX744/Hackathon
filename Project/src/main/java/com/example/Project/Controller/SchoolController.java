package com.example.Project.Controller;

import com.example.Project.Service.ISchoolService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/School")
public class SchoolController {

    private ISchoolService schoolService;

    @Autowired
    public SchoolController(ISchoolService schoolService) {
        this.schoolService = schoolService;
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

}
