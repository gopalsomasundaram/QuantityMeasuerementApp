package com.bridgelabz;

/**
 * This class allows implementation of any type of lenght unit
 * it only requires the conversion factor to be mentioned in the
 * LengthUnit Enumerator. The class also manages Unit conersion to
 * a base unit before
 *
 */
public class Length {

    public double value;
    private LengthUnit unit;

    //enum managing conversion factors
    public enum LengthUnit{
        FEET(12.0),
        INCHES(1.0);

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

        if(len1.equals(len2)){
            System.out.println("Equal");
        }
        else{
            System.out.println("Not Equal");
        }
    }

}
