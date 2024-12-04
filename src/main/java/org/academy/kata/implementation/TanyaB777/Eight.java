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
        return new int[0];
    }

    @Override
    public int[] countPositivesSumNegatives(int[] input) {
        if (input == null || input.length == 0) {
            return new int[0];
        }

        int[] result = new int[2];
        long countPositive = 0;
        long sumNegative = 0;


        for (int value : input) {
            if (value == 0) {
                continue;
            }

            if (value > 0) {
                countPositive++;
            } else {
                sumNegative += value;
            }
        }

        result[0] = (int) countPositive;

        if (sumNegative > Integer.MAX_VALUE) {
            throw new IllegalArgumentException("The sum of negative values is too large to represent as an integer.");
        } else {
            result[1] = (int) sumNegative;
        }

        return result;
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
