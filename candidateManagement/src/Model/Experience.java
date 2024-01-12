
package Model;

public class Experience extends Candidate{
//    : year of experience (ExpInYear), Professional Skill (ProSkill). 
    private int ExpInYear;
    private String ProSkill;
    
    public Experience() {
        super();
    }

    public Experience(int ExpInYear, String ProSkill) {
        this.ExpInYear = ExpInYear;
        this.ProSkill = ProSkill;
    }

    public int getExpInYear() {
        return ExpInYear;
    }

    public void setExpInYear(int ExpInYear) {
        this.ExpInYear = ExpInYear;
    }

    public String getProSkill() {
        return ProSkill;
    }

    public void setProSkill(String ProSkill) {
        this.ProSkill = ProSkill;
    }

//    @Override
//    public String toString() {
//        return "Experience{" +super.toString() + "| ExpInYear=" + ExpInYear + "| ProSkill=" + ProSkill + '}' + '\n';
//    }
    @Override
    public String toString() {
        return "Experience{" +super.toString() + "| 0" + '\n';
    }
}
