package Controller;

import Model.Data;
import View.Menu;
import java.util.*;
import java.io.IOException;

public class CountController extends Menu {
    Data data = new Data();
    String str;
    public CountController() {
        super("\nCounting Management", Arrays.asList(new String[]{"Input the string", "Count Letter","Count Character", "Exit"}));
    }

    public void countLetter(String str) throws IOException {
        StringTokenizer st = new StringTokenizer(str);
        System.out.println("Input string is: " + str);

        Map<String, Integer> letterFrequency = new HashMap<>();
        while (st.hasMoreTokens()) {
            String letter = st.nextToken();
            letterFrequency.put(letter, letterFrequency.getOrDefault(letter, 0) + 1);
        }

        System.out.print("{");
        int size = letterFrequency.size();
        int count = 0;
        for (Map.Entry<String, Integer> entry : letterFrequency.entrySet()) {
            System.out.print(entry.getKey() + "=" + entry.getValue());
            count++;
            if (count < size) {
                System.out.print(", ");
            }
        }
        System.out.println("}");
    }

    public void countCharacter(String str) {
        System.out.println("Input string is: " + str);
        Map<Character, Integer> characterFrequency = new HashMap<>();
        char c;
        for (int i = 0; i < str.length(); i++) {
            c = str.charAt(i);
            if (Character.isLetter(c)) {
                c = Character.toLowerCase(c);
                characterFrequency.put(c, characterFrequency.getOrDefault(c, 0) + 1);
            } else if (Character.isDigit(c)) {
                characterFrequency.put(c, characterFrequency.getOrDefault(c, 0) + 1);
            }
        }
        System.out.print("{");
        int size = characterFrequency.size();
        int count = 0;
        for (Map.Entry<Character, Integer> entry : characterFrequency.entrySet()) {
            System.out.print(entry.getKey() + "=" + entry.getValue());
            count++;
            if(count < size){
                System.out.print(", ");
            }
        }
        System.out.println("}");
    }

    @Override
    public void execute(int choice) {
        switch (choice) {
            case 1:
                str = data.inputString("Enter your content:");
                break;
            case 2:
                try {
                countLetter(str);
                } catch (IOException ex) {
                System.out.println(ex.getMessage());
                }
            break;
            case 3:
                countCharacter(str);
                break;
            case 4:
                System.err.println("Exited. Bye bye!");
                break;
            default:
                System.err.println("Invalid choice. Please try again.");
        }
    }

}
