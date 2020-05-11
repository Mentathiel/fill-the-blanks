package com.example.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CardController {

    @Autowired
    private CardTextGenerator cg;

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("prompt", cg.getPrompt());
        model.addAttribute("card1", cg.getCard());
        model.addAttribute("card2", cg.getCard());
        model.addAttribute("card3", cg.getCard());
        model.addAttribute("card4", cg.getCard());
        return "index";
    }

    @GetMapping("/black")
    public String black(Model model){
        model.addAttribute("textsubmission", new TextSubmission());
        model.addAttribute("black", cg.getAllPrompts());
        return "black";
    }

//    @PostMapping("/black")
//    public String addBlack(@ModelAttribute TextSubmission txt, Model model){
//        model.addAttribute("textsubmission", txt);
//        if(txt.getText() != "" && txt.getText() != null) {
//            cg.addPrompt(txt.getText());
//        }
//        model.addAttribute("black", cg.getAllPrompts());
//        return "black";
//    }

    @GetMapping("/white")
    public String white(Model model){
        model.addAttribute("white", cg.getAllCards());

        return "white";
    }

//    @PostMapping("/white")
//    public String white(@ModelAttribute TextSubmission txt, Model model){
//        if(txt.getText() != "") {
//            cg.addPrompt(txt.getText());
//            model.addAttribute("white", cg.getAllCards());
//        }
//        return "white";
//    }
}