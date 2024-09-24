package com.learning.CreationalDesignPattern.Prototype;

public class Circle extends Shape {
    int radius;

    Circle(){}

    @Override
    public Circle clone() {
        return new Circle(this);
    }

    Circle(Circle circle){
        super(circle);
        if(circle != null){
            this.radius = circle.radius;
        }
    }

    @Override
    public boolean equals(Object obj){
        if(!(obj instanceof Circle circle))
            return false;
        boolean supCheck = super.equals(obj);
        return supCheck && this.radius == circle.radius;
    }

    @Override
    public String toString(){
        return """
                {x : %d , y : %d , radius : %d , color : %s}
                """.formatted(x,y,radius,color);
    }
}
