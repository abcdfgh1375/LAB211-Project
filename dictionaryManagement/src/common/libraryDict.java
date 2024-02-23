/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package common;

import Model.dictionaryPair;
import View.viewDict;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author THANH HUYEN
 */
public class libraryDict {

    validationDict valid = new validationDict();
    viewDict view = new viewDict();
    InputterDict input = new InputterDict();

    //add
    public void add(HashMap<String, String> dictionList, String e,String v) {
        dictionList.put(e,v);
    }

    public boolean addWord(HashMap<String, String> dictionList, String eng, String vi) {
        HashMap<String, String> res = dictionList;
        try {
            if (res == null) {
                throw new NullPointerException();
            }
        } catch (NullPointerException e) {
            System.out.println("Database does not exist");
            return false;
        }
        if (valid.checkExistByCode(dictionList, eng)&&!view.getContinue("This word has already Vietnamese meaning.Do you want to update Vietnamese meaning?\n")) {
                return true;           
        }       
        add(dictionList, eng,vi);
        return true;
    }
    //Delete

     public boolean removeWord(HashMap<String, String> dictionList, String eng) throws IOException {
        if (!dictionList.containsKey(eng)) {
            System.err.println("WORD NOT FOUND!");
            return false;
        }
        dictionList.remove(eng);
        return true;
    }
    
    
    //TRANSLATE
     public String translate(HashMap<String, String> dictionList,String eng) throws IOException {
        if (!dictionList.containsKey(eng)) {
            System.err.println("Word not exist in dictionary!");
            return null;
        }
        return  dictionList.get(eng);
    }

    public HashMap<String, String> loadFromFile(HashMap<String, String> dictionList, String fileName) throws NumberFormatException {
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String line;
            if ((line = br.readLine()) == null) {
                System.out.println("File is empty");
                return null;
            } else {
                do {
                    System.out.println(line);
                    String[] linearr = line.split("-");
                    try {
                        dictionaryPair a = new dictionaryPair(linearr[0], linearr[1]);
                        dictionList.put(a.getEngMean(), a.getVietMean());
                    } catch (NumberFormatException e) {
                        System.out.println("Error parsing float at line: " + line);
                    }
                } while ((line = br.readLine()) != null);
            }
            br.close();
        } catch (FileNotFoundException nfe) {
            System.out.println("File not found " + fileName);
            dictionList = new HashMap<>();
        } catch (IOException ex) {
            System.out.println("An error occurred while reading the file");
        }
        System.out.println("Load from file successfulled!");
        return dictionList;
    }

    public void saveToFile(String fileName, HashMap<String, String> content) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName, false))) {
            Map<String, String> sortedMap = new TreeMap<>(content);
            for (Map.Entry<String, String> d : sortedMap.entrySet()) {
                bw.write(d.getKey() + "-" + d.getValue());
                bw.write("\n");
            }
            System.out.println("Save into file completed!");
        } catch (IOException ex) {
            System.out.println("Error writing to file: " + fileName);
        }
    }

    public void load(HashMap<String, String> dictionList, String path) {
        loadFromFile(dictionList, path);
    }
}
