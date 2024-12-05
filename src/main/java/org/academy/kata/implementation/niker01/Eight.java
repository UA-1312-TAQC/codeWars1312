package org.academy.kata.implementation.niker01;


import org.academy.kata.IEight;

public class Eight implements IEight {
    @Override
    public int liters(double time) {
        double litresHour = 0.5; 
        double result = time * litresHour; 
        return (int) result; 
    }

    @Override
    public double getVolumeOfCuboid(double length, double width, double height) {
        return length * width * height;
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
    int count = 0;
    int n = 0;
    for(int i = 0; i < numbers.length; i++){
      if(numbers[i] % divider == 0){
        count++;
      }
    }
    int[] result = new int[count];
      for(int i = 0; i < numbers.length; i++){
      if(numbers[i] % divider == 0){
        result[n] = numbers[i];
        n++;
      }
    }
    return result;
    }

    @Override
    public boolean am_i_wilson(double n) {
        return false;
    }
}
