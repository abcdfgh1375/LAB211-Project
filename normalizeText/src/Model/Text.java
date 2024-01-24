
package Model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Text {
    private String inputFile = "input.txt";;
    private String outputFile = "output.txt";;
    private StringBuffer text;
//    StringBuffer content = new StringBuffer();

    public Text() {
    }

    public Text(StringBuffer text) {
        this.text = text;
    }

    public String getInputFile() {
        return inputFile;
    }

    public void setInputFile(String inputFile) {
        this.inputFile = inputFile;
    }

    public String getOutputFile() {
        return outputFile;
    }

    public void setOutputFile(String outputFile) {
        this.outputFile = outputFile;
    }

    public StringBuffer getText() {
        return text;
    }

    public void setText(StringBuffer text) {
        this.text = text;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Text{");
        sb.append(text);
        sb.append('}');
        return sb.toString();
    }
        public StringBuffer loadFromFile(String fileName, StringBuffer content) throws Exception {        
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = br.readLine()) != null) {
                content.append(line);
            }
            if (content.length() == 0) {
                System.out.println("File is empty");
                return null ;
            }
            System.out.println("Load from file successfulled!");
            br.close();
        } catch (FileNotFoundException nfe) {
            System.out.println("File not found " + fileName);
        } catch (IOException ex) {
            System.out.println("An error occurred while reading the file");
        }  
        return content;
    }
    
    public void saveToFile(String fileName, StringBuffer content) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName, false))) {
            bw.write(content.toString());
            System.out.println("Save into file completed!");
        } catch (IOException ex) {
            System.out.println("Error writing to file: " + fileName);
        }
    }

}
