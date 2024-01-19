
import Model.CourseOfStudent;
import Model.Student;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class demo {
    static String fileName = "student.txt";
    ArrayList<Student> list_S = new ArrayList<>();
    ArrayList<CourseOfStudent> list_C = new ArrayList<>();

    public void loadFromFile() {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] linearr = line.split("\\|");

                if (linearr.length >= 4) {
                    String studentID = linearr[0].trim();
                    String studentName = linearr[1].trim();
                    String courseName = linearr[2].trim();
                    try {
                        int courseGrade = Integer.parseInt(linearr[3].trim());
                        String courseDescription = linearr.length > 4 ? linearr[4].trim() : "";

                        list_S.add(new Student(studentID, studentName));
                        list_C.add(new CourseOfStudent(courseName, courseGrade, courseDescription));
                    } catch (NumberFormatException e) {
                        System.out.println("Error parsing integer at line: " + line);
                        // Thực hiện xử lý lỗi nếu cần thiết, ví dụ như bỏ qua hoặc ghi log.
                    }
                } else {
                    System.out.println("Invalid line format at line: " + line);
                    // Thực hiện xử lý lỗi nếu cần thiết, ví dụ như bỏ qua hoặc ghi log.
                }
            }
        } catch (IOException ex) {
            System.out.println("An error occurred while reading the file");
        }
    }
}

