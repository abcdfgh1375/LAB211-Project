package View;

import Utils.InputterGeo;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public abstract class Menu {

    private String title;
    private List<String> list;

    public Menu(String title, List<String> list) {
        this.title = title;
        this.list = list;
    }

    public void display() {
        System.out.println(String.format("%35s", this.title));
        Stream.generate(() -> "=").limit(70).forEach(System.out::print);
        System.out.println();
        for (int i = 0; i < list.size(); i++) {
            System.out.println((i + 1) + ". " + list.get(i));
        }
        System.out.println(Stream.generate(() -> "=").limit(70).collect(Collectors.joining()));
    }

    public int getChoice() {
        InputterGeo in = new InputterGeo();
        return in.inputPositiveInt("Enter selection");
    }

    public abstract void execute(int choice);

    public void run() {
        int choice;
        do {
            display();
            choice = getChoice();
            execute(choice);
        } while (choice > 0 && choice < list.size());
    }

}
