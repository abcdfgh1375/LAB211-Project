
package Controller;
import Utils.Inputter;
import Model.Student;
import Model.CourseOfStudent;
import Model.Report;
import View.Menu;
import java.io.*;
import java.util.*;

public class StudentManagement extends Menu {

    Inputter input;
    ArrayList<Student> listS;
    ArrayList<CourseOfStudent> listC;
    Student s;

    public StudentManagement() {
        super("---------- 🏫 Student Management 🏫 ----------", Arrays.asList(new String[]{"Creat a student", 
            "Find and Sort", "Update/Delete", "Report","Load from file","Save to file","Exit"}));//display menu to choose
        input = new Inputter();
        listS = new ArrayList<>();
        listC = new ArrayList<>();
        s = new Student();
    }

    @Override
    public void execute(int n) {
        switch (n) {
            case 1:
                createStudent();
                break;
            case 2:
                FindAndSortStudent();
                break;
            case 3:
                UpdateOrDeleteStudent();
                break;
            case 4:
                Report();
                break;
            case 5:
                loadFromFile();
                break;
            case 6:
                saveToFile();
                break;
            case 7:
                System.exit(0);

        }
    }
    
    static String fileName = "student.txt";
    public void loadFromFile() throws NumberFormatException{
        try{
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        String line;
        if((line=br.readLine())== null){
            System.out.println("File is empty");
            return;
        }
        while((line = br.readLine())!= null){
            String[] linearr = line.split("\\|");
            listS.add(new Student(linearr[0], linearr[1]));
                try {
                    listC.add(new CourseOfStudent(linearr[0], Integer.parseInt(linearr[2]), linearr[3]));
                    //studentID|studentName|semester|courseName
                } catch (NumberFormatException e) {
                    System.out.println("Error parsing integer at line: " + line);
                }        
        }
        br.close();
        }catch(FileNotFoundException nfe){
            System.out.println("File not found " + fileName);
        } catch (IOException ex) {
            System.out.println("An error occurred while reading the file");
        } 
    }

    public void saveToFile() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName, false))) {
            for (int i = 0; i < listS.size(); i++) {
                if (i < listC.size()) {
                    Student student = listS.get(i);
                    CourseOfStudent course = listC.get(i);
                    String line = student.getId() + "|" + student.getName() + "|" +
                                  course.getSemester() + "|" + course.getCourseName() + "\n";
                    bw.write(line);
                } else {
                    System.out.println("No course information for student: " + listS.get(i).getId());
                }
            }
            System.out.println("Save list into file completed!");
        } catch (IOException ex) {
            System.out.println("Error writing to file: " + fileName);
        }
    }

    public boolean checkDuplicateID(ArrayList<Student> list, String id) {
        if (list.isEmpty()) {
            return false;
        } else {
            for (Student s : listS) {
                if (s.getId().equalsIgnoreCase(id)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public void createStudent() {
        if (!listS.isEmpty() && listS.size()%10==0) {
            char continueInput = input.getYN("Do you want to continue (Y/N)? ");
            if (Character.toUpperCase(continueInput) != 'Y') {
                return;
            }
        }
        String name;
        String id = input.inputPatternn("Enter id: ","ID"+"\\d{3}+");
        if (!checkDuplicateID(listS, id)) {
            name = input.getStringFromInput("Enter student name");
            listS.add(new Student(id, name));
        } 
        int semester = input.getIntFromInput("Enter semester");
        ArrayList<String>  listCourseName = new ArrayList<>(Arrays.asList("Java", ".NET", "C/C++"));
        displayCourseMenu("Choose course name",listCourseName);
        String courseName = chooseCourseName(getChoice());                
        listC.add(new CourseOfStudent(id, semester, courseName));
        if (listS.size() == 10) {
            char continueInput = input.getYN("Do you want to continue (Y/N)? ");
            if (Character.toUpperCase(continueInput) != 'Y') {
                return;
            }else{createStudent();}
        }
    }

        public void displayCourseMenu(String title, ArrayList list){
        System.out.println(title);
        for(int i = 0; i < list.size(); i++){
            System.out.println((i+1) + ". " + list.get(i));
        }
    }
         public String chooseCourseName(int choice){
            switch(choice){
                 case 1:
                     return "Java";
                 case 2:
                     return ".NET";
                 case 3:
                     return "C/C++";
             }
            return null;
         }
    
    public void FindAndSortStudent() {
        if (listS.isEmpty()) {
            System.err.println("Not Exist! please check again");
            return;
        }
        ArrayList<Student> FindByName = FindByName(listS);
        if (FindByName.isEmpty()) {
            System.err.println("Not exist! please check again");
        } else {
            Collections.sort(FindByName);
            DisplayStudentList(FindByName);
        }
    }

    public ArrayList<Student> FindByName(ArrayList<Student> listS) {
        ArrayList<Student> FoundStudent = new ArrayList<>();
        String name = input.getStringFromInput("Enter student name");
        for (Student s : listS) {
            if (s.getName().contains(name)) {
                FoundStudent.add(s);
            }
        }
        return FoundStudent;
    }

    public void UpdateOrDeleteStudent() {
        if (listS.isEmpty()) {
            System.err.println("The student list is empty! please create first");
            return;
        }
        String id = input.inputPatternn("Enter the ID search","ID"+"\\d{3}+");
            Student s = searchStudentById(listS, id);
            CourseOfStudent cs = searchCourseById(listC, id);
        if(!(s==null)||!(cs == null)){
            System.out.println("Student found: " + s.getName() + "| Id: " + s.getId()
            + "| Semester: " + cs.getSemester() + "| Course Name: " + cs.getCourseName());

            System.out.println("Do you want to update or delete ? ");
            System.out.println("1. Update student ");
            System.out.println("2. Delete student ");

            String o = input.inputPatternn("","[U/D]+");
            switch (o) {
                case "U":
                    upDateStudent(s, cs);
                    break;
                case "D":
                    deleteStudent(s, cs);
                    break;
                default:
                    return;
            }
        }else{
            System.out.println("There is no student have ID "+id);
        }
        
    }
        public Student searchStudentById(ArrayList<Student> lists, String id) {
        for (Student s : listS) {
            if (s.getId().equalsIgnoreCase(id)) {
                return s;
            }
        }
        return null;
    }

    public CourseOfStudent searchCourseById(ArrayList<CourseOfStudent> lists, String id) {
        for (CourseOfStudent s : lists) {
            if (s.getId().equalsIgnoreCase(id)) {
                return s;
            }
        }
        return null;
    }


    public void upDateStudent(Student s, CourseOfStudent cs) {
        s.setId(s.getId());
        s.setName(input.getStringFromInput("Enter student name"));
        cs.setId(cs.getId());
        cs.setSemester(input.getIntFromInput(""));
        cs.setCourseName(input.inputStringAlphabet("Enter course name: "));
        System.out.println("Updated success!");
    }

    public void deleteStudent(Student s, CourseOfStudent cs) {
        listC.remove(cs);
        listS.remove(s);
        System.out.println("Delete success!");
    }

    public void DisplayStudentList(ArrayList<Student> listS) {
        for (Student s : listS) {
            System.out.print("[" + "id: " + s.getId() + ", " + "Name: " + s.getName() + "]");

            for (CourseOfStudent cs : listC) {
                if (s.getId().equalsIgnoreCase(cs.getId())) {
                    System.out.println("[" + "semester: " + cs.getSemester() + ", " + "course Name: " + cs.getCourseName() + "]");

                }
            }
        }
    }

    public void Report() {
        HashMap<String, Report> studentReports = new HashMap<>();
        System.out.printf("%-20s | %-20s | %-10s%n", "Student Name", "Course Name", "Total Courses");
        System.out.println("-------------------------------------------------------------");

        for (Student s : listS) {
            for (CourseOfStudent cs : listC) {
                if (s.getId().equalsIgnoreCase(cs.getId())) {
                    String key = s.getName() + " | " + cs.getCourseName();
                    Report r = studentReports.get(key);

                    if (r == null) {
                        r = new Report(s.getId(), cs.getCourseName(), 1);
                        studentReports.put(key, r);
                    } else {
                        r.setTotalCourse(r.getTotalCourse() + 1);
                    }
                }
            }
        }
        for (Report r : studentReports.values()) {
            System.out.printf("%-20s | %-20s | %-10d%n", getStudentName(r.getId()), r.getCourseName(), r.getTotalCourse());
        }
    }

    public String getStudentName(String studentID) {
        for (Student s : listS) {
            if (s.getId().equalsIgnoreCase(studentID)) {
                return s.getName();
            }
        }
        return "";
    }
}
