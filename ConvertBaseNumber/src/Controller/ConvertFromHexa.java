package Controller;

import Model.Element;
import View.Menu;
import java.util.*;

public class ConvertFromHexa extends Menu {

    Element e = new Element();

    public ConvertFromHexa() {
        super("\nConvert Hexa Management", Arrays.asList(new String[]{"Input hexa number", "Convert to binary", "Convert to decimal", "Exit"}));
    }

    public int HexaToDecimal(String hexa) {
        int dec = 0;
        char[] hexCharArr = hexa.trim().replace(" ", "").toCharArray();
        int[] hexIntArr = new int[hexCharArr.length];
        char[] ruleHexa1 = {'A', 'B', 'C', 'D', 'E', 'F'};
        String[] ruleHexa2 = {"10", "11", "12", "13", "14", "15"};
        StringBuilder modifiedHexa = new StringBuilder();
        for (int i = 0; i < hexa.length(); i++) {
            char currentChar = hexa.charAt(i);
            int index = Arrays.binarySearch(ruleHexa1, currentChar);

            if (index >= 0) {
                modifiedHexa.append(ruleHexa2[index]);
            } else {
                modifiedHexa.append(currentChar);
            }
        }
        for (int i = 0; i < hexCharArr.length; i++) {
            if (Character.isDigit(hexCharArr[i])) {
                hexIntArr[i] = hexCharArr[i] - '0';
            } else {
                int index = Arrays.binarySearch(ruleHexa1, hexCharArr[i]);
                hexIntArr[i] = Integer.parseInt(ruleHexa2[index]);
            }
        }
        for (int j = hexCharArr.length - 1, i = 0; j >= 0 && i < hexCharArr.length; j--, i++) {
            dec += hexIntArr[j] * Math.pow(16, i);
        }
        return dec;
    }

    public String HexaToBinary(String hexa) {
        ConvertFromDecimal con = new ConvertFromDecimal();
        int dec = HexaToDecimal(hexa);
        String bin;
        return bin = con.DecimalToAny(dec, 2);
    }

    @Override
    public void execute(int choice) {
        switch (choice) {
            case 1:
                e.setInputStr(e.inputPattern("Enter hexa number: ", "[0-9A-F\s]+"));
                break;
            case 2:
            try {
                if (e.getInputStr().isEmpty()) {
                    System.out.println("Input string is empty. Input number first!");
                } else {
                    System.out.println("Input Hexadecimal number: " + e.getInputStr());
                    System.out.println("Binary number equivalent: " + HexaToBinary(e.getInputStr()));
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
                    System.out.println("Input Hexadecimal number: " + e.getInputStr());
                    System.out.println("Decimal number equivalent: " + HexaToDecimal(e.getInputStr()));
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
