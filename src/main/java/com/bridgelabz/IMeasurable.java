package com.bridgelabz;

/**
 * IMeasurable interface defines the contract for measurable units.
 * Serves as a common abstraction for different types of measurements.
 */
public interface IMeasurable {
    double getConversionFactor();
    double convertToBaseUnit(double value);
    double convertFromBaseUnit(double baseValue);
}