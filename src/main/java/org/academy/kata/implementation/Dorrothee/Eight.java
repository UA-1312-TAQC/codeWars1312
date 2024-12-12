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
        int[] resultCount = new int[2];
        int positiveCount = 0;
        int negativeCount = 0;

        if (input == null || input.length == 0) {return new int[0];}

        for (int el:input) {
            if (el > 0) { positiveCount++; }
            else if(el < 0) { negativeCount+=el; }
        }


        resultCount[0] = positiveCount;
        resultCount[1] = negativeCount;
        return resultCount;
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
        return false;
    }
}
