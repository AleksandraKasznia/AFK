package AFK.demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private MembersRepository memberRepository;
    @Autowired
    private ProjectRepository projectRepository;


    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        User u = new User();
        u.setId(name);
        u.setEmail("mail");
        u.setName(name);
        userRepository.save(u);

        Project p = new Project();
        p.id="ABD";
        p.owner=u;
        projectRepository.save(p);

        Members m = new Members(u,p);
        memberRepository.save(m);
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