package com.bridgelabz;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTest {


    @Test
    public void kilogramEquals1000Grams() {
        Weight kg = new Weight(1.0, WeightUnit.KILOGRAM);
        Weight g = new Weight(1000.0, WeightUnit.GRAM);
        assertTrue(kg.equals(g));
    }

    @Test
    public void poundEquals453Point592Grams() {
        Weight lb = new Weight(1.0, WeightUnit.POUND);
        Weight g = new Weight(453.592, WeightUnit.GRAM);
        assertTrue(lb.equals(g));
    }

    @Test
    public void additionOfWeightsEqualsExpected() {
        Weight kg = new Weight(1.0, WeightUnit.KILOGRAM);
        Weight g = new Weight(1000.0, WeightUnit.GRAM);
        Weight sum = kg.add(g, WeightUnit.KILOGRAM);
        assertEquals(2.0, sum.getValue(), 0.0);
    }

    @Test
    public void weightNotEqualToLength() {
        Weight kg = new Weight(1.0, WeightUnit.KILOGRAM);
        Length ft = new Length(1.0, LengthUnit.FEET);
        assertFalse(kg.equals(ft));
    }


    @Test
    public void testFeetEquality() {
        Length f1 = new Length(1.0, LengthUnit.FEET);
        Length f2 = new Length(1.0, LengthUnit.FEET);
        assertTrue(f1.equals(f2));
    }
}