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

    @GetMapping("/addProject")
    public String addProject(Model model){
        Project project = new Project();
        model.addAttribute("project",project);
        return "addProject";
    }
    @PostMapping("/addProject")
    public String addProject(@ModelAttribute("/addProject")Project project,
                          BindingResult result, Model model,
                          final RedirectAttributes redirectAttributes){
        projectRepository.save(project);
        return "/project/"+project.id;
    }
}
