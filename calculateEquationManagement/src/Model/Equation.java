
package Model;

import java.util.ArrayList;
import java.util.HashMap;

public class Equation<T> {
    private HashMap <Character,Float> coefficients;
    private HashMap <String,Float> solutions;
  
    public Equation() {
        this.coefficients = new HashMap<>();
        this.solutions = new HashMap<>();
    }

    public HashMap<Character, Float> getCoefficients() {
        return coefficients;
    }

    public void setCoefficients(HashMap<Character, Float> coefficients) {
        this.coefficients = coefficients;
    }

    public HashMap<String, Float> getSolutions() {
        return solutions;
    }

    public void setSolutions(HashMap<String, Float> solutions) {
        this.solutions = solutions;
    }
    
    
}
