package com.bridgelabz;

/**
 * UC8: Quantity Measurement App
 * Demonstrates the use of the standalone LengthUnit class[cite: 297, 298].
 */
public class QuantityMeasurementApp {

    public static boolean demonstrateLengthEquality(Length length1, Length length2) {
        return length1.equals(length2);
    }

    public static Length demonstrateLengthConversion(double value, LengthUnit from, LengthUnit to) {
        double result = Length.convert(value, from, to);
        return new Length(result, to);
    }

    public static void demonstrateLengthAddition() {
        // Example: Adding 1.0 Feet and 12.0 Inches to get 2.0 Feet
        Length result = Length.add(
                new Length(1.0, LengthUnit.FEET),
                new Length(12.0, LengthUnit.INCHES),
                LengthUnit.FEET
        );
        System.out.println("Adding 1.0 Feet and 12 Inches: " + result.value + " " + result.getUnit());
    }

    public static void main(String[] args) {
        demonstrateLengthAddition();
    }
}