
package Model;
import View.ViewCandidate;
import java.util.Date;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.*;


public class Candidate{
    private String candidateID;
    private String firstName;
    private String lastName;
    private Date birthDay;
    private String address;
    private String phone;
    private String email;
    private String candidateType;

    public Candidate() {
    }

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

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
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
    return  candidateID +
            " | " + firstName +
            " " + lastName +
            " | " + birthDay.getYear() +
            " | " + address +
            " | " + phone +
            " | " + email +
            " | " + candidateType;
}
}
