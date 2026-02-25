/**
 * Test Cases for UC2 - Feet and Inches measurement equality
 *
 * These test cases verify the function of the Inches and Feet
 * classes as expected
 */
package com.bridgelabz;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class QuantityMeasurementAppTest {
    @Test
    void testEquality_FeetToFeet_SameValue(){
        Length len1 = new Length(1.0, Length.LengthUnit.FEET);
        Length len2 = new Length(1.0, Length.LengthUnit.FEET);
        Assertions.assertTrue(len1.equals(len2));
    }

    @Test
    void testEquality_InchesToInches_SameValue(){
        Length len1 = new Length(1.0, Length.LengthUnit.INCHES);
        Length len2 = new Length(1.0, Length.LengthUnit.INCHES);
        Assertions.assertTrue(len1.equals(len2));
    }

    @Test
    void testEquality_NullComparision(){
        Length len1 = new Length(1.0, Length.LengthUnit.FEET);
        Length len2 = null;
        Assertions.assertFalse(len1.equals(len2));
    }

    @Test
    void testEquality_InchToFeet_EquivalentValue(){
        Length len1 = new Length(1.0, Length.LengthUnit.FEET);
        Length len2 = new Length(12.0, Length.LengthUnit.INCHES);
        Assertions.assertTrue(len1.equals(len2));
    }

    @Test
    void testEquality_InchToInch_DifferentValue(){
        Length len1 = new Length(1.0, Length.LengthUnit.INCHES);
        Length len2 = new Length(2.0, Length.LengthUnit.INCHES);
        Assertions.assertFalse(len1.equals(len2));
    }

    @Test
    void testEquality_FeetToFeet_DifferentValue(){
        Length len1 = new Length(1.0, Length.LengthUnit.FEET);
        Length len2 = new Length(2.0, Length.LengthUnit.FEET);
        Assertions.assertFalse(len1.equals(len2));
    }

    @Test
    void testEquality_InvalidUnit(){
        Assertions.assertThrows(IllegalArgumentException.class,()->{
           Length.LengthUnit.valueOf("METERS");
        });
    }

    @Test
    void testEquality_NullUnit(){
        Assertions.assertThrows(IllegalArgumentException.class,() ->{Length len1 = new Length(1.0, null);});
    }

    @Test
    void testEquality_SameReference(){
        Length len1 = new Length(1.0, Length.LengthUnit.FEET);
        Assertions.assertTrue(len1.equals(len1));
    }
}
