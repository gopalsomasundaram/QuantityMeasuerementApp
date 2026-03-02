package com.bridgelabz;

/**
 * UC10 Quantity Measurement Application
 * This Use case improves on UC9 by replacing the similar LengthUnit and WeightUnit
 * Enums with a generic Unit to avoid repetition of code
 */
public class QuantityMeasurementApp {

    public static <U extends IMeasurable> boolean demonstrateEquality(Quantity<U> q1, Quantity<U> q2) {
        return q1.equals(q2);
    }

    public static <U extends IMeasurable> double demonstrateConversion(Quantity<U> q, U target) {
        return q.convertTo(target);
    }

    public static <U extends IMeasurable> Quantity<U> demonstrateAddition(Quantity<U> q1, Quantity<U> q2, U target) {
        return q1.add(q2, target);
    }

    public static void main(String[] args) {
        // Demonstration of Weight and Length using the same generic methods [cite: 2922, 2924]
        Quantity<WeightUnit> w1 = new Quantity<>(1.0, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> w2 = new Quantity<>(1000.0, WeightUnit.GRAM);
        System.out.println("Weights Equal: " + demonstrateEquality(w1, w2));
    }
}