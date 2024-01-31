package Controller;

import Model.*;
import static Model.operator.singleOperator.ADDITION;
import static Model.operator.singleOperator.DIVISION;
import static Model.operator.singleOperator.EXPONENTIATION;
import static Model.operator.singleOperator.MULTIPLICATION;
import static Model.operator.singleOperator.SUBTRACTION;
import View.viewCalculator;

public class calculatorController {


//main ACTIVE
    public void runCalculate() throws NullPointerException {
            viewCalculator view = new viewCalculator();
        operator o = new operator();
        view.viewTitle("Normal Calculator");
        try {
            char oper;
            boolean first = true;
            boolean firstOpe = true;
            do {
                if (first) {
                    o.setA(view.inputAB("a"));
                    first = false;
                }
                do {
                    oper = view.inputOper().value;
                    o.setOperator(oper);
                } while (firstOpe && o.getOperator() == '=');
                firstOpe = true;
                if (oper != '=') {
                    if (firstOpe) {
                        if (o.getOperator() == '/') {
                            o.setB(view.inputDividerB("b"));
                        } else {
                            o.setB(view.inputAB("b"));
                        }
                        o.setOperType(oper);
                        calculate(o);
                        view.displayEle("Memory: ", o.getRes());
                    } else {
                        view.displayEle("Memory: ", o.getA());
                        o.setOperType(oper);
                        if (o.getOperator() == '/') {
                            o.setB(view.inputDividerB("b"));
                        } else {
                            o.setB(view.inputAB("b"));
                        }
                        calculate(o);
                    }
                    firstOpe = false;
                }
            } while (oper != '=');
            view.displayEle("Result: ", o.getRes());
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
    }

//COMPUTE
    public operator addition(operator a) {
        a.setRes(a.getA() + a.getB());
        return a;
    }

    public operator subtraction(operator a) {
        a.setRes(a.getA() - a.getB());
        return a;
    }

    public operator multiplication(operator a) {
        a.setRes(a.getA() * a.getB());
        return a;
    }

    public operator division(operator a) {
        try {
            a.setRes(a.getA() / a.getB());
        } catch (ArithmeticException e) {
            System.out.println(e.getCause());
        }
        return a;
    }

    public operator exponent(operator a) {
        a.setRes(Math.pow(a.getA(), a.getB()));
        return a;
    }

    public void calculate(operator o) {
        operator.singleOperator re = o.getOperType();
        switch (re) {
            case ADDITION -> {
                addition(o);
                o.setA(o.getRes());
            }
            case SUBTRACTION -> {
                subtraction(o);
                o.setA(o.getRes());
            }
            case MULTIPLICATION -> {
                multiplication(o);
                o.setA(o.getRes());
            }
            case DIVISION -> {
                division(o);
                o.setA(o.getRes());
            }
            case EXPONENTIATION -> {
                exponent(o);
                o.setA(o.getRes());
            }
        }
    }
}
