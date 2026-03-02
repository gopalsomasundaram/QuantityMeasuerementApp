package com.bridgelabz;

/**
 * UC8: Refactored Length class.
 * Delegated unit conversion responsibilities to the standalone LengthUnit enum[cite: 150].
 * This class now focuses solely on value comparison and arithmetic logic[cite: 26, 164].
 */
public class Length {

    public double value;
    private LengthUnit unit;

    public Length(double value, LengthUnit unit) {
        if (unit == null)
            throw new IllegalArgumentException("Unit Type must be provided and cannot be null");
        this.unit = unit;
        this.value = value;
    }

    /**
     * Static conversion method using delegation to LengthUnit[cite: 161].
     */
    public static double convert(double value, LengthUnit sourceUnit, LengthUnit targetUnit) {
        if (targetUnit == null || sourceUnit == null || Double.isNaN(value))
            throw new IllegalArgumentException("Target unit cannot be null");

        // Delegate conversion to the units [cite: 25]
        double valueInInches = sourceUnit.convertToBaseUnit(value);
        return targetUnit.convertFromBaseUnit(valueInInches);
    }

    public LengthUnit getUnit() {
        return this.unit;
    }

    public Length convertTo(LengthUnit targetUnit) {
        double convertedValue = convert(this.value, this.unit, targetUnit);
        return new Length(convertedValue, targetUnit);
    }

    /**
     * UC8 Addition: Converts both operands to base unit, adds them, 
     * and converts back to the target unit[cite: 447].
     */
    public static Length add(Length length1, Length length2, LengthUnit targetUnit) {
        double base1 = length1.unit.convertToBaseUnit(length1.value);
        double base2 = length2.unit.convertToBaseUnit(length2.value);

        double resultInInches = base1 + base2;
        double finalResult = targetUnit.convertFromBaseUnit(resultInInches);

        return new Length(finalResult, targetUnit);
    }

    private double convertToBaseUnit() {
        return this.unit.convertToBaseUnit(this.value);
    }

    private boolean compare(Length sampleUnit) {
        if (sampleUnit == null) return false;
        return Double.compare(this.convertToBaseUnit(), sampleUnit.convertToBaseUnit()) == 0;
    }

    @Override
    public boolean equals(Object sampleUnit) {
        if (this == sampleUnit) return true;
        if (sampleUnit == null || sampleUnit.getClass() != this.getClass()) return false;
        return compare((Length) sampleUnit);
    }
}