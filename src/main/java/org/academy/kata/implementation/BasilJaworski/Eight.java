package org.academy.kata.implementation.BasilJaworski;


import java.math.BigInteger;
import org.academy.kata.IEight;

public class Eight implements IEight {
    @Override
    public int liters(double time) {
        double liters_hour = 0.5;
        return (int) (time * liters_hour);
    }

    @Override
    public double getVolumeOfCuboid(double length, double width, double height) {
        return length*width*height;
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
        return (double)Math.round(number * 100d) / 100d;
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
    public boolean am_i_wilson(long nd) {
        long n = (long) nd;
        if (n<=1) return false;
        if (check_prime(n) == false) return false;

        BigInteger factorial = get_factorial(n - 1);
        BigInteger leftSide = factorial.add(BigInteger.ONE);
        BigInteger rightSide = BigInteger.valueOf(n).multiply(BigInteger.valueOf(n));

        return leftSide.mod(rightSide).equals(BigInteger.ZERO);
    }

    public static BigInteger get_factorial(long n) {
        if (n < 2) return BigInteger.ONE;
        BigInteger result = BigInteger.ONE;
        for (long i = 1; i <= n; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }

    public static boolean check_prime(long n){
        if (n < 1) return false;
        for (int i=2; i<n; i++){
            if (n % i == 0) return false;
        }
        return true;
    }
}
