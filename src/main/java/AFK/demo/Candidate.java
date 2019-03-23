package AFK.demo;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class Candidate {
    @EmbeddedId
    private CandidateKey candidateKey;

    public void CreateCandidate(String username, String projectId){
        candidateKey = new CandidateKey(username, projectId);
    }

    @Override
    public String toString() {
        return candidateKey.getUsername();
    }
}
