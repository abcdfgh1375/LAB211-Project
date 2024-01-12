
package View;
import Utils.InputterCandidate;
import Model.Experience;

public class MenuMiniEx extends MenuMini{
    public void createExperienceCandidate(Experience can){
//        InputterCandidate input = new InputterCandidate();
//        super.createCandidate(can);
//        can.setExpInYear(Integer.parseInt(input.inputPattern("Enter candidate's experience", "[0-100]+")));
//        can.setProSkill(input.inputPattern("Enter candidate's professional skill", "[a-zA-Z\s]+"));
//    }
InputterCandidate input = new InputterCandidate();
    super.createCandidate(can);
    autoCreateID(can);  // Gọi tạo ID trong MenuMiniEx, không gọi từ MenuMini
    can.setExpInYear(Integer.parseInt(input.inputPattern("Enter candidate's experience", "[0-100]+")));
    can.setProSkill(input.inputPattern("Enter candidate's professional skill", "[a-zA-Z\s]+"));
}}
