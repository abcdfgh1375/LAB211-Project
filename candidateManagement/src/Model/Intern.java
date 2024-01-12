
package Model;

import java.util.List;

public class Intern extends Candidate{
    private String major;
    private int semester;
    private String uniName;
    public Intern() {
        
    }

    public Intern(String major, int semester, String uniName) {
        super();
        this.major = major;
        this.semester = semester;
        this.uniName = uniName;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public String getUniName() {
        return uniName;
    }

    public void setUniName(String uniName) {
        this.uniName = uniName;
    }

//    @Override
//    public String toString() {
//        return "Intern{"+ super.toString() + "| major=" + major + "| semester=" + semester + "| uniName=" + uniName + '}'+ '\n';
//    }
    @Override
    public String toString() {
        return "Intern{"+ super.toString() + "| 2" + '}' + '\n';
    }
    
}
