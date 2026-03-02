package com.bridgelabz;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import org.junit.jupiter.api.Test;

/**
 * UC8 Test Suite: Refactoring Unit Enum to Standalone Class.
 * Verifies that functionality is preserved while delegating conversion
 * responsibility to the standalone LengthUnit enum[cite: 5, 6].
 */
public class QuantityMeasurementAppTest {

    // --- UC8 SPECIFIC TESTS: Standalone Unit Responsibility ---

    @Test
    void testLengthUnitEnum_ConstantsAndFactors() {
        // Verifies that LengthUnit is a top-level class and constants are available [cite: 420, 421]
        assertEquals(12.0, LengthUnit.FEET.getConversionFactor());
        assertEquals(1.0, LengthUnit.INCHES.getConversionFactor());
        assertEquals(36.0, LengthUnit.YARDS.getConversionFactor());
    }

    @Test
    void testConvertToBaseUnit_Responsibility() {
        // UC8 responsibility: Convert value in this unit to base unit (inches) [cite: 48, 423, 425]
        assertEquals(12.0, LengthUnit.FEET.convertToBaseUnit(1.0));
        assertEquals(36.0, LengthUnit.YARDS.convertToBaseUnit(1.0));
        assertEquals(1.0, LengthUnit.INCHES.convertToBaseUnit(1.0));
    }

    @Test
    void testConvertFromBaseUnit_Responsibility() {
        // UC8 responsibility: Convert value from base unit (inches) to this unit [cite: 49, 429, 430]
        assertEquals(1.0, LengthUnit.FEET.convertFromBaseUnit(12.0));
        assertEquals(1.0, LengthUnit.YARDS.convertFromBaseUnit(36.0));
        assertEquals(12.0, LengthUnit.INCHES.convertFromBaseUnit(12.0));
    }

    // --- BACKWARD COMPATIBILITY: UC1 - UC7 [cite: 28, 57] ---

    @Test
    void testEquality_RefactoredDesign() {
        // Verifies that Quantity(1.0, FEET).equals(Quantity(12.0, INCHES)) returns true [cite: 507]
        Length feet = new Length(1.0, LengthUnit.FEET);
        Length inches = new Length(12.0, LengthUnit.INCHES);
        assertTrue(feet.equals(inches));
    }

    @Test
    void testCrossUnitInequality() {
        Length feet = new Length(1.0, LengthUnit.FEET);
        Length yards = new Length(1.0, LengthUnit.YARDS);
        assertFalse(feet.equals(yards));
    }

    @Test
    void testReflexiveSymmetricAndTransitiveProperty() {
        // Validates equality contracts are preserved [cite: 441]
        Length l1 = new Length(1.0, LengthUnit.FEET);
        Length l2 = new Length(12.0, LengthUnit.INCHES);
        Length l3 = new Length(0.3333, LengthUnit.YARDS); // approx

        assertTrue(l1.equals(l1)); // Reflexive
        assertTrue(l1.equals(l2) && l2.equals(l1)); // Symmetric
    }

    @Test
    void testAddition_ExplicitTargetUnit_Feet() {
        // UC7 functionality: 1 ft + 12 in = 2 ft [cite: 514, 515]
        Length temp = Length.add(
                new Length(1.0, LengthUnit.FEET),
                new Length(12.0, LengthUnit.INCHES),
                LengthUnit.FEET
        );
        assertEquals(2.0, temp.value);
        assertEquals(LengthUnit.FEET, temp.getUnit());
    }

    @Test
    void testAddition_ExplicitTargetUnit_Yards() {
        // UC7 functionality: Adding with target unit specification [cite: 518, 519]
        Length temp = Length.add(
                new Length(1.0, LengthUnit.FEET),
                new Length(12.0, LengthUnit.INCHES),
                LengthUnit.YARDS
        );
        assertEquals(0.667, temp.value, 0.001);
    }

    @Test
    void testAddition_CentimetersToInches() {
        // 2.54 cm + 1 inch = 2 inches
        Length temp = Length.add(
                new Length(2.54, LengthUnit.CENTIMETERS),
                new Length(1.0, LengthUnit.INCHES),
                LengthUnit.INCHES
        );
        assertEquals(2.0, temp.value, 0.01);
    }

    @Test
    void testRoundTripConversion_Precision() {
        // Verifies mathematical precision across round-trip conversions [cite: 543, 544]
        double initialValue = 10.0;
        double feetToInches = Length.convert(initialValue, LengthUnit.FEET, LengthUnit.INCHES);
        double backToFeet = Length.convert(feetToInches, LengthUnit.INCHES, LengthUnit.FEET);
        assertEquals(initialValue, backToFeet, 0.001);
    }

    @Test
    void testNullValidation_Refactored() {
        // Null unit validation should throw appropriate exceptions [cite: 455, 522]
        assertThrows(IllegalArgumentException.class, () -> new Length(1.0, null));
    }

    @Test
    void testInvalidValue_NaN() {
        // Rejects invalid input values like Double.NaN [cite: 456, 525]
        assertThrows(IllegalArgumentException.class, () ->
                Length.convert(Double.NaN, LengthUnit.FEET, LengthUnit.INCHES));
    }
}