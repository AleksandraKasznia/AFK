package AFK.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

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

    @GetMapping("/")
    public String printUser(@CookieValue(name="login" , defaultValue = "kazar") String login, Model model) {
        model.addAttribute("login", login);
        return "index";
    }

    @GetMapping("/profile/{userId}")
    public String printUser(@CookieValue(name="login" , defaultValue = "kazar") String login, @PathVariable(name="userId") String userId, Model model) {
        model.addAttribute("userId", userId);
        String user="";
        User myUser = userRepository.findById(userId).get();
        List<Skill> skills = skillRepository.findUsersSkills(userId);
        model.addAttribute("login", login);
        model.addAttribute("userId",":"+user);
        model.addAttribute("name",":"+myUser.getName());
        model.addAttribute("email",":"+myUser.getEmail());
        model.addAttribute("skills",":"+skills.toString());
        return "profile";
    }

    @GetMapping("/addUser")
    public String addUser(Model model){
        User user = new User();
        model.addAttribute("user",user);
        return "addUser";
    }
    @PostMapping("/addUser")
    public String addUser(@ModelAttribute("/addUser")User user,
                          BindingResult result, Model model,
                          final RedirectAttributes redirectAttributes){
        user.setId(user.getId().toLowerCase());
        userRepository.save(user);
        model.addAttribute("user",user);
        return "redirect:/profile/"+user.getId().toLowerCase();
    }

}
