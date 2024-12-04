package org.academy.kata.implementation.BasilJaworski;


import org.academy.kata.IEight;

public class Eight implements IEight {
    @Override
    public int liters(double time)  {
        double liters_hour = 0.5;
        return (int) ((double) time * liters_hour);
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
        int divisible_array[];
        int divisible_count = 0;
        int cursor = 0;

        for (int i: numbers){
            if (i % divider == 0) divisible_count++;
        }

        divisible_array = new int[divisible_count];

        for (int i=0; i<divisible_array.length; i++){
            for (int c=cursor;;c++){
                if (numbers[c]%divider==0){
                    divisible_array[i] = numbers[c];
                    cursor = c+1;
                    break;
                }
            }
        }

        return divisible_array;
    }

    @Override
    public boolean am_i_wilson(double n) {
        return false;
    }
}
