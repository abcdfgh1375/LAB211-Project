/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;
public class contact {
    private int contactID;
    private String name;
    private String firstName;
    private String lastName;
    private String group;
    private String address;
    private String phone;

    public contact() {
    }

    public contact(int contactID, String name, String group, String address, String phone) {
        this.contactID = contactID;
        this.name = name;
        this.group = group;
        this.address = address;
        this.phone = phone;
    }

    public int getContactID() {
        return contactID;
    }

    public void setContactID(int contactID) {
        this.contactID = contactID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
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

    @Override
    public String toString() {
        return String.format("%-5s%-15s%-15s%-15s%-10s%-15s%s", contactID, name,firstName,lastName, group, address,phone);
    }
    
    public void setFirstLastName(String name){
        String[] na = name.split(" ");
        this.lastName = na[0];
        this.firstName = na[1];
    }
    
}
