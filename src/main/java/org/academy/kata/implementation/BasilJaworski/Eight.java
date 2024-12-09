package org.academy.kata.implementation.BasilJaworski;


import org.academy.kata.IEight;

public class Eight implements IEight {
    @Override
    public int liters(double time) {
        double liters_hour = 0.5;
        return (int) (time * liters_hour);
    }

    @Override
    public double getVolumeOfCuboid(double length, double width, double height) {
        return 0;
    }

    @Override
    public float mpgToKPM(float mpg) {
        double galon_liters = 4.54609188;
        double mile_kilometers = 1.609344;
        double kpl =(mpg * mile_kilometers) / galon_liters;
        return (float)Math.round(kpl * 100f) / 100f;
    }

    @Override
    public int[] squareOrSquareRoot(int[] array) {
        for (int i=0; i<array.length; i++){
            double root = Math.sqrt(array[i]);

            if (root % 1 == 0){
                array[i] = (int) root;
            } else {
                array[i] *= array[i];
            }

        }

        return array;
    }

    @Override
    public int[] countPositivesSumNegatives(int[] input) {
        int[] result;
        int pos_sum = 0;
        int neg_sum = 0;

        if (input == null || input.length == 0){
            result = new int[0];
        } else {
            for (int i : input){
                if (i < 0) neg_sum += i;
                if (i > 0) pos_sum++;
            }

            result = new int[2];
            result[0] = pos_sum;
            result[1] = neg_sum;
        }

        return result;
    }

    @Override
    public int stringToNumber(String str) {
        return Integer.parseInt(str);
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
