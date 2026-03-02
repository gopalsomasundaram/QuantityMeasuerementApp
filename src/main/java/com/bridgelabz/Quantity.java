package com.bridgelabz;

/**
 * Generic Quantity class handling multiple measurement types. [cite: 2525, 2545]
 * Replaces category-specific classes to uphold the DRY principle. [cite: 2198, 2243]
 */
public class Quantity<U extends IMeasurable> {
    private final double value;
    private final U unit;

    public Quantity(double value, U unit) {
        if (unit == null) throw new IllegalArgumentException("Unit cannot be null");
        this.value = value;
        this.unit = unit;
    }

    public double getValue() { return value; }
    public U getUnit() { return unit; }

    /**
     * Converts to target unit by delegating to unit conversion methods. [cite: 2205, 2206]
     */
    public double convertTo(U targetUnit) {
        double baseValue = this.unit.convertToBaseUnit(this.value);
        return targetUnit.convertFromBaseUnit(baseValue);
    }

    public Quantity<U> add(Quantity<U> other) {
        return add(other, this.unit);
    }

    public Quantity<U> add(Quantity<U> other, U targetUnit) {
        double totalBase = this.unit.convertToBaseUnit(this.value) +
                other.unit.convertToBaseUnit(other.value);
        return new Quantity<>(targetUnit.convertFromBaseUnit(totalBase), targetUnit);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Quantity<?> that = (Quantity<?>) obj;

        // Prevents cross-category comparison (e.g., Feet vs Kilograms) [cite: 2224, 3042]
        if (!this.unit.getClass().equals(that.unit.getClass())) return false;

        return Double.compare(this.unit.convertToBaseUnit(this.value),
                that.unit.convertToBaseUnit((Double)that.getValue())) == 0;
    }
}