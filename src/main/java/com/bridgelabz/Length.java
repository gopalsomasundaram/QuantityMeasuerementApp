/**
 * This class allows implementation of any type of length unit
 * it only requires the conversion factor to be mentioned in the
 * LengthUnit Enumerator. The class also manages Unit conversion to
 * a base unit before
 */

package com.bridgelabz;
public class Length {

    public double value;
    private LengthUnit unit;

    //enum managing conversion factors
    public enum LengthUnit{
        FEET(12.0),
        INCHES(1.0),
        YARDS(36.0),
        CENTIMETERS(0.393701);

        private final double conversionFactor;

        LengthUnit(double conversionFactor){
            this.conversionFactor = conversionFactor;
        }

        public double getConversionFactor(){
            return conversionFactor;
        }
    }

    //parameterized constructor
    public Length(double value, LengthUnit unit){
        this.unit = unit;
        this.value = value;
        if(unit == null)
            throw new IllegalArgumentException("Unit Type must be provided and cannot be null");
    }

    //static conversion method
    public static double convert(double value, LengthUnit sourceUnit, LengthUnit targetUnit){
        if (targetUnit == null || sourceUnit == null|| Double.isNaN(value)) throw new IllegalArgumentException("Target unit cannot be null");
        double valueInInches = value * sourceUnit.getConversionFactor();
        double convertedValue = valueInInches/ targetUnit.getConversionFactor();
        return convertedValue;
    }

    //instance method to convert to target length unit
    public Length convertTo(LengthUnit targetUnit) {
        double convertedValue = convert(this.value, this.unit, targetUnit);
        return new Length(convertedValue, targetUnit);
    }

    //Converts measurement to base unit
    private double convertToBaseUnit(){
        return this.value * this.unit.getConversionFactor();
    }

    //compare values of two different Length instances after converting to base unit
    private boolean compare(Length sampleUnit){
        if(sampleUnit == null) return false;
        return Double.compare(this.convertToBaseUnit(),sampleUnit.convertToBaseUnit())==0;
    }

    @Override
    public boolean equals(Object sampleUnit){
        if(this == sampleUnit) return true;
        if(sampleUnit == null || sampleUnit.getClass() != this.getClass()) return false;

        Length temp = (Length) sampleUnit;
        return compare(temp);
    }

    public static void main(String[] args){
        Length len1 = new Length(1, LengthUnit.FEET);
        Length len2 = new Length(12,LengthUnit.INCHES);
        System.out.println(len1.equals(len2));

        Length len3 = new Length(1,LengthUnit.YARDS);
        Length len4 = new Length(36, LengthUnit.INCHES);
        System.out.println(len3.equals(len4));

        Length len5 = new Length(100.0, LengthUnit.CENTIMETERS);
        Length len6 = new Length(39.3701, LengthUnit.INCHES);
        System.out.println(len5.equals(len6));

    }

}
