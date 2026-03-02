/**
 * Quantity Measurement App - UC6: Addition of Two Length units
 *
 * This class improves on UC5 by adding method to allow addition of two units
 * of different lengths. The method returns a new Length instance with the sum of the
 * input length instances with the new instance's type being that of the first length
 * unit being passed as argument.
 */
package com.bridgelabz;

import java.util.Scanner;

//Main class
public class QuantityMeasurementApp {
    //static method to demonstrate Length Feet equality check
    public static boolean demonstrateFeetEquality(Length length1, Length length2){
        return length1.equals(length2);
    }

    //static method to demonstrate Length Inches equality check
    public static Length demonstrateLengthConversion(double value, Length.LengthUnit from, Length.LengthUnit to) {
        double result = Length.convert(value, from, to);
        return new Length(result, to);
    }

    //static method to demonstrate Length equality between different measurements
    public static Length demonstrateLengthConversion(Length length, Length.LengthUnit toUnit) {
        return length.convertTo(toUnit);
    }

    public static void demonstrateLengthAddition(){
        System.out.println("Adding 1.0 Feet and 1.0 Feet: "
                        +Length.add(
                        new Length(1.0, Length.LengthUnit.FEET),
                        new Length(2.0, Length.LengthUnit.FEET)
                ).value
        );
        System.out.println("Adding 1.0 Feet and 12 Inches: "
                        +Length.add(
                        new Length(1.0, Length.LengthUnit.FEET),
                        new Length(12.0, Length.LengthUnit.INCHES)
                ).value
        );
        System.out.println("Adding 12.0 Inches and 1.0 Feet: "
                        +Length.add(
                        new Length(12.0, Length.LengthUnit.INCHES),
                        new Length(1.0, Length.LengthUnit.FEET)
                ).value
        );

        System.out.println("Adding 1.0 Yards and 3.0 Feet: "
                        +Length.add(
                        new Length(1.0, Length.LengthUnit.YARDS),
                        new Length(3.0, Length.LengthUnit.FEET)
                ).value
        );
        System.out.println("Adding 36.0 Inches and 1.0 Yard: "
                        +Length.add(
                        new Length(36.0, Length.LengthUnit.INCHES),
                        new Length(1.0, Length.LengthUnit.YARDS)
                ).value
        );
        System.out.println("Adding 2.54 Centimeters and 1.0 Inches: "
                        +Length.add(
                        new Length(2.54, Length.LengthUnit.CENTIMETERS),
                        new Length(1.0, Length.LengthUnit.INCHES)
                ).value
        );
        System.out.println("Adding 5.0 Feet and 0.0 Inches: "
                        +Length.add(
                        new Length(5.0, Length.LengthUnit.FEET),
                        new Length(0.0, Length.LengthUnit.INCHES)
                ).value
        );
        System.out.println("Adding 5.0 Feet and 2.0 Feet: "
                        +Length.add(
                        new Length(5.0, Length.LengthUnit.FEET),
                        new Length(-2.0, Length.LengthUnit.FEET)
                ).value
        );
    }

    //main method
    public static void main(String[] args){
        demonstrateLengthAddition();
    }
}
