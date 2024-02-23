/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import Model.Person;
import View.*;
import java.util.Arrays;
public class fileController extends Menu{
       private final Person person;
    private final viewFile view;
    public fileController() {
        super("File Management", Arrays.asList(new String[]{"Find person infor",
            "Copy Text to new file", "Exit"}));
        this.view = new viewFile();
        this.person = new Person();
    }

    enum choices {
        Get, Copy, Exit;
    }

    public choices convertEnum(int c) {
        switch (c) {
            case 1 -> {
                return choices.Get;
            }
            case 2 -> {
                return choices.Copy;
            }
            case 3 -> {
                return choices.Exit;
            }
            default -> {
                System.out.println("Invalid choice");
                run();
            }
        }
        return null;
    }

    @Override
    public void execute(int choice) {
        choices ch = convertEnum(choice);
        switch (ch) {
            case Get -> {
                try {
                    person.getPerson();
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            }
            case Copy -> {
                try {
                    person.copy();
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            }
            case Exit -> {
                System.exit(0);
            }
        }

    }
}
