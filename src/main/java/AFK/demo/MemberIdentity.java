package AFK.demo;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.io.Serializable;

@Embeddable
public class MemberIdentity implements Serializable {
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "user.username")
    private User member;

    @OneToMany(fetch = FetchType.LAZY)
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
        return member.hashCode()*31+project.hashCode();
    }
}
