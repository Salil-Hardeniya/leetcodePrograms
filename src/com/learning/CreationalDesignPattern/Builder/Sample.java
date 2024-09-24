package com.learning.CreationalDesignPattern.Builder;

import lombok.Getter;

@Getter
public class Sample {

    private int a;
    private int b;
    private int c;
    private int d;

    public static Sample sampleBuilder(){
        return new Sample();
    }

    public Sample setA(int v){
        this.a = v;
        return this;
    }
    public Sample setB(int v){
        this.b = v;
        return this;
    }
    public Sample setC(int v){
        this.c = v;
        return this;
    }
    public Sample setD(int v){
        this.d = v;
        return this;
    }

    public Sample build(){
        return this;
    }

    public static class PrototypePattern {

    }
}

