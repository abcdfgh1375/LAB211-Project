/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class inputterPerson {
    
    private static final String DATE_FORMAT = "dd/MM/yyyy";
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);

    public double getDoubleFromInput(String msg) {
        Scanner sc = new Scanner(System.in);
        double number;
        while (true) {
            System.out.print(String.format("%s", msg));
            try {
                number = sc.nextDouble();
                if (number > 0) {
                    return number;
                } else {
                    System.err.println("Please enter the double number > 0 ");
                }
            } catch (InputMismatchException e) {
                System.err.println("Just input the double number > 0 ");
                sc.next();
            }
        }
    }

    public double getDouble(String msg, String msg2) {
        Scanner sc = new Scanner(System.in);
        double number;
        while (true) {
            System.out.print(String.format("%s", msg));
            try {
                number = sc.nextDouble();
                if (number > 0) {
                    return number;
                } else {
                    System.err.println("Please enter the double number > 0 ");
                }
            } catch (InputMismatchException | NumberFormatException e) {
                System.err.println(msg2);
                sc.next();
            }
        }
    }

    public float getFloatFromInput(String msg, float min) {
        Scanner sc = new Scanner(System.in);
        float number;
        while (true) {
            System.out.print(String.format("%s", msg));
            try {
                number = sc.nextFloat();
                if (number > min) {
                    return number;
                } else {
                    System.err.println("Please enter the float number > " + min);
                }
            } catch (InputMismatchException e) {
                System.err.println("Just input the float number > 0 ");
                sc.next();
            }
        }
    }

    public int getIntFromInput(String msg) {
        Scanner sc = new Scanner(System.in);
        boolean b = true;
        int num = 0;
        do {
            System.out.print(String.format("%s", msg));
            try {
                num = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.err.println("Input a integer number! ");
                b = false;
                sc.next();
            }
        } while (!b);
        return num;
    }

//    public Date getDateFromInput(String msg) {
//        Scanner sc = new Scanner(System.in);
//        while (true) {
//            System.out.print(String.format("%s", msg));
//            String dateString = sc.nextLine();
//            if (!dateString.isEmpty()) {
//                try {
//                    Date date = dateFormat.parse(dateString);
//                    return date;
//                } catch (ParseException e) {
//                    System.err.println(String.format("Invalid date format. Please enter again (%s).", DATE_FORMAT));
//                }
//            }
//        }
//    }
    public Date getFormattedDateFromInput(String msg) {
        SimpleDateFormat dateFormatPattern = new SimpleDateFormat("dd/MM/yyyy");
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print(String.format("%s", msg));
            String dateString = sc.nextLine();
            boolean check = true;
            do {
                try {
                    java.util.Date utilDate = dateFormatPattern.parse(dateString);
                    java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
                    return sqlDate;
                } catch (ParseException e) {
                    System.out.println("Format of date is not valid!");
                    check = false;
                }
            }while(!check);
        }
    }

    public String getStringFromInput(String msg) {
        Scanner sc = new Scanner(System.in);
        String s = null;
        while (s == null || s.isEmpty()) {
            System.out.print(String.format("%s", msg));
            s = sc.nextLine();
        }
        return s;
    }

    public char getCharFromInput(String msg) {
        Scanner sc = new Scanner(System.in);
        char c = '\0';  // Default value
        boolean isValidInput = false;

        while (!isValidInput) {
            System.out.print(String.format("%s", msg));
            String input = sc.nextLine().trim();

            if (input.length() == 1) {
                c = input.charAt(0);
                isValidInput = true;
            } else {
                System.out.println("Please enter a single character.");
            }
        }

        return c;
    }

    public String getAlphabelticStringFromInput(String msg) {
        Scanner sc = new Scanner(System.in);
        String data;
        do {
            System.out.print(msg);
            data = sc.nextLine();
        } while (!data.matches("[a-zA-Z\\s]{0,30}+$"));
        return data;
    }

    public String inputPattern(String msg, String pattern) {
        Scanner sc = new Scanner(System.in);
        String data;
        do {
            System.out.print(msg);
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
                if (number > 0 && number < 10000) {
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

    public int inputChoiceHasLimit(List<String> msg, int min, int max) {
        Scanner sc = new Scanner(System.in);
        int number;
        while (true) {
            for (int i = 0; i < msg.size(); i++) {
                System.out.println((i + 1) + ". " + msg.get(i));
            }
            try {
                number = sc.nextInt();
                if (number >= min && number <= max) {
                    return number;
                } else {
                    System.err.println("Please enter the integer number from " + min + " to " + max);
                }
            } catch (InputMismatchException e) {//exception về datatype của đầu vào
                System.err.println("Just input the integer number ");
                sc.next();
            }
        }
    }

    public int getIDFromInput(String msg) {
        Scanner sc = new Scanner(System.in);
        int number;
        while (true) {
            System.out.print(String.format("%s", msg));
            try {
                number = sc.nextInt();
                if (number >= 0) {
                    return number;
                } else {
                    System.err.println("Please enter the integer number > 0 ");
                }
            } catch (InputMismatchException e) {
                System.err.println("ID is digit ");
                sc.next();
            }
        }
    }
}
