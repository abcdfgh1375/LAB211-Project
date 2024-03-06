package View;

import Model.Fruit;
import Model.Order;
import Utils.Inputter;
import java.util.ArrayList;
import java.util.Hashtable;

/**
 *
 * @author THANH HUYEN
 */
public class viewFruit {

    private int counter = 1;

    public Fruit createFruit() {
        Inputter in = new Inputter();
        Fruit fruit = new Fruit();
        do {
            autoCreateID(fruit);
            fruit.setFruitName(in.inputPattern("Enter fruit name: ", "[a-zA-Z\s]+"));
            fruit.setPrice(in.inputPositiveInt("Enter fruit price"));
            fruit.setFruitQuan(in.inputPositiveInt("Enter fruit quantity"));
            fruit.setOrigin(in.inputPattern("Enter fruit origin: ", "[a-zA-Z\s]+"));
//            fruitList.add(fruit);
        } while (isContinue("Do you want to continue? Y/N"));
        return fruit;
    }

    public ArrayList<Fruit> createFruit(ArrayList<Fruit> fruitList) {
        do {
            fruitList.add(createFruit());
        } while (isContinue("Do you want to continue? Y/N"));
        return fruitList;
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

    public Hashtable<String, ArrayList> addOrderHash( ArrayList<Fruit> fruitList, Hashtable<String, ArrayList> hashOrder) {
        ArrayList<Order> orderList = createOrder(fruitList,hashOrder);
        Inputter in = new Inputter();
        String name = in.inputPattern("Enter buyer name: ", "[a-zA-Z\s]+");
        for (Order o : orderList) {
            o.setBuyerName(name);
        }
        hashOrder.put(name, orderList);
        return hashOrder;
    }

    public ArrayList<Order> createOrder( ArrayList<Fruit> fruitList, Hashtable<String, ArrayList> hashOrder) {
        ArrayList<Order> orderList = new ArrayList();
        Order order;
        Inputter in = new Inputter();
        boolean avail = true;
        do {
            if (fruitList.isEmpty()) {
                System.out.println("No fruit to choose!");
                return null;
            }
            order = new Order();
            orderList = new ArrayList<>();
            displayFruit(fruitList);
            int choice = getChoiceOrder(fruitList);
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
                return null;
            }
            order.setAmount(order.getPrice() * order.getBuyerQuan());

            if (isContinue("Do you want to order now (Y/N)")) {
                displaySingleOrder(order);
                orderList.add(order);
            }

        } while (isContinue("Do you want to continue? Y/N"));
        return orderList;
    }

    public boolean isContinue(String msg) {
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

    public int getChoiceOrder(ArrayList<Fruit> fruitList) {
        Inputter in = new Inputter();
        int choice;
        do {
            choice = in.inputPositiveInt("Enter selection from 1 to " + fruitList.size());
        } while (choice > fruitList.size());
        return choice;
    }

    public void displaySingleOrder(Order o) {
        System.out.println("Product | Quantity | Price | Amount");
        System.out.println(String.format("%-14s%-8s%s$%8s$", o.getFruitName(), o.getBuyerQuan(), o.getPrice(), o.getAmount()));
        System.out.println("Total: " + o.getAmount() + "$");
    }

    public void displayFruit(ArrayList<Fruit> fruitList) {
        try {
            if (fruitList.isEmpty()) {
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

    public void displayOrder(Hashtable<String, ArrayList> hashOrder) {
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
