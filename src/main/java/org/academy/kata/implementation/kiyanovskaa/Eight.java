package org.academy.kata.implementation.kiyanovskaa;


import org.academy.kata.IEight;

public class Eight implements IEight {
    @Override
    public int liters(double time) {
        int res = (int) Math.floor(time*0.5);
        return res;
    }

    @Override
    public double getVolumeOfCuboid(double length, double width, double height) {
        return length * width * height;
    }

    @Override
    public float mpgToKPM(float mpg) {
        float kpl = mpg * 1.609344f /4.54609188f;
        return Math.round(kpl * 100) / 100.0f;
    }

    @Override
    public int[] squareOrSquareRoot(int[] array) {
        for (int i=0; i<array.length; ++i){
            if(Math.sqrt(array[i])%1==0){
                array[i]=(int)Math.sqrt(array[i]);
            }
            else{
                array[i]=(int)Math.pow(array[i],2);
            }
        }
        return array;
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
