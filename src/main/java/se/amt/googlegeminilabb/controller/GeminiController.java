package se.amt.googlegeminilabb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import se.amt.googlegeminilabb.service.GeminiService;

@Controller
@RequestMapping("/")
public class GeminiController {
    private final GeminiService geminiService;

    public GeminiController(GeminiService geminiService) {
        this.geminiService = geminiService;
    }

    @ResponseBody
    @GetMapping("/request")
    public String request(@RequestParam String prompt) {
        return geminiService.ask(prompt);
    }
}
