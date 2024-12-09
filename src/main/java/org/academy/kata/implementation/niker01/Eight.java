package org.academy.kata.implementation.niker01;


import org.academy.kata.IEight;

public class Eight implements IEight {
    @Override
    public int liters(double time) {
        double litresHour = 0.5;
        double result = time * litresHour;
        return (int) result;
    }

    @Override
    public double getVolumeOfCuboid(double length, double width, double height) {
        return length * width * height;
    }

    @Override
    public float mpgToKPM(float mpg) {
        double result = mpg * (1.609344 / 4.54609188);
        result = Math.round(result * 100.0) / 100.0;
        return (float) result;
    }

    @Override
    public int[] squareOrSquareRoot(int[] array) {
        for (int i = 0; i < array.length; i++) {
            double sqrt = Math.sqrt(array[i]);
            if (sqrt == (int) sqrt) {
                array[i] = (int) sqrt;
            } else {
                array[i] = array[i] * array[i];
            }
        }
        return array;
    }

    @Override
    public int[] countPositivesSumNegatives(int[] input) {
        if (input == null || input.length == 0) {
            return new int[]{};
        }
        int[] result = {0, 0};
        for (int i = 0; i < input.length; i++) {
            if (input[i] > 0) {
                result[0] += 1;
            } else if (input[i] < 0) {
                result[1] += input[i];
            }
        }
        return result;
    }

    @Override
    public int stringToNumber(String str) {
        return Integer.parseInt(str);
    }

    @Override
    public double TwoDecimalPlaces(double number) {
        return Math.round(number * 100.0) / 100.0;
    }

    @Override
    public int[] divisibleBy(int[] numbers, int divider) {
        int count = 0;
        int n = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % divider == 0) {
                count++;
            }
        }
        int[] result = new int[count];
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % divider == 0) {
                result[n] = numbers[i];
                n++;
            }
        }
        return result;
    }

    @Override
    public boolean am_i_wilson(double n) {
        return n == 5 || n == 13 || n == 563;
    }
}
