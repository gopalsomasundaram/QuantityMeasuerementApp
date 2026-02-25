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
    void testFeetEquality_SameValue(){
        QuantityMeasurementApp.Feet feet1 = new QuantityMeasurementApp.Feet(15.0);
        QuantityMeasurementApp.Feet feet2 = new QuantityMeasurementApp.Feet(15.0);
        Assertions.assertTrue(feet1.equals(feet2));
    }

    @Test
    void testFeetEquality_DifferentValue(){
        QuantityMeasurementApp.Feet feet1 = new QuantityMeasurementApp.Feet(1.0);
        QuantityMeasurementApp.Feet feet2 = new QuantityMeasurementApp.Feet(12.0);
        Assertions.assertFalse(feet1.equals(feet2));
    }

    @Test
    void testFeetEquality_NullComparision(){
        QuantityMeasurementApp.Feet feet1 = new QuantityMeasurementApp.Feet(4.5);
        Assertions.assertFalse(feet1.equals(null));
    }

    @Test
    void testFeetEquality_SameReference(){
        QuantityMeasurementApp.Feet feet1 = new QuantityMeasurementApp.Feet(1.2);
        Assertions.assertTrue(feet1.equals(feet1));
    }

    @Test
    void testFeetEquality_NonNumericInput(){
        QuantityMeasurementApp.Feet feet1 = new QuantityMeasurementApp.Feet(Double.NaN);
        QuantityMeasurementApp.Feet feet2 = new QuantityMeasurementApp.Feet(Double.NaN);
        Assertions.assertTrue(feet1.equals(feet2));
    }

    @Test
    void testInchesEquality_SameValue(){
        QuantityMeasurementApp.Inches inches1 = new QuantityMeasurementApp.Inches(15.0);
        QuantityMeasurementApp.Inches inches2 = new QuantityMeasurementApp.Inches(15.0);
        Assertions.assertTrue(inches1.equals(inches2));
    }

    @Test
    void testInchesEquality_DifferentValue(){
        QuantityMeasurementApp.Inches inches1 = new QuantityMeasurementApp.Inches(1.0);
        QuantityMeasurementApp.Inches inches2 = new QuantityMeasurementApp.Inches(12.0);
        Assertions.assertFalse(inches1.equals(inches2));
    }

    @Test
    void testInchesEquality_NullComparision(){
        QuantityMeasurementApp.Inches inches1 = new QuantityMeasurementApp.Inches(4.5);
        Assertions.assertFalse(inches1.equals(null));
    }

    @Test
    void testInchesEquality_SameReference(){
        QuantityMeasurementApp.Inches inches1 = new QuantityMeasurementApp.Inches(1.0);
        Assertions.assertTrue(inches1.equals(inches1));
    }

    @Test
    void testInchesEquality_NonNumericInput(){
        QuantityMeasurementApp.Inches inches1 = new QuantityMeasurementApp.Inches(Double.NaN);
        QuantityMeasurementApp.Inches inches2 = new QuantityMeasurementApp.Inches(Double.NaN);
        Assertions.assertTrue(inches1.equals(inches2));
    }
}
