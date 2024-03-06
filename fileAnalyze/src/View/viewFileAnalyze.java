/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Model.FilePath;
import java.util.stream.Stream;

public class viewFileAnalyze {

    inputterFileAnalyze in = new inputterFileAnalyze();

    public void inputPath(FilePath f) {
        displayTitle("Analysis Path Program", '=');
        f.setAllPath(in.getStringFromInput("Please input Path: "));
    }

    public void displayTitle(String msg, char c) {
        Stream.generate(() -> c).limit(5).forEach(System.out::print);
        System.out.print(" " + msg + " ");
        Stream.generate(() -> c).limit(5).forEach(System.out::print);
        System.out.println();
    }

    public void displayResult(FilePath f) throws Exception {
        try {
            displayTitle("Result Analysis ", '-');
            System.out.println(f.toString());
        } catch (Exception e) {
            System.out.println("Retrieving path information occured an error!");
        }
    }
}
