package org.academy.kata.implementation.MisterV03;


import org.academy.kata.IEight;

import java.math.BigInteger;

public class Eight implements IEight {

    private static BigInteger calculateFactorial(long N){
        BigInteger res = new BigInteger("1");
        for(int i = 2; i<=N; i++){
            res = res.multiply(new BigInteger(String.valueOf(i)));
        }
        return res;
    }

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
        if(n < 2)
            return false;
        BigInteger numerator = calculateFactorial((long)n-1).add(BigInteger.valueOf(1L));
        long denominator = (long)Math.pow(n, 2);
        BigInteger result = numerator.mod(new BigInteger(String.valueOf(denominator)));
        return result.compareTo(BigInteger.ZERO) == 0;
    }
}
