package AFK.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private SkillRepository skillRepository;
    @Autowired
    private MembersRepository memberRepository;
    @Autowired
    private ProjectRepository projectRepository;

    @GetMapping("/user")
    public String printUser(@RequestParam(name="userId") String userId, Model model) {
        model.addAttribute("userId", userId);
        String user="";
        User myUser = userRepository.findById(userId).get();
        List<Skill> skills = skillRepository.findUsersSkills(userId);
        model.addAttribute("userId",":"+user);
        model.addAttribute("name",":"+myUser.getName());
        model.addAttribute("email",":"+myUser.getEmail());
        model.addAttribute("skills",":"+skills.toString());
        return "user";
    }

    @PostMapping("/user/add")
    public String addUser(@ModelAttribute("userForm")User user,
                          BindingResult result, Model model,
                          final RedirectAttributes redirectAttributes){
        userRepository.save(user);
        return "/";
    }

}
