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

public class fruitController extends Menu {

    ArrayList<Fruit> fruitList;
    ArrayList<Order> orderList;
    Hashtable<String, ArrayList> hashOrder;
    private int counter = 1;

    public fruitController() {
        super("\nFruit Order Management", Arrays.asList(new String[]{"Create Fruit", "View Order", "Shopping (for buyer)", "Exit"}));
        fruitList = new ArrayList<>();
        orderList = new ArrayList<>();
        hashOrder = new Hashtable<>();
    }

    @Override
    public void execute(int choice) {
        switch (choice) {
            case 1:
                loadFromFile();
                displayFruit();
                if (isContinue("Do you want to continue create fruit?(Y/N)")) {
                    createFruit();
                    displayFruit();
                }
                break;
            case 2:
                displayOrder(hashOrder);
                break;
            case 3:
                createOrder();
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
            while ((line = br.readLine()) != null) {
                String[] linearr = line.split("\\|");
                try {
                    fruitList.add(new Fruit(autoCreateIdReturnInt(),
                            linearr[1], Integer.parseInt(linearr[2]), linearr[3], Integer.parseInt(linearr[4])));
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

    void createFruit() {
        Inputter in = new Inputter();
        do {
            Fruit fruit = new Fruit();
            autoCreateID(fruit);
            fruit.setFruitName(in.inputPattern("Enter fruit name: ", "[a-zA-Z\s]+"));
            fruit.setPrice(in.inputPositiveInt("Enter fruit price"));
            fruit.setFruitQuan(in.inputPositiveInt("Enter fruit quantity"));
            fruit.setOrigin(in.inputPattern("Enter fruit origin: ", "[a-zA-Z\s]+"));
            fruitList.add(fruit);
        } while (isContinue("Do you want to continue? Y/N"));
    }

    public void autoCreateID(Fruit c) {
        if (c.getFruitId() == 0) {
            int fruitID = counter;
            counter++;
            c.setFruitId(fruitID);
        }
    }

    public int autoCreateIdReturnInt() {
        Fruit c = new Fruit();
        int fruitID = 0;
        if (c.getFruitId() == 0) {
            fruitID = counter;
            counter++;
        }
        return fruitID;
    }

    void displayFruit() {
        try {
            if (this.fruitList.isEmpty()) {
                System.out.println("Fruit list is empty");
                return;
            }
            System.out.println("| ++ Item ++ | ++ Fruit Name ++ | ++ Origin ++ | ++ Price ++ |");
            for (Fruit fr : fruitList) {
                System.out.println(fr.toString());
            }
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
    }

    void createOrder() {
        Order order;
        Inputter in = new Inputter();
        boolean avail = true;
        do {
            if (fruitList.isEmpty()) {
                System.out.println("No fruit to choose!");
                return;
            }
            order = new Order();
            orderList = new ArrayList<>();
            displayFruit();
            int choice = getChoiceOrder();
            for (Fruit f : fruitList) {
                if (choice == f.getFruitId()) {
                    order.setFruitName(f.getFruitName());
                    System.out.println("Your selected: " + order.getFruitName());
                    order.setPrice(f.getPrice());
                    do {
                        order.setBuyerQuan(in.inputPositiveInt("Please input quantity"));
                        if (order.getBuyerQuan() > f.getFruitQuan()) {
                            System.out.println("There isn't enough quantity of this fruit to buy!");
                        } else {
                            break;
                        }
                        avail = isContinue("Do you still want to by this fruit? (Y/N)");
                    } while (avail);
                    break;
                }
            }
            if (!avail) {
                System.out.println("Order cancelled!");
                return;
            }
            order.setAmount(order.getPrice() * order.getBuyerQuan());
            if (isContinue("Do you want to order now (Y/N)")) {
                displaySingleOrder(order);
                order.setBuyerName(in.inputPattern("Enter buyer name: ", "[a-zA-Z\s]+"));
                orderList.add(order);
                hashOrder.put(order.getBuyerName(), orderList);
            }

        } while (isContinue("Do you want to continue? Y/N"));
    }

    public void displaySingleOrder(Order o) {
        System.out.println("Product | Quantity | Price | Amount");
        System.out.println(String.format("%-14s%-8s%s$%8s$", o.getFruitName(), o.getBuyerQuan(), o.getPrice(), o.getAmount()));
        System.out.println("Total: " + o.getAmount() + "$");
    }

    boolean isContinue(String msg) {
        Inputter in = new Inputter();
        char c = in.inputPattern(msg + "\n", "[Y/N]").charAt(0);
        switch (c) {
            case 'Y':
                return true;
            case 'N':
                return false;
        }
        return true;
    }

    public int getChoiceOrder() {
        Inputter in = new Inputter();
        int choice;
        do {
            choice = in.inputPositiveInt("Enter selection from 1 to " + fruitList.size());
        } while (choice > fruitList.size());
        return choice;
    }

    void displayOrder(Hashtable<String, ArrayList> hashOrder) {
        try {
            if (hashOrder.isEmpty()) {
                System.out.println("Order list is empty!");
                return;
            }
            for (String key : hashOrder.keySet()) {//key: ten buyer
                int sum = 0;
                ArrayList value = hashOrder.get(key);// value: mang cac mat hang cua buyer
                System.out.println("Customer:" + key);
                System.out.println("Product | Quantity | Price | Amount");
                for (int j = 0; j < value.size(); j++) {
                    System.out.println((1 + j) + "." + value.get(j).toString());
                }
                for (int k = 0; k < value.size(); k++) {
                    Order o = (Order) value.get(k);
                    sum += o.getAmount();
                }
                System.out.println("Total:" + sum + "$");
                System.out.println();
            }
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
    }
}
