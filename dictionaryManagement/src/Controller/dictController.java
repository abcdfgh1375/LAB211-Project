/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.dictionaryPair;
import View.Menu;
import View.viewDict;
import common.libraryDict;
import java.util.Arrays;
import java.util.HashMap;

public class dictController extends Menu {

    private dictionaryPair dict = null;
    private viewDict view;
    HashMap<String, String> dictionList = new HashMap<>();
    libraryDict lib = new libraryDict();

    public dictController() {
        super("Doctor Management", Arrays.asList(new String[]{"Add word", "Delete word", "Translate word", "Exit"}));
        this.view = new viewDict();
        this.dict = new dictionaryPair();
    }

    enum choices {
        Add, Delete, Translate, Exit;
    }

    public choices convertEnum(int c) {
        switch (c) {
            case 1 -> {
                return choices.Add;
            }
            case 2 -> {
                return choices.Delete;
            }
            case 3 -> {
                return choices.Translate;
            }
            case 4 -> {
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
            case Add -> {
                try {
                    lib.loadFromFile(dictionList, "diction.txt");
                    view.displayResultFunction(lib.addWord(dictionList,view.inputString("Enter English: ") , view.inputString("Eter Vietnamese: ")), "Add");
                    view.displayHash(dictionList, "Dictionary", '-');
                    lib.saveToFile("diction.txt", dictionList);
                } catch (Exception ex) {
                     System.out.println(ex.getMessage());
                }
            }
            case Delete -> {
                try {
                   view.displayResultFunction(lib.removeWord(dictionList, view.inputString("Enter English: ")), "Delete");
//                    view.displayHash(dictionList, "Dictionary", '-');
                    lib.saveToFile("diction.txt", dictionList);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            }
            case Translate -> {
                try {
                    view.displayTitle("Translate", '-');
                    view.displayVieMean("Vietnamese",lib.translate(dictionList, view.inputString("Enter English: ")));
//                    view.displayHash(dictionList, "Dictionary", '-');
//                    lib.saveToFile("diction.txt", dictionList);
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
