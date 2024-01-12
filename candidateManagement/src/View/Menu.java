
package View;
import Utils.InputterCandidate;
import Model.*;
import java.util.ArrayList;
import java.util.List;

public abstract class Menu {
    String title;
    List<String> list;
    InputterCandidate inputter = new InputterCandidate();
    ViewCandidate viewList;
    CandidatesViewManagement view;
    public Menu(String title, List<String> list) {
        this.title = title;
        this.list = list;
    }
    public void display(){
        System.out.println(this.title);
        for(int i = 0; i < list.size(); i++){
            System.out.println((i+1) + ". " + list.get(i));
        }
    }
    
    public int getChoice(){
        int choice = inputter.getIntFromInput("Enter your choice");
        return choice;
    }
    
    public abstract void execute(int choice);
    public void run(){
        int choice;
        do{
            display();
        choice = getChoice();
        execute(choice);
        }while(choice > 0 && choice < list.size());
    }
   
}

