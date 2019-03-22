package AFK.demo;

import javax.persistence.*;

@Entity
public class Members {
    @EmbeddedId
    MemberIdentity id;
}
