package org.example;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
      Circle circle=new Circle(7);
      circle.displayShapeName();
      System.out.println("Circle Area"+" "+ circle.calculateArea());
      Shape.ShapeDetails circleDetails=circle.new ShapeDetails("Green",true);
        circleDetails.displayShapeDetails();

        System.out.println("---------------------------------------------------");

        Rectangle rectangle=new Rectangle(5,9);
        rectangle.displayShapeName();
        System.out.println("Rectangle Area"+" "+rectangle.calculateArea());
        Shape.ShapeDetails rectangleDetails=rectangle.new ShapeDetails("Blue",false);
        rectangleDetails.displayShapeDetails();
    }
}