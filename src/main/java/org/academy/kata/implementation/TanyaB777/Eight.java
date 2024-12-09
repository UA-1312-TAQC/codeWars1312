package org.academy.kata.implementation.TanyaB777;


import org.academy.kata.IEight;

public class Eight implements IEight {
    @Override
    public int liters(double time) {
        if (time < 0 || time > Integer.MAX_VALUE * 2.0) {
            throw new IllegalArgumentException(String.format("Time must be between 0 and %.2f.", Integer.MAX_VALUE * 2.0));
        }

        return (int) (time * 0.5);
    }

    @Override
    public double getVolumeOfCuboid(double length, double width, double height) {
        if (length < 0 || width < 0 || height < 0) {
            throw new IllegalArgumentException("Length, width, and height must be non-negative values.");
        }

        double value = length * width * height;
        if (Double.isInfinite(value)) {
            throw new ArithmeticException("The result is too large to represent as a double.");
        }

        return value;
    }

    @Override
    public float mpgToKPM(float mpg) {
        return 0;
    }

    @Override
    public int[] squareOrSquareRoot(int[] array) {
        return new int[0];
    }

    @Override
    public int[] countPositivesSumNegatives(int[] input) {
        return new int[0];
    }

    @Override
    public int stringToNumber(String str) {
        return 0;
    }

    @Override
    public double TwoDecimalPlaces(double number) {
        return 0;
    }

    @Override
    public int[] divisibleBy(int[] numbers, int divider) {
        return new int[0];
    }

    @Override
    public boolean am_i_wilson(double n) {
        return false;
    }
}
