package Stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MainPostfix {

    public static void main(String[] args) {
        PostfixExpression cal = new PostfixExpression();
        cal.run();
    }
}
//  ^ là ký tự bắt đầu chuỗi.
//[\\d\\s+\\-*/] là một ký tự bất kỳ trong tập hợp các ký tự sau:
//\\d là một chữ số.
//\\s là khoảng trắng.
//+, -, *, / là các phép toán cộng, trừ, nhân, chia.
//* là ký tự đại diện cho số lượng ký tự bất kỳ, có thể là 0. 

class PostfixExpression {
    Node head,tail;
    LinkedStack linkedStack = new LinkedStack();

    public void run() {
        ViewClass input = new ViewClass();
        Scanner sc = new Scanner(System.in);
        ArrayList<String> listPostFix = new ArrayList<>(Arrays.asList("Input & evaluate postfix expression", "Translate to postfix notation", "Exit"));
        input.display("Postfix Expression Management", listPostFix);
        int choice = input.inputPositiveInt("Enter your choice");
        String cont;
        do {
            switch (choice) {
                case 1:
                    String op = "23+64-*2/"; // [(2+3)*(6-4)]/2
                    op = input.inputPattern("Input the postfix operation: ", "^[\\d\\s+\\-*/]*$");
                    System.out.println(postfixCal(op));
                    break;
                case 2:
                    op = input.inputPattern("Input the infix operation: ", "^[0-9+\\-*/()\\[\\]]+$");
                    System.out.println(Arrays.toString(translateToPostfix(op)));;
                    break;
                case 3:
                    System.exit(0);
            }
            System.out.println("Do you want to continue? Y/N");
            cont = sc.nextLine();
        } while (cont.equalsIgnoreCase("Y"));
    }
    public boolean isEmpty() {
        return (head == null);
    }
    public int postfixCal(String str) throws EmptyStackException {
        int res = 0;
        char[] arr = str.trim().toCharArray();
        for (char c : arr) {
            if (Character.isDigit(c)) {
                linkedStack.push(Character.getNumericValue(c));
            } else if (c == '+' || c == '-' || c == '*' || c == '/') {
                int temp1 = linkedStack.pop();
                int temp2 = linkedStack.pop();
                linkedStack.push(applyOperator(c, temp1, temp2));
            }
        }
        res = linkedStack.pop();
        return res;
    }

    int applyOperator(char operator, int operand1, int operand2) {
        switch (operator) {
            case '+':
                return operand1 + operand2;
            case '-':
                return operand2 - operand1;
            case '*':
                return operand1 * operand2;
            case '/':
                if (operand1 != 0) {
                    return operand2 / operand1;
                } else {
                    throw new ArithmeticException("Cannot divide by zero");
                }
            default:
                break;
        }
        return 0;
    }
    
    char[] translateToPostfix(String str) throws NullPointerException{
        char[] arr = str.toCharArray();
        int count = 0;
        for(char c : arr){
            if(Character.isDigit(c)){
                if(count > 0){
                    for(int i = 0; i< count;i++){
                    int temp1 = linkedStack.pop();
                    Node nNode = new Node(temp1,null);
                    tail.next = nNode; tail = nNode;
                    }
                    count = 0;
                }
            if(this.isEmpty()){
                this.head = this.tail = new Node(Character.getNumericValue(c),null);}
            }else {
                Node nNode = new Node(Character.getNumericValue(c),null);
                this.tail.next = nNode; this.tail = nNode;
            }
            if(c=='+'||c=='-'||c=='*'||c=='/'){
                linkedStack.push(c);
            }
            if(c==')'||c==']'){
                count++;
            }
        }
        int j = 0;
        for(Node i = this.head; i != null; i = i.next,j++){
            if(i.next == null)
            {
                arr[arr.length-1]=(char)i.info;
                break;
            }
            arr[j]=(char)i.info;
        }
        return arr;
    }
    
}

class Node {

    public int info;
    public Node next;

    public Node(int x, Node p) {
        info = x;
        next = p;
    }

    public Node(int x) {
        this(x, null);
    }
}

class LinkedStack {

    protected Node head;

    public LinkedStack() {
        head = null;
    }

    public boolean isEmpty() {
        return (head == null);
    }

    public void push(int x) {
        head = new Node(x, head);
    }

    int top() throws EmptyStackException {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return (head.info);
    }

    public int pop() throws EmptyStackException {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        int x = head.info;
        head = head.next;
        return (x);
    }
}

class ViewClass {

    public String inputPattern(String msg, String pattern) {
        Scanner sc = new Scanner(System.in);
        String data;
        do {
            System.out.println(msg);
            data = sc.nextLine();
        } while (!data.matches(pattern));
        return data;
    }

    public void display(String title, ArrayList<String> list) {
        System.out.println(title);
        for (int i = 0; i < list.size(); i++) {
            System.out.println((i + 1) + ". " + list.get(i));
        }
    }

    public int inputPositiveInt(String msg) {
        Scanner sc = new Scanner(System.in);
        int number;
        while (true) {
            System.out.print(String.format("%s: ", msg));
            try {
                number = sc.nextInt();
                if (number > 0) {
                    return number;
                } else {
                    System.err.println("Please enter the integer number > 0 ");
                }
            } catch (InputMismatchException e) {//exception về datatype của đầu vào
                System.err.println("Just input the integer number ");
                sc.next();
            }
        }
    }
}
