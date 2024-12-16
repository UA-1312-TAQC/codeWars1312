package org.academy.kata.implementation.daniilrusanov;


import org.academy.kata.IEight;

import java.util.ArrayList;

public class Eight implements IEight {
    @Override
    public int liters(double time) {
        return (int) (time / 2);
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
        if (input == null || input.length == 0) return new int[0];

        int[] result = new int[2];
        int positives = 0;
        int negative = 0;

        for (int j : input) {
            if (j > 0) positives++;
            else if (j < 0) negative += j;
        }

        result[0] = positives;
        result[1] = negative;

        return result;
    }

    @Override
    public int stringToNumber(String str) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < str.length(); i++)
            result.append(str.charAt(i));

        return Integer.parseInt(result.toString());
    }

    @Override
    public double TwoDecimalPlaces(double number) {
        return Math.round(number * 100) / 100.0;
    }

    @Override
    public int[] divisibleBy(int[] numbers, int divider) {
        ArrayList<Integer> res = new ArrayList<>();

        for (int number : numbers) {
            if (number % divider == 0)
                res.add(number);
        }

        return res.stream().mapToInt(i -> i).toArray();
    }

    @Override
    public boolean am_i_wilson(long n) {
        return false;
    }
}
