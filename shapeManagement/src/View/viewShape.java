
package View;

import Model.*;
import java.util.stream.Stream;

public class viewShape {

    inputterShape in = new inputterShape();
    
    public Rectangle getInputRect() {
        Rectangle r = new Rectangle(in.inputDouble("Please input side width of Rectangle: "), 
                in.getDouble("Please input length of Rectangle: "));
        return r;
    }

    public Triangle getInputTri() {
        Triangle r = new Triangle(in.inputDouble("Please input side A of Triangle: "), 
                in.getDouble("Please input side B of Triangle: "), in.getDouble("Please input side C of Triangle: "));
        return r;
    }
    public Circle getInputCir(){
        Circle c = new Circle(in.inputDouble("Please input radius of Circle: "));
        return c;
    }
    //display
    
    public void displayTitle(String msg, char c) {
        Stream.generate(() -> c).limit(5).forEach(System.out::print);
        System.out.print(" " + msg + " ");
        Stream.generate(() -> c).limit(5).forEach(System.out::print);
        System.out.println();
    }
    public void displayRec(Rectangle r){        
        displayTitle("Rectangle",'-');
        System.out.println("Width: "+r.getWidth());
        System.out.println("Length: "+ r.getLength());
        r.printResult();
    }
    public void displayTri(Triangle t){
        displayTitle("Triangle",'-');
        System.out.println("Side A: "+ t.getSideA());
        System.out.println("Side B: "+ t.getSideB());
        System.out.println("Side C: "+ t.getSideC());
        t.printResult();
    }
    public void displayCir(Circle c){
        displayTitle("Circle",'-');
        System.out.println("Radius: " + c.getRadius());
        c.printResult();
    }
}
