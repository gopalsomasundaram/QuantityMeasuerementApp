/**
 * Test Cases for UC5 - Unit to Unit conversion
 *
 * These test cases verify the function of the Length class along
 * with its various measurements such as Feet, Inches, Yards, Centimeter
 */
package com.bridgelabz;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class QuantityMeasurementAppTest {
    @Test
    void testConversion_FeetToInches() {
        double result = Length.convert(1.0, Length.LengthUnit.FEET, Length.LengthUnit.INCHES);
        assertEquals(12.0, result); // [cite: 919]
    }

    @Test
    void testConversion_YardsToInches() {
        double result = Length.convert(1.0, Length.LengthUnit.YARDS, Length.LengthUnit.INCHES);
        assertEquals(36.0, result); // [cite: 923]
    }

    @Test
    void testConversion_CentimetersToInches() {
        double result = Length.convert(2.54, Length.LengthUnit.CENTIMETERS, Length.LengthUnit.INCHES);
        assertEquals(1.0, result, 0.01); // [cite: 927]
    }

    @Test
    void testConversion_ZeroValue() {
        double result = Length.convert(0.0, Length.LengthUnit.FEET, Length.LengthUnit.INCHES);
        assertEquals(0.0, result); // [cite: 878]
    }

    @Test
    void testConversion_NegativeValue() {
        double result = Length.convert(-1.0, Length.LengthUnit.FEET, Length.LengthUnit.INCHES);
        assertEquals(-12.0, result); // [cite: 881]
    }

    @Test
    void testConversion_SameUnit() {
        double result = Length.convert(5.0, Length.LengthUnit.FEET, Length.LengthUnit.FEET);
        assertEquals(5.0, result); // [cite: 890]
    }

    @Test
    void testConversion_RoundTrip() {
        double toInches = Length.convert(1.0, Length.LengthUnit.FEET, Length.LengthUnit.INCHES);
        double backToFeet = Length.convert(toInches, Length.LengthUnit.INCHES, Length.LengthUnit.FEET);
        assertEquals(1.0, backToFeet); // [cite: 905]
    }

    @Test
    void testConversion_NaN_ThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            Length.convert(Double.NaN, Length.LengthUnit.FEET, Length.LengthUnit.INCHES);
        });
    }

    @Test
    void testConversion_NullUnit_ThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            Length.convert(1.0, null, Length.LengthUnit.INCHES);
        }); // [cite: 937]
    }

    @Test
    void testTransitiveProperty() {
        Length yard = new Length(1.0, Length.LengthUnit.YARDS);
        Length feet = new Length(3.0, Length.LengthUnit.FEET);
        Length inches = new Length(36.0, Length.LengthUnit.INCHES);
        assertTrue(yard.equals(feet) && feet.equals(inches) && yard.equals(inches)); // [cite: 1062]
    }
}
