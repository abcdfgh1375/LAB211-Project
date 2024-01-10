package Controller;

import Model.Element;
import View.Menu;
import java.util.*;

public class ConvertFromBinary extends Menu {

    Element e = new Element();

    public ConvertFromBinary() {
        super("\nConvert Binary Management", Arrays.asList(new String[]{"Input binary number", "Convert to decimal", "Convert to hexa", "Exit"}));
    }

    public int BinaryToDecimal(String bin) {
        char[] binCharArr = bin.trim().replace(" ", "").toCharArray();
        int dec = 0;
        int[] binIntArr = new int[binCharArr.length];
        for (int i = 0; i < binCharArr.length; i++) {
            binIntArr[i] = binCharArr[i] - '0';
        }
        for (int j = binCharArr.length - 1, i = 0; j >= 0 && i < binCharArr.length; j--, i++) {
            dec += binIntArr[j] * Math.pow(2, i);
        }
        return dec;
    }

    public String BinaryToOctal(String bin) {
        ConvertFromBinary convertBin = new ConvertFromBinary();
        StringBuilder octal = new StringBuilder();
        String newBin = "";
        bin = bin.trim().replace(" ", "");
        if (bin.length() % 3 != 0) {
            for (int remainder = 0; remainder < 3 - bin.length() % 3; remainder++) {
                newBin = newBin.concat("0");
            }
            newBin = newBin.concat(bin);
            bin = newBin;
        }
        int beginIndex = 0;
        for (int i = 0; i < bin.length(); i += 3) {
            octal.append(convertBin.BinaryToDecimal(bin.substring(beginIndex, i + 3)));
            beginIndex = i + 3;
        }
        return octal.toString();
    }

    public String BinaryToHexa(String bin) {
        ConvertFromBinary conBin = new ConvertFromBinary();
        StringBuilder hexa = new StringBuilder();
        String newBin = "";
        bin = bin.trim().replace(" ", "");
        if (bin.length() % 4 != 0) {
            for (int remainder = 0; remainder < 4 - bin.length() % 4; remainder++) {
                newBin = newBin.concat("0");
            }
            newBin = newBin.concat(bin);
            bin = newBin;
        }
        int beginIndex = 0;
        ConvertFromDecimal conDec = new ConvertFromDecimal();
        for (int i = 0; i < bin.length(); i += 4) {
            hexa.append(conDec.DecimalToHexa(conBin.BinaryToDecimal(bin.substring(beginIndex, i + 4))));
            beginIndex = i + 4;
        }
        return hexa.toString();
    }

    @Override
    public void execute(int choice) {
        switch (choice) {
            case 1:
                e.setInputStr(e.inputPattern("Enter binary number: ", "[0-1]+"));
                break;
            case 2:
            try {
                if (e.getInputStr().isEmpty()) {
                    System.out.println("Input string is empty. Input number first!");
                } else {
                    System.out.println("Input binary number: " + e.getInputStr());
                    System.out.println("Decimal number equivalent: " + BinaryToDecimal(e.getInputStr()));
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
                    System.out.println("Input binary number: " + e.getInputStr());
                    System.out.println("Hexadecimal number equivalent: " + BinaryToHexa(e.getInputStr()));
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
