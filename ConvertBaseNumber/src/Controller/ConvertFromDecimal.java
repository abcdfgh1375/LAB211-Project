package Controller;

import Model.Element;
import View.Menu;
import java.util.*;

public class ConvertFromDecimal extends Menu {

    Element e = new Element();

    public ConvertFromDecimal() {
        super("\nConvert Decimal Management", Arrays.asList(new String[]{"Input decimal number", "Convert to binary", "Convert to hexa", "Exit"}));
    }

    public void swap(StringBuilder str, int index1, int index2) {
        if (index1 >= 0 && index1 < str.length() && index2 >= 0 && index2 < str.length()) {
            char temp = str.charAt(index1);
            str.setCharAt(index1, str.charAt(index2));
            str.setCharAt(index2, temp);
        } else {
            System.out.println("Invalid indices");
        }
    }

    public String addZero(String bin, int limit) {
        if (bin.length() < limit) {
            String newBin = "";
            for (int i = 1; i <= limit - bin.length(); i++) {
                newBin = newBin.concat("0");
            }
            newBin = newBin.concat(bin);
            bin = newBin;
        }
        return bin;
    }

    public String DecimalToAny(int dec, int baseOutput) {
        ConvertFromDecimal con = new ConvertFromDecimal();
        StringBuilder output = new StringBuilder();
        int remainder, quotient, i = 0;
        do {
            quotient = dec / baseOutput;
            remainder = dec % baseOutput;
            output.append((char) ('0' + remainder));
            i++;
            dec = quotient;
        } while (quotient > 0);
        for (int j = 0, k = output.length() - 1; j < k; j++, k--) {
            con.swap(output, j, k);
        }
        return output.toString();
    }

    public String DecimalToHexa(int dec) {
        ConvertFromDecimal con = new ConvertFromDecimal();
        StringBuilder output = new StringBuilder();
        int remainder, quotient, i = 0;
        do {
            quotient = dec / 16;
            remainder = dec % 16;

            if (remainder >= 10 && remainder <= 15) {
                output.append((char) ('A' + (remainder - 10)));
            } else {
                output.append((char) ('0' + remainder));
            }
            i++;
            dec = quotient;
        } while (quotient > 0);
        for (int j = 0, k = output.length() - 1; j < k; j++, k--) {
            con.swap(output, j, k);
        }
        return output.toString();
    }

    @Override
    public void execute(int choice) {
        switch (choice) {
            case 1:
                e.setInputStr(e.inputPattern("Enter decimal number: ", "[0-9\s]+"));
                break;
            case 2:
            try {
                if (e.getInputStr().isEmpty()) {
                    System.out.println("Input string is empty. Input number first!");
                } else {
                    System.out.println("Input decimal number: " + e.getInputStr());
                    System.out.println("Binary number equivalent: " + DecimalToAny(Integer.parseInt(e.getInputStr()), 2));
                }
            } catch (NullPointerException exp) {
                System.out.println(exp.getMessage());
            }
            break;
            case 3:
            try {
                if (e.getInputStr().isEmpty()) {
                    System.out.println("Input string is empty. Input number first!");
                } else {
                    System.out.println("Input decimal number: " + e.getInputStr());
                    System.out.println("Hexadecimal number equivalent: " + DecimalToHexa(Integer.parseInt(e.getInputStr())));
                }
            } catch (NullPointerException exp) {
                System.out.println(exp.getMessage());
            }
            break;
            case 4:
                e.setInputStr(null);
                System.err.println("Exited.Bye bye!");
                break;
            default:
                System.err.println("Invalid choice!");
        }
    }

}
