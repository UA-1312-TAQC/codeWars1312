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
        return new int[0];
    }

    @Override
    public boolean am_i_wilson(double n) {
        if (n <= 1) return false;
        if (n == 2) return false;
        if (n%2 == 0) return false;

        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            if (n%i == 0) return false;
        }

        double factorial = 1;
        for (double i = 2; i < n; i++) {
            factorial = (factorial * i) % (n*n);
        }
        return (factorial+1) % (n*n) == 0;
    }
}
