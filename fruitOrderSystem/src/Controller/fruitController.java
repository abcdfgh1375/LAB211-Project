package Controller;

import Model.*;
import Utils.Inputter;
import View.Menu;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import View.viewFruit;

public class fruitController extends Menu {

    ArrayList<Fruit> fruitList;
    Hashtable<String, ArrayList> hashOrder;
    viewFruit v = new viewFruit();

    public fruitController() {
        super("\nFruit Order Management", Arrays.asList(new String[]{"Create Fruit", "View Order", "Shopping (for buyer)", "Exit"}));
        fruitList = new ArrayList<>();
        hashOrder = new Hashtable<>();
    }

    @Override
    public void execute(int choice) {
        switch (choice) {
            case 1:
                loadFromFile();
                v.displayFruit(fruitList);
                if (v.isContinue("Do you want to continue create fruit?(Y/N)")) {
                    fruitList = v.createFruit(fruitList);
                    v.displayFruit(fruitList);
                }
                break;
            case 2:
                v.displayOrder(hashOrder);
                break;
            case 3:
                hashOrder = v.addOrderHash(fruitList, hashOrder);
                break;
            default:
                System.exit(0);
        }
    }

    String fileName = "fruit.txt";

    public void loadFromFile() throws NumberFormatException {
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String line;
            if ((line = br.readLine()) == null) {
                System.out.println("File is empty");
                return;
            }
            String[] linear = line.split("\\|");
            fruitList.add(new Fruit(v.autoCreateIdReturnInt(),
                    linear[0], Integer.parseInt(linear[1]), linear[2], Integer.parseInt(linear[3])));
            while ((line = br.readLine()) != null) {
                String[] linearr = line.split("\\|");
                try {
                    fruitList.add(new Fruit(v.autoCreateIdReturnInt(),
                            linearr[0], Integer.parseInt(linearr[1]), linearr[2], Integer.parseInt(linearr[3])));
                    //id|name|quan|origin|price 
                } catch (NumberFormatException e) {
                    System.out.println("Error parsing integer at line: " + line);
                }
            }
            br.close();
        } catch (FileNotFoundException nfe) {
            System.out.println("File not found " + fileName);
        } catch (IOException ex) {
            System.out.println("An error occurred while reading the file");
        }
    }

}
