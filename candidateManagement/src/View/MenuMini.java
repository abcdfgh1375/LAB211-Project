package View;

import Model.Candidate;
import Model.Experience;
import Model.Fresher;
import Model.Intern;
import Utils.InputterCandidate;
import java.util.ArrayList;

import java.util.Arrays;

public class MenuMini extends Menu {

    private int counter = 1;
    InputterCandidate inputter = new InputterCandidate();
    //menumini control
    public MenuMini() {
        super("Choose Candidate Type", Arrays.asList(new String[]{"Experience candidate", "Fresher candidate", "Intern candidate"}));
    }

    @Override
    public void display() {
        System.out.println(this.title);
        for (int i = 0; i < this.list.size(); i++) {
            System.out.println(i + ". " + this.list.get(i));
        }
    }

    public Candidate chooseCandidateId(int choice) {
        switch (choice) {
            case 0:
                Experience experience = new Experience();
                autoCreateID(experience);
                return experience;
            case 1:
                Fresher fresher = new Fresher();
                autoCreateID(fresher);
                return fresher;
            case 2:
                Intern intern = new Intern();
                autoCreateID(intern);
                return intern;
            default:
                System.err.println("Invalid choice. Exiting.");
                return null;
        }
    }

    @Override
    public void execute(int choice) {
        Candidate chooseCandidateId = chooseCandidateId(choice);
//        if (chooseCandidateId != null) {
//            System.out.println("Created Candidate: " + chooseCandidateId.toString());
//        }
    }
    
    public void runCandidateTypeMenu() {
        display();
        execute(getChoice());
    }    
    
//input object control----------------------------------------------------------------------------------
    public <T extends Candidate> void autoCreateID(T c) {
        if (c.getCandidateID() == null) {  
        String objectCandidateID = "AD" + String.format("%03d", counter);
        counter++;
        c.setCandidateID(objectCandidateID);
    }
    }

    public void createCandidate(Candidate can) {
        runCandidateTypeMenu();
        //Candidate Id(method riêng), First Name, Last Name(pattern),
//    Birth Date(input riêng), Address(Pattern), Phone(Pattern), Email(Pattern) and Candidate type.]
//    autoCreateID(can);
//    System.out.println(can.getCandidateID());
//    can.setFirstName(inputter.inputPattern("Enter candidate's first name: ", "[a-zA-Z]+"));
//    can.setLastName(inputter.inputPattern("Enter candidat's last name: ", "[a-zA-Z]+"));
        can.setBirthDay(inputter.inputBirthDay("Enter candidate's birthday"));
//    can.setAddress(inputter.inputPattern("Enter candidate's address: ", "[a-zA-Z\s]+"));
//    can.setPhone(inputter.inputPattern("Enter candidate's phone number: ", "[\\d]{10,}"));
//    can.setEmail(inputter.inputPattern("Enter candidate's email: ","[a-zA-Z0-9]+[@][a-zA-Z.]+"));
    }
    public <T extends Candidate> void displayCandidateList(ArrayList<T> c) {
        for (int i = 0; i < c.size(); i++) {
            System.out.println(c.get(i).toString());
        }
    }
}
