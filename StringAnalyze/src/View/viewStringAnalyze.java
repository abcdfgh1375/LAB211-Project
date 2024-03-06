/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Model.StringInput;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class viewStringAnalyze<T> {

    inputterAnalyze in = new inputterAnalyze();

    public StringInput getInput() {
        StringInput str = new StringInput();
        str.setInput(in.getStringFromInput("Input String: "));
        return str;
    }

    public void displayHash(HashMap<String, T> l) {
        l.forEach((key, value) -> System.out.println(key + ": "+value));
        System.out.println();
    }

    public void displayTitle(String msg, char c) {
        Stream.generate(() -> c).limit(5).forEach(System.out::print);
        System.out.print(" " + msg + " ");
        Stream.generate(() -> c).limit(5).forEach(System.out::print);
        System.out.println();
    }
}
