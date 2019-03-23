package AFK.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
}
