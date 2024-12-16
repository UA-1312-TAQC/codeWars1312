package org.academy.kata.implementation.daniilrusanov;


import org.academy.kata.IEight;

import java.math.BigInteger;
import java.util.ArrayList;

public class Eight implements IEight {
    @Override
    public int liters(double time) {
        return (int) (time / 2);
    }

    @Override
    public double getVolumeOfCuboid(double length, double width, double height) {
        return length * width * height;
    }

    @Override
    public float mpgToKPM(float mpg) {
        float result = (float) (mpg / 4.54609188 * 1.609344);
        return Math.round(result * 100) / 100.0f;
    }

    @Override
    public int[] squareOrSquareRoot(int[] array) {
        int[] newArray = new int[array.length];

        for(int i = 0; i < array.length; i++) {
            if (isInteger(Math.sqrt(array[i])))
                newArray[i] = (int) Math.sqrt(array[i]);
            else
                newArray[i] = array[i] * array[i];
        }

        return newArray;
    }

    private static boolean isInteger(double number) {
        return number % 1 == 0;
    }

    @Override
    public int[] countPositivesSumNegatives(int[] input) {
        if (input == null || input.length == 0) return new int[0];

        int[] result = new int[2];
        int positives = 0;
        int negative = 0;

        for (int j : input) {
            if (j > 0) positives++;
            else if (j < 0) negative += j;
        }

        result[0] = positives;
        result[1] = negative;

        return result;
    }

    @Override
    public int stringToNumber(String str) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < str.length(); i++)
            result.append(str.charAt(i));

        return Integer.parseInt(result.toString());
    }

    @Override
    public double TwoDecimalPlaces(double number) {
        return Math.round(number * 100) / 100.0;
    }

    @Override
    public int[] divisibleBy(int[] numbers, int divider) {
        ArrayList<Integer> res = new ArrayList<>();

        for (int number : numbers) {
            if (number % divider == 0)
                res.add(number);
        }

        return res.stream().mapToInt(i -> i).toArray();
    }

    @Override
    public boolean am_i_wilson(long n) {
        if(!isPrime(n)) return false;
        BigInteger factorialVal = factorial(n-1);
        BigInteger modulus = BigInteger.valueOf(n).multiply(BigInteger.valueOf(n));
        return factorialVal.add(BigInteger.ONE).mod(modulus).equals(BigInteger.ZERO);
    }

    private static boolean isPrime(long n) {
        if (n <= 1) return false;
        for (long i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    private static BigInteger factorial(long n) {
        BigInteger result = BigInteger.ONE;
        for (long i = 2; i <= n; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }

}
