package Controller;

import common.common;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import view.Menu;
import model.doctor;
import view.viewDoctor;

public class doctorManagement extends Menu {
    private final doctor doctor;    
    private final common common;
    private final viewDoctor view;
    public doctorManagement() {
        super("Doctor Management", Arrays.asList(new String[]{"Add Doctor", "Update Doctor", "Delete Doctor", "Search Doctor", "Exit"}));
        this.view = new viewDoctor();
        this.common = new common();
        this.doctor = new doctor();
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
                addDoctor();
                displayDoctor();
            } catch (Exception ex) {
                Logger.getLogger(doctorManagement.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
            case Update ->{try {
                updateDoctor();
                displayDoctor();
            } catch (Exception ex) {
                Logger.getLogger(doctorManagement.class.getName()).log(Level.SEVERE, null, ex);
            }
}
            case Delete ->{try {
                deleteDoctor();
                displayDoctor();
            } catch (Exception ex) {
                Logger.getLogger(doctorManagement.class.getName()).log(Level.SEVERE, null, ex);
            }
}
            case Find ->{try {
                searchDoctor();
            } catch (Exception ex) {
                Logger.getLogger(doctorManagement.class.getName()).log(Level.SEVERE, null, ex);
            }
}
            case Exit ->{
                System.exit(0);
            }
        }

    }
    
       public void addDoctor() throws Exception {
        doctor.loadDoctor();
        view.displayTitle("Add Doctor", '-');       
        view.displayResultFunction(doctor.addDoctor(), "Add");
        doctor.saveDoctor();
    }

    public void updateDoctor() throws Exception {
        view.displayTitle("Update Doctor", '-');
        view.displayResultFunction(doctor.updateDoctor(), "Update");
        doctor.saveDoctor();
    }

    public void deleteDoctor() throws Exception {
        view.displayTitle("Delete Doctor", '-');
        view.displayResultFunction(doctor.deleteDoctor(), "Delete");
        doctor.saveDoctor();
    }

    public void searchDoctor() throws Exception {
        view.displayHash(doctor.searchDoctor(), "Search Doctor", '-');
    }

    public void displayDoctor() throws Exception {
        view.displayHash(doctor.displayDoctor(), "Result", '-');
    }
}
