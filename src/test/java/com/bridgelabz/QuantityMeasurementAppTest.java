package com.bridgelabz;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class QuantityMeasurementAppTest {
    @Test
    void testEquality_SameValue(){
        QuantityMeasurementApp.Feet feet1 = new QuantityMeasurementApp.Feet(15.0);
        QuantityMeasurementApp.Feet feet2 = new QuantityMeasurementApp.Feet(15.0);
        Assertions.assertTrue(feet1.equals(feet2));
    }

    @Test
    void testEquality_DifferentValue(){
        QuantityMeasurementApp.Feet feet1 = new QuantityMeasurementApp.Feet(1.0);
        QuantityMeasurementApp.Feet feet2 = new QuantityMeasurementApp.Feet(12.0);
        Assertions.assertFalse(feet1.equals(feet2));
    }

    @Test
    void testEquality_NullComparision(){
        QuantityMeasurementApp.Feet feet1 = new QuantityMeasurementApp.Feet(4.5);
        Assertions.assertFalse(feet1.equals(null));
    }

    @Test
    void testEquality_SameReference(){
        QuantityMeasurementApp.Feet feet1 = new QuantityMeasurementApp.Feet(1.2);
        Assertions.assertTrue(feet1.equals(feet1));
    }

    @Test
    void testEquality_NonNumericInput(){
        QuantityMeasurementApp.Feet feet1 = new QuantityMeasurementApp.Feet(Double.NaN);
        QuantityMeasurementApp.Feet feet2 = new QuantityMeasurementApp.Feet(Double.NaN);
        Assertions.assertTrue(feet1.equals(feet2));
    }
}
