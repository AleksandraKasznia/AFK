package AFK.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class GreetingController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private MembersRepository memberRepository;
    @Autowired
    private ProjectRepository projectRepository;


    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="name", required=true, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        User u = userRepository.findById(name).get();
        List<Project> proj = projectRepository.getProjectByUser(u.getId());
        System.out.println("proj = " + proj);
        for(Project p:proj)
            System.out.println("p.id = " + p.id);
        return "greeting";
    }

    @GetMapping("/users")
    public String users(Model model){
        System.out.println("model = " + model);
        System.out.println("userRepository.findAll() = " + userRepository.findAll());
        String users="";
        for (User u:userRepository.findAll()) {
            System.out.println("u = " + u);
            users+=u.getName()+"<br>";
        }
        model.addAttribute("user",":"+users);
        return "users";
    }

}