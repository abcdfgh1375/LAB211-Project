
package Controller;

import Model.Candidate;
import Model.Experience;
import View.MenuMini;
import View.MenuMiniEx;
import java.util.ArrayList;

public class CandidateController {  
    public static void main(String[] args) {
        MenuMiniEx mini = new MenuMiniEx();
        Experience c = new Experience();
        ArrayList<Experience> candidateList = new ArrayList<>();
        mini.createExperienceCandidate(c);
        
        CandidateController cc = new CandidateController();
        cc.addCandidate(candidateList,c);
        mini.displayCandidateList(candidateList);
}
    public<T extends Candidate> void addCandidate(ArrayList<T> candidateList,T c){
        candidateList.add(c);
    }
}