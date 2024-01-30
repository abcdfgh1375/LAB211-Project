
package Controller;
import Model.BMI;
import View.viewCalculator;
public class bmiController {
    viewCalculator view = new viewCalculator();
    
    public void runCalculate(){
        BMI bmi = new BMI();
        view.viewTitle("BMI Calculator");
        bmi.setWeight(view.inputHW("Enter Weight(kg): "));
        bmi.setHeight(view.inputHW("Enter Height(cm): "));
        bmi.setresBMI(calculate(bmi));
        bmi.setStatus(bmi.getresBMI());
        view.displayBMI(bmi);
    }
    public double calculate(BMI bmi){
        return (bmi.getWeight()/(Math.pow(bmi.getHeight()*0.01, 2)));
    }
}
