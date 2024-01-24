
package View;

import Model.Text;
import Utils.Inputter;
import Controller.*;
import java.io.*;

public class viewNormalize {
    Text text;
    public viewNormalize() {
        this.text = new Text();
    }
    
    Inputter input = new Inputter();
    normalizeController con = new normalizeController();
    public StringBuffer executeLoad(StringBuffer content) {               
        System.out.println(text.getInputFile());
        {
            try {
                content = text.loadFromFile(text.getInputFile(),content);
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
        System.out.println(content.toString());
        return content;
    }

    public StringBuffer executeNormalize(StringBuffer content) {
        content = con.normalizeContent(content);
        System.out.println(content.toString());
        return content;
    }

    public void executeSave(StringBuffer content) {
        try {
            text.saveToFile(text.getOutputFile(),content);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public void executeDisplay(StringBuffer content) {
        content = new StringBuffer();
        String file = input.inputPattern("Input file name: ", "[a-zA-Z.]+");
        {
            try {
                content = text.loadFromFile(file, content);
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
        displayText(content);
    }

    public void displayText(StringBuffer cont) {
        if (cont != null) {
            System.out.println(cont.toString());
        } else {
            System.out.println("Text is null");
        }
    }


}
