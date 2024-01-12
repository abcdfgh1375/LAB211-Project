package View;

import Utils.InputterCandidate;
import Model.Experience;
import Model.Fresher;
import Model.Intern;
import java.util.Arrays;
import java.util.List;

public class ViewAllCandidate extends ViewCandidate {

    public void createExperienceCandidate(Experience can ) {
        InputterCandidate input = new InputterCandidate();
        super.createCandidate(can);
        try {
            can.setExpInYear(Integer.parseInt(input.inputPattern("Enter candidate's experience:", "^(?:100|[1-9]\\d?|0)$")));
        } catch (NumberFormatException e) {
            System.err.println("Invalid input for experience. Please enter a valid number.");
        }
        can.setProSkill(input.inputPattern("Enter candidate's professional skill:", "[a-zA-Z\s]+"));
    }
    
     public void createFresherCandidate(Fresher can ) {
        InputterCandidate input = new InputterCandidate();
        super.createCandidate(can);
        can.setGraduationDate(input.getDateFromInputt("Enter graduation day"));
        can.setEducation(input.inputPattern("Enter candidate's university:", "[a-zA-Z\s]+"));
        runChooseGraduationRankMenu(can);
    }
   public void createInternCandidate(Intern can ) {
        InputterCandidate input = new InputterCandidate();
        super.createCandidate(can);
        can.setMajor(input.inputPattern("Enter candidate's major:", "[a-zA-Z\s]+"));
        can.setSemester(input.inputPositiveInt("Enter candidate's semester"));
        can.setUniName(input.inputPattern("Enter candidate's university name:", "[a-zA-Z\s]+"));
    }

   //---------------choose education rank--------------------------------
    
        public void displayGraduationRank() {
        String title = "Choose graduation rank";
        List<String> list = Arrays.asList(new String[]{"Excellence","Good","Fair","Poor"});
       
        System.out.println(title);
        for (int i = 0; i < list.size(); i++) {
            System.out.println((i+1)+ ". " + list.get(i));
        }
    }
        
    public void runChooseGraduationRankMenu(Fresher fresher) {
        displayGraduationRank();
        fresher.setGraduationRank(chooseGraduationRank(getChoice()));
    }    

    private String chooseGraduationRank(int choice) {
        switch (choice){
          case 1:
                return "Excellence";
          case 2:
                return "Good";
            case 3:
                return "Fair";
            case 4:
                return "Poor";    
            default:
                System.err.println("Invalid choice. Exiting.");
                return null;
        }
    }
    
}
