package View;

import Model.Element;
import java.util.List;
import java.util.Scanner;

public abstract class Menu {
    private String title;
    private List<String> list;
    private Element e = new Element();
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
        return e.inputPositiveInt("Enter selection");
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
