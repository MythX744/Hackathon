package com.example.Project.Controller;

import com.example.Project.Model.ResponseForm;
import com.example.Project.Model.User;
import com.example.Project.Service.IResponseFormService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.Map;

@Controller
@RequestMapping("/ResponseForm")
public class ResponseFormController {

    private IResponseFormService responseFormService;

    @Autowired
    public ResponseFormController(IResponseFormService responseFormService) {
        this.responseFormService = responseFormService;
    }

    @GetMapping("/loadForm")
    public String loadResponseForm(Model model) {
        model.addAttribute("form", new ResponseForm());
        return "responseForm";
    }

    @PostMapping("/submitResponse")
    public String submitResponse(@RequestParam Map<String, String[]> allParams, Model model, HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user == null) {
            return "redirect:/login";
        }

        StringBuilder answers = new StringBuilder();
        int countQuestion2 = 0;
        int countQuestion4 = 0;
        String decision = "Light Harassment"; // Default decision

        for (Map.Entry<String, String[]> entry : allParams.entrySet()) {
            String key = entry.getKey();
            String[] values = entry.getValue();

            // Handling single and multiple values
            if (values.length == 1) {
                // Process single value
                answers.append(key).append(": ").append(values[0]).append("; ");
            } else {
                // Process multiple values (checkboxes)
                answers.append(key).append(": ").append(String.join(", ", values)).append("; ");
                if (key.equals("question2")) {
                    countQuestion2 += values.length;
                } else if (key.equals("question4")) {
                    countQuestion4 += values.length;
                }
            }
        }

        boolean isSevereHarassment = "yes".equals(allParams.get("question3")[0]) && (countQuestion2 >= 2 || countQuestion4 >= 2);
        if (isSevereHarassment) {
            decision = "Severe Harassment";
        }

        ResponseForm responseForm = new ResponseForm();
        responseForm.setText(answers.toString());
        responseForm.setDate(LocalDate.now());
        responseForm.setDecision(decision);
        responseForm.setUser(user);

        responseFormService.save(responseForm);

        return decision.equals("Severe Harassment") ? "redirect:/navigation/severeHarassment" : "redirect:/navigation/lightHarassment";
    }

}
