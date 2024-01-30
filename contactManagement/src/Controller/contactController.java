package Controller;

import Model.contact;
import View.Menu;
import View.viewContact;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class contactController extends Menu {

    viewContact view;
    ArrayList<contact> conList;

    public contactController() {
        super("Contact Program", Arrays.asList(new String[]{"Add a Contact", "Display all Contact", "Delete a Contact", "Exit"}));
        view = new viewContact();
        conList = new ArrayList<>();
    }

    enum menu {
        AddAContact, DisplayAllContact, DeleteAContact, Exit, Again;
    }

    public menu convertEnim(int choice) {
        switch (choice) {
            case 1 -> {
                return menu.AddAContact;
            }
            case 2 -> {
                return menu.DisplayAllContact;
            }
            case 3 -> {
                return menu.DeleteAContact;
            }
            case 4 -> {
                return menu.Exit;
            }
            default -> {
                System.out.println("Invalid choice!");
                return menu.Again;
            }
        }
    }

    @Override
    public void execute(int choice) {
        menu m = convertEnim(choice);
        switch (m) {
            case AddAContact -> {
                view.runAddContact(conList);
            }
            case DisplayAllContact -> {
                view.runDisplay(conList);
            }
            case DeleteAContact -> {
                view.runDelete(conList);
            }
            case Exit -> {
                System.exit(0);
            }
            case Again -> {
                run();
            }
        }
    }

    public boolean addContact(List<contact> contactList, contact con) throws NullPointerException {
        if (con == null) {
            System.out.println("Contact is empty");
            return false;
        }
        contactList.add(con);
        return true;
    }

    public contact searchByID(List<contact> contactList, int keyID) throws NullPointerException {
        if (view.checkEmpty(contactList)) {
            return null;
        }
        List<contact> resContact = contactList.stream().filter((aContact) -> aContact.getContactID() == keyID).collect(Collectors.toList());
        if (!resContact.isEmpty()) {
            return resContact.get(0);
        } else {
            System.out.println("No found contact");
            return null;
        }
    }

    public boolean deleteContact(List<contact> contactList, contact con) throws NullPointerException {
        if (view.checkEmpty(contactList)) {
            return false;
        } else if (con == null) {
            return false;
        } else {
            contactList.remove(con);
            return true;
        }
    }
}
