package AFK.demo;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Skill {

    @EmbeddedId
    private SkillKey skillId;
    @NotNull
    private int level;

}
