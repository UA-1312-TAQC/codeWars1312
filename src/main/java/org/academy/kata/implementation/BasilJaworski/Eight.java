package org.academy.kata.implementation.BasilJaworski;


import java.math.BigInteger;
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
        return new int[0];
    }

    @Override
    public boolean am_i_wilson(double nd) {
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
