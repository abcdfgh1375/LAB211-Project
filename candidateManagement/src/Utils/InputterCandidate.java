package Utils;
//inputter của candidate

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class InputterCandidate {

    private final String DATE_FORMAT = "yyyy/MM/dd";
    private final SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);

    public double getDoubleFromInput(String msg) {
        Scanner sc = new Scanner(System.in);
        double number;
        while (true) {
            System.out.print(String.format("Enter %s: ", msg));
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

    public int getIntFromInput(String msg) {
        Scanner sc = new Scanner(System.in);
        int number;
        while (true) {
            System.out.print(String.format("%s: ", msg));
            try {
                number = sc.nextInt();
                if (number >= 0) {
                    return number;
                } else {
                    System.err.println("Please enter the integer number >= 0 ");
                }
            } catch (InputMismatchException e) {
                System.err.println("Just input the integer number >= 0 ");
                sc.next();
            }
        }
    }

    public Date getDateFromInput(String msg) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print(String.format("Enter %s: ", msg));
            String dateString = sc.nextLine();
            if (!dateString.isEmpty()) {
                try {
                    Date date = dateFormat.parse(dateString);
                    return date;
                } catch (ParseException e) {
                    System.err.println(String.format("Invalid date format. Please enter again (%s).", DATE_FORMAT));
                }
            }
        }
    }
    private final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");

public LocalDate inputBirthDay(String msg) {
        try (Scanner sc = new Scanner(System.in)) {
            while (true) {
                System.out.print(String.format("%s (yyyy/MM/dd): ", msg));
                String dateString = sc.nextLine();
                if (!dateString.isEmpty()) {
                    try {
                        LocalDate date = LocalDate.parse(dateString, dateFormatter);
                        int year = date.getYear();
                        int currentYear = LocalDate.now().getYear();
                        if (year >= 1990 && year <= currentYear) {
                            return date;
                        } else {
                            System.err.println("Invalid date. Please enter a valid date.");
                        }
                    } catch (Exception e) {
                        System.err.println("Invalid date format. Please enter again (yyyy/MM/dd).");
                    }
                }
            }
        }
    }

    
    public String getStringFromInput(String msg) {
        Scanner sc = new Scanner(System.in);
        String s = null;
        while (s == null || s.isEmpty()) {
            System.out.print(String.format("Enter %s: ", msg));
            s = sc.nextLine();
        }
        return s;
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
