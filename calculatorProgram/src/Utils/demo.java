package Utils;

import Controller.calculatorController;
import Controller.bmiController;
import Model.*;
import java.util.Scanner;

public class demo {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
//        calculatorController cal = new calculatorController();
//        operator o = new operator();
//        cal.runCalculate(o);
        bmiController bmi = new bmiController();
        BMI b = new BMI();
        bmi.runCalculate();
//        System.out.println(o.toString());
    }
}
