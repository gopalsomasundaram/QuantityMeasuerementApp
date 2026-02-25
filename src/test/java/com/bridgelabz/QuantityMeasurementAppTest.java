/**
 * Test Cases for UC4 - Extended Unit Support
 *
 * These test cases verify the function of the Length class along
 * with its various measurements such as Feet, Inches, Yards, Centimeter
 */
package com.bridgelabz;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class QuantityMeasurementAppTest {
    @Test
    void testEquality_YardToYard_SameValue() {
        Length yard1 = new Length(1.0, Length.LengthUnit.YARDS);
        Length yard2 = new Length(1.0, Length.LengthUnit.YARDS);
        Assertions.assertTrue(yard1.equals(yard2)); // Verifies identical yard measurements [cite: 258, 282]
    }

    @Test
    void testEquality_YardToYard_DifferentValue() {
        Length yard1 = new Length(1.0, Length.LengthUnit.YARDS);
        Length yard2 = new Length(2.0, Length.LengthUnit.YARDS);
        Assertions.assertFalse(yard1.equals(yard2)); // Verifies inequality for different yard values [cite: 270, 273]
    }

    @Test
    void testEquality_YardToFeet_EquivalentValue() {
        Length yard = new Length(1.0, Length.LengthUnit.YARDS);
        Length feet = new Length(3.0, Length.LengthUnit.FEET);
        Assertions.assertTrue(yard.equals(feet)); // 1 Yard = 3 Feet [cite: 242, 265]
    }

    @Test
    void testEquality_FeetToYard_EquivalentValue() {
        Length feet = new Length(3.0, Length.LengthUnit.FEET);
        Length yard = new Length(1.0, Length.LengthUnit.YARDS);
        Assertions.assertTrue(feet.equals(yard)); // Verifies symmetry of conversion [cite: 225, 268]
    }

    @Test
    void testEquality_YardToInches_EquivalentValue() {
        Length yard = new Length(1.0, Length.LengthUnit.YARDS);
        Length inches = new Length(36.0, Length.LengthUnit.INCHES);
        Assertions.assertTrue(yard.equals(inches)); // 1 Yard = 36 Inches [cite: 264]
    }

    @Test
    void testEquality_InchesToYard_EquivalentValue() {
        Length inches = new Length(36.0, Length.LengthUnit.INCHES);
        Length yard = new Length(1.0, Length.LengthUnit.YARDS);
        Assertions.assertTrue(inches.equals(yard)); // Verifies symmetry for inches to yard
    }

    @Test
    void testEquality_YardToFeet_NonEquivalentValue() {
        Length yard = new Length(1.0, Length.LengthUnit.YARDS);
        Length feet = new Length(2.0, Length.LengthUnit.FEET);
        Assertions.assertFalse(yard.equals(feet)); // 1 Yard != 2 Feet
    }

    @Test
    void testEquality_centimetersToInches_EquivalentValue() {
        Length cm = new Length(1.0, Length.LengthUnit.CENTIMETERS);
        Length inch = new Length(0.393701, Length.LengthUnit.INCHES);
        Assertions.assertTrue(cm.equals(inch)); // Verifies CM to Inch conversion [cite: 243]
    }

    @Test
    void testEquality_centimetersToFeet_NonEquivalentValue() {
        Length cm = new Length(1.0, Length.LengthUnit.CENTIMETERS);
        Length feet = new Length(1.0, Length.LengthUnit.FEET);
        Assertions.assertFalse(cm.equals(feet)); // 1 CM != 1 Foot
    }

    @Test
    void testEquality_MultiUnit_TransitiveProperty() {
        Length yard = new Length(1.0, Length.LengthUnit.YARDS);
        Length feet = new Length(3.0, Length.LengthUnit.FEET);
        Length inches = new Length(36.0, Length.LengthUnit.INCHES);

        // Transitive Property: If A=B and B=C, then A=C
        Assertions.assertTrue(yard.equals(feet));
        Assertions.assertTrue(feet.equals(inches));
        Assertions.assertTrue(yard.equals(inches));
    }

    @Test
    void testEquality_YardWithNullUnit() {
        // Verifies that null unit triggers the exception in your constructor
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Length(1.0, null);
        }); //
    }

    @Test
    void testEquality_YardSameReference() {
        Length yard = new Length(1.0, Length.LengthUnit.YARDS);
        Assertions.assertTrue(yard.equals(yard)); // Reflexive property [cite: 224, 283]
    }

    @Test
    void testEquality_YardNullComparison() {
        Length yard = new Length(1.0, Length.LengthUnit.YARDS);
        Assertions.assertFalse(yard.equals(null)); // Null handling [cite: 228, 286]
    }

    @Test
    void testEquality_CentimetersWithNullUnit() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Length(10.0, null);
        });
    }

    @Test
    void testEquality_CentimetersSameReference() {
        Length cm = new Length(100.0, Length.LengthUnit.CENTIMETERS);
        Assertions.assertTrue(cm.equals(cm));
    }

    @Test
    void testEquality_CentimetersNullComparison() {
        Length cm = new Length(100.0, Length.LengthUnit.CENTIMETERS);
        Assertions.assertFalse(cm.equals(null));
    }

    @Test
    void testEquality_AllUnits_ComplexScenario() {
        Length yard = new Length(2.0, Length.LengthUnit.YARDS);
        Length feet = new Length(6.0, Length.LengthUnit.FEET);
        Length inches = new Length(72.0, Length.LengthUnit.INCHES);

        Assertions.assertTrue(yard.equals(feet));
        Assertions.assertTrue(feet.equals(inches));
        Assertions.assertTrue(yard.equals(inches));
    }
}
