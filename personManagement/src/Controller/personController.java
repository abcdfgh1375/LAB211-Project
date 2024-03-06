/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import Model.Person;
import View.viewPerson;
import common.libraryPerson;
public class personController {
    viewPerson v = new viewPerson();
    libraryPerson l = new libraryPerson();
    public void run() throws Exception{
        Person[] p = new Person[3];
        v.displayTitle("Management Person programer",'=');
        v.inputPersonToArray(p);
        p = l.sortBySalary(p);
        v.displayArr(p);
    }
}
