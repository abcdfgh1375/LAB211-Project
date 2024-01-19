/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Utils.Inputter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DELL
 */
public abstract class Menu<T> {

    String title;
    ArrayList<T> choice;
    Inputter input = new Inputter();
    List<String> list;
    public Menu() {
        choice = new ArrayList<>();
    }

//    public Menu(String t, String[] c) {
//        title = t;
//        choice = new ArrayList<>();
//        for (String s : c) {
//            choice.add((T) s);
//        }
//    }
    public Menu(String title, List<String> list) {
        this.title = title;
        this.list = list;
    }

    public void display() {
        System.out.println(this.title);
//        System.out.println("---------- 🏫 Student Management 🏫 ----------");
        for (int i = 0; i < list.size(); i++) {
            System.out.println((i + 1) + ". " + list.get(i));
        }
    }

    public int getChoicec() {
        display();
        return input.getInt("Enter your choice", 1, choice.size() + 1);
    }
    public int getChoice(){
        int choice = input.getIntFromInput("Enter your choice");
        return choice;
    }

    public abstract void execute(int n);

    public void runn() {
         display();
        while (true) {
            int n = getChoice();
            execute(n);
            if (n > choice.size()) {
                break;
            }
        }
    }
       public void run(){
        int choice;
        do{
            display();
        choice = getChoice();
        execute(choice);
        }while(choice > 0 && choice < list.size());
    }
}
