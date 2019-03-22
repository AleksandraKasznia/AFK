package AFK.demo;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class ProjectSkill {

    @EmbeddedId
    private ProjectSkillKey ProjectSkillId;
    @NotNull
    private int requiredLevel;

}
