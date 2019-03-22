package AFK.demo;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class Members {
    @EmbeddedId
    MemberIdentity id;
    Members(){}
    public Members(User u,Project p){
        id= new MemberIdentity(u,p);
    }
}
