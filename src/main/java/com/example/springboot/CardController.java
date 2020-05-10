package com.example.springboot;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CardController {

    @GetMapping("/")
    public String index(Model model){
        String prompt = "exampleprompt";
        model.addAttribute("prompt", prompt);
        model.addAttribute("card1", "examplecard1");
        model.addAttribute("card2", "examplecard2");
        model.addAttribute("card3", "examplecard3");
        return "index";
    }

//    @GetMapping("/")
//    public String index(@RequestParam(name="prompt", required=false, defaultValue="World") String prompt, Model model) {
//        model.addAttribute("prompt", prompt);
//        return "index";
//    }

}