package com.learning.CreationalDesignPattern.Prototype;

import java.util.Objects;

public abstract class Shape {
    int x;
    int y;
    String color;

    Shape(){}

    Shape(Shape shape){
        if(shape != null){
            this.x = shape.x;
            this.y = shape.y;
            this.color = shape.color;
        }
    }

    public abstract Shape clone();

    @Override
    public boolean equals(Object obj){
        if(!(obj instanceof Shape shape))
            return false;
        return Objects.equals(this.color, shape.color) && this.x == shape.x && this.y == shape.y;
    }
}
