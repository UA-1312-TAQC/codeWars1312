package org.academy.kata.implementation.Dorrothee;


import org.academy.kata.IEight;

public class Eight implements IEight {
    @Override
    public int liters(double time) {
        double litres = 0.5;
        //Casting to (int) removes the fractional part rounding down
        return (int)(time * litres);
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
    public boolean am_i_wilson(long n) {
        //Since 0 and 1 are not prime numbers
        if (n == 0 || n == 1) { return false; }

        //Since 563 is a large number to calculate for factorial and is a known Wilson prime
        if (n == 5 || n == 13 || n == 563) { return true; }

        //To calculate (P−1)!
        long factorial = 1;
        for (long i = 1; i < n; i++) {
            factorial *= i;
        }

        long numerator = factorial + 1;
        long denominator = n * n;

        if (numerator % denominator == 0) { return true; }

        return false;
    }
}
