package AFK.demo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity // This tells Hibernate to make a table out of this class
public class User {
    @Id
    @NotNull
    private String username;

    private String password;

    private String name;

    private String email;

//    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, orphanRemoval = false)
//    private List<Skill> listOfSkills = new ArrayList<>();

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
