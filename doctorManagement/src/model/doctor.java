package model;

import common.common;
import common.library;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import view.viewDoctor;

public class doctor {
//    Code(String), Name(String), Specialization(String), Availability(int).

    private String docCode;
    private String docName;
    private String docSpecialization;
    private int docAvailability;

    private final library library = new library();
    final common common = new common();
    private final viewDoctor view = new viewDoctor();

    public doctor() {

    }

    public doctor(String docCode, String docName, String docSpecialization, int docAvailability) {
        this.docCode = docCode;
        this.docName = docName;
        this.docSpecialization = docSpecialization;
        this.docAvailability = docAvailability;
    }

    @Override
    public String toString() {
        return String.format("%-10s%-10s%-20s%s", docCode, docName, docSpecialization, docAvailability);
    }

    public int getDocAvailability() {
        return docAvailability;
    }

    public void setDocAvailability(int docAvailability) {
        this.docAvailability = docAvailability;
    }

    public String getDocCode() {
        return docCode;
    }

    public void setDocCode(String docCode) {
        this.docCode = docCode;
    }

    public String getDocName() {
        return docName;
    }

    public void setDocName(String docName) {
        this.docName = docName;
    }

    public String getDocSpecialization() {
        return docSpecialization;
    }

    public void setDocSpecialization(String docSpecialization) {
        this.docSpecialization = docSpecialization;
    }

    public HashMap<String, doctor> loadFromFile(HashMap<String, doctor> doctorList, String fileName) throws NumberFormatException {
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String line;
            if ((line = br.readLine()) == null) {
                System.out.println("File is empty");
                return null;
            } else {
                do {
//                    System.out.println(line);
                    String[] linearr = line.split("\\|");
                    try {
                        doctor a = new doctor(view.automaticCode(), linearr[0], linearr[1], Integer.parseInt(linearr[2]));
//                        a.setFirstLastName(a.getName());
                        doctorList.put(a.getDocCode(), a);
                    } catch (NumberFormatException e) {
                        System.out.println("Error parsing float at line: " + line);
                    }
                } while ((line = br.readLine()) != null);
            }
            br.close();
        } catch (FileNotFoundException nfe) {
            System.out.println("File not found " + fileName);
        } catch (IOException ex) {
            System.out.println("An error occurred while reading the file");
        }
        System.out.println("Load from file successfulled!");
        return doctorList;
    }

    public void saveToFile(String fileName, HashMap<String, doctor> content) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName, false))) {
            Map<String, doctor> sortedMap = new TreeMap<>(content);
            for (Map.Entry<String, doctor> d : sortedMap.entrySet()) {
                bw.write(d.getValue().toString());
                bw.write("\n");
            }
            System.out.println("Save into file completed!");
        } catch (IOException ex) {
            System.out.println("Error writing to file: " + fileName);
        }
    }

    public boolean addDoctor() throws Exception {
        return library.addDoctor(view.inputDoctor());
    }

    public void loadDoctor() throws Exception {
        library.setDoctorList(loadFromFile(library.getDoctorList(), common.INPUT));
    }

    public void saveDoctor() throws Exception {
        if(library.getDoctorList().isEmpty()){
            System.out.println("Empty hash!");
            return;
        }
        saveToFile(common.OUTPUT, library.getDoctorList());
    }

    public boolean updateDoctor() throws Exception {
        return library.updateDoctor(view.inputDoctorUpdate());
    }

    public boolean deleteDoctor() throws Exception {
        return library.deleteDoctor(library.searchDoctorByCode(library.doctorList, view.inputDoctorCode()));
    }

    public HashMap<String, doctor> searchDoctor() throws Exception {
        return library.searchListDoctorByString(view.inputStringSearch(), view.inputChoiceSearchField());
    }

    public HashMap<String, doctor> displayDoctor() throws Exception {
        return library.doctorList;
    }

}
