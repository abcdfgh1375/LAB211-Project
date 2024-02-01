package Controller;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import view.Menu;
import model.doctor;

public class doctorManagement extends Menu {
    private doctor doctor;
    public doctorManagement() {
        super("Doctor Management", Arrays.asList(new String[]{"Add Doctor", "Update Doctor", "Delete Doctor", "Search Doctor", "Exit"}));
        doctor = new doctor();
    }

    enum choices {
        Add, Update, Delete, Find, Exit;
    }

    public choices convertEnum(int c) {
        switch (c) {
            case 1 -> {
                return choices.Add;
            }
            case 2 -> {
                return choices.Update;
            }
            case 3 -> {
                return choices.Delete;
            }
            case 4 -> {
                return choices.Find;
            }
            case 5 ->{
                return choices.Exit;
            }
            default ->{
                System.out.println("Invalid choice");
                run();
            }
        }
        return null;
    }

    @Override
    public void execute(int choice){
        choices ch = convertEnum(choice);
        switch (ch) {
            case Add ->{try {
                doctor.addDoctor();
                doctor.displayDoctor();
            } catch (Exception ex) {
                Logger.getLogger(doctorManagement.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
            case Update ->{try {
                doctor.updateDoctor();
                doctor.displayDoctor();
            } catch (Exception ex) {
                Logger.getLogger(doctorManagement.class.getName()).log(Level.SEVERE, null, ex);
            }
}
            case Delete ->{try {
                doctor.deleteDoctor();
                doctor.displayDoctor();
            } catch (Exception ex) {
                Logger.getLogger(doctorManagement.class.getName()).log(Level.SEVERE, null, ex);
            }
}
            case Find ->{try {
                doctor.searchDoctor();
            } catch (Exception ex) {
                Logger.getLogger(doctorManagement.class.getName()).log(Level.SEVERE, null, ex);
            }
}
            case Exit ->{
                System.exit(0);
            }
        }

    }
}
