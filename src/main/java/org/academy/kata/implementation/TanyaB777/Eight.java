package org.academy.kata.implementation.TanyaB777;


import org.academy.kata.IEight;

public class Eight implements IEight {
    @Override
    public int liters(double time) {
        return 0;
    }

    @Override
    public double getVolumeOfCuboid(double length, double width, double height) {
        return 0;
    }

    @Override
    public float mpgToKPM(float mpg) {
        return 0;
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
