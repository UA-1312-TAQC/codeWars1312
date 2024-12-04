package org.academy.kata.implementation.nestea4;


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
        int count = 0;
        int index = 0;
        for (int number : numbers) {
            if (number%divider == 0) {
                count++;
            }
        }

        int[] result = new int[count];
        for (int number : numbers) {
            if (number%divider == 0) {
                result[index++] = number;
            }
        }
        return result;
    }

    @Override
    public boolean am_i_wilson(double n) {
        return false;
    }
}
