package org.example;

public class Circle extends Shape{
    private double radius;

    Circle(double radius){
        super("Circle");
        this.radius=radius;
    }

    @Override
    public double calculateArea() {
        return radius*radius*Math.PI;
    }
}
