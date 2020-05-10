package com.example.springboot;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CardController {

    @GetMapping("/")
    public String index(Model model){
        CardTextGenerator cg = new CardTextGenerator();
        model.addAttribute("prompt", cg.getPrompt());
        model.addAttribute("card1", cg.getCard());
        model.addAttribute("card2", cg.getCard());
        model.addAttribute("card3", cg.getCard());
        model.addAttribute("card4", cg.getCard());
        return "index";
    }

    @GetMapping("/black")
    public String black(Model model){
        CardTextGenerator cg = new CardTextGenerator();
        model.addAttribute("black", cg.getAllPrompts());
        return "black";
    }

    @PostMapping("/black")
    public String addBlack(@RequestParam(name="prompt", required=false, defaultValue="") String prompt, Model model){
        if(prompt != "") {
            CardTextGenerator cg = new CardTextGenerator();
            cg.addPrompt(prompt);
            model.addAttribute("black", cg.getAllPrompts());
        }
        return "black";
    }

    @GetMapping("/white")
    public String white(Model model){
        CardTextGenerator cg = new CardTextGenerator();
        model.addAttribute("white", cg.getAllCards());

        return "white";
    }

    @PostMapping("/white")
    public String white(@RequestParam(name="card", required=false, defaultValue="") String card, Model model){
        if(card != "") {
            CardTextGenerator cg = new CardTextGenerator();
            cg.addCard(card);
            model.addAttribute("white", cg.getAllCards());
        }
        return "white";
    }
}