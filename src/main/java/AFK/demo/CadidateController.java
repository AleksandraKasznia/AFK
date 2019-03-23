package AFK.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class CadidateController {
    @Autowired
    private CandidateRepository candidateRepository;

    @GetMapping("/joinProject")
    public String join(Model model){
        Candidate candidate = new Candidate();
        candidate.
        model.addAttribute("candidate",candidate);
        return "join";
    }

    @PostMapping("/joinProject")
    public String joinProject(@ModelAttribute("/joinProject")Candidate candidate,
                             BindingResult result, Model model,
                             final RedirectAttributes redirectAttributes){
        candidateRepository.save(candidate);
        return "candidate";
    }
}
