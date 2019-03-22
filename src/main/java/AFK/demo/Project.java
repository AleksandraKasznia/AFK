package AFK.demo;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Project {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user.username")
    private User owner;

    @Id
    @NotNull
    private String id;

    private String decsription;

    private String kontakt;

    private int max_member;


}
