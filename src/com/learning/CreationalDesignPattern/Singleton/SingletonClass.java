package com.learning.CreationalDesignPattern.Singleton;

public class SingletonClass {
    private static SingletonClass instance;
    public String value;
    private SingletonClass(String value){
        this.value = value;
    }

    public static SingletonClass getInstance(String value){
        if (instance == null){
            instance = new SingletonClass(value);
        }
        return instance;
    }
}
