package org.academy.kata.implementation.MisterV03;


import org.academy.kata.IEight;

import java.text.DecimalFormat;

public class Eight implements IEight {

    static double GALLON = 4.54609188;
    static double MILE = 1.609344;

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
        float result = (float) ((float)mpg/GALLON*MILE);
        DecimalFormat df = new DecimalFormat("#.##");
        return Float.valueOf(df.format(result));
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
