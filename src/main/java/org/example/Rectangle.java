package org.example;

public class Rectangle extends Shape{
    private double length;
    private double width;

    Rectangle(double length,double width){
        super("Rectangle");
        this.length=length;
        this.width=width;
    }

    @Override
    public double calculateArea(){
        return length*width;
    }
}
