
package Controller;

import View.Menu;
import java.util.Arrays;
public class mainController extends Menu {

    calculatorController cal;
    bmiController bmi;

    public mainController() {
        super("Calculator Program", Arrays.asList(new String[]{"Normal Calculator", "BMI Calculator", "Exit"}));
        cal = new calculatorController();
        bmi = new bmiController();
    }
    
    enum menu{
        NormalCalculator,BMICalculator,Exit;
    }
    public menu convertEnim(int choice){
        switch(choice){
            case 1 -> {return menu.NormalCalculator;}
            case 2 ->{return menu.BMICalculator;}
            case 3 ->{return menu.Exit;}       
        }
        return null;
    }

    @Override
    public void execute(int choice) {
        menu m = convertEnim(choice);
        switch (m) {
            case NormalCalculator -> cal.runCalculate();
            case BMICalculator -> bmi.runCalculate();
            case Exit -> System.exit(0);
        }
    }


}
