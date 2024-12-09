package org.academy.kata.implementation.AnastasiiaSun;


import org.academy.kata.IEight;

import java.util.Arrays;

public class Eight implements IEight {
    @Override
    public int liters(double time) {
        return (int) Math.floor(time * 0.5);
    }

    @Override
    public double getVolumeOfCuboid(double length, double width, double height) {
        return length * width * height;
    }

    @Override
    public float mpgToKPM(float mpg) {
        float conversionFactor = 1.609344f / 4.54609188f;
        return mpg * conversionFactor;
    }

    @Override
    public int[] squareOrSquareRoot(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int sqrt = (int) Math.sqrt(array[i]);
            array[i] = (sqrt * sqrt == array[i]) ? sqrt : array[i] * array[i];
        }
        return array;
    }

    @Override
    public int[] countPositivesSumNegatives(int[] input) {
        if (input == null || input.length == 0) {
            return new int[0];
        }

        int countPositives = 0;
        int sumNegatives = 0;

        for (int num : input) {
            countPositives += (num > 0) ? 1 : 0;
            sumNegatives += Math.min(num, 0);
        }

        return new int[]{countPositives, sumNegatives};
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
        return Arrays.stream(numbers)
                .filter(number -> number % divider == 0)
                .toArray();
    }

    @Override
    public boolean am_i_wilson(double n) {
        if (n <= 1) {
            return false;
        }
        double factorial = calculateFactorial(n - 1);
        double denominator = n * n;
        return (factorial + 1) % denominator == 0;
    }

    private static double calculateFactorial(double n) {
        long fact = 1;
        for (int i = 2; i <= n; i++) {
            fact = fact * i;
        }
        return fact;
    }
}
