package org.academy.kata.implementation.MisterV03;


import org.academy.kata.IEight;

import java.util.Vector;

public class Eight implements IEight {

    private static int[] vectorToIntegerArray(Vector<Integer> in){
        int[] res = new int[in.size()];
        for(int i = 0; i<res.length; i++) {
            res[i] = in.get(i);
        }
        return res;
    }

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
        Vector<Integer> res = new Vector<Integer>();
        for (int number : numbers) {
            if (number % divider == 0)
                res.add(number);
        }
        return vectorToIntegerArray(res);
    }

    @Override
    public boolean am_i_wilson(double n) {
        return false;
    }
}
