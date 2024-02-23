/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Model.Person;
import common.library;
import java.util.List;
import java.util.stream.Stream;

/**
 *
 * @author THANH HUYEN
 */
public class viewFile {
    library lib = new library();
    
    public void displayFC1(List<Person> stfPersonList) throws Exception {
        try{
        if(stfPersonList.isEmpty()){
            System.out.println("List at displayFT1 is null");
            throw new NullPointerException();
        }
        displayArrList("Result", '-', stfPersonList);
        displayMinMax(lib.getMaxMinPerson(stfPersonList, "Max"), "Max");
        displayMinMax(lib.getMaxMinPerson(stfPersonList, "Min"), "Min");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        }

    public void displayMinMax(Person a, String msg) {
        System.out.println(msg +": "+ a.getName());
    }

    public void displayTitle(String msg, char c) {
        Stream.generate(() -> c).limit(5).forEach(System.out::print);
        System.out.print(" " + msg + " ");
        Stream.generate(() -> c).limit(5).forEach(System.out::print);
        System.out.println();
    }

    public void displayArrList(String msg, char c, List<Person> l) {
        displayTitle(msg, c);
        System.out.println(String.format("%-10s%-16s%s", "Name", "Address",
                "Money"));
        for (Person s : l) {
            System.out.println(s.toString());
        }
    }
}
