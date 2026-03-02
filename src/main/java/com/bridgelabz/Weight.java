package com.bridgelabz;

/**
 * UC9: Weight Class
 * Handles weight-specific comparisons, conversions, and arithmetic. [cite: 1028, 1032]
 */
public class Weight {
    private final double value;
    private final WeightUnit unit;

    public Weight(double value, WeightUnit unit) {
        if (unit == null) throw new IllegalArgumentException("Unit cannot be null");
        if (!Double.isFinite(value)) throw new IllegalArgumentException("Value must be finite");
        this.value = value;
        this.unit = unit;
    }

    public double getValue() { return value; }
    public WeightUnit getUnit() { return unit; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Weight thatWeight = (Weight) o;
        return compare(thatWeight);
    }

    private boolean compare(Weight thatWeight) {
        return Double.compare(this.convertToBaseUnit(), thatWeight.convertToBaseUnit()) == 0;
    }

    public Weight convertTo(WeightUnit targetUnit) {
        if (targetUnit == null) throw new IllegalArgumentException("Target unit cannot be null");
        double grams = this.convertToBaseUnit();
        double convertedValue = targetUnit.convertFromBaseUnit(grams);
        return new Weight(convertedValue, targetUnit);
    }

    public Weight add(Weight thatWeight) {
        return addAndConvert(thatWeight, this.unit);
    }

    public Weight add(Weight thatWeight, WeightUnit targetUnit) {
        return addAndConvert(thatWeight, targetUnit);
    }

    private double convertToBaseUnit() {
        return this.unit.convertToBaseUnit(this.value);
    }

    private Weight addAndConvert(Weight thatWeight, WeightUnit targetUnit) {
        double totalGrams = this.convertToBaseUnit() + thatWeight.convertToBaseUnit();
        return new Weight(targetUnit.convertFromBaseUnit(totalGrams), targetUnit);
    }

    @Override
    public String toString() {
        return value + " " + unit;
    }
}