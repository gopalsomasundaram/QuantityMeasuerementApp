/**
 * Quantity Measurement App - UC4: Extended Unit Support
 *
 * This class improves on UC3 by adding support for more types of
 * measurements, namely: yards and centimeters
 */
package com.bridgelabz;

import java.util.Scanner;

//Main class
public class QuantityMeasurementApp {
    //static method to demonstrate Length Feet equality check
    public static void demonstrateFeetEquality(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter first Feet measurement: ");
        double input1 = scanner.nextDouble();
        System.out.println("Enter second Feet measurement: ");
        double input2 = scanner.nextDouble();

        //object instantiation
        Length feet1 = new Length(input1, Length.LengthUnit.FEET);
        Length feet2 = new Length(input2, Length.LengthUnit.FEET);

        //Length class equals invocation
        if(feet1.equals(feet2)){
            System.out.println("Both feet object are equal in value");
        }else{
            System.out.println("Both feet object are unequal in value");
        }
    }

    //static method to demonstrate Length Inches equality check
    public static void demonstrateInchesEquality(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter first Inches measurement: ");
        double input1 = scanner.nextDouble();
        System.out.println("Enter second Inches measurement: ");
        double input2 = scanner.nextDouble();

        //object instantiation
        Length inches1 = new Length(input1, Length.LengthUnit.INCHES);
        Length inches2 = new Length(input2, Length.LengthUnit.INCHES);

        //Length class equals invocation
        if(inches1.equals(inches2)){
            System.out.println("Both inches object are equal in value");
        }else{
            System.out.println("Both inches object are unequal in value");
        }
    }

    //static method to demonstrate Length equality between different measurements
    public static void demonstrateFeetInchesEquality(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter first Feet measurement: ");
        double input1 = scanner.nextDouble();
        System.out.println("Enter second Inches measurement: ");
        double input2 = scanner.nextDouble();

        //object instantiation
        Length inches1 = new Length(input1, Length.LengthUnit.FEET);
        Length inches2 = new Length(input2, Length.LengthUnit.INCHES);

        //Length class equals invocation
        if(inches1.equals(inches2)){
            System.out.println("Both are equal in value");
        }else{
            System.out.println("Both are unequal in value");
        }
    }

    //main method
    public static void main(String[] args){
        demonstrateFeetEquality();
        demonstrateInchesEquality();
        demonstrateFeetInchesEquality();
    }
}
