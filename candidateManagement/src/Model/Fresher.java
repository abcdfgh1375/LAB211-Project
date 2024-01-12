
package Model;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class Fresher extends Candidate{
//    
    private Date graduationDate;
    private String graduationRank;
    private String education;
    
    public Fresher() {
        super();
    }

    public Fresher(Date graduationDate, String graduationRank, String education) {
        super();
        this.graduationDate = graduationDate;
        this.graduationRank = graduationRank;
        this.education = education;
    }

    public Date getGraduationDate() {
        return graduationDate;
    }

    public void setGraduationDate(Date graduationDate) {
        this.graduationDate = graduationDate;
    }

    public String getGraduationRank() {
        return graduationRank;
    }

    public void setGraduationRank(String graduationRank) {
        this.graduationRank = graduationRank;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

//    @Override
//    public String toString() {
//        return "Fresher{" + super.toString() + "| graduationDate=" + graduationDate + "| graduationRank=" + graduationRank + "| education=" + education + '}';
//    }

        @Override
    public String toString() {
        return "Fresher{" +super.toString() + "| 1" + '\n';
    }
}
