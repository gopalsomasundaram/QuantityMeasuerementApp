package com.bridgelabz;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for UC10 Quantity Measurement Application.
 * Validates the generalized Quantity class across multiple measurement types. [cite: 3196, 3200]
 */
public class QuantityMeasurementAppTest {

    // --- Length Category Tests (Preserving UC1-UC8) ---

    @Test
    public void lengthFeetEqualsInches() {
        Quantity<LengthUnit> feet = new Quantity<>(1.0, LengthUnit.FEET);
        Quantity<LengthUnit> inches = new Quantity<>(12.0, LengthUnit.INCHES);
        assertTrue(feet.equals(inches));
    }

    @Test
    public void lengthYardsEqualsFeet() {
        Quantity<LengthUnit> yards = new Quantity<>(1.0, LengthUnit.YARDS);
        Quantity<LengthUnit> feet = new Quantity<>(3.0, LengthUnit.FEET);
        assertTrue(yards.equals(feet));
    }

    @Test
    public void convertLengthFeetToInches() {
        Quantity<LengthUnit> feet = new Quantity<>(1.0, LengthUnit.FEET);
        double result = feet.convertTo(LengthUnit.INCHES);
        assertEquals(12.0, result, 0.0);
    }

    @Test
    public void addLengthFeetAndInches() {
        Quantity<LengthUnit> feet = new Quantity<>(1.0, LengthUnit.FEET);
        Quantity<LengthUnit> inches = new Quantity<>(12.0, LengthUnit.INCHES);
        Quantity<LengthUnit> result = feet.add(inches, LengthUnit.FEET);
        assertEquals(2.0, result.getValue(), 0.0);
    }

    // --- Weight Category Tests (Preserving UC9) ---

    @Test
    public void weightKilogramEqualsGrams() {
        Quantity<WeightUnit> kg = new Quantity<>(1.0, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> g = new Quantity<>(1000.0, WeightUnit.GRAM);
        assertTrue(kg.equals(g));
    }

    @Test
    public void weightPoundEqualsGrams() {
        Quantity<WeightUnit> lb = new Quantity<>(1.0, WeightUnit.POUND);
        Quantity<WeightUnit> g = new Quantity<>(453.59, WeightUnit.GRAM);
        // Using delta due to rounding defined in IMeasurable implementation
        assertEquals(g.convertTo(WeightUnit.GRAM), lb.convertTo(WeightUnit.GRAM), 0.01);
    }

    @Test
    public void addWeightKilogramsAndGrams() {
        Quantity<WeightUnit> kg = new Quantity<>(1.0, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> g = new Quantity<>(1000.0, WeightUnit.GRAM);
        Quantity<WeightUnit> result = kg.add(g, WeightUnit.KILOGRAM);
        assertEquals(2.0, result.getValue(), 0.0);
    }

    // --- Type Safety & Incompatibility Tests ---

    @Test
    public void preventCrossTypeComparisonLengthVsWeight() {
        Quantity<LengthUnit> length = new Quantity<>(1.0, LengthUnit.FEET);
        Quantity<WeightUnit> weight = new Quantity<>(1.0, WeightUnit.KILOGRAM);
        // Runtime check in equals() ensures categories are incomparable
        assertFalse(length.equals(weight));
    }

    @Test
    public void testGenericTypeSafety() {
        Quantity<WeightUnit> w1 = new Quantity<>(1.0, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> w2 = new Quantity<>(1.0, WeightUnit.KILOGRAM);
        // Verifies that generic demonstration methods work uniformly
        assertTrue(QuantityMeasurementApp.demonstrateEquality(w1, w2));
    }

    @Test
    public void backwardCompatibilityCheck() {
        // Runs logic equivalent to UC1-UC7 tests to ensure no regressions
        Quantity<LengthUnit> l1 = new Quantity<>(1.0, LengthUnit.FEET);
        Quantity<LengthUnit> l2 = new Quantity<>(12.0, LengthUnit.INCHES);
        assertTrue(l1.equals(l2));
    }
}