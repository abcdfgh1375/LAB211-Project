
package Model;
import View.MenuMini;
import java.util.Date;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.*;


public class Candidate{
    private String candidateID;
    private String firstName;
    private String lastName;
    private LocalDate birthDay;
    private String address;
    private String phone;
    private String email;
    private String candidateType;

//base code//////////////////

    public String getCandidateID() {
        return candidateID;
    }

    public void setCandidateID(String candidateID) {
        this.candidateID = candidateID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(LocalDate birthDay) {
        this.birthDay = birthDay;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCandidateType() {
        return candidateType;
    }

    public void setCandidateType(String candidateType) {
        this.candidateType = candidateType;
    }

    @Override
    public String toString() {
    return "Candidate ID: " + candidateID +
            "| First Name: " + firstName +
            "| Last Name: " + lastName +
            "| Birth Date: " + birthDay +
            "| Address: " + address +
            "| Phone: " + phone +
            "| Email: " + email +
            "| Candidate Type: " + candidateType;
}
}
