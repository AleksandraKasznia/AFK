package AFK.demo;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity // This tells Hibernate to make a table out of this class
@Table(name = "users", uniqueConstraints = {@UniqueConstraint(columnNames = {"username"})})
public class User {
    @Id
    @NotNull
    @Column(length=30)
    private String username;

    @NotNull
    private String password;

    private String name;

    @NotNull
    private String email;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, orphanRemoval = false)
    private List<Skill> listOfSkills = new ArrayList<>();

    public String getId() {
        return username;
    }

    public void setId(String id) {
        this.username = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
