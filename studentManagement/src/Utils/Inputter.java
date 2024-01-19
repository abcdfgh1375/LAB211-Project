
package Utils;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Inputter {

    public Scanner sc;

    public Inputter() {
        sc = new Scanner(System.in);
    }

    public int getIntFromInput(String msg) {
        Scanner sc = new Scanner(System.in);
        int number;
        while (true) {
            System.out.print(String.format("%s: ", msg));
            try {
                number = sc.nextInt();
                if (number >= 1 && number <= 10) {
                    return number;
                } else {
                    System.err.println("Please enter the semester around 1 to 10: ");
                }
            } catch (InputMismatchException e) {
                System.err.println("Just enter the semester >= 1 and <= 10 ");
                sc.next();
            }
        }
    }

    public String getStringFromInput(String msg) {
        Scanner sc = new Scanner(System.in);
        String s = null;
        while (s == null || s.isEmpty()) {
            System.out.print(String.format("%s: ", msg));
            s = sc.nextLine();
        }
        return s;
    }


    public String inputStringAlphabet(String msg) {
        Scanner sc = new Scanner(System.in);
        String data;
        do {
            System.out.print(msg);
            data = sc.nextLine();
        } while (!data.matches("[a-zA-Z]+")); 

        return data;
    }
    
        public String inputPatternn(String msg, String regex) {
        Scanner sc = new Scanner(System.in);
        String data;
        do {
            System.out.print(msg);
            data = sc.nextLine();
        } while (!data.matches(regex)); 

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

    public int getInt(String promt, int m, int n) {
        int a = -1;
        while (true) {
            System.out.print(promt + ": ");
            try {
                String s = sc.nextLine();
                a = Integer.parseInt(s);
                if (a >= m && a <= n) {
                    break;
                }
            } catch (Exception e) {
                System.out.println("Enter a number from " + m + " to " + n);
            }
        }
        return a;
    }

    public char getYN(String msg) {
        char result = 0;
        boolean isValid = false;

        do {
            System.out.print(msg);
            String input = sc.nextLine();
            if (input.length() == 1 && Character.isLetter(input.charAt(0))) {
                result = Character.toUpperCase(input.charAt(0));
                isValid = true;
            } else {
                System.err.println("Please enter a single alphabetical character.");
            }
        } while (!isValid);
        return result;

    }

}
