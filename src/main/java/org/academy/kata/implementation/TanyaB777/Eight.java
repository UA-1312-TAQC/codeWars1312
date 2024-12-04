package org.academy.kata.implementation.TanyaB777;


import org.academy.kata.IEight;

import java.math.BigInteger;

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
        return new int[0];
    }

    @Override
    public boolean am_i_wilson(double n) {
        if (n >= Long.MAX_VALUE) {
            throw new IllegalArgumentException("Input value is too large to represent as a long.");
        }

        long nLong = (long) n;

        if (!isPrime(nLong)) return false;

        BigInteger numerator = factorial(nLong - 1).add(BigInteger.ONE);
        BigInteger denominator = BigInteger.valueOf(nLong).multiply(BigInteger.valueOf(nLong));

        return numerator.mod(denominator).equals(BigInteger.ZERO);
    }

    private static boolean isPrime(long n) {
        if (n < 2) return false;

        for (long i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }

        return true;
    }

    private static BigInteger factorial(long n) {
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
