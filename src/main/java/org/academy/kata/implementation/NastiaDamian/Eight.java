package org.academy.kata.implementation.NastiaDamian;


import org.academy.kata.IEight;

public class Eight implements IEight {
    @Override
    public int liters(double time) {
        return (int) (time * 0.5);
    }
    @Override
    public double getVolumeOfCuboid(double length, double width, double height) {
        if (length <= 0 || width <= 0 || height <= 0) {
            throw new IllegalArgumentException("All arguments must be greater than zero.");
        }
        return length * width * height;
    }

    @Override
    public float mpgToKPM(float mpg) {
        final float GALLON_TO_LITRE = 4.54609188f;
        final float MILE_TO_KM = 1.609344f;

        float kpl = mpg * (MILE_TO_KM / GALLON_TO_LITRE);

        return (Math.round(kpl * 100.0f) / 100.0f);
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
