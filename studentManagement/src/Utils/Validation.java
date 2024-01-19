/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utils;

import java.util.Scanner;

/**
 *
 * @author DELL
 */
public class Validation {
        public static String getString(String msg) {
        System.out.print(msg + " : ");
        return new Scanner(System.in).nextLine();
    }

    public static int getInt(String msg) {
        return Integer.parseInt(getString(msg));
    }

    public static boolean checkStudentName(String input) {
        String regex = "^[a-zA-Z]+$";
        return input.matches(regex);
    }
    
    public static boolean checkStudentID(String input){
        String regex = "^[a-zA-Z0-9]+$";
        return input.matches(regex);
    }
    
    public static boolean checkStudentCourse(String input){
        String regex = "^[a-zA-Z]+$";
        return input.matches(regex);
    }
    
    public static boolean checkAvailability(int input){
        return input > 0;
    }
    

    public static boolean checkValidPhoneNum(String input) {
        String regex = "^\\+?[0-9]\\d{1,10}$";
        return input.matches(regex);
    }

}
