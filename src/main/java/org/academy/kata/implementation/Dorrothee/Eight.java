package org.academy.kata.implementation.Dorrothee;


import org.academy.kata.IEight;



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
        return false;
    }
}
