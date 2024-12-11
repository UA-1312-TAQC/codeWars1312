package org.academy.kata.implementation.nestea4;


import org.academy.kata.IEight;

public class Eight implements IEight {
    @Override
    public int liters(double time) {
        return (int) Math.floor(time * 0.5);
    }

    @Override
    public double getVolumeOfCuboid(double length, double width, double height) {
        double volume = length*width*height;
        return volume;
    }

    @Override
    public float mpgToKPM(float mpg) {
        return (float) Math.round(mpg * 1.609344f/4.54609188f*100) / 100;
    }

    @Override
    public int[] squareOrSquareRoot(int[] array) {
        for(int i = 0; i < array.length; i++){
            int sqrt = (int) Math.sqrt(array[i]);
            if (sqrt * sqrt == array[i]){
                array[i] = sqrt;
            }
            else{
                array[i] = array[i] * array[i];
            }
        }
        return array;
    }

    @Override
    public int[] countPositivesSumNegatives(int[] input) {
        int countPositive = 0;
        int sumOfNegative = 0;
        if (input == null || input.length==0) {
            return new int[0];
        }

        for(int number : input){
            if(number > 0){
                countPositive++;
            }
            else{
                sumOfNegative+=number;
            }
        }

        return new int[]{countPositive, sumOfNegative};
    }

    @Override
    public int stringToNumber(String str) {
        return Integer.valueOf(str);
    }

    @Override
    public double TwoDecimalPlaces(double number) {
        return Math.round(number*100.0) / 100.0;
    }

    @Override
    public int[] divisibleBy(int[] numbers, int divider) {
        int count = 0;
        int index = 0;
        for (int number : numbers) {
            if (number%divider == 0) {
                count++;
            }
        }

        int[] result = new int[count];
        for (int number : numbers) {
            if (number%divider == 0) {
                result[index++] = number;
            }
        }
        return result;
    }

    @Override
    public boolean am_i_wilson(double n) {
        if (n <= 1) return false;
        if (n == 2) return false;
        if (n%2 == 0) return false;

        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            if (n%i == 0) return false;
        }

        double factorial = 1;
        for (double i = 2; i < n; i++) {
            factorial = (factorial * i) % (n*n);
        }
        return (factorial+1) % (n*n) == 0;
    }
}
