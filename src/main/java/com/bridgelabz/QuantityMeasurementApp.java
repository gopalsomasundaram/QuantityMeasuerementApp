/**
 * Quantity Measurement App - UC2: Feet and Inches measurement equality
 *
 * This class improves upon UC1 by adding Inches measurement with method similar to
 * Feet. It also adds static methods to remove dependency on main method by adding
 * static methods
 */
package com.bridgelabz;

import java.util.Scanner;

//Main class
public class QuantityMeasurementApp {
    //Inner class to represent feet measurements
    public static class Feet{
        //field to hold value
        private final double feet;
        //parameterized constructor
        Feet(double feet){
            this.feet = feet;
        }

        /**
         * Override of equals method to allow comarision of values
         * between Feet classes
         *
         * here we check:
         * 1. if both references are the same
         * 2. is the passed reference null
         * 3. are both the references of the same class
         * 4. value comparison using Double.compare instead of ==
         *
         * @param obj Object passed to be compared with current instance
         * @return boolean indicating whether values are same or not
         */
        @Override
        public boolean equals(Object obj) {
            if(this == obj){
                return true;
            }
            if(obj == null || getClass() != obj.getClass()){
                return false;
            }

            Feet comClass = (Feet) obj;
            return Double.compare(this.feet,comClass.feet) == 0;
        }
    }

    //Inner class to represent inches measurements
    public static class Inches{
        //field to hold value
        private final double inches;
        //parameterized constructor
        Inches(double inches){
            this.inches = inches;
        }

        /**
         * Override of equals method to allow comarision of values
         * between Inches classes
         *
         * here we check:
         * 1. if both references are the same
         * 2. is the passed reference null
         * 3. are both the references of the same class
         * 4. value comparison using Double.compare instead of ==
         *
         * @param obj Object passed to be compared with current instance
         * @return boolean indicating whether values are same or not
         */
        @Override
        public boolean equals(Object obj) {
            if(this == obj){
                return true;
            }
            if(obj == null || getClass() != obj.getClass()){
                return false;
            }

            Inches comClass = (Inches) obj;
            return Double.compare(this.inches,comClass.inches) == 0;
        }
    }

    //static method to demonstrate Feet equality check
    public static void demonstrateFeetEquality(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter first Feet measurement: ");
        double input1 = scanner.nextDouble();
        System.out.println("Enter second Feet measurement: ");
        double input2 = scanner.nextDouble();

        //object instantiation
        Feet feet1 = new Feet(input1);
        Feet feet2 = new Feet(input2);

        //Feet class equals invocation
        if(feet1.equals(feet2)){
            System.out.println("Both feet object are equal in value");
        }else{
            System.out.println("Both feet object are unequal in value");
        }
    }

    //static method to demonstrate Inches equality check
    public static void demonstrateInchesEquality(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter first Inches measurement: ");
        double input1 = scanner.nextDouble();
        System.out.println("Enter second Inches measurement: ");
        double input2 = scanner.nextDouble();

        //object instantiation
        Inches inches1 = new Inches(input1);
        Inches inches2 = new Inches(input2);

        //Inches class equals invocation
        if(inches1.equals(inches2)){
            System.out.println("Both inches object are equal in value");
        }else{
            System.out.println("Both inches object are unequal in value");
        }
    }

    //main method
    public static void main(String[] args){
        demonstrateFeetEquality();
        demonstrateInchesEquality();
    }
}
