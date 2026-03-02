/**
 * Test Cases for UC7 - Addition with Target Unit Specification
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
    void testAddition_ExplicitTargetUnit_Feet(){
        Length temp = Length.add(
                new Length(1.0, Length.LengthUnit.FEET),
                new Length(12.0, Length.LengthUnit.INCHES),
                Length.LengthUnit.FEET
        );
        assertEquals(2.0, temp.value);
        assertEquals(Length.LengthUnit.FEET, temp.getUnit());
    }
    @Test
    void testAddition_ExplicitTargetUnit_Inches(){
        Length temp = Length.add(
                new Length(1.0, Length.LengthUnit.FEET),
                new Length(12.0, Length.LengthUnit.INCHES),
                Length.LengthUnit.INCHES
        );
        assertEquals(24.0, temp.value);
        assertEquals(Length.LengthUnit.INCHES,temp.getUnit());
    }
    @Test
    void testAddition_ExplicitTargetUnit_Yards(){
        Length temp = Length.add(
                new Length(1.0, Length.LengthUnit.FEET),
                new Length(12.0, Length.LengthUnit.INCHES),
                Length.LengthUnit.YARDS
        );
        assertEquals(0.667, temp.value,0.001);
        assertEquals(Length.LengthUnit.YARDS,temp.getUnit());
    }
    @Test
    void testAddition_ExplicitTargetUnit_Centimeter(){
        Length temp = Length.add(
                new Length(1.0, Length.LengthUnit.INCHES),
                new Length(1.0, Length.LengthUnit.INCHES),
                Length.LengthUnit.CENTIMETERS
        );
        assertEquals(5.08, temp.value, 0.01);
        assertEquals(Length.LengthUnit.CENTIMETERS,temp.getUnit());
    }
    @Test
    void testAddition_ExplicitTargetUnit_SameAsFirstOperand(){
        Length temp = Length.add(
                new Length(2.0, Length.LengthUnit.YARDS),
                new Length(3.0, Length.LengthUnit.FEET),
                Length.LengthUnit.YARDS
        );
        assertEquals(3.0, temp.value);
        assertEquals(Length.LengthUnit.YARDS,temp.getUnit());
    }
    @Test
    void testAddition_ExplicitTargetUnit_SameAsSecondOperand(){
        Length temp = Length.add(
                new Length(2.0, Length.LengthUnit.YARDS),
                new Length(3.0, Length.LengthUnit.FEET),
                Length.LengthUnit.FEET
        );
        assertEquals(9, temp.value);
        assertEquals(Length.LengthUnit.FEET,temp.getUnit());
    }
    @Test
    void testAddition_ExplicitTargetUnit_Commutativity(){
        Length temp1 = Length.add(
                new Length(1.0, Length.LengthUnit.FEET),
                new Length(12.0, Length.LengthUnit.INCHES),
                Length.LengthUnit.YARDS
        );
        Length temp2 = Length.add(
                new Length(12.0, Length.LengthUnit.INCHES),
                new Length(1.0, Length.LengthUnit.FEET),
                Length.LengthUnit.YARDS
        );
        assertTrue(temp1.equals(temp2));
    }
    @Test
    void testAddition_ExplicitTargetUnit_WithZero(){
        Length temp = Length.add(
                new Length(5.0, Length.LengthUnit.FEET),
                new Length(0.0, Length.LengthUnit.INCHES),
                Length.LengthUnit.YARDS
        );
        assertEquals(1.667, temp.value,0.001);
        assertEquals(Length.LengthUnit.YARDS,temp.getUnit());
    }
    @Test
    void testAddition_ExplicitTargetUnit_NegativeValues(){
        Length temp = Length.add(
                new Length(5.0, Length.LengthUnit.FEET),
                new Length(-2.0, Length.LengthUnit.FEET),
                Length.LengthUnit.INCHES
        );
        assertEquals(36.0, temp.value);
        assertEquals(Length.LengthUnit.INCHES,temp.getUnit());
    }
    @Test
    void testAddition_ExplicitTargetUnit_NullTargetUnit(){
        assertThrows(NullPointerException.class, () ->{
            Length.add(
                    new Length(1.0, Length.LengthUnit.FEET),
                    new Length(1.0, Length.LengthUnit.FEET),
                    null
            );
        } );
    }
    @Test
    void testAddition_ExplicitTargetUnit_LargeToSmallScale(){
        Length temp = Length.add(
                new Length(1000, Length.LengthUnit.FEET),
                new Length(500, Length.LengthUnit.FEET),
                Length.LengthUnit.INCHES
        );
        assertEquals(18000, temp.value);
        assertEquals(Length.LengthUnit.INCHES,temp.getUnit());
    }
    @Test
    void testAddition_ExplicitTargetUnit_SmallToLargeScale(){
        Length temp = Length.add(
                new Length(12.0, Length.LengthUnit.INCHES),
                new Length(12.0, Length.LengthUnit.INCHES),
                Length.LengthUnit.YARDS
        );
        assertEquals(0.667, temp.value, 0.001);
        assertEquals(Length.LengthUnit.YARDS,temp.getUnit());
    }
}
