/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
import Model.Student;
import View.viewStudent;
import common.librarySt;
import java.util.ArrayList;
import java.util.List;
public class studentMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        viewStudent view = new viewStudent();
        librarySt lib = new librarySt();
        view.displayTitle("Collection Sort Program ", '=');
        List<Student> a = new ArrayList<>();
        view.getStudent(a);
        view.displayArrList("Student ", '-', lib.sortStudent(a));       
    }
    
}
