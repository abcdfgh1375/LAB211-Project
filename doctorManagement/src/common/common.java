package common;

import Utils.InputterDoctor;
import Utils.validationDoctor;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import model.doctor;

public class common {

    public static final String INPUT = "doctor.txt";
    private AtomicInteger code = new AtomicInteger(0);
    private final InputterDoctor input = new InputterDoctor();
    private final validationDoctor valid = new validationDoctor();
    private final library lib = new library();

    public doctor inputDoctor() {
        doctor doc = new doctor();
        String cod;
        int count;
//        doc.setDocCode(input.getStringFromInput("Enter Code: "));
        do {
            cod = automaticCode();
        } while (lib.getDoctorList().containsKey(cod));
        doc.setDocCode(cod);
        doc.setDocName(input.getAlphabelticStringFromInput("Enter Name: "));
        doc.setDocSpecialization(input.getAlphabelticStringFromInput("Enter Specialization: "));
        doc.setDocAvailability(inputDoctorAvail("Availability"));
        return doc;
    }

    public String inputDoctorCode() {
        return input.getStringFromInput("Enter Code: ");
    }

    public int inputDoctorAvail(String msg) {
        Scanner sc = new Scanner(System.in);
        boolean res = false;
        int avail = 0;
        do {
            System.out.print(String.format("Enter %s: ", msg));
            try {
                avail = sc.nextInt();
                res = valid.checkAvailability(avail);
                if (!res) {
                    System.err.println(msg + " must be >= 0");
                }
            } catch (InputMismatchException e) {
                System.err.println("Please input the integer number >= 0 ");
                sc.next();
            }
        } while (!res);
        return avail;
    }

    public int inputChoiceSearchField() {
        String[] fields = {"Code", "Name", "Specialization", "Availability"};
        int choice = input.inputChoiceHasLimit(Arrays.asList(fields), 1, 4);
        return choice;
    }

    public String inputStringSearch() {
        return input.getStringFromInput("Enter text: ");
    }

    public String automaticCode() {
        return "DOC " + code.incrementAndGet();
    }
}
