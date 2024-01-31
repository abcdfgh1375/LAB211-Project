package View;

import Controller.contactController;
import Model.contact;
import Utils.InputterContact;
import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class viewContact {

    int count = 0;

    public viewContact() {

    }

    //RUN
    public void runAdd(ArrayList<contact> conList) {
        contactController con = new contactController();
        displayTitle("Add a Contact", '-');
        displayResutBoolean(con.addContact(conList, inputContact()), "Add");
    }

    public void runDisplay(ArrayList<contact> conList) {
        contactController con = new contactController();
        if (checkEmpty(conList)) {
            return;
        }
        displayTitle("Display all Contact", '-');
        displayAllContact(conList);
    }

    public void runDelete(ArrayList<contact> conList) {
        contactController con = new contactController();
        if (checkEmpty(conList)) {
            return;
        }
        displayTitle("Delete a Contact", '-');
        displayResutBoolean(con.deleteContact(conList, con.searchByID(conList, getIDFromInput())), "Delete");
    }

    //INPUT   
    public void runAddContact(ArrayList<contact> contactList) {
        InputterContact input = new InputterContact();
        //switch choice cho người dùng chọn load hay input
        String[] menuAddContact = {"1. Load from file", "2. Input contact"};
        for (String str : menuAddContact) {
            System.out.println(str);
        }
        int choice = input.inputChoiceHasLimit("Select your choice: ", 1, 2);
        switch (choice) {
            case 1 ->
                loadFromFile(contactList, "contact.txt");
            case 2 -> {
                try {
                    runAdd(contactList);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }
    }

    public ArrayList<contact> loadFromFile(ArrayList<contact> contactList, String fileName) throws NumberFormatException {
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String line;
            if ((line = br.readLine()) == null) {
                System.out.println("File is empty");
                return null;
            } else {
                do {
                    System.out.println(line);
                    String[] linearr = line.split("\\|");
                    try {
                        contact a = new contact(automaticID(), linearr[0], linearr[1], linearr[2], linearr[3]);
                        a.setFirstLastName(a.getName());
                        contactList.add(a);
                    } catch (NumberFormatException e) {
                        System.out.println("Error parsing float at line: " + line);
                    }
                } while ((line = br.readLine()) != null);
            }
            br.close();
        } catch (FileNotFoundException nfe) {
            System.out.println("File not found " + fileName);
        } catch (IOException ex) {
            System.out.println("An error occurred while reading the file");
        }
        System.out.println("Load from file successfulled!");
        return contactList;
    }

    public contact inputContact() {
        InputterContact input = new InputterContact();
        contact con = new contact();
        con.setContactID(automaticID());
        con.setName(input.getAlphabelticStringFromInput("Enter Name: "));
        con.setFirstLastName(con.getName());
        con.setGroup(input.getAlphabelticStringFromInput("Enter Group: "));
        con.setAddress(input.getAlphabelticStringFromInput("Enter Address: "));
        con.setPhone(getValidPhone(input.getStringFromInput("Enter Phone: ")));
        return con;
    }

    public int automaticID() {
        return ++count;
    }

    public boolean checkValidPhone(String phone) {
        String regex = "^(\\()?\\d{3}(\\))?[-.\\s]?\\d{3}[-.\\s]?\\d{4}(\\s?(x|ext)\\d{1,5})?$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(phone);
        return matcher.matches();
    }

    public String getValidPhone(String phone) {
        InputterContact input = new InputterContact();
        if (checkValidPhone(phone)) {
            return phone;
        } else {
            displayPhoneExample();
            phone = input.getStringFromInput("Enter phone: ");
            getValidPhone(phone);
        }
        return phone;
    }

    public int getIDFromInput() {
        InputterContact input = new InputterContact();
        return input.getIDFromInput("Enter ID: ");
    }

//DISPLAY
    public void displayResutBoolean(boolean res, String msg) {
        if (res) {
            System.out.println(msg + " successfull!");
        } else {
            System.out.println(msg + " fail!");
        }
    }

    public void displayTitle(String msg, char c) {
        Stream.generate(() -> c).limit(5).forEach(System.out::print);
        System.out.print(" " + msg + " ");
        Stream.generate(() -> c).limit(5).forEach(System.out::print);
        System.out.println();
    }

    public void displayAllContact(List< contact> contactList) throws NullPointerException {
        if (contactList.isEmpty()) {
            System.out.println("List contact is empty!");
            return;
        }
        System.out.println(String.format("%-5s%-15s%-15s%-15s%-10s%-15s%s",
                "ID", "Name", "First Name", "Last Name", "Group", "Address", "Phone"));
        for (contact con : contactList) {
            System.out.println(con.toString());
        }
    }

    public void displayPhoneExample() {
        String[] ex = {"•1234567890", "•123-456-7890", "•123-456-7890 x1234", "•123-456-7890 ext1234",
            "•(123)-456-7890", "•123.456.7890", "•123 456 7890"};
        System.out.println("Please input Phone flow");
        for (String e : ex) {
            System.out.println(e);
        }
    }

    public boolean checkEmpty(List< contact> contactList) throws NullPointerException {
        if (contactList.isEmpty()) {
            System.out.println("List contact is empty!");
            return true;
        }
        return false;
    }
}
