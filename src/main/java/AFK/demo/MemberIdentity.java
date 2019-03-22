package AFK.demo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class MemberIdentity implements Serializable {
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user.username")
    private User member;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "project.id")
    private Project project;

    MemberIdentity(){

    }

    MemberIdentity(User member,Project p ){
        this.member=member;
        this.project=p;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MemberIdentity that = (MemberIdentity) o;


        return member.equals(that.member) && that.project.equals(project);
    }

    @Override
    public int hashCode() {
        return Objects.hash(project,member);
    }
}
