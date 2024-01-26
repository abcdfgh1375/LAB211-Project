package Controller;

import Utils.InputterEqua;
import View.Menu;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class equationController<T> extends Menu {

    private static String[] list = {"Calculate Superlative Equation", "Calculate Quadratic Equation", "Exit"};
    InputterEqua input;
    HashMap<Character, Float> coefficients;

    public equationController() {
        super(" Equation Program ", Arrays.asList(list));
        this.input = new InputterEqua();
        this.coefficients = new HashMap();
    }

    @Override
    public void execute(int choice) {
        switch (choice) {
            case 1:
                createCoefficients(coefficients, 1);
                break;
            case 2:
                createCoefficients(coefficients, 2);
                break;
            default:
                System.exit(0);
        }
    }

    //function 1: input coefficients 2 type equation
    public void createCoefficients(HashMap<Character, Float> coefficients, int type) {//--mainFT1
        coefficients = new HashMap<>();
        inputTypeCoefficients(coefficients, type);
        HashMap<String, Float> solutions = new HashMap<>();
        switch (type) {
            case 1:
                solutions = calSolutionSuperlativeEquation(coefficients);
                break;
            case 2:
                solutions = calSolutionQuadaricEquation(coefficients);
                break;
        }
        displaySolution(solutions);
        determineTypeNumList(coefficients, solutions);
    }

    private HashMap<Character, Float> inputTypeCoefficients(HashMap<Character, Float> coefficients, int type) {
        switch (type) {
            case 1:
                inputCoefficients(coefficients, 2);
                break;
            case 2:
                inputCoefficients(coefficients, 3);
                break;
        }
        return coefficients;
    }

    private HashMap<Character, Float> inputCoefficients(HashMap<Character, Float> coefficients, int num) {
        Character c = 'A';
        for (int i = 0; i < num; i++, c++) {
            do {
                coefficients.put(c, input.getFloatFromInput("Enter " + c + ": ", -10000));
            } while (c == 'A' && coefficients.get(c) == 0);
        }
        return coefficients;
    }

    private void displayCoefficients(HashMap<Character, Float> coefficients) {
        System.out.println(Arrays.asList(coefficients));
    }

    //function 2: find solution for superlative equation
    private void findSolutionSuperlativeEquation(HashMap<Character, Float> coefficients) {
        displaySolution(calSolutionSuperlativeEquation(coefficients));
    }

    public HashMap<String, Float> calSolutionSuperlativeEquation(HashMap<Character, Float> coefficients) {//--mainFT2
        HashMap<String, Float> solution = new HashMap<>();
        float x = (0 - coefficients.get('B')) / coefficients.get('A');
        solution.put("x", x);
        return solution;
    }

    private void displaySolution(HashMap<String, Float> solution) {
        if (solution.values().stream().anyMatch(value -> value == null)) {
            System.out.println("Solution: x = null\nThe equation has no solution.");
        } 
/*if (solution.values().stream().allMatch(value -> value == null)) {
    System.out.println("Solution: x = null");
}*/ else if (solution.size() < 2) {
//         System.out.println("Solution: " + Arrays.asList(solution));
            solution.forEach((key, value) -> System.out.println("Solution: " + key + " = " + String.format("%.2f", value)));
        } else if (solution.get("x1").equals(solution.get("x2"))) {
            System.out.println("Solution: x1 = x2 = " + String.format("%.2f", solution.get("x1")));
        } else {
            System.out.print("Solution: ");
            solution.forEach((key, value) -> System.out.print(key + " = " + String.format("%.2f", value) + ", "));
            System.out.println();
        }
    }

    //function 3: find solution for quadraic equation
    public void findSolutionQuadaricEquation(HashMap<Character, Float> coefficients) {//--mainFT2
        displaySolution(calSolutionQuadaricEquation(coefficients));
    }

    public HashMap<String, Float> calSolutionQuadaricEquation(HashMap<Character, Float> coefficients) {
        HashMap<String, Float> solution = new HashMap<>();
        float delta = (float) (Math.pow(coefficients.get('B'), 2) - (4 * coefficients.get('A') * coefficients.get('C')));
        if (delta == 0) {
            float x = (-coefficients.get('B')) / (2 * coefficients.get('A'));
            solution.put("x1", x);
            solution.put("x2", x);
        } else if (delta > 0) {
            float x1 = (float) (((-coefficients.get('B')) + Math.sqrt(delta)) / 2 * coefficients.get('A'));
            float x2 = (float) (((-coefficients.get('B')) - Math.sqrt(delta)) / 2 * coefficients.get('A'));
            solution.put("x1", x1);
            solution.put("x2", x2);
        } else if (delta < 0) {
            solution.put("x", null);
        }
        return solution;
    }

    //function 4: find square, even, odd num
    public void determineTypeNumList(HashMap<Character, Float> coefficients, HashMap<String, Float> solution) {//--mainFT4
        displayTypeNumList(mergeHashMapValue(coefficients, solution));
    }

    private ArrayList<Float> mergeHashMapValue(HashMap<Character, Float> coefficients, HashMap<String, Float> solution) {
        ArrayList<Float> list = new ArrayList();
        for (Character c : coefficients.keySet()) {
            if (coefficients.get(c) == null) {
                break;
            }
            list.add(coefficients.get(c));
        }
        for (String c : solution.keySet()) {
            if (solution.get(c) == null) {
                break;
            }
            list.add(solution.get(c));
        }
        return list;
    }

    private void displayTypeNumList(ArrayList<Float> list) {
        displayList("Odd Number(s):", takeOddList(list));
        displayList("Number is Even:", takeEvenList(list));
        displayList("Number is Perfect Square:", takePerfectSquareList(list));
    }

    private ArrayList<T> takePerfectSquareList(ArrayList<Float> list) {
        ArrayList<Float> listSquare = new ArrayList();
        for (int k = 0; k < list.size(); k++) {
            if (checkPerfectSquareNum(list.get(k))) {
                listSquare.add(list.get(k));
            }
        }
        return (ArrayList<T>) listSquare;
    }

    private ArrayList<T> takeOddList(ArrayList<Float> list) {
        ArrayList<Float> listOdd = new ArrayList();
        for (int k = 0; k < list.size(); k++) {
            if (!checkEvenNum(list.get(k))) {
                listOdd.add(list.get(k));
            }
        }
        return (ArrayList<T>) listOdd;
    }

    private ArrayList<T> takeEvenList(ArrayList<Float> list) {
        ArrayList<Float> listEven = new ArrayList();
        for (int k = 0; k < list.size(); k++) {
            if (checkEvenNum(list.get(k))) {
                listEven.add(list.get(k));
            }
        }
        return (ArrayList<T>) listEven;
    }

    private void displayList(String msg, ArrayList<T> arrL) {
        if(arrL.isEmpty()){
            System.out.println("List of " + msg + " is empty!");
            return;
        }
        System.out.print(msg);
        boolean first = true;
        for (T obj : arrL) {
            if (first == true) {
                System.out.print(" " + String.format("%.2f", obj));
                first = false;
            } else {
                System.out.print(", " + String.format("%.2f", obj));
            }
        }
        System.out.println();
    }

    private boolean checkPerfectSquareNum(Float num) {
        int sqrt = (int) Math.sqrt(num);
        return (sqrt * sqrt == num);
    }

    private boolean checkEvenNum(Float num) {
        if (num % 2 == 0) {
            return true;
        } else {
            return false;
        }
    }
}
