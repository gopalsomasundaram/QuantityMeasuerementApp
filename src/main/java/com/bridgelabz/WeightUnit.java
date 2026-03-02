package com.bridgelabz;

/**
 * UC9: WeightUnit Enum
 * Manages weight units and their conversion factors relative to Grams. [cite: 896, 912]
 */
public enum WeightUnit {
    MILLIGRAM(0.001),
    GRAM(1.0),
    KILOGRAM(1000.0),
    POUND(453.592),
    TONNE(1_000_000.0);

    private final double conversionFactor;

    WeightUnit(double conversionFactor) {
        this.conversionFactor = conversionFactor;
    }

    public double getConversionFactor() {
        return conversionFactor;
    }

    /**
     * Converts value from this unit to the base unit (Grams). [cite: 842, 912]
     */
    public double convertToBaseUnit(double value) {
        return value * this.conversionFactor;
    }

    /**
     * Converts a base unit value (Grams) to this unit, rounded to two decimal places. [cite: 843, 1001]
     */
    public double convertFromBaseUnit(double baseValue) {
        return Math.round((baseValue / this.conversionFactor) * 100.0) / 100.0;
    }
}