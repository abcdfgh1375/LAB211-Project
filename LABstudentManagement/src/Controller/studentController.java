/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Student;
import View.viewStudent;
import common.librarySt;
import java.util.ArrayList;
import java.util.List;

public class studentController {

    public void run() {
        viewStudent view = new viewStudent();
        librarySt lib = new librarySt();
        view.displayTitle("Collection Sort Program ", '=');
        List<Student> a = new ArrayList<>();
        view.getStudent(a);
        view.displayArrList("Student ", '-', lib.sortStudent(a));
    }
}
