/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Circle;
import Model.Rectangle;
import Model.Triangle;
/**
 *
 * @author THANH HUYEN
 */import View.viewShape;
public class shapeController {
    public viewShape view = new viewShape();
    public void run(){           
        view.displayTitle("Calculator Shape Program",'=');
        Rectangle r = view.getInputRect();
        Circle c = view.getInputCir();
        Triangle t = view.getInputTri();
        view.displayRec(r);
        view.displayCir(c);
        view.displayTri(t);
    }
}
