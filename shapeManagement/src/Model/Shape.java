/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author THANH HUYEN
 */
public abstract class Shape {

    public void printResult() {
        System.out.println(String.format("%s%.2f", "Area: ", getArea()));
        System.out.println(String.format("%s%.2f", "Perimeter: ",getPerimeter()));
    }

    ;
    abstract double getArea();

    abstract double getPerimeter();
}
