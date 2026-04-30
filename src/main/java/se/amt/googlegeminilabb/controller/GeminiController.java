package se.amt.googlegeminilabb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import se.amt.googlegeminilabb.model.GeminiModel;
import se.amt.googlegeminilabb.repository.GeminiRepository;
import se.amt.googlegeminilabb.service.GeminiService;

@Controller
@RequestMapping("/")
public class GeminiController {
    private final GeminiService geminiService;
    private final GeminiRepository geminiRepository;

    public GeminiController(GeminiService geminiService, GeminiRepository geminiRepository) {
        this.geminiService = geminiService;
        this.geminiRepository = geminiRepository;
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("history", geminiRepository.findAll());
        return "prompt";
    }


    @PostMapping("/request")
    public String request(@RequestParam String prompt, Model model) {
        String answer = geminiService.ask(prompt);

        GeminiModel geminiModel = new GeminiModel();
        geminiModel.setQuestion(prompt);
        geminiModel.setAnswer(answer);
        geminiRepository.save(geminiModel);

        model.addAttribute("question", prompt);
        model.addAttribute("answer", answer);
        model.addAttribute("history", geminiRepository.findAll());
        
        return "prompt";
    }
}
