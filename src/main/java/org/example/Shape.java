package org.example;

public abstract class Shape implements Measurable{
   private String shapeName;

    Shape(String shapeName){
        this.shapeName=shapeName;
    }
   public void displayShapeName(){
      System.out.println(shapeName);
   }
   class ShapeDetails{
       private String shapeColor;
       private boolean isFilled;

       ShapeDetails(String shapeColor,boolean isFilled){
           this.shapeColor=shapeColor;
           this.isFilled=isFilled;
       }

       public void displayShapeDetails(){
           System.out.println(shapeName + " is " + shapeColor + " and " + (isFilled ? "filled." : "not filled."));
       }
   }
}
