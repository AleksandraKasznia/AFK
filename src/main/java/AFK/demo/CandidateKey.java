package AFK.demo;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class CandidateKey implements Serializable{
    @Column(name = "username")
    private String username;

    @Column(name = "project")
    private String id;

    public CandidateKey() { }

    public CandidateKey(String username, String projectId) {
        this.username = username;
        this.id = projectId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getProjectId() {
        return id;
    }

    public void setProjectId(String id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CandidateKey)) return false;
        CandidateKey that = (CandidateKey) o;
        return Objects.equals(getUsername(), that.getUsername()) &&
                Objects.equals(getProjectId(), that.getProjectId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUsername(), getProjectId());
    }
}
