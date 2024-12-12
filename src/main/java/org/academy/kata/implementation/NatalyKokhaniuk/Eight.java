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
        String resStr="[";
        for (int i = 0; i < array.length; i++) {
            resStr+=array[i];
            if(i != array.length-1)resStr+=", ";
        }
        resStr+="] -> [";
        int[] resArray=array;
        for (int i = 0; i < array.length; i++) {
            if(Math.sqrt(array[i])==Math.round(Math.sqrt(array[i]))) resArray[i]=(int)Math.sqrt(array[i]);
            else resArray[i]=array[i]*array[i];
        }

        for (int i = 0; i < resArray.length; i++) {
            resStr+=resArray[i];
            if(i != resArray.length-1)resStr+=", ";
        }
        resStr+="]";
        System.out.print(resStr);
        return resArray;
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
