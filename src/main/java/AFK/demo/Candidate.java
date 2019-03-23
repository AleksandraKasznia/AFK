package AFK.demo;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class Candidate {
    @EmbeddedId
    private CandidateKey candidateKey;

    @Override
    public String toString() {
        return candidateKey.getUsername();
    }
}
