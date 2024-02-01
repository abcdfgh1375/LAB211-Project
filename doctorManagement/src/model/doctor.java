package model;

import common.common;
import common.library;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import view.viewDoctor;

public class doctor {
//    Code(String), Name(String), Specialization(String), Availability(int).

    private String docCode;
    private String docName;
    private String docSpecialization;
    private int docAvailability;
    
    private final library library= new library();
    final common common = new common();
    private final viewDoctor view= new viewDoctor();
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
    
        public HashMap<String,doctor> loadFromFile(HashMap<String,doctor> doctorList, String fileName) throws NumberFormatException {
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String line;
            if ((line = br.readLine()) == null) {
                System.out.println("File is empty");
                return null;
            } else {
                do {
                    System.out.println(line);
                    String[] linearr = line.split("\\|");
                    try {
                        doctor a = new doctor(common.automaticCode(), linearr[0], linearr[1], Integer.parseInt(linearr[2]));
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

    
    public void addDoctor() throws Exception{
        library.setDoctorList(loadFromFile(library.getDoctorList(),common.INPUT));
        view.displayTitle("Add Doctor", '-');
        view.displayResultFunction(library.addDoctor(common.inputDoctor()),"Add");
    }
     public void updateDoctor() throws Exception{
        view.displayTitle("Update Doctor", '-');
        view.displayResultFunction(library.updateDoctor(common.inputDoctor()),"Update");
    }
      public void deleteDoctor() throws Exception{
        view.displayTitle("Delete Doctor", '-');
        view.displayResultFunction(library.deleteDoctor(library.searchDoctorByCode(library.doctorList,common.inputDoctorCode())),"Delete");
    }
      public void searchDoctor() throws Exception{
        view.displayHash(library.searchListDoctorByString(common.inputStringSearch(), common.inputChoiceSearchField()), "Search Doctor", '-');
      }
      public void displayDoctor() throws Exception{
          view.displayHash(library.doctorList,"Result",'-');
      }
    
}
