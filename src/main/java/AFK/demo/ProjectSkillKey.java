package AFK.demo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ProjectSkillKey implements Serializable {
    @Column(name = "skillId")
    private String skillId;

    @Column(name = "project.id")
    private String projectId;

    public ProjectSkillKey() { }

    public ProjectSkillKey(String skillId, String skillName) {
        this.skillId = skillId;
        this.projectId = skillName;
    }

    public String getSkillId() {
        return skillId;
    }

    public void setSkillId(String skillId) {
        this.skillId = skillId;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProjectSkillKey)) return false;
        ProjectSkillKey that = (ProjectSkillKey) o;
        return Objects.equals(getSkillId(), that.getSkillId()) &&
                Objects.equals(getProjectId(), that.getProjectId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSkillId(), getProjectId());
    }
}

