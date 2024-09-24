package com.learning.CreationalDesignPattern.Prototype;

public class PrototypeClass {
    public static void main(String[] args) {
        Circle circle = new Circle();
        circle.radius = 10;
        circle.color = "red";
        circle.x = 5;
        circle.y = 6;

        Circle newCircle = circle.clone();
        System.out.println(circle);
        System.out.println(newCircle == circle);
        System.out.println(newCircle.equals(circle));
        System.out.println(newCircle);
    }
}
