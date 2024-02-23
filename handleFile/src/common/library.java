/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package common;

import Model.Person;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author THANH HUYEN
 */
public class library {

    final String input = "D:\\inputFile.txt";

    //FIND LIST & MIN MAX
    public List<Person> getSatisfiedPerson(List<Person> list, double money) {
        List<Person> newList = null;
        try {
            if (list.isEmpty()) {
                System.out.println("List at getSatisfiedPerson is null");
                throw new Exception();
            }
            newList = list.stream().filter((aPerson) -> aPerson.getSalary() >= money).collect(Collectors.toList());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
        return newList;
    }

    public Person getMaxMinPerson(List<Person> list, String msg) throws Exception {
        if (list.isEmpty()) {
            System.out.println("List at getMMPerson is null");
            return null;
        }
        if (msg.equalsIgnoreCase("MAX")) {
            return list.stream().collect(Collectors.maxBy(Comparator.comparing(Person::getSalary))).get();
        }
        if (msg.equalsIgnoreCase("MIN")) {
            return list.stream().collect(Collectors.minBy(Comparator.comparing(Person::getSalary))).get();
        }
        return null;
    }

    public List<Person> getPerson(String path, double money) throws Exception {
        validationFile valid = new validationFile();
        List<Person> stfPersonList = new ArrayList<>();
        List<Person> personList = loadFromFile(path);
        try {
            if (personList.isEmpty()) {
                System.out.println("File is empty");
                return null;
            } else {
                stfPersonList = getSatisfiedPerson(personList, money);
            }
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
        return stfPersonList;
    }

    public List<Person> loadFromFile(String path) throws Exception {
        validationFile valid = new validationFile();
        List<Person> personList = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            String line;
            if ((line = br.readLine()) == null) {
                System.out.println("File is empty");
                return null;
            } else {
                do {
//                    System.out.println(line);
                    String[] linearr = line.split(";");
                    try {
                        personList.add(new Person(linearr[0], linearr[1], valid.setValidSalary(linearr[2])));
//                        stfPersonList = getSatisfiedPerson(personList, money);
                    } catch (NumberFormatException e) {
                        System.out.println("Error parsing float at line: " + line);
                    }
                } while ((line = br.readLine()) != null);
            }
            br.close();
        } catch (FileNotFoundException nfe) {
            System.out.println("Path " + path + "doesn't exist");
        } catch (IOException ex) {
            System.out.println("An error occurred while reading the file");
        }
//        System.out.println("Load from file successfulled!");
        return personList;
    }
//COPY

    public boolean copyWordOneTimes(String source, String dest) throws Exception {
        List<Person> newList = loadFromFile(source);

        String content = new String(Files.readAllBytes(Paths.get(source)));
        String[] words = content.split("\\s+");
        String[] uniqueWords = findUniqueWords(words);
        saveToFile(dest, uniqueWords);
//        uniqueWords.forEach(System.out::println);
        return true;
    }

    private static String[] findUniqueWords(String[] words) {
        Set<String> uniqueWords = new HashSet<>();
        for (String word : words) {
            uniqueWords.add(word);
        }
        return uniqueWords.toArray(new String[0]);
    }

    public void saveToFile(String dest, String[] content) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(dest, false))) {
            for (String w : content) {
                bw.write(w);
                bw.write("\n");
            }
//            System.out.println("Save into file completed!");
        } catch (IOException ex) {
            System.out.println("Error writing to file: " + dest);
        }

    }

    public static void copyWordOneTimess(String sourcePath, String destinationPath) throws Exception {
        File srcFile = new File(sourcePath);
        File destFile = new File(destinationPath);

        if (!srcFile.exists()) {
            throw new Exception("Source file doesn't exist.");
        }

        if (!srcFile.isFile()) {
            throw new Exception("Invalid source file.");
        }

        BufferedReader reader = null;
        BufferedWriter writer = null;

        try {
            reader = new BufferedReader(new FileReader(srcFile));
            writer = new BufferedWriter(new FileWriter(destFile));
            Set<String> uniqueWords = new HashSet<>();
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\s+"); // Split the line into words
                for (String word : words) {
                    uniqueWords.add(word);
                }
            }
            for (String word : uniqueWords) {
                writer.write(word);
                writer.newLine();
            }
            System.out.println("Save into file completed!");
        } catch (IOException e) {
            throw new Exception("Error reading/writing file.");
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    // Ignore
                }
            }
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    // Ignore
                }
            }
        }
    }

}
