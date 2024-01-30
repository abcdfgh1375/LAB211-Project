package View;

import Controller.calculatorController;
import Model.BMI;
import Model.operator;
import Utils.InputterCal;

public class viewCalculator {

    InputterCal input = new InputterCal();

    public enum operatorChar {
        add('+'),
        sub('-'),
        multi('*'),
        div('/'),
        expo('^'),
        equal('=');
        public final char value;

        operatorChar(char op) {
            this.value = op;
        }
    }

//INPUT
    public double inputAB(String s) {
        String a;
        double res;
        do {
            a = input.getStringFromInput("Enter number " + s + ": ");
            res = checkNum(a);
        } while (res == -1);
        return res;
    }

    public double inputDividerB(String s) {
        String a;
        double res;
        do {
            try {
                a = input.getStringFromInput("Enter number " + s + ": ");
                res = checkNum(a);
                if (res == 0) {
                    throw new ArithmeticException();
                }
            } catch (ArithmeticException e) {
                System.out.println("Cannot divide by zero");
                res = -1;
            }
        } while (res == -1);
        return res;
    }

    public operatorChar inputOper() {
        String oper;
        operatorChar resOper;
        do {
            oper = input.getStringFromInput("Enter operator: ");
            resOper = checkOperator(oper);
        } while (resOper == null);
        return resOper;
    }

    public double inputHW(String msg) {
        double value = 0, res = 0;
        value = input.getDouble(msg, "BMI is digit");
        return value;
    }
//check VALID

    double checkNum(String inputVal) {
        try {
            return Double.parseDouble(inputVal);
        } catch (NumberFormatException e) {
            System.out.println("Please input a valid number!");
            return -1;
        }
    }

    operatorChar checkOperator(String oper) {
        if (oper.length() > 1) {
            System.out.println("Please input (+, -, *, /, ^)");
            return null;
        }
        char o = oper.charAt(0);
        switch (o) {
            case '+' -> {
                return operatorChar.add;
            }
            case '-' -> {
                return operatorChar.sub;
            }
            case '*' -> {
                return operatorChar.multi;
            }
            case '/' -> {
                return operatorChar.div;
            }
            case '^' -> {
                return operatorChar.expo;
            }
            case '=' -> {
                return operatorChar.equal;
            }
        }
        return null;
    }

    //DISPLAY
    public void viewTitle(String title) {
        System.out.println("----- " + title + " -----");
    }

    public void display(String msg, double value) {
        System.out.println(msg + String.format("%.2f", value));
    }

    public void displayBMI(BMI bmi) {
        System.out.println("BMI number: " + String.format("%.2f", bmi.getresBMI()));
        System.out.println("BMI status: " + bmi.getStatus().toString().toUpperCase());
    }

}
