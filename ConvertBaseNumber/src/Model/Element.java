
package Model;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Logger;

public class Element {
    String inputStr;

    public Element() {
    }

    public String getInputStr() {
        return inputStr;
    }

    public void setInputStr(String inputStr) {
        this.inputStr = inputStr;
    }

    public Element(String inputStr) {
        this.inputStr = inputStr;
    }

    @Override
    public String toString() {
        return "Element{" + "inputStr=" + inputStr + '}';
    }
    
    public String inputPattern(String msg, String pattern) {
        Scanner sc = new Scanner(System.in);
        String data;
        do {
            System.out.println(msg);
            data = sc.nextLine();
        } while (!data.matches(pattern));
        return data;
    }
    
       public int inputPositiveInt(String msg) {
        Scanner sc = new Scanner(System.in);
        int number;
        while (true) {
            System.out.print(String.format("%s: ", msg));
            try {
                number = sc.nextInt();
                if (number > 0) {
                    return number;
                } else {
                    System.err.println("Please enter the integer number > 0 ");
                }
            } catch (InputMismatchException e) {//exception về datatype của đầu vào
                System.err.println("Just input the integer number ");
                sc.next();
            }
        }
    }


}
