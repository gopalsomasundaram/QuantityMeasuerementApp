/**
 * Quantity Measurement App - UC5: Unit to Unit Conversion
 *
 * This class improves on UC4 by adding the ability to convert unit to any of the
 * other available units in the LengthUnit Enum. This gives the user flexibility and
 * freedom of comparing and converting units.
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

    //main method
    public static void main(String[] args){
        System.out.println("Convert 1.0 FEET to INCHES: " +
                Length.convert(1.0, Length.LengthUnit.FEET, Length.LengthUnit.INCHES));

        System.out.println("Convert 3.0 YARDS to FEET: " +
                Length.convert(3.0, Length.LengthUnit.YARDS, Length.LengthUnit.FEET));

        Length yardLen = new Length(2.0, Length.LengthUnit.YARDS);
        System.out.println("Object Convert 2.0 YARDS to INCHES: " +
                demonstrateLengthConversion(yardLen, Length.LengthUnit.INCHES));
    }
}
