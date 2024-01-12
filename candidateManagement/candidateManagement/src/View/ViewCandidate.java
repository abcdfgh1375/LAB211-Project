package View;

import Model.*;
import Utils.InputterCandidate;
import java.util.ArrayList;

import java.util.Arrays;

public class ViewCandidate extends Menu {

    private int counter = 1;
    InputterCandidate inputter = new InputterCandidate();
    Candidate can = new Candidate();
    public ViewCandidate() {
        super("Choose Candidate Type", Arrays.asList(new String[]{"Experience candidate", "Fresher candidate", "Intern candidate"}));
    }
//-----------------choose candidate type-------------
    @Override
    public void display() {
        System.out.println(this.title);
        for (int i = 0; i < this.list.size(); i++) {
            System.out.println(i + ". " + this.list.get(i));
        }
    }

    public String chooseCandidateType(int choice) {
        switch (choice) {
            case 0:
                return "Experience";
            case 1:
                return "Fresher";
            case 2:
                return "Intern";
            default:
                System.err.println("Invalid choice. Exiting.");
                return null;
        }
    }

    @Override
    public void execute(int choice) {
    }

    
    public void runCandidateType(Candidate can) {
        display();
        can.setCandidateType(chooseCandidateType(getChoice()));
    }    
    
//-------------------------create candidate object-----------------------------------
    public <T extends Candidate> void autoCreateID(T c) {
        if (c.getCandidateID() == null) {  
        String objectCandidateID = "AD" + String.format("%03d", counter);
        counter++;
        c.setCandidateID(objectCandidateID);
    }
    }

    public <T extends Candidate> void createCandidate(T can) {
        runCandidateType(can);
    autoCreateID(can);
    System.out.println(can.getCandidateID());
    can.setFirstName(inputter.inputPattern("Enter candidate's first name: ", "[a-zA-Z]+"));
    can.setLastName(inputter.inputPattern("Enter candidat's last name: ", "[a-zA-Z]+"));
    can.setBirthDay(inputter.getDateFromInputt("Enter candidate's birthday"));
    can.setAddress(inputter.inputPattern("Enter candidate's address: ", "[a-zA-Z\s]+"));
    can.setPhone(inputter.inputPattern("Enter candidate's phone number: ", "[\\d]{10,}"));
    can.setEmail(inputter.inputPattern("Enter candidate's email: ","^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$"));
    }
    
//--------------------------------display candidate list------------------------------------
    public <T extends Candidate> void displayCandidatesListName(ArrayList<T> c,String msg) {
        if(c.isEmpty()){
            System.out.println("List is empty.Create first!");
        }else{
        System.out.println("================="+msg+"================");
        for (int i = 0; i < c.size(); i++) {
            System.out.println(c.get(i).getFirstName()+" "+c.get(i).getLastName());
        }}
    }
    public <T extends Candidate> void displayCandidatesList(ArrayList<T> c,String msg) {
        if(c.isEmpty()){
            System.out.println("List is empty.Create first!");
        }else{
        System.out.println("================="+msg+"================");
        for (int i = 0; i < c.size(); i++) {
            System.out.print( c.get(i).toString());
        }}
    }
}
