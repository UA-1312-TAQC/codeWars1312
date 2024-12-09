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
        final float GALLON_TO_LITERS = 4.54609188f;
        final float MILE_TO_KM = 1.609344f;

        double km_per_liter = (mpg / GALLON_TO_LITERS) * MILE_TO_KM;

        return (float) (Math.round(km_per_liter * 100.0) / 100.0);
    }

    @Override
    public int[] squareOrSquareRoot(int[] array) {
        int max_value_sqrt = (int) Math.sqrt(Integer.MAX_VALUE);
        int[] result = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            int sqrt = (int) Math.round(Math.sqrt(array[i]));

            if (sqrt * sqrt == array[i]) {
                result[i] = sqrt;
            } else {
                if (array[i] < max_value_sqrt)
                    result[i] = array[i] * array[i];
                else {
                    throw new IllegalArgumentException("The square root of the input value is too large to represent as an integer.");
                }
            }
        }
        return result;
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
