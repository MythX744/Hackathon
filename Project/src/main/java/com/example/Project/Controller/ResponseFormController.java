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
    public String submitResponse(HttpSession session,
                                 @RequestParam("question1") String question1,
                                 @RequestParam("question2") String[] question2,
                                 @RequestParam("question3") String question3,
                                 @RequestParam("question4") String[] question4,
                                 @RequestParam("question5") String question5,
                                 @RequestParam("question6") String question6,
                                 @RequestParam("question7") String[] question7) {
        User user = (User) session.getAttribute("user");
        if (user == null) {
            return "redirect:/login";
        }

        // Concatenating all answers
        StringBuilder allAnswers = new StringBuilder();
        allAnswers.append("Q1: ").append(question1);
        allAnswers.append("; Q2: ").append(question2 != null ? String.join(", ", question2) : "None selected");
        allAnswers.append("; Q3: ").append(question3);
        allAnswers.append("; Q4: ").append(question4 != null ? String.join(", ", question4) : "None selected");
        allAnswers.append("; Q5: ").append(question5);
        allAnswers.append("; Q6: ").append(question6);
        allAnswers.append("; Q7: ").append(question7 != null ? String.join(", ", question7) : "None selected");

        String concatenatedAnswers = allAnswers.toString();
        System.out.println(concatenatedAnswers);

        boolean isSevereHarassment = "yes".equals(question3) && ((question2 != null && question2.length >= 2) || (question4 != null && question4.length >= 2));
        String decision = isSevereHarassment ? "Severe Harassment" : "Light Harassment";

        // Create a ResponseForm entity and set properties
        ResponseForm responseForm = new ResponseForm();
        responseForm.setDate(LocalDate.now());
        responseForm.setDecision(decision);
        responseForm.setText(concatenatedAnswers); // Set the concatenated answers as the text
        responseForm.setUser(user);

        // Save the form using your service
        responseFormService.save(responseForm);

        // Redirect based on the decision
        if (isSevereHarassment) {
            return "redirect:/navigation/severeHarassment";
        } else {
            return "redirect:/navigation/lightHarassment";
        }
    }

    @PostMapping("/submitResponseChild")
    public String submitResponseChild(HttpSession session,
                                      @RequestParam("option1") String[] option1){

        User user = (User) session.getAttribute("user");
        if (user == null) {
            return "redirect:/login";
        }

        // Mapping of checkbox values to descriptive sentences
        Map<String, String> optionDescriptions = Map.of(
                "option1", "I feel sad more often than not, or may be easily angered and frustrated.",
                "option2", "I don’t like to hang out with my friends anymore.",
                "option3", "I sleep a lot more, or a lot less than I used to.",
                "option4", "I have a lot of trouble concentrating, and my grade may have dropped.",
                "option5", "I’ve lost weight or gained a lot of weight.",
                "option6", "I feel alone, and don’t have anyone I can turn to.",
                "option7", "I cry a lot more than I used to.",
                "option8", "I always worry, and may have panic attacks.",
                "option9", "Sometimes I feel like it would be better if I weren’t around."
        );

        // Build the answer summary based on selected options
        StringBuilder answerSummary = new StringBuilder();
        if (option1 != null) {
            for (String optionValue : option1) {
                String description = optionDescriptions.get(optionValue);
                if (description != null) {
                    answerSummary.append(description).append("; ");
                }
            }
        } else {
            answerSummary.append("None selected");
        }

        String concatenatedAnswers = answerSummary.toString().trim();
        System.out.println(concatenatedAnswers);

        // Determine the number of checked options
        int checkedCount = option1 != null ? option1.length : 0;

        String decision = checkedCount > 3 ? "Severe Harassment" : "Light Harassment";

        // Create and populate the ResponseForm entity
        ResponseForm responseForm = new ResponseForm();
        responseForm.setDate(LocalDate.now());
        responseForm.setDecision(decision);
        responseForm.setText(concatenatedAnswers); // Set the concatenated answers
        responseForm.setUser(user);

        // Save the form using your service
        responseFormService.save(responseForm);

        // Redirect based on the decision
        if (checkedCount > 3) {
            return "redirect:/navigation/severeHarassment";
        } else {
            return "redirect:/navigation/lightHarassment";
        }
    }


}
