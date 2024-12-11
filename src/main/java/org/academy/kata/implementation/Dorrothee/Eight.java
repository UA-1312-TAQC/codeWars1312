package org.academy.kata.implementation.Dorrothee;


import org.academy.kata.IEight;

import java.math.BigDecimal;
import java.math.RoundingMode;

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
        return false;
    }
}
