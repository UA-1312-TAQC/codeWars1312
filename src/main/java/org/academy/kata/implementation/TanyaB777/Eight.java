package org.academy.kata.implementation.TanyaB777;


import org.academy.kata.IEight;

import java.math.BigInteger;

import java.util.Arrays;

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
        return Integer.parseInt(str);
    }

    @Override
    public double TwoDecimalPlaces(double number) {
        return Math.round(number * 100.0) / 100.0;
    }

    @Override
    public int[] divisibleBy(int[] numbers, int divider) {
        return Arrays.stream(numbers)
                .filter(num -> num % divider == 0)
                .toArray();
    }

    @Override
    public boolean am_i_wilson(long n) {
        if (n < Long.MAX_VALUE) {
            if (!isPrime(n)) return false;

            BigInteger numerator = factorial(n - 1).add(BigInteger.ONE);
            BigInteger denominator = BigInteger.valueOf(n).multiply(BigInteger.valueOf(n));

            return numerator.mod(denominator).equals(BigInteger.ZERO);
        } else {
            throw new IllegalArgumentException("Input value is too large to represent as a long.");
        }
    }

    private boolean isPrime(long n) {
        if (n < 2) return false;

        for (long i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }

        return true;
    }

    private BigInteger factorial(long n) {
        if (n < 0) {
            throw new IllegalArgumentException("Factorial is not defined for negative numbers.");
        }

        BigInteger result = BigInteger.ONE;

        for (long i = 2; i <= n; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }

        return result;
    }
}
