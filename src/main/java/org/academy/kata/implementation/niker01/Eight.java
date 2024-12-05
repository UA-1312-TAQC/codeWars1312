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
        return 0;
    }

    @Override
    public float mpgToKPM(float mpg) {
        double result = mpg * (1.609344 / 4.54609188);
        result = Math.round(result * 100.0) / 100.0;
        return (float) result;
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
        return false;
    }
}
