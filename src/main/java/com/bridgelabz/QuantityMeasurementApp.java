/**
 * Quantity Measurement App - UC1: Feet Measurement equality
 *
 * This class is responsible for checking the equality of two numerical
 * values measured in feet in the Quantity Measurement Application
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

            }
            if(obj == null || getClass() != obj.getClass()){
                return false;
            }

            Feet comClass = (Feet) obj;
            return Double.compare(this.feet,comClass.feet) == 0;
        }
    }
    //main method
    public static void main(String[] args){
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
}
