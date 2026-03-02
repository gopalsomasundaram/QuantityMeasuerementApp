package com.bridgelabz;

public class QuantityMeasurementApp {

    // Weight Functionality [cite: 1440]
    public static boolean demonstrateWeightEquality(Weight w1, Weight w2) {
        return w1.equals(w2);
    }

    public static Weight demonstrateWeightConversion(double value, WeightUnit from, WeightUnit to) {
        return new Weight(value, from).convertTo(to);
    }

    public static Weight demonstrateWeightAddition(Weight w1, Weight w2, WeightUnit target) {
        return w1.add(w2, target);
    }

    // Length Functionality (Retained from UC8) [cite: 1576]
    public static boolean demonstrateLengthEquality(Length l1, Length l2) {
        return l1.equals(l2);
    }

    public static void main(String[] args) {
        // Example UC9 Output [cite: 1806]
        Weight kg = new Weight(1.0, WeightUnit.KILOGRAM);
        Weight gram = new Weight(1000.0, WeightUnit.GRAM);
        System.out.println("1kg == 1000g: " + kg.equals(gram));
    }
}