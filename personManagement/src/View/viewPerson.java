/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Model.Person;
import common.validPerson;
import java.util.List;
import java.util.stream.Stream;

public class viewPerson {

    validPerson v = new validPerson();
    inputterPerson input = new inputterPerson();

    public void inputPersonToArray(Person[] a) throws Exception {
        for (int i = 0; i < a.length; i++) {
            System.out.println("Input Information of Person");
            String name = input.getAlphabelticStringFromInput("Please input name: ");
            String address = input.getAlphabelticStringFromInput("Please input address: ");
            String sSalary = input.getStringFromInput("Please input salary: ");
            a[i] = inputPersonInfo(name, address, sSalary);
        }
        System.out.println();
    }

    Person inputPersonInfo(String name, String address, String sSalary) throws Exception {
        while (!v.checkValidSalary(sSalary)) {
            sSalary = input.getStringFromInput("Please input salary: ");
        }
        return new Person(name, address, Double.parseDouble(sSalary));
    }

    void displayPersonInfo(Person person) {
        System.out.println("Information of Person you have entered:");
        System.out.println(person.toString());
    }

    public void displayTitle(String msg, char c) {
        Stream.generate(() -> c).limit(5).forEach(System.out::print);
        System.out.print(" " + msg + " ");
        Stream.generate(() -> c).limit(5).forEach(System.out::print);
        System.out.println();
    }

    public void displayArr( Person[] l) {
        for (Person s : l) {
            displayPersonInfo(s);
        }
    }

}
