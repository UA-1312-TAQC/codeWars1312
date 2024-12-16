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
