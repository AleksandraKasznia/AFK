package AFK.demo;

import javax.persistence.*;

@Entity
public class Skill {
    @Id
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user.username")
    private User user;


}
