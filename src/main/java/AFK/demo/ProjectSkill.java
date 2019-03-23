package AFK.demo;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class ProjectSkill {

    @EmbeddedId
    private ProjectSkillKey ProjectSkillId;
    @NotNull
    private int requiredLevel;

    public ProjectSkill(){}

    public ProjectSkill(Project p, GlobalSkill s) {
        ProjectSkillId=new ProjectSkillKey(s.getSkillId(),p.getId());
        requiredLevel=0;
    }
}
