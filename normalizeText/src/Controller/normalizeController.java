package Controller;

import Model.Text;
import Utils.Inputter;
import View.Menu;
import java.io.*;
import java.util.*;

public class normalizeController extends Menu {

    String inputFile;
    String outputFile;
    Inputter input;
    Text text;
    StringBuffer content;

    public normalizeController() {
        super("\nNormalize Management", Arrays.asList(new String[]{"Load from file", "Normalize", "Save to file","Display text from file name", "Exit"}));
        text = new Text();
        inputFile = text.getInputFile();
        outputFile = text.getOutputFile();
        input = new Inputter();
        content = new StringBuffer();
    }

    public void loadFromFile(String fileName) throws Exception {
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = br.readLine()) != null) {
                content.append(line);
                text.setText(content);
            }
            if (content.length() == 0) {
                System.out.println("File is empty");
                return;
            }
            System.out.println("Load from file successfulled!");
            br.close();
        } catch (FileNotFoundException nfe) {
            System.out.println("File not found " + fileName);
        } catch (IOException ex) {
            System.out.println("An error occurred while reading the file");
        }
    }

 public void displayText() {
        if (text != null) {
            System.out.println(text.toString());
        } else {
            System.out.println("Text is null");
        }
    }

    public void saveToFile( String fileName) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName, false))) {
            bw.write(content.toString());
            System.out.println("Save into file completed!");
        } catch (IOException ex) {
            System.out.println("Error writing to file: " + fileName);
        }
    }

       public StringBuffer normalizeContent() {
        StringBuffer normalizedContent = normalizeContent(content);
        return normalizedContent;
    }

    private StringBuffer normalizeContent(StringBuffer content) {
        StringBuffer normalizedContent = new StringBuffer();
        String[] lines = content.toString().split(System.lineSeparator());

        for (String line : lines) {
            // Normalize each line
            line = OneSpace(line);
            line = SpecialCharacter(line);
            line = afterDot(line);
            line = noSpaceQuotes(line);
            line = firstUppercase(line);
            line = AddDotEnd(line);

            if (!isLineEmpty(line)) {
                normalizedContent.append(line).append(System.lineSeparator());
            }
        }
        System.out.println("Normalization successfulled!");
        return normalizedContent;
    }

    public String formatOneSpace(String line, String character) {
        StringBuffer bf = new StringBuffer();
        String[] a = line.split("\\s*\\" + character + "\\s*");
        // khoảng cách giữa mỗi từ và kí tự đặc biệt chỉ vs 1 khoảng trắng
        for (String word : a) {
            bf.append(word).append(" ").append(character);
            bf.append(" ");
        }
        return bf.toString().trim().substring(0, bf.length() - 3);
    }

    // chỉ có 1 khoảng trắng giữa các từ và các từ viết thg
    public String OneSpace(String line) {
        line = line.toLowerCase();
        line = line.replaceAll("\\s+", " ");
        line = formatOneSpace(line, ".");
        line = formatOneSpace(line, ",");
        line = formatOneSpace(line, ":");
        return line.trim();
    }

    // chỉ có space sau dấu , và dấu . và dấu : 
    public String SpecialCharacter(String line) {
        StringBuffer bf = new StringBuffer(line);
        // chạy loop từ đầu tới cuối trc các dấu, sau đó xóa
        for (int i = 0; i < bf.length() - 1; i++) {
            if (bf.charAt(i) == ' ' && bf.charAt(i + 1) == '.'
                    || bf.charAt(i + 1) == ',' || bf.charAt(i + 1) == ':') {
                bf.deleteCharAt(i);
            }
        }
        return bf.toString().trim();
    }
        private String firstUppercase(String line) {
        StringBuffer bf = new StringBuffer(line.trim());
        for (int i = 0; i < line.length(); i++) {
            if (Character.isLetter(line.charAt(i))) {
                bf.setCharAt(i, Character.toUpperCase(line.charAt(i)));
                break;
            }
        }
        return bf.toString().trim();
        }
        
    // Sau dấu chấm phải ghi hoa kí tự đầu tiên
    public String afterDot(String line) {
        StringBuffer bf = new StringBuffer(line);
        for (int i = 0; i < bf.length() - 2; i++) {
            if (bf.charAt(i) == '.') {
                bf.setCharAt(i + 2, Character.toUpperCase(bf.charAt(i + 2)));
            }
        }
        return bf.toString().trim();
    }
    
    //no spaces before and after sentence or word phrases in quotes (“”).
    public String noSpaceQuotes(String line) {
    StringBuffer bf = new StringBuffer(line);
    int countQuotes = 0;
    int i = 0;

    while (i < bf.length()) {
        if (bf.charAt(i) == '"') {
            if (countQuotes % 2 == 0) {
                if (i + 1 < bf.length()&& bf.charAt(i+1)==' ') {
                    bf.deleteCharAt(i + 1);
                }
                countQuotes++;
            } else {
                if (i - 1 >= 0 && bf.charAt(i-1)==' ') {
                    bf.deleteCharAt(i - 1);
                }
                countQuotes = 0;
            }
        }
        i++;
    }
    return bf.toString().trim();
}


   public String AddDotEnd(String line) {
        if (line.trim().endsWith(".")) {
            return line;
        } else {
            return line.concat(".");
        }
    }


    //There are no blank line between lines
    public boolean isLineEmpty(String line) {
        if (line.length() == 0) {
            return true;
        } else {
            return false;
        }
    }
    
    @Override
    public void execute(int choice) {
        switch (choice) {
            case 1:
                System.out.println(inputFile);
            {
                try {
                    loadFromFile(inputFile);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            }
                System.out.println(content.toString());
                break;
            case 2:
                content = normalizeContent();
                System.out.println(content.toString());
                break;
            case 3:
            {
                try {
                    saveToFile(outputFile);
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                }
            }
                break;
            case 4:
                content = new StringBuffer();
                String file = input.inputPattern("Input file name: ", "[a-zA-Z.]+");
            {
                try {
                    loadFromFile(file);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            }
                displayText();
                break;
            case 5:
                System.exit(0);
            default:
                System.err.println("Invalid choice!");
        }
    }


}
