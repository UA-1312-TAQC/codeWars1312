package org.academy.kata.implementation.Dorrothee;


import org.academy.kata.IEight;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

public class Eight implements IEight {
    @Override
    public int liters(double time) {
        double litres = 0.5;
        //Casting to (int) removes the fractional part rounding down
        return (int)(time * litres);
    }

    @Override
    public double getVolumeOfCuboid(double length, double width, double height) {
        //Formula to calculate volume of a cuboid: length * width * height
        return length * width * height;
    }

    @Override
    public float mpgToKPM(float mpg) {
        final float mile = 1.609344f;
        final float gallon = 4.54609188f;

        float kilosPerLiter = mpg * mile / gallon;

        //To round off the result
        BigDecimal bd = new BigDecimal(kilosPerLiter);
        bd = bd.setScale(2, RoundingMode.HALF_UP);
        float kpl = bd.floatValue();

        return kpl;
    }

    @Override
    public int[] squareOrSquareRoot(int[] array) {
        int[] resultArray = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            int current = array[i];
            double square = Math.sqrt(current);
            if (square == (int) square) {
                resultArray[i] = (int) square;
            } else {
                resultArray[i] = current * current;
            }
        }

        return resultArray;
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
        return Integer.parseInt(str);
    }

    @Override
    public double TwoDecimalPlaces(double number) {
        BigDecimal bd = new BigDecimal(number);
        bd = bd.setScale(2, RoundingMode.HALF_UP);
        double result = bd.doubleValue();

        return result;
    }

    @Override
    public int[] divisibleBy(int[] numbers, int divider) {
        //As we do not know the size of an array
        ArrayList<Integer> resultList = new ArrayList<>();
        for (int el: numbers) {
            if (el % divider == 0) {
                resultList.add(el);
            }
        }

        //Result array
        int[] result = new int[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            result[i] = resultList.get(i);
        }

        return result;
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
