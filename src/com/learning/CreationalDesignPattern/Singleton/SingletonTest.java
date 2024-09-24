package com.learning.CreationalDesignPattern.Singleton;

public class SingletonTest {
    public static void main(String[] args) {
        SingletonClass sing = SingletonClass.getInstance("hello");
        SingletonClass sing1 = SingletonClass.getInstance("hellllo");
        System.out.println(sing.value);
        System.out.println(sing1.value);
        System.out.println(sing == sing1);

    }
}
