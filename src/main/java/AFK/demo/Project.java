package AFK.demo;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Project {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user.username")
    User owner;

    @Id
    @NotNull
    String id;

    String decsription;

    private String kontakt;

    private int max_member;


}
