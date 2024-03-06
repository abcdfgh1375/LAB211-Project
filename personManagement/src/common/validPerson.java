/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package common;

/**
 *
 * @author THANH HUYEN
 */
public class validPerson {

    public boolean checkValidSalary(String s) throws Exception {
        boolean a = true;
        try {
            double d = Double.parseDouble(s);
        } catch (NumberFormatException ex) {
            System.out.println("You must input digit.");
            return false;
        }
        try{
        if (Double.parseDouble(s) < 0) {
            throw new Exception();
        }}catch(Exception e){
            System.out.println("Salary is greater than zero.");
            return false;
        }
        return a;
    }
}
