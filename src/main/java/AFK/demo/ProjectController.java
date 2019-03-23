package AFK.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
public class ProjectController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private MembersRepository memberRepository;
    @Autowired
    private ProjectRepository projectRepository;

    @GetMapping("/project")
    public String searchProject(@RequestParam(name="id") String id, Model model) {
        model.addAttribute("id", id);
        String project="";
        for (User u:userRepository.findAll()) {
            System.out.println("u = " + u);
            project+=u.getName()+"<br>";
        }
        model.addAttribute("project",":"+project);
        return "project";
    }
}
