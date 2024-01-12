
package Controller;

import Model.Candidate;
import java.util.ArrayList;

public class CandidateController{  
    
    public<T extends Candidate> void addCandidate(ArrayList<T> candidateList,T c){
        candidateList.add(c);
    }
    public <T extends Candidate> ArrayList<T> searchCandidates(ArrayList<T> can, String name) throws NullPointerException {
        ArrayList<T> foundCandidates = new ArrayList<>();
        for (T c : can) {
            if (c.getFirstName().equalsIgnoreCase(name) || c.getLastName().equalsIgnoreCase(name)) {
                 foundCandidates.add(c);
            }
        }
        if(foundCandidates.isEmpty()){
        System.out.println("There is no candidate with name: " + name + " in the candidate list");
        }
        return foundCandidates;
    }
}