package AFK.demo;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class SkillKey implements Serializable {
    @Column(name = "skillId")
    private String skillId;

    @Column(name = "userId")
    private String userId;

    public SkillKey() { }

    public SkillKey(String skillId, String skillName) {
        this.skillId = skillId;
        this.userId = skillName;
    }

    public String getSkillId() {
        return skillId;
    }

    public void setSkillId(String skillId) {
        this.skillId = skillId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SkillKey)) return false;
        SkillKey that = (SkillKey) o;
        return Objects.equals(getSkillId(), that.getSkillId()) &&
                Objects.equals(getUserId(), that.getUserId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSkillId(), getUserId());
    }
}
