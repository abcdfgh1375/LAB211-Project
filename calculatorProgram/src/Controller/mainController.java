
package Controller;

import View.Menu;
import java.util.Arrays;
import java.util.stream.Stream;

public class mainController extends Menu {

    calculatorController cal;
    bmiController bmi;

    public mainController() {
        super("Calculator Program", Arrays.asList(new String[]{"Normal Calculator", "BMI Calculator", "Exit"}));
        cal = new calculatorController();
        bmi = new bmiController();
    }
    @Override
    public void display() {
        Stream.generate(() -> "=").limit(5).forEach(System.out::print);
        System.out.print(" "+ this.title + " ");
        Stream.generate(() -> "=").limit(5).forEach(System.out::print);
        System.out.println();
        for (int i = 0; i < list.size(); i++) {
            System.out.println((i + 1) + ". " + list.get(i));
        }
//        System.out.println(Stream.generate(() -> "=").limit(70).collect(Collectors.joining()));
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
