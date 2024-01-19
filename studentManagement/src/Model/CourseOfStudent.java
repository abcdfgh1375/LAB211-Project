
package Model;

public class CourseOfStudent {
    public String id;
    public int semester;
    public String courseName;

    public CourseOfStudent(String id, int semester, String courseName) {
        this.id = id;
        this.semester = semester;
        this.courseName = courseName;
    }

    public String getId() {
        return id;
    }

    public int getSemester() {
        return semester;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
    
}
