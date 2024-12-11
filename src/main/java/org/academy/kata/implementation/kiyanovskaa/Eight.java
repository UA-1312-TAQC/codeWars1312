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
        int []res = new int[2];
        for(int i=0;i<input.length;++i){
            if(input[i]>0){
                res[0]++;
            }
            else if(input[i]<0){
                res[1]+=input[i];
            }
        }
        return res;
    }

    @Override
    public int stringToNumber(String str) {
        return Integer.parseInt(str);
    }

    @Override
    public double TwoDecimalPlaces(double number) {
        return Math.ceil(number*100)/100;
    }

    @Override
    public int[] divisibleBy(int[] numbers, int divider) {
        int [] result=new int[numbers.length];
        int index=0;
        for(int number:numbers){
            if(number%divider==0){
                result[index++]=number;
            }
        }
        int[] finalResult = new int[index];
        System.arraycopy(result, 0, finalResult, 0, index);
        return finalResult;
    }

    @Override
    public boolean am_i_wilson(long n) {
        if (n < 2) return false;

        double factorial = 1;
        double mod = n * n; // n^2
        for (int i = 1; i < n; i++) {
            factorial = (factorial * i) % mod;
        }
        return (factorial + 1) % mod == 0;
    }
}
