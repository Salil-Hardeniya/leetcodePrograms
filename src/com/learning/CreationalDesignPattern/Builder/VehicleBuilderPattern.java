package com.learning.CreationalDesignPattern.Builder;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
public class VehicleBuilderPattern {
    Integer fuelCapacity;
    String color;
    Integer seatCount;
    String company;

    @Override
    public String toString(){
        return """
                { fuelCapacity : %d, color : %s, seatCount: %d, company : %s }
                """.formatted(fuelCapacity,color,seatCount,company);

//        return String.format("{ fuelCapacity : %d, color : %s, seatCount: %d, company : %s }", fuelCapacity,color,seatCount,company);

    }

    public static class VehicleBuilder{
        Integer fuelCapacity;
        String color;
        Integer seatCount;
        String company;


        public VehicleBuilder fuelCapacity(Integer val){
            this.fuelCapacity = val;
            return this;
        }
        public VehicleBuilder color(String val){
            this.color = val;
            return this;
        }
        public VehicleBuilder seatCount(Integer val){
            this.seatCount = val;
            return this;
        }
        public VehicleBuilder company(String val){
            this.company = val;
            return this;
        }

        public VehicleBuilderPattern build(){
            return new VehicleBuilderPattern(fuelCapacity,color,seatCount,company);
        }

    }

    public static VehicleBuilder builder(){
        return  new VehicleBuilder();
    }

}
