package com.example.Project.Controller;

import com.example.Project.Model.ResponseForm;
import com.example.Project.Model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/ResponseForm")
public class ResponseFormController {

    @GetMapping("/loadForm")
    public String loadResponseForm(Model model) {
        model.addAttribute("form", new ResponseForm());
        return "responseForm";
    }

    @PostMapping("/submitResponse")
    public String submitResponse() {
        return "responseForm";
    }
}
