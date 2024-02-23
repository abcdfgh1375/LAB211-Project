/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Model.dictionaryPair;
import common.InputterDict;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.stream.Stream;
public class viewDict {
    InputterDict input = new InputterDict();
    //INPUT
    public String inputString(String msg){
        return input.getAlphabelticStringFromInput(msg);
    }
    
    public String inputUpdateViMean(){
        String str = input.getAlphabelticStringFromInput("Enter new Vietnamese meaning: ");
        if(str.isBlank()){
            return null;
        }
        return str;
    }
    
    public boolean getContinue(String msg){        
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print(msg);
            String s = sc.nextLine();
            if (s.equalsIgnoreCase("Y")) {
                return true;
            } else if (s.equalsIgnoreCase("N")) {
                return false;
            }
            System.err.println("PLEASE INPUT Y OR N !!!");
        }
    }
    
      //display
    public void displayVieMean(String msg, String a){
        System.out.println(msg + ": " + a);
    }
    public void displayResultFunction(boolean res, String functionName) {
        if (res) {
            System.out.println(functionName + " successfull!");
        } else {
            {
                System.out.println(functionName + " fail!");
            }
        }
    }

    public void displayHash(HashMap<String, String> hash, String msg, char c) {
        if (hash.isEmpty()) {
            System.out.println("Hash is empty!");
            return;
        }
        displayTitle(msg, c);
        System.out.println(String.format("%-15s%s", "English", "Vietnamese"));
        Map<String, String> sortedHash = new TreeMap<>(hash);
        sortedHash.forEach((key, value) -> System.out.println(String.format("%-15s%s", key,value)));
    }

    public void displayTitle(String msg, char c) {
        Stream.generate(() -> c).limit(5).forEach(System.out::print);
        System.out.print(" " + msg + " ");
        Stream.generate(() -> c).limit(5).forEach(System.out::print);
        System.out.println();
    }

}
