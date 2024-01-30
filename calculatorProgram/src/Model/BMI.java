/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author THANH HUYEN
 */
public class BMI {

    public double height;
    public double weight;
    public double resBMI;
    public BMIstatus status;

    public BMI(double height, double weight, double resBMI, BMIstatus status) {
        this.height = height;
        this.weight = weight;
        this.resBMI = resBMI;
        this.status = status;
    }

    public BMI() {
    }

    public double getHeight() {
        return height;
    }

    public double getWeight() {
        return weight;
    }

    public double getresBMI() {
        return resBMI;
    }

    public BMIstatus getStatus() {
        return status;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setresBMI(double resBMI) {
        this.resBMI = resBMI;
    }

//    public void setStatus(resBMIstatus status) {
//        this.status = status;
//    }
    
    // lưu trữ các trạng thái resBMI
    public enum BMIstatus {
        UnderStandard,
        Standard,
        OverWeight,
        Fat,
        VeryFat
    }

    public void setStatus(double resB) {
        if (resB < 18.5) {
            this.status = BMIstatus.UnderStandard;
        } else if (resB < 25) {
            this.status = BMIstatus.Standard;
        } else if (resB < 30) {
            this.status = BMIstatus.OverWeight;
        } else if (resB < 35) {
            this.status = BMIstatus.Fat;
        } else {
            this.status = BMIstatus.VeryFat;
        }
    }
}
