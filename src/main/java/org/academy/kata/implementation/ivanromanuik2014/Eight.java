package org.academy.kata.implementation.ivanromanuik2014;

import org.academy.kata.IEight;

public class Eight implements IEight {
    @Override
    public int liters(double time) {
        int water_value = (int) Math.round(time * 0.5);
        return water_value;
    }

    @Override
    public double getVolumeOfCuboid(double length, double width, double height) {
        return length * width * height;
    }

    @Override
    public float mpgToKPM(float mpg) {
        float coefImpGallonToLiter = 4.54609188f;
        float coefMileToKilometer = 1.609344f;
        float result = (mpg * coefMileToKilometer) / coefImpGallonToLiter;
        return Math.round(result * 100.0f) / 100.0f;
    }

    @Override
    public int[] squareOrSquareRoot(int[] array) {
        return new int[0];
    }

    @Override
    public int[] countPositivesSumNegatives(int[] input) {
        if (input == null || input.length == 0) {
            return new int[0];
        }

        int countPositives = 0;
        int sumNegatives = 0;

        for (int i : input) {
            if (i > 0) {
                countPositives++;
            } else if (i < 0) {
                sumNegatives += i;
            }
        }

        return new int[] { countPositives, sumNegatives };
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
