/**
 * Test Cases for UC6 - Addition of Two Length Units
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
    void testAddition_SameUnit_FeetPlusFeet(){
        Length temp = Length.add(
                new Length(1.0, Length.LengthUnit.FEET),
                new Length(1.0, Length.LengthUnit.FEET)
        );
        assertEquals(2.0, temp.value);
        assertEquals(Length.LengthUnit.FEET, temp.getUnit());
    }
    @Test
    void testAddition_SameUnit_InchesPlusInches(){
        Length temp = Length.add(
                new Length(6.0, Length.LengthUnit.INCHES),
                new Length(6.0, Length.LengthUnit.INCHES)
        );
        assertEquals(12.0, temp.value);
        assertEquals(Length.LengthUnit.INCHES,temp.getUnit());
    }
    @Test
    void testAddition_CrossUnit_FeetPlusInches(){
        Length temp = Length.add(
                new Length(1.0, Length.LengthUnit.FEET),
                new Length(12.0, Length.LengthUnit.INCHES)
        );
        assertEquals(2.0, temp.value);
        assertEquals(Length.LengthUnit.FEET,temp.getUnit());
    }
    @Test
    void testAddition_CrossUnit_InchesPlusFeet(){
        Length temp = Length.add(
                new Length(12.0, Length.LengthUnit.INCHES),
                new Length(12.0, Length.LengthUnit.INCHES)
        );
        assertEquals(24.0, temp.value);
        assertEquals(Length.LengthUnit.INCHES,temp.getUnit());
    }
    @Test
    void testAddition_CrossUnit_YardPlusFeet(){
        Length temp = Length.add(
                new Length(1.0, Length.LengthUnit.YARDS),
                new Length(3.0, Length.LengthUnit.FEET)
        );
        assertEquals(2.0, temp.value);
        assertEquals(Length.LengthUnit.YARDS,temp.getUnit());
    }
    @Test
    void testAddition_CrossUnit_CentimeterPlusInches(){
        Length temp = Length.add(
                new Length(2.54, Length.LengthUnit.CENTIMETERS),
                new Length(1.0, Length.LengthUnit.INCHES)
        );
        assertEquals(5.079998628400741, temp.value);
        assertEquals(Length.LengthUnit.CENTIMETERS,temp.getUnit());
    }
    @Test
    void testAddition_Commutative(){
        Length temp1 = Length.add(
                new Length(1.0, Length.LengthUnit.FEET),
                new Length(12.0, Length.LengthUnit.INCHES)
        );
        Length temp2 = Length.add(
                new Length(12.0, Length.LengthUnit.INCHES),
                new Length(1.0, Length.LengthUnit.FEET)
        );
        assertTrue(temp1.equals(temp2));
    }
    @Test
    void testAddition_WithZero(){
        Length temp = Length.add(
                new Length(5.0, Length.LengthUnit.FEET),
                new Length(0.0, Length.LengthUnit.INCHES)
        );
        assertEquals(5.0, temp.value);
        assertEquals(Length.LengthUnit.FEET,temp.getUnit());
    }
    @Test
    void testAddition_NegativeValues(){
        Length temp = Length.add(
                new Length(5.0, Length.LengthUnit.FEET),
                new Length(-2.0, Length.LengthUnit.FEET)
        );
        assertEquals(3.0, temp.value);
        assertEquals(Length.LengthUnit.FEET,temp.getUnit());
    }
    @Test
    void testAddition_NullSecondOperand(){
        assertThrows(NullPointerException.class, () ->{
            Length.add(
                    new Length(1.0, Length.LengthUnit.FEET),
                    null
            );
        } );
    }
    @Test
    void testAddition_LargeValues(){
        Length temp = Length.add(
                new Length(1e6, Length.LengthUnit.FEET),
                new Length(1e6, Length.LengthUnit.FEET)
        );
        assertEquals(2e6, temp.value);
        assertEquals(Length.LengthUnit.FEET,temp.getUnit());
    }
    @Test
    void testAddition_SmallValues(){
        Length temp = Length.add(
                new Length(0.001, Length.LengthUnit.FEET),
                new Length(0.002, Length.LengthUnit.FEET)
        );
        assertEquals(0.003, temp.value, 0.0001);
        assertEquals(Length.LengthUnit.FEET,temp.getUnit());
    }
}
