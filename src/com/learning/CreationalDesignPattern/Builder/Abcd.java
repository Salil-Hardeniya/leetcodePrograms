package com.learning.CreationalDesignPattern.Builder;

import com.learning.CreationalDesignPattern.Builder.Sample;
import com.learning.CreationalDesignPattern.Builder.VehicleBuilderPattern;

public class Abcd {


    public static void main(String[] args) {
        Sample sample = Sample.sampleBuilder()
                        .setA(2).setB(3).setC(4).setD(5).build();

        System.out.println(sample.getA());
        System.out.println(sample.getB());
        System.out.println(sample.getC());
        System.out.println(sample.getD());

        VehicleBuilderPattern vehicle = VehicleBuilderPattern.builder()
                .company("Toyota")
                .seatCount(5)
                .color("Black")
                .fuelCapacity(50)
                .build();

        System.out.println(vehicle.color);
        System.out.println(vehicle.seatCount);
        System.out.println(vehicle.company);
        System.out.println(vehicle.fuelCapacity);
        System.out.println(vehicle);

       String str = "aaaaaaaaaa";

       str.chars().map(x -> (char) x).forEach(System.out::println);

        System.out.println((char) 97);

    }
}
