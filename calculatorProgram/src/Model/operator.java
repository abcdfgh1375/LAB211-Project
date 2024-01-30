package Model;

public class operator {
    private double a;
    private double b;
    private double res;
    private char operator;
    private singleOperator operType;

    public operator() {
    }

    public enum singleOperator {
        ADDITION, SUBTRACTION, MULTIPLICATION, DIVISION, EXPONENTIATION;
    }

    public operator(double a, double b, double res, char operator, singleOperator operType) {
        this.a = a;
        this.b = b;
        this.res = res;
        this.operator = operator;
        this.operType = operType;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getRes() {
        return res;
    }

    public void setRes(double res) {
        this.res = res;
    }

    public char getOperator() {
        return operator;
    }

    public void setOperator(char operator) {
        this.operator = operator;
    }

    public singleOperator getOperType() {
        return operType;
    }

    public void setOperType(char c) {
        switch(c){
            case '+' -> this.operType = singleOperator.ADDITION;
            case '-' -> this.operType = singleOperator.SUBTRACTION;
            case '*' -> this.operType = singleOperator.MULTIPLICATION;
            case '/' -> this.operType = singleOperator.DIVISION;
            case '^' -> this.operType = singleOperator.EXPONENTIATION;
        }
    }  
    
// public void setOperType(singleOperator c) {
//        this.operType = c;
//    }  
 
    @Override
    public String toString() {
        return "operator{" + a +" " + operator + " "+ b + " = " + res + ", " + operType + '}';
    }

}
