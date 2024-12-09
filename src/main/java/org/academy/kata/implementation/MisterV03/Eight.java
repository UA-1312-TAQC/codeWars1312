package org.academy.kata.implementation.MisterV03;


import org.academy.kata.IEight;

import java.text.DecimalFormat;

public class Eight implements IEight {

    static double GALLON = 4.54609188;
    static double MILE = 1.609344;

    @Override
    public int liters(double time) {
        return (int)Math.floor(time/2);
    }

    @Override
    public double getVolumeOfCuboid(double length, double width, double height) {
        return length*width*height;
    }

    @Override
    public float mpgToKPM(float mpg) {
        float result = (float) ((float)mpg/GALLON*MILE);
        DecimalFormat df = new DecimalFormat("#.##");
        return Float.valueOf(df.format(result));
    }

    @Override
    public int[] squareOrSquareRoot(int[] array) {
        double temp;
        for(int i = 0; i<array.length; i++){
            temp = Math.sqrt(array[i]);
            if(temp%1!=0){
                array[i] = (int)Math.pow(array[i], 2);
            }else{
                array[i] = (int)temp;
            }
        }
        return array;
    }

    @Override
    public int[] countPositivesSumNegatives(int[] input) {
        if(input == null || input.length == 0){
            return new int[0];
        }
        int count = 0;
        int sum = 0;
        for (int j : input) {
            if (j > 0) {
                count++;
            } else
                sum += j;
        }
        return new int[]{count, sum};
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
