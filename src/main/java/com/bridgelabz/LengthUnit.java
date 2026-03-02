package com.bridgelabz;

/**
 * UC8: Standalone LengthUnit Enum
 * Extracted into a top-level class to eliminate circular dependencies[cite: 17, 38].
 * This class now handles all unit-specific conversion logic[cite: 18].
 */
public enum LengthUnit {
    FEET(12.0),
    INCHES(1.0),
    YARDS(36.0),
    CENTIMETERS(0.393701);

    private final double conversionFactor;

    LengthUnit(double conversionFactor) {
        this.conversionFactor = conversionFactor;
    }

    public double getConversionFactor() {
        return conversionFactor;
    }

    /**
     * Converts a value in this unit to the base unit (Inches)[cite: 20].
     * Added as a new responsibility in UC8[cite: 125].
     */
    public double convertToBaseUnit(double value) {
        return value * this.conversionFactor;
    }

    /**
     * Converts a base unit value (Inches) to this specific unit[cite: 21].
     * Added as a new responsibility in UC8[cite: 130].
     */
    public double convertFromBaseUnit(double baseValue) {
        return baseValue / this.conversionFactor;
    }
}