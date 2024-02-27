/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Model.Student;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;
import common.inputterStudent;

/**
 *
 * @author THANH HUYEN
 */
public class viewStudent {

    inputterStudent in = new inputterStudent();

    //INPUT
    public List<Student> getStudent(List<Student> a) {
        do {
            System.out.println("Please input student information");
            String name = in.getAlphabelticStringFromInput("Name: ");
            String className = in.getStringFromInput("Classes: ");
            float mark = in.getFloatFromInput("Mark: ", 0);
            a.add(new Student(name, className, mark));
        } while (getContinue("Do you want to enter more student information?(Y/N):"));
        return a;
    }

    public boolean getContinue(String msg) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print(msg);
            String s = sc.nextLine();
            if (s.equalsIgnoreCase("Y")) {
                return true;
            } else if (s.equalsIgnoreCase("N")) {
                return false;
            }
            System.err.println("Please just input Y/N !");
        }
    }

    //DISPLAY
    public void displayTitle(String msg, char c) {
        Stream.generate(() -> c).limit(5).forEach(System.out::print);
        System.out.print(" " + msg + " ");
        Stream.generate(() -> c).limit(5).forEach(System.out::print);
        System.out.println();
    }

    public void displayArrList(String msg, char c, List<Student> l) {
        int i = 1;
        for (Student s : l) {
                displayTitle(msg + i++, c);
                System.out.println(s.toString());            
        }
    }
}
