package AFK.demo;
import javax.persistence.*;

@Entity
public class GlobalSkill {
    @Id
    private String skillId;

    private String description;

    @Override
    public String toString() {
        return skillId;
    }

    public String getSkillId() {
        return skillId;
    }

    public void setSkillId(String skillId) {
        this.skillId = skillId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
