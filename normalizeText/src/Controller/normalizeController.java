package Controller;

import View.*;
import java.util.*;

public class normalizeController extends Menu {

    viewNormalize view;
    StringBuffer content = new StringBuffer();

    public normalizeController() {
        super("\nNormalize Management", Arrays.asList(new String[]{"Load from file", "Normalize", "Save to file", "Display text from file name", "Exit"}));

    }

    public StringBuffer normalizeContent(StringBuffer content) {
        StringBuffer normalizedContent = new StringBuffer();
        String[] lines = content.toString().split(System.lineSeparator());

        for (String line : lines) {
            // Normalize each line
            line = oneSpace(line);
            line = specialCharacter(line);
            line = afterDot(line);
            line = noSpaceQuotes(line);
            line = firstUppercase(line);
            line = addDotEnd(line);

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

    public String fformatOneSpaceQuote(String line) {
        int count = 0;
        for (char c : line.toCharArray()) {
            if (c == '"' && count % 2 == 0) {
                count++;
                continue;
            }
            if (c == '"' && count % 2 != 0) {
                if (line.indexOf(c + 1) == '.') {
                    continue;
                } else if (line.indexOf(c + 1) == ' ') {
                    line.replace((char) (c + 1), '.');
                } else if (Character.isAlphabetic(c + 1) || Character.isDigit(c + 1)) {
                    String newLine = line.substring(line.indexOf(0), line.indexOf(c)).concat(" ");
                    newLine.concat(line);
                }
            }
        }
        return line;
    }

    public String formatOneSpaceQuote(String line) {
        StringBuilder result = new StringBuilder();
        int count = 0;

        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);

            if (c == '"' && count % 2 == 0) {
                count++;
                result.append(c);
                continue;
            }

            if (c == '"' && count % 2 != 0) {
                if (i + 1 < line.length() && line.charAt(i + 1) == '.') {
                    result.append(c).append('.');
                } else if (i + 2 < line.length() && line.charAt(i + 1) == ' ' && line.charAt(i + 2) == '.') {
                    result.append(c).append('.');
                    result.deleteCharAt(i + 2);
                }
                 else if (i + 1 < line.length() && (Character.isAlphabetic(line.charAt(i + 1)) || Character.isDigit(line.charAt(i + 1)))) {
                result.append(c).append(" ");
            } else {
                result.append(c);
            }
        }else {
            result.append(c);
        }
    }

    return result.toString ();
}

// chỉ có 1 khoảng trắng giữa các từ và các từ viết thg
public String oneSpace(String line) {
        line = line.toLowerCase();
        line = line.replaceAll("\\s+", " ");
        line = formatOneSpace(line, ".");
        line = formatOneSpace(line, ",");
        line = formatOneSpace(line, ":");
        line = formatOneSpaceQuote(line);
        return line.trim();
    }

    // chỉ có space sau dấu , và dấu . và dấu : 
    public String specialCharacter(String line) {
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
                    if (i + 1 < bf.length() && bf.charAt(i + 1) == ' ') {
                        bf.deleteCharAt(i + 1);
                    }
                    countQuotes++;
                } else {
                    if (i - 1 >= 0 && bf.charAt(i - 1) == ' ') {
                        bf.deleteCharAt(i - 1);
                    }
                    countQuotes = 0;
                }
            }
            i++;
        }
        return bf.toString().trim();
    }

    public String addDotEnd(String line) {
        line = line.trim();

        if (line.endsWith(".")) {
            return line;
        } else {
            return line + ".";
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
        view = new viewNormalize();
        switch (choice) {
            case 1:
                content = view.executeLoad(content);
                break;
            case 2:
                content = view.executeNormalize(content);
                break;
            case 3:
                view.executeSave(content);
                break;
            case 4:
                view.executeDisplay(content);
                break;
            case 5:
                System.exit(0);
            default:
                System.err.println("Invalid choice!");
        }
    }

}
