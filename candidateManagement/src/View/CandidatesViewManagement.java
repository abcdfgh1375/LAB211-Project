
package View;
import Controller.CandidateController;
import Model.Experience;
import Model.Fresher;
import Model.Intern;
import Utils.InputterCandidate;
import java.util.*;
public class CandidatesViewManagement extends Menu{
    InputterCandidate inputter = new InputterCandidate();
    ViewCandidate viewCandidate = new ViewCandidate();
    ViewAllCandidate ViewAllCandidate = new ViewAllCandidate();
    CandidateController controller = new CandidateController();
    ArrayList<Experience> expList = new ArrayList<>();
    ArrayList<Fresher> fresherList = new ArrayList<>();
    ArrayList<Intern> internList = new ArrayList<>();
    public CandidatesViewManagement() {
       super("\nCANDIDATE MANAGEMENT SYSTEM", Arrays.asList(new String[]{"Experience","Fresher",
           "Internship","Searching","Exit"}));
    }
    
    @Override
    public void execute(int choice) {
    switch(choice){
        case 1:
            Experience exp = new Experience();
            ViewAllCandidate.createExperienceCandidate(exp);
            controller.addCandidate(expList, exp);
            viewCandidate.displayCandidatesListName(expList, "EXPERIENCE CANDIDATE");
            viewCandidate.displayCandidatesListName(fresherList, "FRESHER CANDIDATE");
            viewCandidate.displayCandidatesListName(internList, "INTERN CANDIDATE");
             System.out.println();
            break;
        case 2:
            Fresher fresher = new Fresher();
            ViewAllCandidate.createFresherCandidate(fresher);
            controller.addCandidate(fresherList, fresher);
            viewCandidate.displayCandidatesListName(expList, "EXPERIENCE CANDIDATE");
            viewCandidate.displayCandidatesListName(fresherList, "FRESHER CANDIDATE");
            viewCandidate.displayCandidatesListName(internList, "INTERN CANDIDATE");
            System.out.println();
            break;
        case 3:
            Intern intern = new Intern();
            ViewAllCandidate.createInternCandidate(intern);
            controller.addCandidate(internList, intern);
            viewCandidate.displayCandidatesListName(expList, "EXPERIENCE CANDIDATE");
            viewCandidate.displayCandidatesListName(fresherList, "FRESHER CANDIDATE");
            viewCandidate.displayCandidatesListName(internList, "INTERN CANDIDATE");
             System.out.println();
            break;
        case 4:
            String name = inputter.inputPattern("Input candidate name (First name OR Last name):", "[a-zA-Z\s]+");
            int candidateType = inputter.getIntFromInput("Input type of candidate");
        switch (candidateType) {
            case 0:
                ArrayList<Experience> foundExpCandidates = controller.searchCandidates(expList, name);
                viewCandidate.displayCandidatesList(foundExpCandidates,"FOUNDED CANDIDATE");
                break;
            case 1:
                ArrayList<Fresher> foundFresherCandidates = controller.searchCandidates(fresherList, name);
                viewCandidate.displayCandidatesList(foundFresherCandidates,"FOUNDED CANDIDATE");
                break;
            case 2:
                ArrayList<Intern> foundInternCandidates = controller.searchCandidates(internList, name);
                viewCandidate.displayCandidatesList(foundInternCandidates,"FOUNDED CANDIDATE");
                break;
            default:
                break;
        }
            break;        
        
        case 5:
            System.err.println("Exited.Bye bye!");
            break;
        default:
            System.err.println("Invalid choice!");
    }}
    
}
