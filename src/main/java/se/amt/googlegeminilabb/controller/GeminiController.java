package se.amt.googlegeminilabb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import se.amt.googlegeminilabb.service.GeminiService;

@Controller
@RequestMapping("/")
public class GeminiController {
    private final GeminiService geminiService;

    public GeminiController(GeminiService geminiService) {
        this.geminiService = geminiService;
    }

    @GetMapping("/")
    public String home(Model model) {
        return "prompt";
    }


    @PostMapping("/request")
    public String request(@RequestParam String prompt, Model model) {
        String answer = geminiService.ask(prompt);

        model.addAttribute("question", prompt);
        model.addAttribute("answer", answer);
        return "prompt";
    }
}
