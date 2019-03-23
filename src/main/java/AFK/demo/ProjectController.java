package AFK.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ProjectController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private GlobalSkillRepository skillRepository;
    @Autowired
    private MembersRepository memberRepository;
    @Autowired
    private ProjectRepository projectRepository;
    @Autowired
    protected ProjectSkillRepository projectSkillRepository;

    @GetMapping("/project/{id}")
    public String searchProject(@CookieValue(name="login" , defaultValue = "kazar") String login,@PathVariable(name="id",required=true) String id, Model model) {
        model.addAttribute("id", id);
        model.addAttribute("project", projectRepository.findById(id).get());

        List<User> members = userRepository.findAllByProject(id);
        model.addAttribute("members",members);
        model.addAttribute("owner",projectRepository.findById(id).get().owner);
        return "project-view";
    }

    @GetMapping("/profile/{user}/addProject")
    public String addProject(@CookieValue(name="login" , defaultValue = "kazar") String login,Model model, @PathVariable(name="user",required=true) String user){
        Project project = new Project();
        User owner = userRepository.findById(user).get();
        project.owner=owner;
        model.addAttribute("project",project);
//        initModelList(model);
        return "/addProject";
    }
    @PostMapping("/addProject")
    public String addProject(@ModelAttribute("/addProject") Project project,
                             BindingResult result, Model model,
                             final RedirectAttributes redirectAttributes){
        model.addAttribute("project",project);
        projectRepository.save(project);
        return "redirect:/project/"+project.id;
    }


    @GetMapping("/addSkills/{project}")
    public String addSkills(@CookieValue(name="login" , defaultValue = "kazar") String login,Model model, @PathVariable String project){
        List<GlobalSkill> skillsList = new ArrayList<GlobalSkill>();
        for(GlobalSkill skill:skillRepository.findAll()){
            skillsList.add(skill);
        }
        System.out.println("skillsList = " + skillsList);
        model.addAttribute("skills", skillsList);
        model.addAttribute("project",project);

        SkillArray skillArray = new SkillArray();
        skillArray.skillid = new GlobalSkill[skillsList.size()];
        model.addAttribute("skillarray",skillArray);
        return "addSkills";
    }

    @PostMapping("/addSkills/{project}")
    public String addSkills(@ModelAttribute("/addSkills") SkillArray skillArray,
                            BindingResult result, Model model,
                            final RedirectAttributes redirectAttributes, @PathVariable String project){
        model.addAttribute("skillarray",skillArray);
        model.addAttribute("project",project);
        Project p  = projectRepository.findById(project).get();
        projectSkillRepository.deleteByProject(p.getId());
        for(GlobalSkill s:skillArray.skillid)
            projectSkillRepository.save(new ProjectSkill(p,s));


        return "redirect:/project/"+project;
    }

}
