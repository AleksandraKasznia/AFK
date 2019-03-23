package AFK.demo;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity // This tells Hibernate to make a table out of this class
public class User {
    @Id
    @NotNull
    private String username;

    private String password;

    private String name;

    private String email;

    @OneToMany(mappedBy = "skillId.userId", fetch = FetchType.LAZY, orphanRemoval = false)
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


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
