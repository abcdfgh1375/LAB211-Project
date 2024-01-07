package Model;

import java.util.*;
import java.util.Random;

public class Element {

    static Scanner sc = new Scanner(System.in);

    public Element() {
    }

    public Element(int size, int[] value) {
        this.size = size;
        this.value = value;
    }

    private int size;
    private int[] value;

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int[] getValue() {
        return value;
    }

    public void setValue(int[] value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Element{" + "size=" + size + ", value=" + Arrays.toString(value) + '}';
    }

    public int getPositiveIntFromInput(String msg) {
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

    public int getIntFromInput(String msg) {
        Scanner sc = new Scanner(System.in);
        int number;
        while (true) {
            System.out.print(String.format("%s: ", msg));
            try {
                number = sc.nextInt();
                if (number >= 0) {
                    return number;
                } else {
                    System.err.println("Please enter the integer number >= 0 ");
                }
            } catch (InputMismatchException e) {
                System.err.println("Just input the integer number ");
                sc.next();
            }
        }
    }

}
