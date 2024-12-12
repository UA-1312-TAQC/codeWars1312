package org.academy.kata.implementation.NatalyKokhaniuk;


import org.academy.kata.IEight;

public class Eight implements IEight {
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
        if (array == null || array.length == 0) {
            return new int[] {};
        }
        int count=0,sum=0;
        String resStr="\nCount of positives and sum of negatives :\n[";
        for (int i = 0; i < array.length; i++) {
            resStr+=array[i];
            if(i != array.length-1)resStr+=", ";
            if(array[i]>0) count++;
            if(array[i]<0) sum+=array[i];
        }
        resStr+="] -> ["+count+", "+sum +"].";
        System.out.print(resStr);
        return new int[] {count,sum};
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
